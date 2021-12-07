package uz.jurayev.academy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.jurayev.academy.domain.Direction;
import uz.jurayev.academy.domain.Groups;
import uz.jurayev.academy.domain.Tutor;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.repository.DirectionRepository;
import uz.jurayev.academy.repository.GroupRepository;
import uz.jurayev.academy.repository.TutorRepository;
import uz.jurayev.academy.rest.GroupsDto;
import uz.jurayev.academy.service.GroupService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final TutorRepository tutorRepository;
    private final DirectionRepository directionRepository;

    @Override
    public Result addGroup(GroupsDto groupsDto) {
        Optional<Tutor> tutor =
                tutorRepository.findById(groupsDto.getTutorId());
        if (tutor.isEmpty())
            return new Result("Tutor id " + groupsDto.getTutorId() + " not found", false);
        Optional<Direction> direction =
                directionRepository.findById(groupsDto.getDirectionId());
        if (direction.isEmpty())
            return new Result("Groups id " + groupsDto.getDirectionId() + " not found", false);

        Groups groups = new Groups();
        groups.setName(groupsDto.getName());
        groups.setCourseNumber(groupsDto.getCourseNumber());
        groups.setTutor(tutor.get());
        groups.setDirection(direction.get());
        groupRepository.save(groups);
        return null;
    }

    @Override
    public List<Groups> getAll() {
        return groupRepository.findAll();
    }

    @Override
    public Groups getOne(Long id) {
        Optional<Groups> groupsById =
                groupRepository.findById(id);
        return groupsById.orElse(null);
    }

    @Override
    public Result edit(Long id, GroupsDto groupsDto) {
        Optional<Groups> groupsById =
                groupRepository.findById(id);
        if (groupsById.isEmpty()) {
            return new Result("Group id " + id + " not found", false);
        }
        Optional<Tutor> tutorById = tutorRepository.findById(groupsDto.getTutorId());
        if (tutorById.isEmpty()) {
            return new Result("Tutor id " + groupsDto.getTutorId() + " not found", false);
        }
        Optional<Direction> directionById = directionRepository.findById(groupsDto.getDirectionId());
        if (directionById.isEmpty()) {
            return new Result("Direction id " + groupsDto.getDirectionId() +" not found", false);
        }
        Groups groups = groupsById.get();
        groups.setName(groupsDto.getName());
        groups.setCourseNumber(groupsDto.getCourseNumber());
        groups.setTutor(tutorById.get());
        groups.setDirection(directionById.get());
        groupRepository.save(groups);
        return new Result("Group successfully update", true);
    }

    @Override
    public Result delete(Long id) {
        try {
            groupRepository.deleteById(id);
            return new Result("Groups successfully deleted", true);
        }catch (Exception e){
            return new Result("Error "  + e.getMessage(), false);
        }
    }

}

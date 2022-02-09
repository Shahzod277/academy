package uz.jurayev.academy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.jurayev.academy.domain.Group;
import uz.jurayev.academy.domain.Tutor;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.repository.GroupRepository;
import uz.jurayev.academy.repository.TutorRepository;
import uz.jurayev.academy.rest.GroupDto;
import uz.jurayev.academy.service.GroupService;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private TutorRepository tutorRepository;

    @Override
    public Result save(GroupDto groupDto) {
        Group saveGroup = new Group();
        saveGroup.setGroupId(groupDto.getName());
        Optional<Tutor> optionalTutor = tutorRepository.findById(groupDto.getTutorId());
        if (optionalTutor.isEmpty()) {
            return new Result("tutor id not found ", false);
        }
        saveGroup.setTutor(optionalTutor.get());
        groupRepository.save(saveGroup);
        return new Result("group added", true);
    }

    @Override
    public List<Group> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Group> groups = groupRepository.findAll(pageable);
        return groups.getContent();
    }

    @Override
    public Group getOne(Long id) {
        Optional<Group> optionalGroup = groupRepository.findById(id);
        return optionalGroup.orElse(null);
    }

    @Override
    public Result edit(Long id, GroupDto groupDto) {
        Optional<Group> optionalGroup = groupRepository.findById(id);
        if (optionalGroup.isEmpty()) {
            return new Result("id not found ", false);

        }
        Group updateGroup = optionalGroup.get();
        updateGroup.setGroupId(groupDto.getName());
        Optional<Tutor> optionalTutor = tutorRepository.findById(groupDto.getTutorId());
        if (optionalTutor.isEmpty()) {
            return new Result("tutor id not found ", false);
        }
        updateGroup.setTutor(optionalTutor.get());
        groupRepository.save(updateGroup);
        return new Result("group updated successfull", true);
    }


    @Override
    public Result delete(Long id) {
        try {
            groupRepository.deleteById(id);
            return new Result("deleted group", true);
        } catch (Exception e) {
            return new Result("" + e.getMessage(), false);
        }

    }
}

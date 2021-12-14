package uz.jurayev.academy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.jurayev.academy.domain.Direction;
import uz.jurayev.academy.domain.Faculty;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.repository.DirectionRepository;
import uz.jurayev.academy.repository.FacultyRepository;
import uz.jurayev.academy.rest.DirectionDto;
import uz.jurayev.academy.service.DirectionService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DirectionServiceImpl implements DirectionService {

    private final DirectionRepository directionRepository;
    private final FacultyRepository facultyRepository;

    @Override
    public Result addDirection(DirectionDto directionDto) {

        Optional<Faculty> facultyRepositoryById =
                facultyRepository.findById(directionDto.getFacultyId());
        if (facultyRepositoryById.isEmpty())
            return new Result("Faculty not found " + directionDto.getFacultyId(), false);
        Direction direction = new Direction();
        direction.setName(directionDto.getName());
        direction.setFaculty(facultyRepositoryById.get());
        directionRepository.save(direction);
        return new Result("Direction successfully saved", true);
    }

    @Override
    public List<Direction> getAll() {
        return directionRepository.findAll();
    }

    @Override
    public Direction getOne(Long id) {
        Optional<Direction> directionRepositoryById = directionRepository.findById(id);
        if (directionRepositoryById.isEmpty())
            return null;
        return directionRepositoryById.get();
    }

    @Override
    public Result edit(Long id, DirectionDto directionDto) {
        Optional<Direction> directionRepositoryById = directionRepository.findById(id);
        if (directionRepositoryById.isEmpty())
            return new Result("Direction not found", false);
        Optional<Direction> directionFaculty
                = directionRepository.findById(directionDto.getFacultyId());
        if (directionFaculty.isEmpty())
            return new Result("Faculty not found", false);
        Direction direction = directionRepositoryById.get();
        direction.setName(directionDto.getName());
        direction.setFaculty(directionFaculty.get().getFaculty());
        directionRepository.save(direction);
        return new Result("Direction successfully upload", true);
    }

    @Override
    public Result delete(Long id) {
        try {
            directionRepository.deleteById(id);
            return new Result("Direction delete "+id, true);
        }catch (Exception e){
//            e.printStackTrace();
            return new Result("Direction not found, error " + e.getMessage() , false);
        }
    }
}

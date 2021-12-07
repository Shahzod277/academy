package uz.jurayev.academy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.jurayev.academy.domain.Faculty;
import uz.jurayev.academy.domain.University;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.repository.FacultyRepository;
import uz.jurayev.academy.repository.UniversityRepository;
import uz.jurayev.academy.rest.FacultyDto;
import uz.jurayev.academy.service.FacultyService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;
    private final UniversityRepository universityRepository;

    @Override
    public Result addFaculty(FacultyDto facultyDto) {
        Faculty faculty = new Faculty();
        faculty.setName(facultyDto.getName());
        Optional<University> optionalUniversity = universityRepository.findById(facultyDto.getUniversityId());
        if (optionalUniversity.isEmpty()) {
            return new Result("university id not found " + facultyDto.getUniversityId() + "", false);
        }
        faculty.setUniversityId(facultyDto.getUniversityId());
        facultyRepository.save(faculty);
        return new Result("Faculty successfully saved", true);
    }

    @Override
    public List<Faculty> getAll() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty getOne(Long id) {
        Optional<Faculty> byId =
                facultyRepository.findById(id);
        if (byId.isEmpty())
            return null;
        return byId.get();
    }

    @Override
    public Result edit(Long id, FacultyDto facultyDto) {
        Optional<Faculty> byId =
                facultyRepository.findById(id);
        if (byId.isEmpty())
            return new Result("Faculty id -> " + id + " not found", false);
        Faculty faculty = byId.get();
        faculty.setName(facultyDto.getName());
        Optional<University> optionalUniversity = universityRepository.findById(faculty.getUniversityId());
        if (optionalUniversity.isEmpty()) {
            return new Result("not found university  id " + facultyDto.getUniversityId() + "", false);
        }
        faculty.setUniversityId(facultyDto.getUniversityId());
        facultyRepository.save(faculty);
        return new Result("Faculty successfully update", true);
    }

    @Override
    public Result delete(Long id) {
        try {
            facultyRepository.deleteById(id);
            return new Result("faculty successfully delete", true);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("Faculty id " + id + " not found", false);
        }
    }
}

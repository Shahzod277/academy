package uz.jurayev.academy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.jurayev.academy.domain.University;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.repository.UniversityRepository;
import uz.jurayev.academy.rest.UniversityDto;
import uz.jurayev.academy.service.UniversityService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository universityRepository;

    @Override
    public Result save(UniversityDto universityDto) {
        boolean existsByName = universityRepository.existsByName(universityDto.getName());
        if (existsByName) {
            return new Result("alredy added this university", false);
        }
        University university = new University();
        university.setName(universityDto.getName());
        universityRepository.save(university);
        return new Result("university added", true);
    }

    @Override
    public List<University> getAll() {

        return universityRepository.findAll();
    }

    @Override
    public University getOne(Integer id) {
        Optional<University> optionalUniversity = universityRepository.findById(id);
        return optionalUniversity.orElse(null);
    }

    @Override
    public Result update(Integer id, UniversityDto universityDto) {
        Optional<University> optionalUniversity = universityRepository.findById(id);
        if (optionalUniversity.isEmpty()) {
            return new Result("id not found " + id + "", false);
        }
        University university = optionalUniversity.get();
        university.setName(universityDto.getName());
        universityRepository.save(university);
        return new Result("universitet added", true);
    }

    @Override
    public Result delete(Integer id) {
        try {
            universityRepository.deleteById(id);
            return new Result("deleted", true);
        } catch (Exception e) {
            return new Result(e.getMessage() + "", false);
        }
    }
}

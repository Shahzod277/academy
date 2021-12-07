package uz.jurayev.academy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.jurayev.academy.domain.Education;
import uz.jurayev.academy.domain.Faculty;
import uz.jurayev.academy.domain.Groups;
import uz.jurayev.academy.domain.University;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.repository.EducationRepository;
import uz.jurayev.academy.repository.FacultyRepository;
import uz.jurayev.academy.repository.GroupRepository;
import uz.jurayev.academy.repository.UniversityRepository;
import uz.jurayev.academy.rest.EducationDto;
import uz.jurayev.academy.service.EducationService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EducationServiceImpl implements EducationService {

    private final EducationRepository educationRepository;
    private final FacultyRepository facultyRepository;
    private final UniversityRepository universityRepository;
    private final GroupRepository groupRepository;

    @Override
    public Result addEducation(EducationDto educationDto) {
//        Optional<Faculty> facultyById =
//                facultyRepository.findById(educationDto.getFacultyId());
//        if (facultyById.isEmpty())
//            return new Result("Faculty id " + educationDto.getFacultyId() + "not found", false);
//        Optional<University> universityById =
//                universityRepository.findById(educationDto.getUniversityId());
//        if (universityById.isEmpty()) {
//            return new Result("university id " + educationDto.getUniversityId() + " not found", false);
//        }
//        Optional<Groups> groupsById =
//                groupRepository.findById(educationDto.getGroupId());
//        if (groupsById.isEmpty())
//            return new Result("Groups id " + educationDto.getGroupId() + " not found", false);
        Result success = success(educationDto);
        if (!success.getSuccess())
            return success;
        Education education = new Education();
        education.setFacultyId(educationDto.getFacultyId());
        education.setGroupId(educationDto.getGroupId());
        education.setUniversityId(educationDto.getUniversityId());
        educationRepository.save(education);
        return success;
    }

    @Override
    public List<Education> getAll() {
        return educationRepository.findAll();
    }

    @Override
    public Education getOne(Long id) {
        Optional<Education> educationById =
                educationRepository.findById(id);
        return educationById.orElse(null);
    }

    @Override
    public Result edit(Long id, EducationDto educationDto) {
        Optional<Education> educationById =
                educationRepository.findById(id);
        if (educationById.isEmpty())
            return new Result("Education id " + id + " not found", false);
        Result success = success(educationDto);
        if (!success.getSuccess())
            return success;
        Education education = educationById.get();
        education.setUniversityId(educationDto.getUniversityId());
        education.setGroupId(educationDto.getGroupId());
        education.setFacultyId(educationDto.getFacultyId());
        educationRepository.save(education);
        return success;
    }

    @Override
    public Result delete(Long id) {
        try {
            educationRepository.deleteById(id);
            return new Result("education successfully delete", true);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("Education Error delete", false);
        }
    }

    public Result success(EducationDto educationDto) {
        Optional<Faculty> facultyById =
                facultyRepository.findById(educationDto.getFacultyId());
        if (facultyById.isEmpty())
            return new Result("Faculty id " + educationDto.getFacultyId() + "not found", false);
        Optional<University> universityById =
                universityRepository.findById(educationDto.getUniversityId());
        if (universityById.isEmpty()) {
            return new Result("university id " + educationDto.getUniversityId() + " not found", false);
        }
        Optional<Groups> groupsById =
                groupRepository.findById(educationDto.getGroupId());
        if (groupsById.isEmpty())
            return new Result("Groups id " + educationDto.getGroupId() + " not found", false);
        return new Result("Education successfully saved", true);
    }

}

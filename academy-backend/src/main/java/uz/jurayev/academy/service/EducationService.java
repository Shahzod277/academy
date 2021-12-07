package uz.jurayev.academy.service;

import uz.jurayev.academy.domain.Education;
import uz.jurayev.academy.domain.Faculty;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.EducationDto;
import uz.jurayev.academy.rest.FacultyDto;

import java.util.List;

public interface EducationService {
    Result addEducation(EducationDto educationDto);
    List<Education> getAll();
    Education getOne(Long id);
    Result edit(Long id, EducationDto educationDto);
    Result delete(Long id);
}

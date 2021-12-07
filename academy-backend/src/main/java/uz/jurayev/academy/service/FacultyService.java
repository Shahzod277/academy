package uz.jurayev.academy.service;

import uz.jurayev.academy.domain.Faculty;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.FacultyDto;

import java.util.List;

public interface FacultyService {
    Result addFaculty(FacultyDto facultyDto);
    List<Faculty> getAll();
    Faculty getOne(Long id);
    Result edit(Long id, FacultyDto facultyDto);
    Result delete(Long id);
}

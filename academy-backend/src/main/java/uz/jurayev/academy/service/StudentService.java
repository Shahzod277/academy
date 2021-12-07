package uz.jurayev.academy.service;

import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.StudentDto;
import java.util.List;

public interface StudentService {

    Result save(StudentDto entity);
    Result delete(Long id);
    List<StudentDto> findAll();
    StudentDto findById(Long id);
    Result update(Long id, StudentDto studentDto);
}

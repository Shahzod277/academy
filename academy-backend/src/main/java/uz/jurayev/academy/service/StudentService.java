package uz.jurayev.academy.service;

import uz.jurayev.academy.domain.Student;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.StudentDto;
import java.util.List;

public interface StudentService {

    Result save(StudentDto entity);

    Result delete(Long id);

    List<Student> findAll(int page, int size);

    Student findById(Long id);

    Result update(Long id, StudentDto studentDto);
}

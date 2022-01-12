package uz.jurayev.academy.service;

import uz.jurayev.academy.rest.Data;
import uz.jurayev.academy.domain.Student;
import uz.jurayev.academy.model.Result;

import java.util.List;

public interface StudentService {

    Result save(Data data);
    Result delete(Long id);
    List<Student> findAll(int page, int size);
    Student getStudentById(Long id);
}

package uz.jurayev.academy.service;

import uz.jurayev.academy.domain.Group;
import uz.jurayev.academy.rest.GroupAndStudentDto;
import uz.jurayev.academy.rest.PinflDto;
import uz.jurayev.academy.rest.StudentInfoDto;
import uz.jurayev.academy.domain.Student;
import uz.jurayev.academy.model.Result;

import java.util.List;

public interface StudentService {

    Result save(StudentInfoDto studentInfo, Group group);
    Result delete(Long id);
    List<Student> findAll(int page, int size);
    Student getStudentById(Long id);
    StudentInfoDto getStudentByApi(PinflDto pinflDto);
    Result updateStudent(GroupAndStudentDto groupAndStudentDto);
}

package uz.jurayev.academy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.jurayev.academy.rest.Data;
import uz.jurayev.academy.domain.Student;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.repository.*;
import uz.jurayev.academy.service.StudentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    @Override
    public Result save(Data data) {
        Student student = new Student();
        student.setStudentId(data.getId());
        student.setAccomodationCode(data.getAccomodationCode());
        student.setAccomodationName(data.getAccomodationName());
        student.setAddress(data.getAddress());
        student.setAddressCurrent(data.getAddressCurrent());
        student.setBirthday(data.getBirthday());
        student.setCitizenshipCode(data.getCitizenshipCode());
        student.setCitizenshipName(data.getCitizenshipName());
        student.setCountryCode(data.getCountryCode());
        student.setCountryName(data.getCountryName());
        student.setCourse(data.getCourse());
        student.setDistrict(data.getDistrict());
        student.setEducationFormCode(data.getEducationFormCode());
        student.setEducationFormName(data.getEducationFormName());
        student.setEducationTypeCode(data.getEducationTypeCode());
        student.setEducationTypeName(data.getEducationTypeName());
        student.setFacultyCode(data.getFacultyCode());
        student.setFacultyName(data.getFacultyName());
        student.setGenderCode(data.getGenderCode());
        student.setGenderName(data.getGenderName());
        student.setNationalityCode(data.getNationalityCode());
        student.setNationalityName(data.getNationalityName());

        studentRepository.save(student);
        return new Result("Student successfully saved", true);
    }

    @Override
    public Result delete(Long id) {
        return null;
    }

    @Override
    public List<Student> findAll(int page, int size) {
        return null;
    }

    @Override
    public Student getStudentById(Long id) {
        return null;
    }
}

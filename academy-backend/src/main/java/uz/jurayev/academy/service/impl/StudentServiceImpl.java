package uz.jurayev.academy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.jurayev.academy.domain.Address;
import uz.jurayev.academy.domain.Groups;
import uz.jurayev.academy.domain.Student;
import uz.jurayev.academy.mapper.StudentMapper;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.repository.*;
import uz.jurayev.academy.rest.StudentDto;
import uz.jurayev.academy.service.StudentService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    @Override
    public Result save(StudentDto studentDto) {

        if (studentDto == null) {
            return null;
        }

        Student student = new Student();
        student.setCreativePotentialId(studentDto.getCreativePotentialId());
        student.setPassportData(studentDto.getPassportData());
        student.setRelativesId(studentDto.getRelativesId());
        student.setTelegramPhoneNumber(studentDto.getTelegramPhoneNumber());
        student.setNationalityId(studentDto.getNationalityId());
        student.setGenderId(studentDto.getGenderId());
        student.setEducationId(studentDto.getEducationId());
        student.setPhoneNumber(studentDto.getPhoneNumber());
        student.setFamilyStatusId(studentDto.getFamilyStatusId());
        student.setTemporalAddressId(studentDto.getTemporalAddressId());
        student.setAddressId(studentDto.getAddressId());
        student.setBirthDate(studentDto.getBirthDate());
        student.setLastname(studentDto.getLastname());
        student.setSurname(studentDto.getSurname());
        student.setName(studentDto.getName());
        Optional<Groups> optionalGroups = groupRepository.findById(studentDto.getGroupId());
        if (optionalGroups.isPresent()) {
            student.setGroups(optionalGroups.get());
            studentRepository.save(student);
        }

        return new Result("Student successfully saved", true);
    }

    @Override
    public Result delete(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return new Result("Student successfully deleted", true);
        } else {
            return new Result("Student with id " + id + " not found", false);
        }
    }

    @Override
    public List<Student> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Student> students = studentRepository.findAll(pageable);
        return students.getContent();
    }

    @Override
    public Student findById(Long id) {
        Optional<Student> byId = studentRepository.findById(id);
        return byId.orElse(null);
    }

    @Override
    public Result update(Long id, StudentDto studentDto) {
        Optional<Student> studentById = studentRepository.findById(id);
        if (studentById.isPresent()) {
            Student student = studentById.get();
            student.setCreativePotentialId(studentDto.getCreativePotentialId());
            student.setRelativesId(studentDto.getRelativesId());
            student.setTelegramPhoneNumber(studentDto.getTelegramPhoneNumber());
            student.setNationalityId(studentDto.getNationalityId());
            student.setGenderId(studentDto.getGenderId());
            student.setEducationId(studentDto.getEducationId());
            student.setPhoneNumber(studentDto.getPhoneNumber());
            student.setFamilyStatusId(studentDto.getFamilyStatusId());
            student.setTemporalAddressId(studentDto.getTemporalAddressId());
            student.setAddressId(studentDto.getAddressId());
            student.setBirthDate(studentDto.getBirthDate());
            student.setLastname(studentDto.getLastname());
            student.setSurname(studentDto.getSurname());
            student.setName(studentDto.getName());
            Optional<Groups> optionalGroups = groupRepository.findById(studentDto.getGroupId());
            if (optionalGroups.isPresent()) {
                student.setGroups(optionalGroups.get());

                studentRepository.save(student);
                return new Result("Student successfully updated", true);
            }
            return null;
        }
        return new Result("id not found ", false);
    }
}

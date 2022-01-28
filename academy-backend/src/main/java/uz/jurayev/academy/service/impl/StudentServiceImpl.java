package uz.jurayev.academy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.jurayev.academy.domain.Group;
import uz.jurayev.academy.domain.ResponseToken;
import uz.jurayev.academy.hemis_api.Data;

import uz.jurayev.academy.rest.PinflDto;
import uz.jurayev.academy.rest.StudentInfoDto;
import uz.jurayev.academy.domain.Student;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.repository.*;
import uz.jurayev.academy.security.SecurityConstant;
import uz.jurayev.academy.service.StudentService;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    TokenServiceImpl tokenService;
    private final RestTemplate restTemplate = new RestTemplate();
    private final StudentRepository studentRepository;
    private final TokenRepository tokenRepository;
    private final GroupRepository groupRepository;

    @Override
    public StudentInfoDto getStudentByApi(PinflDto pinflDto) {

        List<ResponseToken> responseTokens = new ArrayList<>();
        responseTokens.add(tokenRepository.getLastToken());
        String pinfl = pinflDto.getPinfl();
        URI baseUrl = URI.create(SecurityConstant.GET_STUDENT_URL + pinfl);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        httpHeaders.setBearerAuth(responseTokens.get(responseTokens.size() - 1).getAccess_token());
        HttpEntity<Object> httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Data> data = restTemplate.exchange(baseUrl, HttpMethod.GET, httpEntity, Data.class);
        Data body = data.getBody();
        assert body != null;
        return body.getData();
    }

    @Override
    public Result save(StudentInfoDto studentInfo, Group group) {
        Student student = new Student();
        student.setStudentId(studentInfo.getId());
        student.setAccomodation_name(studentInfo.getAccomodation_code());
        student.setAddress(studentInfo.getAddress());
        student.setBirthday(studentInfo.getBirthday());
        student.setAddress_current(studentInfo.getAddress_current());
        student.setEducation_form_name(studentInfo.getEducation_form_name());
        student.setEducation_type_name(studentInfo.getEducation_type_name());
        student.setEducation_year(studentInfo.getEducation_year());
        student.setCountry_name(studentInfo.getCountry_name());
        student.setCitizenship_name(studentInfo.getCitizenship_name());
        student.setCourse(studentInfo.getCourse());
        student.setDistrict(studentInfo.getDistrict());
        student.setFaculty_name(studentInfo.getFaculty_name());
        student.setFathername(studentInfo.getFathername());
        student.setLastname(studentInfo.getLastname());
        student.setFirstname(studentInfo.getFirstname());
        student.setGender_name(studentInfo.getGender_name());
        student.setNationality_name(studentInfo.getNationality_name());
        student.setPayment_type_name(studentInfo.getPayment_type_name());
        student.setPinfl(studentInfo.getPinfl());
        student.setSerial_number(studentInfo.getSerial_number());
        student.setSpeciality_code(studentInfo.getSpeciality_code());
        student.setSpeciality_name(studentInfo.getSpeciality_name());
        student.setUniversity_code(studentInfo.getUniversity_code());
        student.setUniversity_name(studentInfo.getUniversity_name());
        student.setUniversity_type_name(studentInfo.getUniversity_type_name());
        student.setRegion(studentInfo.getRegion());
        student.setFaculty_code(studentInfo.getFaculty_code());
        student.setSocial_category_name(studentInfo.getSocial_category_name());
        student.setUniversity_ownership_name(studentInfo.getUniversity_ownership_name());
        student.setGroup(null);
        studentRepository.save(student);
        return new Result("Student successfully saved", true);
    }

    @Override
    public Result delete(Long id) {
        studentRepository.deleteById(id);
        return new Result("deleted", true);

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
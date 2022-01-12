package uz.jurayev.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import uz.jurayev.academy.rest.Data;
import uz.jurayev.academy.domain.Student;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.security.SecurityConstant;
import uz.jurayev.academy.service.impl.StudentServiceImpl;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.List;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
@CrossOrigin
public class StudentController {

    private final StudentServiceImpl studentService;

    private String getToken() {
        HttpRequest httpRequest = HttpRequest.newBuilder().build();
        return null;
    }

    @PostMapping
    public HttpEntity<?> add(@RequestBody String pinfl) {


        URI baseUrl = URI.create("http://ministry.hemis.uz/app/rest/v2/services/student/get?pinfl=" + pinfl);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setBearerAuth(SecurityConstant.TOKEN);
        HttpEntity<Object> httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Data> data = restTemplate.exchange(baseUrl, HttpMethod.POST, httpEntity, Data.class);
        Data body = data.getBody();
        assert body != null;
        Result result = studentService.save(body);
        return ResponseEntity.status(result.getSuccess() ? 201 : 401).body(result);
    }

    @GetMapping("/all")
    public HttpEntity<?> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "15") int size) {
        List<Student> students = studentService.findAll(page, size);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.status(student != null ? 200 : 404).body(student);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id) {
        Result delete = studentService.delete(id);
        return ResponseEntity.status(delete.getSuccess() ? 200 : 409).body(delete);
    }
}

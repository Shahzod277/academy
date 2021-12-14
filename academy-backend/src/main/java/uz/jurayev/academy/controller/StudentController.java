package uz.jurayev.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.jurayev.academy.domain.Student;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.StudentDto;
import uz.jurayev.academy.service.StudentService;
import java.util.List;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping()
    public HttpEntity<?> addAddress(@RequestBody StudentDto entity) {
        Result result = studentService.save(entity);
        return ResponseEntity.status(result.getSuccess() ? 201 : 409).body(result);
    }

    @GetMapping("/all")
    public HttpEntity<?> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "15") int size) {
        List<Student> students = studentService.findAll(page, size);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Long id) {
        Student student = studentService.findById(id);
        return ResponseEntity.status(student != null ? 201 : 409).body(student);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id) {
        Result delete = studentService.delete(id);
        return ResponseEntity.status(delete.getSuccess() ? 201 : 409).body(delete);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        Result result = studentService.update(id, studentDto);
        return ResponseEntity.status(result != null ? 202 : 409).body(result);
    }
}

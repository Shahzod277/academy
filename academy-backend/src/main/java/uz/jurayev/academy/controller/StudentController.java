package uz.jurayev.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import uz.jurayev.academy.domain.Group;
import uz.jurayev.academy.domain.Student;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.PinflDto;
import uz.jurayev.academy.rest.StudentInfoDto;
import uz.jurayev.academy.service.impl.StudentServiceImpl;
import java.util.List;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
@CrossOrigin
public class StudentController {

    private final StudentServiceImpl studentService;

    @PostMapping
    public HttpEntity<StudentInfoDto> getStudentByApi(@RequestBody PinflDto pinflDto) {

        StudentInfoDto student = studentService.getStudentByApi(pinflDto);
        return ResponseEntity.ok(student);
    }

    @PostMapping("create")
    public ResponseEntity<Result> saveStudent(@RequestBody StudentInfoDto studentInfoDto, @RequestBody Group group){
        Result save = studentService.save(studentInfoDto, group);
        return ResponseEntity.status(save.getSuccess() ? 200 : 204).body(save);
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

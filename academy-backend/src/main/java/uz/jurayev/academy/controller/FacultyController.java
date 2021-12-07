package uz.jurayev.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.jurayev.academy.domain.Faculty;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.FacultyDto;
import uz.jurayev.academy.service.impl.FacultyServiceImpl;

@RestController
@RequestMapping("/api/v1/faculty")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class FacultyController {

    private final FacultyServiceImpl facultyService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody FacultyDto facultyDto){
        Result result = facultyService.addFaculty(facultyDto);
        if (result.getSuccess())
            return ResponseEntity.ok(result);
        return ResponseEntity.status(409).body(result);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(facultyService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        Faculty one = facultyService.getOne(id);
        if (one!=null)
            return ResponseEntity.ok(one);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(one);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody FacultyDto facultyDto){
        Result edit = facultyService.edit(id, facultyDto);
        if (edit.getSuccess())
            return ResponseEntity.ok(edit);
        return ResponseEntity.status(409).body(edit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Result delete = facultyService.delete(id);
        if (delete.getSuccess())
            return ResponseEntity.ok(delete);
        return ResponseEntity.status(409).body(delete);
    }
}

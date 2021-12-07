package uz.jurayev.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.jurayev.academy.domain.Education;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.EducationDto;
import uz.jurayev.academy.service.impl.EducationServiceImpl;

@RestController
@RequestMapping("/api/v1/education")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class EducationController {

    private final EducationServiceImpl educationService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody EducationDto educationDto){
        Result result = educationService.addEducation(educationDto);
        if (result.getSuccess())
            return ResponseEntity.ok(result);
        return ResponseEntity.status(409).body(result);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(educationService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        Education one = educationService.getOne(id);
        if (one!=null)
            return ResponseEntity.ok(one);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody EducationDto educationDto){
        Result edit = educationService.edit(id, educationDto);
        if (edit.getSuccess())
            return ResponseEntity.ok(edit);
        return ResponseEntity.status(409).body(edit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Result delete = educationService.delete(id);
        if (delete.getSuccess())
            return ResponseEntity.ok(delete);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(delete);
    }
    
}

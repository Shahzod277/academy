package uz.jurayev.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.jurayev.academy.domain.University;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.UniversityDto;
import uz.jurayev.academy.service.impl.UniversityServiceImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("/university")
public class UniverstiyController {
    private final UniversityServiceImpl universityService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        University one = universityService.getOne(id);
        if (one == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok(one);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(universityService.getAll());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody UniversityDto universityDto) {
        Result save = universityService.save(universityDto);
        if (save.getSuccess()) {
            return ResponseEntity.status(202).body(save);
        }
        return ResponseEntity.status(409).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Result delete = universityService.delete(id);
        if (delete.getSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(delete);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UniversityDto universityDto) {
        Result update = universityService.update(id, universityDto);
        if (update.getSuccess()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(update);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
    }
}
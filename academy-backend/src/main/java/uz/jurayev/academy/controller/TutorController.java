package uz.jurayev.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.jurayev.academy.domain.Tutor;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.TutorDto;
import uz.jurayev.academy.service.TutorService;

import java.util.List;

@RestController
@RequestMapping("/api/tutor")
@RequiredArgsConstructor
public class TutorController {

    private final TutorService tutorService;

    @PostMapping()
    public HttpEntity<?> add(@RequestBody TutorDto entity) {
        Result result = tutorService.create(entity);
        return ResponseEntity.status(result.getSuccess() ? 201 : 409).body(result);
    }

    @GetMapping("/all")
    public HttpEntity<?> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "15") int size) {
        List<TutorDto> all = tutorService.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Long id) {
        TutorDto tutor = tutorService.findById(id);
        return ResponseEntity.status(tutor != null ? 200 : 409).body(tutor);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id) {
        Result delete = tutorService.delete(id);
        return ResponseEntity.status(delete.getSuccess() ? 200 : 409).body(delete);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Long id, @RequestBody TutorDto tutorDto) {
        Result result = tutorService.update(id, tutorDto);
        return ResponseEntity.status(result != null ? 202 : 409).body(result);
    }
}

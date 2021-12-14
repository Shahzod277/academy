package uz.jurayev.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.jurayev.academy.domain.Nationality;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.service.impl.NationalityServiceImpl;

@RequiredArgsConstructor
@RestController
@RequestMapping("/nationality")
public class NationalityController {
    private final NationalityServiceImpl nationalityService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(nationalityService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        Nationality one = nationalityService.getOne(id);
        if (one == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
        return ResponseEntity.ok(one);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Result delete = nationalityService.delete(id);
        if (delete.getSuccess()) {
            return ResponseEntity.ok(delete);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Nationality nationality) {
        Result save = nationalityService.save(nationality);
        if (save.getSuccess()) {
            return ResponseEntity.status(202).body(save);
        }
        return ResponseEntity.status(409).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Nationality nationality) {
        Result update = nationalityService.update(id, nationality);
        if (update.getSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(update);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}

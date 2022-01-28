package uz.jurayev.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.service.InvalidService;

import java.util.List;

@RestController
@RequestMapping("/api/invalid")
@RequiredArgsConstructor
public class InvalidController {
/*
    final private InvalidService invalidService;

    @PostMapping()
    public HttpEntity<?> add(@RequestBody Invalid invalid) {
        Result result = invalidService.invalidAdd(invalid);
        return ResponseEntity.status(result.getSuccess() ? 201 : 409).body(result);
    }

    @GetMapping("/all")
    public HttpEntity<?> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "15") int size) {
        List<Invalid> invalids = invalidService.getAll(page, size);
        return ResponseEntity.ok(invalids);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Long id) {
        Invalid invalid = invalidService.getOne(id);
        return ResponseEntity.status(invalid != null ? 200 : 409).body(invalid);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Long id, @RequestBody Invalid invalid) {
        Invalid invalidEdit = invalidService.edit(id, invalid);
        return ResponseEntity.status(invalidEdit != null ? 202 : 409).body(invalidEdit);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id) {
        Result delete = invalidService.delete(id);
        return ResponseEntity.status(delete.getSuccess() ? 200 : 409).body(delete);
    }*/
}

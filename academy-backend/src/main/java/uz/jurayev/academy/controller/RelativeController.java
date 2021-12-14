package uz.jurayev.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.jurayev.academy.domain.Relative;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.RelativeDto;
import uz.jurayev.academy.service.impl.RelativeServiceImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("/relative")
public class RelativeController {

    private final RelativeServiceImpl relativeService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(relativeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> One(@PathVariable Long id) {
        Relative one = relativeService.getOne(id);
        if (one == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(one);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Result delete = relativeService.delete(id);
        if (delete.getSuccess()) {
            return ResponseEntity.ok(delete);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody RelativeDto relativeDto) {
        Result result = relativeService.addRelative(relativeDto);
        if (result.getSuccess()) {
            return ResponseEntity.status(202).body(result);
        }
        return ResponseEntity.status(409).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody RelativeDto relativeDto) {
        Result edit = relativeService.edit(id, relativeDto);
        if (!edit.getSuccess()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(edit);
    }
}

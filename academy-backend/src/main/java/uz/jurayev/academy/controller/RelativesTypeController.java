package uz.jurayev.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.jurayev.academy.domain.RelativesType;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.service.impl.RelativesTypeServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/relativestype")
public class RelativesTypeController {
    private final RelativesTypeServiceImpl relativesTypeService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<RelativesType> all = relativesTypeService.getAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        RelativesType one = relativesTypeService.getOne(id);
        if (one == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok(one);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Result delete = relativesTypeService.delete(id);
        if (delete.getSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(delete);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody RelativesType relativesType) {
        Result result = relativesTypeService.addRelativesType(relativesType);
        if (result.getSuccess()) {
            return ResponseEntity.status(202).body(result);
        }
        return ResponseEntity.status(409).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody RelativesType type) {
        Result edit = relativesTypeService.edit(id, type);
        if (edit.getSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(edit);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}


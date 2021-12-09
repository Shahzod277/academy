package uz.jurayev.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.jurayev.academy.domain.FamilyCondition;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.service.FamilyConditionService;

import java.util.List;

@RestController
@RequestMapping("/api/familyCondition")
@RequiredArgsConstructor
public class FamilyConditionController {
    final private FamilyConditionService familyConditionService;

    @PostMapping()
    public HttpEntity<?> add(@RequestBody FamilyCondition familyCondition) {
        Result result = familyConditionService.addCondition(familyCondition);
        return ResponseEntity.status(result.getSuccess() ? 201 : 409).body(result);
    }

    @GetMapping("/all")
    public HttpEntity<?> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "15") int size) {
        List<FamilyCondition> familyConditions = familyConditionService.getAll(page, size);
        return ResponseEntity.ok(familyConditions);
    }

    @GetMapping("{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {
        FamilyCondition familyCondition = familyConditionService.getOne(id);
        return ResponseEntity.status(familyCondition != null ? 200 : 409).body(familyCondition);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @RequestBody FamilyCondition condition) {
        FamilyCondition familyCondition = familyConditionService.edit(id, condition);
        return ResponseEntity.status(familyCondition != null ? 201 : 409).body(familyCondition);
    }
    @DeleteMapping("{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        boolean delete = familyConditionService.delete(id);
        if (delete)
            return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();

    }
}
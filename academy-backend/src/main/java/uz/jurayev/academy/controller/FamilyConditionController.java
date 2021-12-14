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
    public HttpEntity<?> getOne(@PathVariable Long id) {
        FamilyCondition familyCondition = familyConditionService.getOne(id);
        return ResponseEntity.status(familyCondition != null ? 200 : 409).body(familyCondition);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Long id, @RequestBody FamilyCondition condition) {
        FamilyCondition familyCondition = familyConditionService.edit(id, condition);
        return ResponseEntity.status(familyCondition != null ? 202 : 409).body(familyCondition);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id) {
        Result delete = familyConditionService.delete(id);
        return ResponseEntity.status(delete.getSuccess() ? 200 : 409).body(delete);
    }
}

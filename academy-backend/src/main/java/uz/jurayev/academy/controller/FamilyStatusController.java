package uz.jurayev.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.jurayev.academy.domain.FamilyStatus;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.FamilyStatusDTO;
import uz.jurayev.academy.service.FamilyStatusService;

import java.util.List;
@RestController
@RequestMapping("/api/familyStatus")
@RequiredArgsConstructor
public class FamilyStatusController {

    final private FamilyStatusService familyStatusService;

    @PostMapping()
    public HttpEntity<?> add(@RequestBody FamilyStatusDTO familyStatusDTO) {
        Result result = familyStatusService.Add(familyStatusDTO);
        return ResponseEntity.status(result.getSuccess() ? 201 : 409).body(result);
    }

    @GetMapping("/all")
    public HttpEntity<?> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "15") int size) {
        List<FamilyStatus> familyStatuses = familyStatusService.getAll(page, size);
        return ResponseEntity.ok(familyStatuses);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Long id) {
        FamilyStatus familyStatus = familyStatusService.getOne(id);
        return ResponseEntity.status(familyStatus != null ? 202 : 409).body(familyStatus);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Long id, @RequestBody FamilyStatusDTO familyStatusDTO) {
        FamilyStatus familyStatusEdit = familyStatusService.edit(id, familyStatusDTO);
        return ResponseEntity.status(familyStatusEdit != null ? 202 : 409).body(familyStatusEdit);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id) {
        boolean delete = familyStatusService.delete(id);
        if (delete)
            return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();

    }
}

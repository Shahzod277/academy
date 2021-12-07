package uz.jurayev.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.jurayev.academy.domain.Benefit;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.service.BenefitService;
import uz.jurayev.academy.service.impl.BenefitServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BenefitController {

    private final BenefitServiceImpl benefitService;

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(value = "0") int page, @RequestParam(value = "10") int size) {
        List<Benefit> allBenefit = benefitService.getAllBenefit(page, size);
        return ResponseEntity.ok(allBenefit);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        Benefit oneBenefit = benefitService.getOneBenefit(id);
        if (oneBenefit != null) {
            return ResponseEntity.ok(oneBenefit);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBenefit(@PathVariable Long id) {
        Result deleteBenefit = benefitService.deleteBenefit(id);
        if (deleteBenefit.getSuccess()) {
            return ResponseEntity.ok(deleteBenefit);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping
    public ResponseEntity<?> saveBenefit(@RequestBody Benefit benefit) {
        Result saveBenefit = benefitService.save(benefit);
        if (saveBenefit.getSuccess()) {
            return ResponseEntity.status(202).body(saveBenefit);
        }
        return ResponseEntity.status(409).body(null);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBenefit(@PathVariable Long id, @RequestBody Benefit benefit) {
        Result editBenefit = benefitService.edit(id, benefit);
        if (editBenefit.getSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(editBenefit);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}

package uz.jurayev.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.jurayev.academy.domain.District;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.DistrictDto;
import uz.jurayev.academy.service.DistrictService;
import uz.jurayev.academy.service.impl.DistrictServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/district")
@RequiredArgsConstructor
public class DistrictController {


    private final DistrictServiceImpl districtService;

    @PostMapping
    public HttpEntity<?> addDistrict(@RequestBody DistrictDto districtDto) {
        Result result = districtService.addDistrict(districtDto);
        return ResponseEntity.status(result.getSuccess() ? 201 : 409).body(result);
    }

    @GetMapping("/all")
    public HttpEntity<?> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "15") int size) {
        List<District> districts = districtService.getAll(page, size);
        return ResponseEntity.ok(districts);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Long id) {
        District district = districtService.getOne(id);
        return ResponseEntity.status(district != null ? 200 : 409).body(district);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Long id, @RequestBody DistrictDto districtDto) {
        Result districtEdit = districtService.edit(id, districtDto);
        return ResponseEntity.status(districtEdit.getSuccess() ? 202 : 409).body(districtEdit);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id) {
        Result delete = districtService.delete(id);
        return ResponseEntity.status(delete.getSuccess() ? 202 : 409).body(delete);
    }
}


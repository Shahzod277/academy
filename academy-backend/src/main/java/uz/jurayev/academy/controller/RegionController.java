package uz.jurayev.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.jurayev.academy.domain.District;
import uz.jurayev.academy.domain.Region;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.DistrictDto;
import uz.jurayev.academy.rest.RegionDto;
import uz.jurayev.academy.service.RegionService;

import java.util.List;

@RestController
@RequestMapping("/api/region")
@RequiredArgsConstructor
public class RegionController {


    private final RegionService regionService;

    @PostMapping
    public HttpEntity<?> addRegion(@RequestBody RegionDto regionDto) {
        Result result = regionService.addRegion(regionDto);
        return ResponseEntity.status(result.getSuccess() ? 201 : 409).body(result);
    }

    @GetMapping("/all")
    public HttpEntity<?> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "15") int size) {
        List<Region> regions = regionService.getAll(page, size);
        return ResponseEntity.ok(regions);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Long id) {
        Region region = regionService.getOne(id);
        return ResponseEntity.status(region != null ? 201 : 409).body(region);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id) {
        boolean delete = regionService.delete(id);
        if (delete)
            return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Long id,@RequestBody RegionDto regionDto) {
        Region region = regionService.edit(id, regionDto);
        return ResponseEntity.status(region != null ? 202 : 409).body(region);
    }
}


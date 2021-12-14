package uz.jurayev.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.jurayev.academy.domain.Country;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.service.CountryService;
import uz.jurayev.academy.service.impl.CountryServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/country")
@RequiredArgsConstructor
public class CountryController {
    final private CountryServiceImpl countryService;

    @PostMapping()
    public HttpEntity<?> addCountry(@RequestBody Country country) {
        Result result = countryService.addCountry(country);
        return ResponseEntity.status(result.getSuccess() ? 201 : 409).body(result);
    }

    @GetMapping("/all")
    public HttpEntity<?> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "15") int size) {
        List<Country> countries = countryService.getAll(page, size);
        return ResponseEntity.ok(countries);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Long id) {
        Country country = countryService.getOne(id);
        return ResponseEntity.status(country != null ? 200 : 409).body(country);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editCountry(@PathVariable Long id, @RequestBody Country country) {
        Country countryEdit = countryService.edit(id, country);
        return ResponseEntity.status(countryEdit != null ? 202 : 409).body(countryEdit);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id) {
        boolean delete = countryService.delete(id);
        if (delete)
            return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

}

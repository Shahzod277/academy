package uz.jurayev.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.jurayev.academy.domain.Address;
import uz.jurayev.academy.domain.Country;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.AddressDTO;
import uz.jurayev.academy.service.AddressService;
import uz.jurayev.academy.service.impl.AddressServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressServiceImpl addressService;

    @PostMapping()
    public HttpEntity<?> addAddress(@RequestBody AddressDTO addressDTO) {
        Result result = addressService.addAddress(addressDTO);
        return ResponseEntity.status(result.getSuccess() ? 201 : 409).body(result);
    }

    @GetMapping("/all")
    public HttpEntity<?> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "15") int size) {
        List<Address> addresses = addressService.getAll(page, size);
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Long id) {
        Address address = addressService.getOne(id);
        return ResponseEntity.status(address != null ? 201 : 409).body(address);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id) {
        boolean delete = addressService.delete(id);
        if (delete)
            return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Long id, @RequestBody AddressDTO addressDTO) {
        Address address = addressService.edit(id, addressDTO);
        return ResponseEntity.status(address != null ? 202 : 409).body(address);
    }
}

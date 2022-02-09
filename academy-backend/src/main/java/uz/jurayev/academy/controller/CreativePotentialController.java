package uz.jurayev.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.jurayev.academy.domain.CreativePotential;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.CreativePotentialDto;
import uz.jurayev.academy.service.CreativePotentialService;
import uz.jurayev.academy.service.impl.CreativePotentialServiceImpl;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/creative_potential")
@CrossOrigin(origins = "*")
public class CreativePotentialController {

    private final CreativePotentialServiceImpl creativePotentialService;

    @PostMapping("/save")
    public Result save(@RequestBody CreativePotentialDto creativePotentialDto){
        return creativePotentialService.save(creativePotentialDto);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody CreativePotentialDto creativePotentialDto){
        Result update = creativePotentialService.update(id, creativePotentialDto);
        if (update.getSuccess())
            return ResponseEntity.ok(update);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(update);
    }

    @GetMapping("/page")
    public ResponseEntity<?> finAll(@RequestParam(value = "0") int page, @RequestParam(value = "10") int size){
        Page<CreativePotential> all = creativePotentialService.findAll(page, size);
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id){
        CreativePotential one = creativePotentialService.getOne(id);
        if (one != null)
            return ResponseEntity.ok(one);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Result delete = creativePotentialService.delete(id);
        if (delete.getSuccess())
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(delete);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(delete);
    }

}

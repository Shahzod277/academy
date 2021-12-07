package uz.jurayev.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.jurayev.academy.domain.Category;
import uz.jurayev.academy.domain.Gender;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.GenderDto;
import uz.jurayev.academy.service.GenderService;
import uz.jurayev.academy.service.impl.GenderServiceImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/gender")
@CrossOrigin(origins = "*")
public class GenderController {

    private final GenderServiceImpl genderService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody GenderDto gender){
        Result save = genderService.save(gender);
        if (save.getSuccess())
            return ResponseEntity.status(202).body(save);
        return ResponseEntity.status(409).body(save);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody GenderDto genderDto){
        Result update = genderService.update(id, genderDto);
        if (update.getSuccess())
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(update);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(update);
    }

    @GetMapping("/page")
    public ResponseEntity<?> page(@RequestParam(value = "0") int page, @RequestParam(value = "10") int size){
        Page<Gender> genderPage = genderService.findAll(page, size);
        return ResponseEntity.ok(genderPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        Gender one = genderService.getOne(id);
        if (one != null)
            return ResponseEntity.ok(one);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Result delete = genderService.delete(id);
        if (delete.getSuccess())
            return ResponseEntity.ok(delete);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(delete);
    }
}

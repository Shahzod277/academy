package uz.jurayev.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.jurayev.academy.domain.Category;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.CategoryDto;
import uz.jurayev.academy.service.CategoryService;
import uz.jurayev.academy.service.impl.CategoryServiceImpl;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/category")
@CrossOrigin(origins = "*")
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody CategoryDto categoryDto){
        Result save = categoryService.save(categoryDto);
        if (save.getSuccess())
            return ResponseEntity.status(201).body(save);
        return ResponseEntity.status(409).body(save);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CategoryDto categoryDto){
        Result update = categoryService.update(id, categoryDto);
        if (update.getSuccess())
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(update);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(update);
    }

    @GetMapping("/page")
    public ResponseEntity<?> page(@RequestParam(value = "0") int page, @RequestParam(value = "10") int size){
        Page<Category> categories = categoryService.page(page, size);
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        Category category = categoryService.getOne(id);
        if (category!=null)
            return ResponseEntity.ok(category);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Result delete = categoryService.delete(id);
        if (delete.getSuccess())
            return ResponseEntity.ok(delete);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(delete);
    }

}

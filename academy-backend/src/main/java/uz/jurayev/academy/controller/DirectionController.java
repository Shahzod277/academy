package uz.jurayev.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.jurayev.academy.domain.Direction;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.DirectionDto;
import uz.jurayev.academy.service.impl.DirectionServiceImpl;

@RestController
@RequestMapping("/api/v1/direction")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class DirectionController {

    private final DirectionServiceImpl directionService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody DirectionDto directionDto){
        Result result = directionService.addDirection(directionDto);
        if (result.getSuccess())
            return ResponseEntity.ok(result);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(directionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        Direction one = directionService.getOne(id);
        if (one != null)
            return ResponseEntity.ok(one);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody DirectionDto directionDto){
        Result result = directionService.edit(id, directionDto);
        if (result.getSuccess())
            return ResponseEntity.ok(result);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Result delete = directionService.delete(id);
        if (delete.getSuccess())
            return ResponseEntity.ok(delete);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(delete);
    }

}

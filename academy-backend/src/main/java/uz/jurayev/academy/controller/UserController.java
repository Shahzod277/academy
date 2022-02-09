package uz.jurayev.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.jurayev.academy.domain.User;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.UserRequestDto;
import uz.jurayev.academy.service.impl.UserServiceImpl;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody UserRequestDto userRequestDto){
        Result result = userService.addUser(userRequestDto);
        if (result.getSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.status(409).body(result);
    }

    @GetMapping
    public ResponseEntity<?> list(){
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        User serviceOne = userService.getOne(id);
        if (serviceOne==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(serviceOne);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody User user){
        Result edit = userService.edit(id, user);
        if (edit.getSuccess()){
            return ResponseEntity.ok(edit);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(edit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Result delete = userService.delete(id);
        if (delete.getSuccess()){
            return ResponseEntity.ok(delete);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(delete);
    }
}

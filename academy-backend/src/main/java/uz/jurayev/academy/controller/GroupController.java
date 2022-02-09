package uz.jurayev.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.jurayev.academy.domain.Group;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.GroupDto;
import uz.jurayev.academy.service.impl.GroupServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/group")
@RequiredArgsConstructor
@CrossOrigin
public class GroupController {
    private final GroupServiceImpl groupService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "15") int size){
        List<Group> groups = groupService.getAll(page, size);
        return ResponseEntity.ok(groups);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        Group group = groupService.getOne(id);
        return ResponseEntity.status(group != null ? 200 : 404).body(group);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Result delete = groupService.delete(id);
        return ResponseEntity.status(delete.getSuccess() ? 200 : 409).body(delete);

    }
    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Long id  , @RequestBody GroupDto groupDto) {
        Result update = groupService.edit(id,groupDto);
        return ResponseEntity.status(update.getSuccess() ? 200 : 400).body(update);
    }
}

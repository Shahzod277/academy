package uz.jurayev.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.jurayev.academy.domain.Groups;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.GroupsDto;
import uz.jurayev.academy.service.impl.GroupServiceImpl;

@RestController
@RequestMapping("/api/v1/group")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class GroupController {

    private final GroupServiceImpl groupService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody GroupsDto groupsDto){
        Result result = groupService.addGroup(groupsDto);
        if (result.getSuccess())
            return ResponseEntity.ok(result);
        return ResponseEntity.status(409).body(result);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(groupService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        Groups one = groupService.getOne(id);
        if (one!=null)
            return ResponseEntity.ok(one);
        return ResponseEntity.status(409).body(null);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody GroupsDto groupsDto){
        Result result = groupService.edit(id, groupsDto);
        if (result.getSuccess())
            return ResponseEntity.ok(result);
        return ResponseEntity.status(409).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Result result = groupService.delete(id);
        if (result.getSuccess())
            return ResponseEntity.ok(result);
        return ResponseEntity.status(409).body(result);
    }

}

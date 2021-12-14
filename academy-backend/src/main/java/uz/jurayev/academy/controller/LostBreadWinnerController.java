package uz.jurayev.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.jurayev.academy.domain.LostBreadwinner;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.service.LostBreadWinnerSerivce;

import java.util.List;

@RestController
@RequestMapping("/api/lostBreadwinner")
@RequiredArgsConstructor
public class LostBreadWinnerController {

    final private LostBreadWinnerSerivce lostBreadWinnerSerivce;

    @PostMapping()
    public HttpEntity<?> add(@RequestBody LostBreadwinner breadwinner) {
        Result result = lostBreadWinnerSerivce.Add(breadwinner);
        return ResponseEntity.status(result.getSuccess() ? 201 : 409).body(result);
    }

    @GetMapping("/all")
    public HttpEntity<?> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "15") int size) {
        List<LostBreadwinner> lostBreadwinners = lostBreadWinnerSerivce.getAll(page, size);
        return ResponseEntity.ok(lostBreadwinners);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Long id) {
        LostBreadwinner breadwinner = lostBreadWinnerSerivce.getOne(id);
        return ResponseEntity.status(breadwinner != null ? 200 : 409).body(breadwinner);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Long id, @RequestBody LostBreadwinner breadwinner) {
        LostBreadwinner breadwinnerEdit = lostBreadWinnerSerivce.edit(id, breadwinner);
        return ResponseEntity.status(breadwinnerEdit != null ? 202 : 409).body(breadwinnerEdit);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Long id){
        Result delete = lostBreadWinnerSerivce.delete(id);
        return ResponseEntity.status(delete.getSuccess() ? 200 : 409).body(delete);
    }
}

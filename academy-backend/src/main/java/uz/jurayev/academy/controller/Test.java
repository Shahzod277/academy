package uz.jurayev.academy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Test {

    @GetMapping("/superadmin")
    public String getSuperAdminPage() {
        return "SuperAdmin Page";
    }

    @GetMapping("/admin")
    public String getAdminPage() {
        return "Admin Page";
    }
}

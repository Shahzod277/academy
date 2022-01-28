package uz.jurayev.academy.rest;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;
    private String password;
}

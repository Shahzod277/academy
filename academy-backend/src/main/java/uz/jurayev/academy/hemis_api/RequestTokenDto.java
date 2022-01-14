package uz.jurayev.academy.hemis_api;

import lombok.Data;

@Data
public class RequestTokenDto {

    private String grant_type;
    private String username;
    private String password;
}

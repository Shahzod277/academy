package uz.jurayev.academy.rest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import uz.jurayev.academy.domain.Role;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
public class UserRequestDto {

        private String username;
        private String password;
        private String email;
        private String phoneNumber;
        private Set<Role> roles = new HashSet<>();
}

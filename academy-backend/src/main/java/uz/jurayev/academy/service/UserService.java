package uz.jurayev.academy.service;

import uz.jurayev.academy.domain.User;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.UserRequestDto;

import java.util.List;

public interface UserService {

    Result addUser(UserRequestDto userRequestDto);
    List<User> getAll();
    User getOne(Long id);
    Result edit(Long id, User user);
    Result delete(Long id);
}

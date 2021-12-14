package uz.jurayev.academy.service;

import uz.jurayev.academy.domain.Faculty;
import uz.jurayev.academy.domain.User;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.FacultyDto;

import java.util.List;

public interface UserService {
    Result addUser(User user);
    List<User> getAll();
    User getOne(Long id);
    Result edit(Long id, User user);
    Result delete(Long id);
}

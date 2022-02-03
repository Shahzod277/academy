package uz.jurayev.academy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.jurayev.academy.domain.Role;
import uz.jurayev.academy.domain.User;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.repository.RoleRepository;
import uz.jurayev.academy.repository.UserRepository;
import uz.jurayev.academy.rest.UserRequestDto;
import uz.jurayev.academy.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Result addUser(UserRequestDto userRequestDto) {

        try{
            User user = new User();
            user.setUsername(userRequestDto.getUsername());
            user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
            user.setEmail(userRequestDto.getEmail());
            user.setPhoneNumber(userRequestDto.getPhoneNumber());

            if (user.getRoles() == null){
                user.setRoles(new HashSet<>());
            }
            user.setRoles(userRequestDto.getRoles());
            userRepository.save(user);
            return new Result("user successfully saved", true);
        }catch (Exception e){
            e.printStackTrace();
            return new Result("Error User, not saved", false);
        }
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getOne(Long id) {
        try {
            Optional<User> userById = userRepository.findById(id);
            if (userById.isEmpty()){
                return null;
            }
            return userById.get();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Result edit(Long id, User user) {
        try {
            Optional<User> byId = userRepository.findById(id);
            if (byId.isEmpty()) {
                return new Result("Not found user " + id, false);
            }
            User user1 = byId.get();
            user1.setUsername(user.getUsername());
            user1.setEmail(user.getEmail());
            user1.setPassword(user.getPassword());
            user1.setPhoneNumber(user.getPhoneNumber());
            userRepository.save(user1);
            return new Result("Upload successfully user", true);
        }catch (Exception e){
            e.printStackTrace();
            return new Result("Error", false);
        }
    }

    @Override
    public Result delete(Long id) {
        try{
            userRepository.deleteById(id);
            return new Result("delete user", true);
        }catch (Exception e){
            e.printStackTrace();
            return new Result("Error deleted", false);
        }
    }
}

package com.cookBook.api.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.cookBook.api.model.data.LoginUser;
import com.cookBook.api.model.data.NewUser;
import com.cookBook.api.model.database.UserRepository;
import com.cookBook.api.model.entity.Rol;
import com.cookBook.api.model.entity.UserModel;

/**
 * UserService
 */
@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Optional<UserModel> createNewUser(NewUser user) {
        if (findUser(user)) {
            return Optional.empty();
        } else {
            return Optional.of(saveUser(user));
        }
    }

    private UserModel saveUser(NewUser user) {
        UserModel entity = new UserModel(
                user.getName(),
                encodePassword(user.getPassword()),
                user.getUsername(),
                user.getRol()
                );
        return repository.save(entity);
    }

    private boolean findUser(NewUser user) {
        Example<UserModel> entity = Example.of(new UserModel(user.getUsername()));
        return repository.exists(entity);
    }

    public Optional<UserModel> findUserById(Long id) {
        return repository.findById(id);
    }

    public boolean deleteUser(Long id) {
        if (existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean deleteUser(String name) {
        Optional<UserModel> user = findUser(name);
        if (user.isPresent()) {
            repository.delete(user.get());
            return true;
        }
        return false;
    }

    private boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public static Rol getRol(String rol) {
        switch (rol) {
            case "admin":
                return Rol.admin;
            case "anonymous":
                return Rol.anonymous;
            case "user":
                return Rol.user;
            default:
                return Rol.user;
        }
    }

    private Optional<UserModel> findUser(String username) {
        Example<UserModel> entity = Example.of(new UserModel(username));
        return repository.findOne(entity);
    }

    private String encodePassword(String rawPassword) {
        return rawPassword;
    }

    public boolean loginUser(LoginUser entity) {
        Optional<UserModel> user = findUser(entity.getUsername());
        if (user.isEmpty()) {
            return false;
        }
        if (user.get().getPassword().equals(encodePassword(entity.getPassword()))) {
            return true;
        }
        return false;
    }

    public List<UserModel> findAllUser() {
        return repository.findAll();
    }
}
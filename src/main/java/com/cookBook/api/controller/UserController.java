package com.cookBook.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cookBook.api.model.data.LoginUser;
import com.cookBook.api.model.data.NewUser;
import com.cookBook.api.model.entity.UserModel;
import com.cookBook.api.model.service.UserService;
import com.cookBook.api.view.UserView;
import com.cookBook.api.view.data.UserDTO;

/**
 * Main controller.
 */
@RestController
@RequestMapping(path = "/user")
class UserController {

    @Autowired
    private final UserView userView;
    private final UserService userService;

    UserController(UserView userView, UserService userService) {
        this.userView = userView;
        this.userService = userService;

    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginUser entity) {
        boolean result = userService.loginUser(entity);
        return userView.loginUser(result);
    }

    // @PreAuthorize
    @GetMapping(value = "/users")
    public List<UserDTO> getAllUsers() {
        List<UserModel> users = userService.findAllUser();
        return userView.getViewAllUsers(users);
    }

    @PostMapping(value = "/users")
    public ResponseEntity<String> createUser(@RequestBody NewUser entity) {
        Optional<UserModel> user = userService.createNewUser(entity);
        return userView.responseCreateUser(user);

    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {
        Optional<UserModel> user = userService.findUserById(id);
        return userView.getUser(user);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        Boolean result = userService.deleteUser(id);
        return userView.deleteUser(result);
    }

    @DeleteMapping(value = "/users")
    public ResponseEntity<String> deleteUserByName(@RequestParam(name = "name", required = true) String name) {
        Boolean result = userService.deleteUser(name);
        return userView.deleteUser(result);
    }

}

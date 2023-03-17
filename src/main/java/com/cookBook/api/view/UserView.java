package com.cookBook.api.view;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.cookBook.api.model.entity.UserModel;
import com.cookBook.api.view.data.UserDTO;
import com.cookBook.api.view.mapping.UserMapping;

/**
 * UserView
 */
@Component
public class UserView {

    public List<UserDTO> getViewAllUsers(List<UserModel> users) {
        return UserMapping.userToUserDTO(users);
    }

    public ResponseEntity<String> responseCreateUser(Optional<UserModel> entity) {
        if (entity.isPresent()) {
            return new ResponseEntity<>("User Created.", HttpStatus.OK);
        }

        return new ResponseEntity<>("User exists.", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> getUser(Optional<UserModel> entity) {
        if (entity.isPresent()) {
            UserDTO user = UserMapping.userToUserDTO(entity.get());
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>("No user found.", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> deleteUser(Boolean result) {
        if (result) {
            return new ResponseEntity<>("User deleted.", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("User doesn't exist.", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> loginUser(boolean result) {
        if (result) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
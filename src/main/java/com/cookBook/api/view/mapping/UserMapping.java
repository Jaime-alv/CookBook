package com.cookBook.api.view.mapping;

import java.util.ArrayList;
import java.util.List;

import com.cookBook.api.model.entity.UserModel;
import com.cookBook.api.view.data.UserDTO;

/**
 * UserMapping
 */

public interface UserMapping {

    static UserDTO userToUserDTO(UserModel entity) {
        return new UserDTO(entity);
    }

    static List<UserDTO> userToUserDTO(List<UserModel> entity) {
        List<UserDTO> users = new ArrayList<UserDTO>();
        entity.stream().forEach(user -> users.add(userToUserDTO(user)));
        return users;
    }
    
}
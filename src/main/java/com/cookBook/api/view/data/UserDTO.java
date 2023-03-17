package com.cookBook.api.view.data;

import com.cookBook.api.model.entity.UserModel;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * UserDTO
 */
@Data
public class UserDTO {

    @JsonProperty("username")
    private String username;

    @JsonProperty("name")
    private String name;

    @JsonProperty("rol")
    private String rol;

    public UserDTO(UserModel user) {
        this.name = user.getName();
        this.rol = user.getRol().toString();
        this.username = user.getUsername();
    }

}
package com.cookBook.api.model.data;

import jakarta.validation.constraints.NotBlank;

import org.springframework.lang.Nullable;

import com.cookBook.api.model.entity.Rol;
import com.cookBook.api.model.service.UserService;

import lombok.Data;

/**
 * NewUser
 */
@Data
public class NewUser {

    @NotBlank
    private String name;

    @Nullable
    private Rol rol;

    @NotBlank
    private String username;

    @NotBlank
    private String password;


    public NewUser(@NotBlank String name,@Nullable String rol, @NotBlank String username, @NotBlank String password) {
        this.name = name;
        this.rol = UserService.getRol(rol);
        this.username = username;
        this.password = password;
    }

}


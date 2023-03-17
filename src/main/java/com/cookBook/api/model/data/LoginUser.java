package com.cookBook.api.model.data;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginUser {
    
    @NotBlank
    private String username;

    @NotBlank
    private String password;

}

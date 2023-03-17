package com.cookBook.api.model.entity;

import java.util.Objects;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class UserModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @NotNull
    @Column(name = "username", unique = true)
    private String username;

    @NotNull
    private String password;

    @Nullable
    private String name;

    @Nullable
    private Rol rol;
    
    public UserModel(@NotNull String username, @NotNull String password, String name, Rol rol) {
      this.username = username;
      this.password = password;
      this.name = name;
      this.rol = rol;
    }

    public UserModel(String username) {
        this.username = username;
    }

    public UserModel() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rol getRol() {
        return this.rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public boolean equals(Object o) {
  
      if (this == o)
        return true;
      if (!(o instanceof UserModel))
        return false;
      UserModel User = (UserModel) o;
      return Objects.equals(this.id, User.id) && Objects.equals(this.name, User.name)
          && Objects.equals(this.rol, User.rol);
    }
  
    @Override
    public int hashCode() {
      return Objects.hash(this.id, this.name, this.rol);
    }
  
    @Override
    public String toString() {
      return "User{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.rol + '\'' + '}';
    }

    public String getUsername() {
      return username;
    }

    public void setUsername(String username) {
      this.username = username;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }

    
}
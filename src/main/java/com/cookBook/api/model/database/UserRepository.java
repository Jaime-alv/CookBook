package com.cookBook.api.model.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookBook.api.model.entity.UserModel;


/**
 * UserRepository
 * 
 * Extends with JpaRepository, which in turn extends CrudRepository.
 */
public interface UserRepository extends JpaRepository<UserModel, Long>{}
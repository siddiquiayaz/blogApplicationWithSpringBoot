package com.ayaz.blg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayaz.blg.entities.User;

public interface UserRepositroy  extends JpaRepository<User, Long>{

}

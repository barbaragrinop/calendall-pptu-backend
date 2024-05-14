package com.dev.calendallpptubackend.repository;

import org.springframework.stereotype.Repository;

import com.dev.calendallpptubackend.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);
}

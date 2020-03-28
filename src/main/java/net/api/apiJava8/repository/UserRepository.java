package net.api.apiJava8.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.api.apiJava8.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}
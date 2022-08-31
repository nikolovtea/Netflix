package com.example.netflix.repos;

import com.example.netflix.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findUserByUsername(String username);
    void deleteUserByUsername(String username);
}

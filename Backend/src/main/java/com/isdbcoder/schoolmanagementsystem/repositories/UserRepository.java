package com.isdbcoder.schoolmanagementsystem.repositories;

import com.isdbcoder.schoolmanagementsystem.enums.UserRole;
import com.isdbcoder.schoolmanagementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findByRole(UserRole userRole);

    Optional<User> findFirstByEmail(String email);

}

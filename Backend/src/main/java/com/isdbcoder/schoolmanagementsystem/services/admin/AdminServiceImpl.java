package com.isdbcoder.schoolmanagementsystem.services.admin;

import com.isdbcoder.schoolmanagementsystem.enums.UserRole;
import com.isdbcoder.schoolmanagementsystem.model.User;
import com.isdbcoder.schoolmanagementsystem.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl {

    private final UserRepository userRepository;

    public AdminServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @PostConstruct
    public void createAdminAccount(){

        User adminAccount = userRepository.findByRole(UserRole.ADMIN);
        if (adminAccount == null){
            User admin = new User();
            admin.setEmail("admin@test.com");
            admin.setName("admin");
            admin.setRole(UserRole.ADMIN);
            admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(admin);
        }
    }
}

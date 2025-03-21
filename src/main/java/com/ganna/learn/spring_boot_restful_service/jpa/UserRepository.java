package com.ganna.learn.spring_boot_restful_service.jpa;

import com.ganna.learn.spring_boot_restful_service.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

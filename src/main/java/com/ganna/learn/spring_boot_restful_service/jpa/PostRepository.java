package com.ganna.learn.spring_boot_restful_service.jpa;

import com.ganna.learn.spring_boot_restful_service.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}

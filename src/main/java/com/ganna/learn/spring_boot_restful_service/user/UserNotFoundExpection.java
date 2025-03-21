package com.ganna.learn.spring_boot_restful_service.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundExpection extends RuntimeException {
    public UserNotFoundExpection(String s) {
        super(s);
    }
}

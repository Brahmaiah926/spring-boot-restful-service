package com.ganna.learn.spring_boot_restful_service.helloworld;

public class HelloWorldBean {

    private String message;
    public HelloWorldBean(String msg) {
        this.setMessage(msg);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }
}

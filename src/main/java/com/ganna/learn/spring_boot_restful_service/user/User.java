package com.ganna.learn.spring_boot_restful_service.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.springframework.boot.convert.DataSizeUnit;

import java.time.LocalDate;
import java.util.List;

@Entity(name="user_details")
public class User {

    protected User(){

    }
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=2)
    private String name;

    @Past()
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;

    public User(Integer id, String name, LocalDate birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}

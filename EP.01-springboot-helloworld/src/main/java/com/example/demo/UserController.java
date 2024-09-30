package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@RestController
public class UserController {

    @GetMapping(value = "/users", produces = "application/json")
    public Users getUsers() {
        List<User> usersList = new ArrayList<>();

        usersList.add(new User(1, "John Doe", "john.doe@example.com"));
        usersList.add(new User(2, "Jane Smith", "jane.smith@example.com"));
        usersList.add(new User(3, "Michael Johnson", "michael.johnson@example.com"));
        usersList.add(new User(4, "Emily Davis", "emily.davis@example.com"));
        usersList.add(new User(5, "William Brown", "william.brown@example.com"));
        usersList.add(new User(6, "Sophia Taylor", "sophia.taylor@example.com"));
        usersList.add(new User(7, "James Anderson", "james.anderson@example.com"));
        usersList.add(new User(8, "Olivia Martinez", "olivia.martinez@example.com"));
        usersList.add(new User(9, "Benjamin Thomas", "benjamin.thomas@example.com"));
        usersList.add(new User(10, "Isabella Lee", "isabella.lee@example.com"));

        return new Users(usersList);
    }
}

@XmlRootElement(name = "users")
class Users {
    private List<User> users;

    public Users() {}

    public Users(List<User> users) {
        this.users = users;
    }

    @XmlElement(name = "user")
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

@XmlRootElement
class User {
    private int id;
    private String name;
    private String email;

    public User() {}

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

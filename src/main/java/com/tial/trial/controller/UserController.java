package com.tial.trial.controller;

import com.tial.trial.model.User;
import com.tial.trial.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserDaoService dao;

    @Autowired
    public UserController(UserDaoService dao) {
        this.dao = dao;
    }

    @GetMapping
    public Collection<User> listUsers() {
        return dao.getUsers();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {
        return dao.getUserById(id);
    }

    @PostMapping()
    public void addUser(@RequestBody User user) {
        dao.addUser(user);
    }

    @PostMapping("/{name}/{lastName}/{id}")
    public int addUser(@PathVariable String name, @PathVariable String lastName, @PathVariable int id){
        dao.addUser(name,lastName,id);
        return 1;
    }

}

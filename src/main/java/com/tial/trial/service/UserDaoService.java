package com.tial.trial.service;

import com.tial.trial.model.User;
import com.tial.trial.repository.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserDaoService {

    private final Base base;

    @Autowired
    public UserDaoService(Base base) {
        this.base = base;
    }

    public Collection<User> getUsers() {
        return base.listUsers();
    }

    public User getUserById(int id) {
        return base.getUserById(id);
    }

    public void addUser(User user) {
        base.addUser(user);
    }

    public void addUser(String name, String lastName, int id) {
        base.addUser(new User(name, lastName, id));
    }
}

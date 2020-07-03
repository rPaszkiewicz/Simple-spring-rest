package com.tial.trial.repository;

import com.tial.trial.model.User;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class Base {

    private static Map<Integer, User> map = new LinkedHashMap<>();

    private static void presetUsers(){
        map.put(1, new User("Alfred", "Woulden", 1));
        map.put(2, new User("Jeff", "Tatanka", 2));
        map.put(3, new User("Marion", "Cobretti", 3));
    }

    public Collection<User> listUsers() {
        presetUsers();
        return map.values();
    }

    public User getUserById(int id) {
        Optional<User> optionalUser = Optional.ofNullable(map.get(id));
        return optionalUser.orElseGet(() -> new User("John", "Doe", 0));
    }

    public void addUser(User user){
        map.put(user.getId(),user);
    }
}

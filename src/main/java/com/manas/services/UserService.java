package com.manas.services;

import com.manas.entities.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    void deleteUserById(Long id);

}

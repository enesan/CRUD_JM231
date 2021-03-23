package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);
    List<User> getSomeUsers(int count);
    void deleteUser(User user);
    void updateUser(Long id, String name, String surname);
}


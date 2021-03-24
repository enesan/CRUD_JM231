package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);
    List<User> getSomeUsers();
    void deleteUser(long id);
    //void deleteUser(User user);
    void updateUser(long id, String name, String surname);
}


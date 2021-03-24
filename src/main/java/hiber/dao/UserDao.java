package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);
    List<User> getSomeUsers();
    void deleteUser(long id);
    void updateUser(long id, String name, String surname);
}

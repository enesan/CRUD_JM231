package hiber.dao;

import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    // разобраться с persistanceunit и persistancecontext
    @Autowired
    @Qualifier("entityManagerFactory")
    private EntityManagerFactory entityManagerFactory;

    @Transactional
    @Override
    // как вытащить юзера из параметра? например, если бы было
    // insert into User(name, surname) select name, surname from ***user***");
    public void addUser(User user){
        entityManagerFactory.createEntityManager()
                .createNativeQuery(String.format("insert into users values (%s, %s)",
                user.getName(), user.getSurname()));
    }

    @Transactional
    @Override
    public List<User> getSomeUsers(int count) {
        TypedQuery<User> query =(TypedQuery<User>) entityManagerFactory.createEntityManager()
                .createQuery("from User");
        return query.getResultList();
    }

    @Transactional
    @Override
    public void deleteUser(User user) {
      //  Query query = entityManagerFactory.createEntityManager()
      //          .createQuery("delete from User where id =: u");
        entityManagerFactory.createEntityManager().remove(user);
        System.out.println("Note: User deleted, id = " + user.getId());
    }

    @Transactional
    @Override
    public void updateUser(Long id, String name, String surname) {
        Query query = entityManagerFactory.createEntityManager()
                .createQuery("update User set name = :name, surname = :surname " +
                        "where id = :id");
    }
}

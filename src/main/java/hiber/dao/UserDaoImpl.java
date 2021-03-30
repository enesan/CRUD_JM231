package hiber.dao;

import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager em;

    @Transactional
    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Transactional
    @Override
    public List<User> getSomeUsers() {
        TypedQuery<User> query = (TypedQuery<User>) em.createQuery("from User");
        return query.getResultList();
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        User user = em.find(User.class, id);
        em.remove(em.contains(user) ? user : em.merge(user));
    }

    @Transactional
    @Override
    public void updateUser(long id, String name, String surname) {
        int result = em.createQuery("update User set name = :name, surname = :surname " +
                "where id = :id")
                .setParameter("id", id)
                .setParameter("name", name)
                .setParameter("surname", surname)
                .executeUpdate();

    }

    @Transactional
    @Override
    public User getUserById(long id) {
        return em.find(User.class, id);
    }
}

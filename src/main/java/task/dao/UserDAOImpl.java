package task.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import task.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;


@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager em;


    @Override
    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(em.find(User.class, id));
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            em.persist(user);
            return user;
        } else {
            return em.merge(user);
        }
    }

    @Override
    public void deleteById(Long id) {
        findById(id).ifPresent(em::remove);

    }

}

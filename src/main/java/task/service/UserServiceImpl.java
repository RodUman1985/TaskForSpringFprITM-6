package task.service;

import task.dao.UserDAO;
import task.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;



    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override

    public User save(User user) {
        return userDAO.save(user);
    }

    @Override

    public void deleteById(Long id) {
        userDAO.deleteById(id);
    }
}
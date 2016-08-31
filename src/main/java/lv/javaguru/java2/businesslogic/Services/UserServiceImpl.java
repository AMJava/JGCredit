package lv.javaguru.java2.businesslogic.Services;

import lv.javaguru.java2.businesslogic.UserService;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    public User findByLogin(String login) throws SQLException {

        return userDAO.getByLogin(login);
    }

    @Transactional
    public User CheckAuthorization(String login, String password) {

        User user = null;
        try {
            user = findByLogin(login);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (user != null) {
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

}

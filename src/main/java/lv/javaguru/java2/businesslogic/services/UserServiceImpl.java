package lv.javaguru.java2.businesslogic.services;

import lv.javaguru.java2.businesslogic.UserService;
import lv.javaguru.java2.businesslogic.UserValidator;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.ConvertorDTO;
import lv.javaguru.java2.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ConvertorDTO convertorDTO;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    public List<String> create(UserDTO userDTO) throws SQLException{

        User user = convertorDTO.convertUserFromDTO(userDTO);
        List<String> registerErrors = userValidator.validateUser(user,userDTO.getPassword2());
        if (registerErrors.size() > 0) {
            return registerErrors;
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userDAO.create(user);
        }
        return null;
    }

    @Transactional
    public User findByLogin(String login) throws SQLException {

        return userDAO.getByLogin(login);
    }

    @Transactional
    public User checkAuthorization(String login, String password) {

        User user = null;
        try {
            user = findByLogin(login);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }
}

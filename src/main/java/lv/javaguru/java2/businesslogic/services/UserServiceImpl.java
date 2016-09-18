package lv.javaguru.java2.businesslogic.services;

import lv.javaguru.java2.businesslogic.UserService;
import lv.javaguru.java2.businesslogic.UserValidator;
import lv.javaguru.java2.businesslogic.exceptions.ServiceException;
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
    public User create(UserDTO userDTO) throws SQLException, ServiceException {

        User user = convertorDTO.convertUserFromDTO(userDTO);
        if(user == null)
            throw new ServiceException("Please Contact Second Line Support");
        boolean isVaalid = userValidator.validateUser(user,userDTO.getPassword2());
        if (isVaalid) {
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
    public User checkAuthorization(String login, String password) throws SQLException, ServiceException {

        if(login.equals("")){
            throw new ServiceException("Login cannot be null or empty");
        }

        if(password.equals("")){
            throw new ServiceException("Password cannot be null or empty");
        }

        User user = null;
        user = findByLogin(login);
        if(user == null)
            throw new ServiceException("Wrong Login");
        else{
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
            else{
                throw new ServiceException("Wrong Password");
            }
        }
    }
}

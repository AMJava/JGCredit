package lv.javaguru.java2.businesslogic.services;

import lv.javaguru.java2.businesslogic.CommunicationService;
import lv.javaguru.java2.businesslogic.UserService;
import lv.javaguru.java2.businesslogic.UserValidator;
import lv.javaguru.java2.businesslogic.exceptions.CommunicationException;
import lv.javaguru.java2.businesslogic.exceptions.ServiceException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.ConvertorDTO;
import lv.javaguru.java2.dto.UserDTO;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import java.security.SecureRandom;
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

    @Autowired
    CommunicationService communicationService;

    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";

    @Transactional
    public UserDTO create(UserDTO userDTO) throws SQLException, ServiceException {

        User user = convertorDTO.convertUserFromDTO(userDTO);
        if(user == null)
            throw new ServiceException("Please Contact Second Line Support, null was returned by DTOConverter");
        boolean isVaalid = userValidator.validateUser(user,userDTO.getPassword2());
        if (isVaalid) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Long userId = userDAO.create(user);
            userDTO.setId(userId);
        }
        return userDTO;
    }

    @Transactional
    public User findByLogin(String login) throws SQLException {

        return userDAO.getByLogin(login);
    }

    @Transactional
    public void update(User user) throws SQLException {

        userDAO.update(user);
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

    @Transactional
    public void restorePass(String login, String question, String answer) throws SQLException, ServiceException, MessagingException, CommunicationException {

        if(login.equals("")){
            throw new ServiceException("Login cannot be null or empty");
        }

        if(question.equals("") || question.equals("Select Question")){
            throw new ServiceException("Please choose secret question");
        }

        if(answer.equals("")){
            throw new ServiceException("Answer cannot be null or empty");
        }

        User user = null;
        user = findByLogin(login);
        if(user == null)
            throw new ServiceException("User is not exist");
        else{
            if (!user.getQuestion().equals(question) || !user.getAnswer().equals(answer)) {
                throw new ServiceException("Quastion or Answer are incorrect");
            }
            else{
                String newPassword = RandomStringUtils.random( 10, 0, 0, false, false, characters.toCharArray(), new SecureRandom() );
                user.setPassword(passwordEncoder.encode(newPassword));
                update(user);
                communicationService.sendRestoreEmail(user, newPassword);
            }
        }
    }
}

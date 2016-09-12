package lv.javaguru.java2.businesslogic.Services;

import lv.javaguru.java2.businesslogic.UserService;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.ConvertorDTO;
import lv.javaguru.java2.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Transactional
    public List<String> create(UserDTO userDTO) throws SQLException{

        User user = convertorDTO.convertUserFromDTO(userDTO);
        List<String> registerErrors = validateUser(user,userDTO.getPassword2());
        if (registerErrors.size() > 0) {
            return registerErrors;
        } else {
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
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    @Transactional
    public List<String> validateUser(User user, String Password2) {

        List<String> errors = new ArrayList<String>();

        User existingUser = null;
        if (user == null){
            errors.add("Tehnical error, please contact 2 line support");
            return errors;
        }

        if(user.getLogin() == null){
            errors.add("Login is empty");}
        if(!user.getPassword().equals(Password2)){
                errors.add("Login is empty");}
        if(user.getEmail() == null || user.getFName() == null || user.getLName() == null || user.getGender() == null || user.getPersonalCode() == null ||
        user.getBirthDate() == null || user.getAddress() == null || user.getPhoneNumber() == null ||
        user.getQuestion() == null || user.getAnswer() == null){
            errors.add("Some of required fields are empty");}
        if(user.getPassword() != null && user.getPassword().length() > 6 &&
        user.getPassword().length() < 15 && user.getPassword().matches(".*[a-zA-Z]+.*") &&
        user.getPassword().matches(".*[0-9]+.*") && errors.size() <= 0){
            try {
                existingUser = findByLogin(user.getLogin());
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (existingUser != null) {
                errors.add("User with same login already exist");
            }
        }
        else{
            errors.add("Password should be > 6 and < 15 symbvols and contain characters and numbers");
        }

        return errors;
    }

}

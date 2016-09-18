package lv.javaguru.java2.businesslogic.validators;

import lv.javaguru.java2.businesslogic.UserService;
import lv.javaguru.java2.businesslogic.UserValidator;
import lv.javaguru.java2.businesslogic.exceptions.ServiceException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.ConvertorDTO;
import lv.javaguru.java2.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserValidatorImpl implements UserValidator {

    @Autowired
    private UserDAO userDAO;

    public boolean validateUser(User user, String Password2) throws SQLException, ServiceException {

        User existingUser = null;
        if (user == null){
            throw new ServiceException("Please Contact Second Line Support.");
        }

        existingUser = userDAO.getByLogin(user.getLogin());
        if (existingUser != null) {
            throw new ServiceException("User with same login already exist.");
        }

        existingUser = userDAO.getByEmail(user.getEmail());
        if (existingUser != null) {
            throw new ServiceException("User with same email already exist.");
        }

        if(!user.getPassword().equals(Password2)) {
            throw new ServiceException("Your password and confirmation password do not match.");
        }
        if(user.getTerm() == null || user.getTerm().equals("N")){
            throw new ServiceException("Check that you have read and agree to the terms of the JGCredit.");
        }


        if(!validatePassword(user.getPassword())){
            throw new ServiceException("Password must contain at least 8 characters including 1 uppercase letter, 1 lowercase letter and 1 alphanumeric characters.");
        }

        if(!validateAge(user.getBirthDate())){
            throw new ServiceException("A person must be 18 years old.");
        }

        return true;
    }

    public boolean validatePassword(String password){

        boolean flagUppercase = false;
        boolean flagLowercase = false;
        boolean flagDigit = false;
        boolean flag = false;

        if (password.length() >= 8) {

            for (int i = 0; i < password.length(); i++) {

                if (!Character.isLetterOrDigit(password.charAt(i))) {
                    return false;
                }

                if (Character.isDigit(password.charAt(i)) && !flagDigit) {
                    flagDigit = true;

                }

                if (Character.isUpperCase(password.charAt(i)) && !flagUppercase) {
                    flagUppercase = true;

                }

                if (Character.isLowerCase(password.charAt(i)) && !flagLowercase) {
                    flagLowercase = true;
                }
            }
        }

        if (flagDigit && flagUppercase && flagLowercase) {
            flag = true;
        }
        return flag;
    }

    public boolean validateAge(Date birthDate){
        LocalDate today = LocalDate.now();
        LocalDate localBirthDate = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period p = Period.between(localBirthDate, today);
        if(p.getYears() > 18){
            return true;
        }
        return false;
    }
}

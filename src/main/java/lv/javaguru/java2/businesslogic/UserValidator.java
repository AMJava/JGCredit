package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.UserDTO;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface UserValidator {

    List<String> validateUser(User User, String password2) throws SQLException;

    boolean validatePassword(String password);

    boolean validateAge(Date birthDate);
}

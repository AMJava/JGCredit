package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.UserDTO;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    List<String> create(UserDTO userDTO) throws SQLException;

    User findByLogin(String login) throws SQLException;

    User checkAuthorization(String login, String password);

    List<String> validateUser(User User, String Password2);

}

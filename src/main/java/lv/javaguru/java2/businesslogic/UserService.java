package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.businesslogic.exceptions.ServiceException;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.UserDTO;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    User create(UserDTO userDTO) throws SQLException, ServiceException;

    User findByLogin(String login) throws SQLException;

    User checkAuthorization(String login, String password) throws SQLException, ServiceException;

}

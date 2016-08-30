package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.domain.User;

import java.sql.SQLException;

public interface UserLoginService {

    User findByLogin(String login) throws SQLException;

    User CheckAuthorization(String login, String password);

}

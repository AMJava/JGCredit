package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    User getByLogin(String login) throws SQLException;

}

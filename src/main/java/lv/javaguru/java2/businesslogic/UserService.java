package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.businesslogic.exceptions.CommunicationException;
import lv.javaguru.java2.businesslogic.exceptions.ServiceException;
import lv.javaguru.java2.businesslogic.exceptions.UnAuthorizedUserException;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.UserDTO;

import javax.mail.MessagingException;
import java.sql.SQLException;
import java.util.List;

public interface UserService {

    UserDTO create(UserDTO userDTO) throws SQLException, ServiceException;

    User findByLogin(String login) throws SQLException;

    void update(User User) throws SQLException;

    User checkAuthorization(String login, String password) throws SQLException, ServiceException;

    void checkAuthorization() throws UnAuthorizedUserException;

    void restorePass(String login, String question, String answer) throws SQLException, ServiceException, MessagingException, CommunicationException;

    void login(UserDTO userDTO);
}

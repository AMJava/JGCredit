package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.businesslogic.exceptions.CommunicationException;
import lv.javaguru.java2.businesslogic.exceptions.ServiceException;
import lv.javaguru.java2.domain.Communication;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.UserDTO;

import javax.mail.MessagingException;
import java.sql.SQLException;

public interface CommunicationService {

    Long create(Communication communication) throws SQLException, ServiceException, CommunicationException;

    void sendRestoreEmail(User user, String password) throws SQLException, MessagingException, CommunicationException;

    void sendChangeEmail(User user) throws SQLException, MessagingException, CommunicationException;

    void generateAndSendEmail(String sBody, String sTo, String sSubject) throws MessagingException;

}

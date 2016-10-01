package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.businesslogic.exceptions.CommunicationException;
import lv.javaguru.java2.businesslogic.exceptions.ServiceException;
import lv.javaguru.java2.businesslogic.exceptions.UnAuthorizedUserException;
import lv.javaguru.java2.domain.Rate;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.UserDTO;

import javax.mail.MessagingException;
import java.sql.SQLException;

public interface RateService {

    Rate findByTermAndDuration(int duration, String term) throws SQLException;

}

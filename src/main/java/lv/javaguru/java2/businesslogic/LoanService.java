package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.businesslogic.exceptions.CommunicationException;
import lv.javaguru.java2.businesslogic.exceptions.ServiceException;
import lv.javaguru.java2.domain.Rate;
import lv.javaguru.java2.dto.LoanDTO;

import javax.mail.MessagingException;
import java.sql.SQLException;

public interface LoanService {

    LoanDTO create(LoanDTO loanDTO) throws SQLException, ServiceException, CommunicationException, MessagingException;

    Double CalculateLoan(int amount, int term, String duration) throws SQLException;

}

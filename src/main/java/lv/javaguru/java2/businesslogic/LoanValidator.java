package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.businesslogic.exceptions.ServiceException;
import lv.javaguru.java2.domain.Loan;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.LoanDTO;

import java.sql.SQLException;
import java.util.Date;

public interface LoanValidator {

    boolean validateLoan(LoanDTO loanDTO) throws SQLException, ServiceException;

    boolean validateIBAN(String bankNumber);

}

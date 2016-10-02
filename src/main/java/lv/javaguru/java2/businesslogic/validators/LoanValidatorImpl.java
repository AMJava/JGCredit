package lv.javaguru.java2.businesslogic.validators;

import lv.javaguru.java2.businesslogic.LoanValidator;
import lv.javaguru.java2.businesslogic.UserValidator;
import lv.javaguru.java2.businesslogic.exceptions.ServiceException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.Loan;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.LoanDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Service
public class LoanValidatorImpl implements LoanValidator {

    public boolean validateLoan(LoanDTO loanDTO) throws SQLException, ServiceException {

        if (loanDTO == null){
            throw new ServiceException("Please Contact Second Line Support.User is null in validateUser method");
        }

        if(loanDTO.getAgreementTeam() == null || loanDTO.getTerm().equals("N")){
            throw new ServiceException("Check that you have read and agree to the terms of the JGCredit.");
        }


        if(!validateIBAN(loanDTO.getBankAccountNumb())){
            throw new ServiceException("Bank Number must contain at least 15 characters.");
        }
        return true;
    }

    public boolean validateIBAN(String bankNumber){
        if(bankNumber.length() >= 15){
            return true;
        }
        return false;
    }
}

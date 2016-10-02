package lv.javaguru.java2.businesslogic.services;

import lv.javaguru.java2.businesslogic.CommunicationService;
import lv.javaguru.java2.businesslogic.LoanService;
import lv.javaguru.java2.businesslogic.LoanValidator;
import lv.javaguru.java2.businesslogic.UserService;
import lv.javaguru.java2.businesslogic.exceptions.CommunicationException;
import lv.javaguru.java2.businesslogic.exceptions.ServiceException;
import lv.javaguru.java2.database.LoanDAO;
import lv.javaguru.java2.database.RateDAO;
import lv.javaguru.java2.domain.Loan;
import lv.javaguru.java2.domain.Rate;
import lv.javaguru.java2.dto.ConvertorLoanDTO;
import lv.javaguru.java2.dto.LoanDTO;
import lv.javaguru.java2.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private RateDAO rateDAO;

    @Autowired
    private LoanDAO loanDAO;

    @Autowired
    private LoanValidator loanValidator;

    @Autowired
    UserService userService;

    @Autowired
    private ConvertorLoanDTO convertorLoanDTO;

    @Autowired
    CommunicationService communicationService;

    @Transactional
    public LoanDTO create(LoanDTO loanDTO) throws SQLException, ServiceException, CommunicationException, MessagingException {

        boolean isValid = loanValidator.validateLoan(loanDTO);
        if (isValid) {
                Loan loan = convertorLoanDTO.convertLoanFromDTO(loanDTO);
                if(loan == null)
                    throw new ServiceException("Please Contact Second Line Support, null was returned by DTOConverter");
            Date today = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(today);
            cal.add(Calendar.MONTH, loan.getDuration());
            UserDTO userDTO = userService.gerSessionUserDTO();

            loan.setStartDate(today);
            loan.setEndDate(cal.getTime());
            loan.setLoanStatus("APPROVED");
            loan.setUserId(userDTO.getId());
            Long loanId = loanDAO.create(loan);
            loanDTO.setId(loanId);
            communicationService.sendLoanEmail(userDTO.getId(), userDTO.getEmail());
        }
        return loanDTO;
    }

    public Double CalculateLoan(int amount, int duration, String term) throws SQLException{
        Double total = 0.0;
        Rate rate = new Rate();
        rate = rateDAO.getByTermAndDuration(duration,term);
        total = rate.getRate()*amount;
        return total;
    }


}

package lv.javaguru.java2.dto;

import lv.javaguru.java2.domain.Loan;
import lv.javaguru.java2.domain.User;
import org.springframework.stereotype.Component;

/**
 * Created by Arturs on 29.08.2016.
 */
@Component
public class ConvertorLoanDTO {

    public LoanDTO convertLoanToDTO(Loan loan) {

        if (loan != null) {
            return new LoanDTO(
            loan.getId(),
            loan.getLoan(),
            loan.getLoanSum(),
            loan.getDuration(),
            loan.getTerm(),
            loan.getTermPayment(),
            loan.getStartDate(),
            loan.getEndDate(),
            loan.getExtendedDate(),
            loan.getLoanStatus(),
            loan.getExtendedFlag(),
            loan.getUserId(),
            loan.getEmployeeId(),
            loan.getBankAccountNumb(),
            loan.getComments(),
            loan.getAgreement());
        }
        return null;
    }

    public Loan convertLoanFromDTO(LoanDTO loanDTO) {

        if (loanDTO != null) {
            return new Loan(
            loanDTO.getId(),
            loanDTO.getLoan(),
            loanDTO.getLoanSum(),
            loanDTO.getDuration(),
            loanDTO.getTerm(),
            loanDTO.getTermPayment(),
            loanDTO.getStartDate(),
            loanDTO.getEndDate(),
            loanDTO.getExtendedDate(),
            loanDTO.getLoanStatus(),
            loanDTO.getExtendedFlag(),
            loanDTO.getUserId(),
            loanDTO.getEmployeeId(),
            loanDTO.getBankAccountNumb(),
            loanDTO.getComments(),
            loanDTO.getAgreement());
        }
        return null;
    }
}

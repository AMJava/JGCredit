package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Loan;

import java.util.List;

/**
 * Created by Arturs on 10.08.2016.
 */
public interface LoanDAO {

    void createLoan(Loan loan) throws DBException;

    Loan getLoanById(Long id) throws DBException;

    void deleteLoan(Long id) throws DBException;

    void updateLoanStatus(String status) throws DBException;

    List<Loan> getAllUserLoans(Long userId) throws DBException;
}

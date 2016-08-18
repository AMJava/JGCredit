package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.LoanExt;

import java.util.List;

/**
 * Created by Arturs on 10.08.2016.
 */
public interface LoanExtDAO {

    void createLoanExt(LoanExt loanExt) throws DBException;

    LoanExt getLoanExtById(Long id) throws DBException;

    void deleteLoanExt(Long id) throws DBException;

    void updateLoanExtStatus(String status) throws DBException;

    List<LoanExt> getAllLoanExts(Long loanId) throws DBException;
}

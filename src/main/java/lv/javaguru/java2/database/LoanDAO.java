package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Loan;
import lv.javaguru.java2.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface LoanDAO extends BaseDAO<Loan> {

    List<Loan> getActiveUserLoans(Long userId) throws SQLException;

    List<Loan> getUserLoans(Long userId) throws SQLException;
}

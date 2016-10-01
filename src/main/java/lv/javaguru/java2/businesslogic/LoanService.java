package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.domain.Rate;

import java.sql.SQLException;

public interface LoanService {

    Double CalculateLoan(int amount, int term, String duration) throws SQLException;

}

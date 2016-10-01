package lv.javaguru.java2.businesslogic.services;

import lv.javaguru.java2.businesslogic.LoanService;
import lv.javaguru.java2.database.RateDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private RateDAO rateDAO;

    public Double CalculateLoan(int amount, int duration, String term) throws SQLException{
        Double total = 0.0;
        Rate rate = new Rate();
        rate = rateDAO.getByTermAndDuration(duration,term);
        total = rate.getRate()*amount;
        return total;
    }


}

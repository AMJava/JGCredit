package lv.javaguru.java2.businesslogic.services;

import lv.javaguru.java2.businesslogic.*;
import lv.javaguru.java2.database.RateDAO;
import lv.javaguru.java2.domain.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;

@Service
public class RateServiceImpl implements RateService {

    @Autowired
    private RateDAO rateDAO;


    @Transactional
    public Rate findByTermAndDuration(int duration, String term) throws SQLException {

        return rateDAO.getByTermAndDuration(duration,term);
    }


}

package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Rate;
import lv.javaguru.java2.domain.User;

import java.math.BigDecimal;
import java.sql.SQLException;

public interface RateDAO extends BaseDAO<Rate> {

    Rate getByTermAndDuration(int duration, String term) throws SQLException;

}

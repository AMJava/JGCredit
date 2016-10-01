package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.RateDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.Rate;
import lv.javaguru.java2.domain.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * Created by Arturs on 25.08.2016.
 */

@SuppressWarnings("ALL")
@Repository
public class RateDAOImpl extends BaseDAOImpl<Rate> implements RateDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Rate getByTermAndDuration(int duration, String term) throws SQLException{
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Rate.class);
        return (Rate) criteria.add(Restrictions.and(Restrictions.eq("term", term),
        Restrictions.eq("duration",duration))).uniqueResult();
    }

}

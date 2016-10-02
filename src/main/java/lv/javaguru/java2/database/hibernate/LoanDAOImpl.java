package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.LoanDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.Loan;
import lv.javaguru.java2.domain.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Arturs on 25.08.2016.
 */

@SuppressWarnings("ALL")
@Repository
public class LoanDAOImpl extends BaseDAOImpl<Loan> implements LoanDAO {

    public List<Loan> getActiveUserLoans(Long userId) throws SQLException{
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Loan.class).add(Restrictions.and(Restrictions.eq("userId", userId),
        Restrictions.eq("loanStatus","ACTIVE"))).list();
    }

    public List<Loan> getUserLoans(Long userId) throws SQLException{
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Loan.class).add(Restrictions.eq("userId",userId)).list();
    }
}
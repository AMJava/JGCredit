package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.LoanDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.Loan;
import lv.javaguru.java2.domain.User;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
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

    public List<Long> getUserWeekLoans() throws SQLException{
        List<Long> users = new ArrayList<Long>();
        Session session = sessionFactory.getCurrentSession();
        String qry = "select user_id,id from loans WHERE loan_status = 'ACTIVE' AND end_date > sysdate() AND end_date < sysdate()+ INTERVAL 7 DAY";
        SQLQuery sqlQuery = session.createSQLQuery(qry);
        List<Object[]> list = sqlQuery.list();
        for(Object[] obj : list) {
            Long id = Long.valueOf(String.valueOf(obj[0]));
            if(id != null) {
                users.add(id);
            }
        }
        return users;
    }
}

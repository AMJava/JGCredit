package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * Created by Arturs on 25.08.2016.
 */

@SuppressWarnings("ALL")
@Repository
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public User getByLogin(String login) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        return (User) criteria.add(Restrictions.eq("login", login)).uniqueResult();
    }

    public User getByEmail(String email) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        return (User) criteria.add(Restrictions.eq("email", email)).uniqueResult();
    }
}

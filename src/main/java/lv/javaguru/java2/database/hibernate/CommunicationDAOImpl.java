package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.CommunicationDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.Communication;
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
public class CommunicationDAOImpl extends BaseDAOImpl<Communication> implements CommunicationDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Communication getByUserId(Long id) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        return (Communication) criteria.add(Restrictions.eq("user_id", id)).uniqueResult();
    }

}

package lv.javaguru.java2.database.hibernate;


import lv.javaguru.java2.database.BaseDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;


@Transactional
public abstract class BaseDAOImpl<T> implements BaseDAO<T> {

    private Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public BaseDAOImpl() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().
        getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Autowired
    public SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public long create(T entity) throws SQLException {
        return (Long) getCurrentSession().save(entity);
    }

    @Override
    public void update(T entity) throws SQLException {
        getCurrentSession().update(entity);
    }

    @Override
    public void delete(T entity) throws SQLException {
        getCurrentSession().delete(entity);
    }

    @Override
    public T getById(long id) throws SQLException {
        return (T) getCurrentSession().get(persistentClass, id);
    }
/*
    @Override
    public T getByLogin(String login) throws SQLException {
        return (T) getCurrentSession().get(persistentClass, login);
    }
*/
    @Override
    public List<T> getAll() throws SQLException {
        return getCurrentSession().createCriteria(persistentClass).list();
    }
}

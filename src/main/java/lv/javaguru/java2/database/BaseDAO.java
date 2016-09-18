package lv.javaguru.java2.database;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Arturs on 29.08.2016.
 */
public interface BaseDAO<T> {

    long create(T entity) throws SQLException;

    void update(T entity) throws SQLException;

    void delete(T entity) throws SQLException;

    T getById(long id) throws SQLException;

    List<T> getAll() throws SQLException;

}

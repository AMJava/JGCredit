package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.User;

public interface UserDAO {

    void create(User user) throws DBException;

    User getById(Long id) throws DBException;

    User getByLogin(String login) throws DBException;

    void delete(Long id) throws DBException;

    void update(User user) throws DBException;

    void updatelName(User user) throws DBException;

    void updateAddress(User user) throws DBException;

//    List<User> getAll() throws DBException;

}

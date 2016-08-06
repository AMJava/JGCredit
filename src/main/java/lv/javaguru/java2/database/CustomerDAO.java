package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Customer;

import java.util.List;

public interface CustomerDAO {

    void create(Customer customer) throws DBException;

    Customer getById(Long id) throws DBException;

    void delete(Long id) throws DBException;

    void update(Customer customer) throws DBException;

    void updatelName(Customer customer) throws DBException;

    void updateAddress(Customer customer) throws DBException;

//    List<Customer> getAll() throws DBException;

}

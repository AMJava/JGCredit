package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Employee;

import java.util.List;

public interface EmployeeDAO {

    void create(Employee employee) throws DBException;

    Employee getById(Long id) throws DBException;

    Employee getByLogin(String login) throws DBException;

    void delete(Long id) throws DBException;

    void update(Employee employee) throws DBException;

    void updatelName(Employee employee) throws DBException;

    void updateAddress(Employee employee) throws DBException;

    List<Employee> getAll() throws DBException;

}

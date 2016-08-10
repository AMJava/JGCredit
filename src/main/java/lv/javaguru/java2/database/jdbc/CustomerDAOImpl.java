package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.CustomerDAO;
import lv.javaguru.java2.domain.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl extends DAOImpl implements CustomerDAO {

    @Override
    public void create(Customer customer) throws DBException {
        if (customer == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into customers values (default, ?, ?,?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, customer.getLogin());
            preparedStatement.setString(2, customer.getPassword());
            preparedStatement.setString(3, customer.getfName());
            preparedStatement.setString(4, customer.getlName());
            preparedStatement.setString(5, customer.getGender());
            preparedStatement.setString(6, customer.getPersonalCode());
            preparedStatement.setDate(7, (java.sql.Date)customer.getBirthDate());
            preparedStatement.setString(8, customer.getAddress());
            preparedStatement.setInt(9, customer.getMobilePhoneNumber());
            preparedStatement.setInt(10, customer.getPhoneNumber());
            preparedStatement.setString(11, customer.getCompany());
            preparedStatement.setString(12, customer.getJobTitle());
            preparedStatement.setString(13, customer.getSalary());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                customer.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute CustomerDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public Customer getById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from customers where ID = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer = null;
            if (resultSet.next()) {
                customer = new Customer();
                customer.setId(resultSet.getLong("ID"));
                customer.setLogin(resultSet.getString("LOGIN"));
                customer.setPassword(resultSet.getString("LOGIN_PW"));
                customer.setfName(resultSet.getString("FIRST_NAME"));
                customer.setlName(resultSet.getString("LAST_NAME"));
                customer.setGender(resultSet.getString("GENDER"));
                customer.setPersonalCode(resultSet.getString("PERSONAL_CODE"));
                customer.setBirthDate(resultSet.getDate("BIRTH_DATE"));
                customer.setAddress(resultSet.getString("Address"));
                customer.setPhoneNumber(resultSet.getInt("M_PHONE_NUMBER"));
                customer.setMobilePhoneNumber(resultSet.getInt("PHONE_NUMBER"));
                customer.setCompany(resultSet.getString("COMPANY"));
                customer.setJobTitle(resultSet.getString("JOB_TITLE"));
                customer.setSalary(resultSet.getString("SALARY"));
            }
            return customer;
        } catch (Throwable e) {
            System.out.println("Exception while execute CustomerDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }
// Need to merge with getById
    @Override
    public Customer getByLogin(String login) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from customers where login = ?");
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer = null;
            if (resultSet.next()) {
                customer = new Customer();
                customer.setId(resultSet.getLong("ID"));
                customer.setLogin(resultSet.getString("LOGIN"));
                customer.setPassword(resultSet.getString("LOGIN_PW"));
                customer.setfName(resultSet.getString("FIRST_NAME"));
                customer.setlName(resultSet.getString("LAST_NAME"));
                customer.setGender(resultSet.getString("GENDER"));
                customer.setPersonalCode(resultSet.getString("PERSONAL_CODE"));
                customer.setBirthDate(resultSet.getDate("BIRTH_DATE"));
                customer.setAddress(resultSet.getString("Address"));
                customer.setPhoneNumber(resultSet.getInt("M_PHONE_NUMBER"));
                customer.setMobilePhoneNumber(resultSet.getInt("PHONE_NUMBER"));
                customer.setCompany(resultSet.getString("COMPANY"));
                customer.setJobTitle(resultSet.getString("JOB_TITLE"));
                customer.setSalary(resultSet.getString("SALARY"));
            }
            return customer;
        } catch (Throwable e) {
            System.out.println("Exception while execute CustomerDAOImpl.getByLogin)");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

//    @Override
//    public List<Customer> getAll() throws DBException {
//        List<Customer> customers = new ArrayList<Customer>();
//        Connection connection = null;
//        try {
//            connection = getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement("select * from USERS");
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                Customer customer = new Customer();
//                customer.setCustomerId(resultSet.getLong("UserID"));
//                customer.setFirstName(resultSet.getString("FirstName"));
//                customer.setLastName(resultSet.getString("LastName"));
//                customers.add(customer);
//            }
//        } catch (Throwable e) {
//            System.out.println("Exception while getting customer list CustomerDAOImpl.getList()");
//            e.printStackTrace();
//            throw new DBException(e);
//        } finally {
//            closeConnection(connection);
//        }
//        return customers;
//    }

    @Override
    public void delete(Long id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from customers where ID = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute CustomerDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(Customer customer) throws DBException {
        if (customer == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update customers set first_name = ?, last_name = ? " +
                            "where ID = ?");
            preparedStatement.setString(1, customer.getfName());
            preparedStatement.setString(2, customer.getlName());
            preparedStatement.setLong(3, customer.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute CustomerDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void updateAddress(Customer customer) throws DBException {
        if (customer == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update customers set address = ? " +
                            "where ID = ?");
            preparedStatement.setString(1, customer.getAddress());
            preparedStatement.setLong(2, customer.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute CustomerDAOImpl.updateAdress()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }
    @Override
    public void updatelName(Customer customer) throws DBException {
        if (customer == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update customers set last_name = ? " +
                            "where ID = ?");
            preparedStatement.setString(1, customer.getlName());
            preparedStatement.setLong(2, customer.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute CustomerDAOImpl.updatelLame()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

}

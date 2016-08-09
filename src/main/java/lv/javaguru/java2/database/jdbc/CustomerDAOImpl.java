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
                    connection.prepareStatement("insert into customer values (default, ?, ?,?,?,?,?,?,?,?,?,)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, customer.getfName());
            preparedStatement.setString(2, customer.getlName());
            preparedStatement.setString(3, customer.getPersonalCode());
            preparedStatement.setDate(4, (java.sql.Date)customer.getBirthDate());
            preparedStatement.setString(5, customer.getAddress());
            preparedStatement.setInt(6, customer.getMobilePhoneNumber());
            preparedStatement.setInt(7, customer.getPhoneNumber());
            preparedStatement.setString(8, customer.getCompany());
            preparedStatement.setString(9, customer.getJobTitle());
            preparedStatement.setString(10, customer.getSalary());

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
                    .prepareStatement("select * from customer where ID = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer = null;
            if (resultSet.next()) {
                customer = new Customer();
                customer.setId(resultSet.getLong("ID"));
                customer.setfName(resultSet.getString("FIRST_NAME"));
                customer.setlName(resultSet.getString("LAST_NAME"));
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
                    .prepareStatement("delete from customer where ID = ?");
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
                    .prepareStatement("update USERS set first_name = ?, last_name = ? " +
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
                    .prepareStatement("update customer set address = ? " +
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
                    .prepareStatement("update customer set last_name = ? " +
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

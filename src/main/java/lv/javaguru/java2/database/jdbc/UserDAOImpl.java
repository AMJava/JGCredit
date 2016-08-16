package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOImpl extends DAOImpl implements UserDAO {

    @Override
    public void create(User user) throws DBException {
        if (user == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into users values (default, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getAccessLevel());
            preparedStatement.setString(4, user.getfName());
            preparedStatement.setString(5, user.getlName());
            preparedStatement.setString(6, user.getGender());
            preparedStatement.setString(7, user.getPersonalCode());
            preparedStatement.setDate(8, (java.sql.Date) user.getBirthDate());
            preparedStatement.setString(9, user.getAddress());
            preparedStatement.setInt(10, user.getMobilePhoneNumber());
            preparedStatement.setInt(11, user.getPhoneNumber());
            preparedStatement.setString(12, user.getCompany());
            preparedStatement.setString(13, user.getJobTitle());
            preparedStatement.setString(14, user.getSalary());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                user.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public User getById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from users where ID = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("ID"));
                user.setLogin(resultSet.getString("LOGIN"));
                user.setPassword(resultSet.getString("LOGIN_PW"));
                user.setPassword(resultSet.getString("ACCESS_LEVEL"));
                user.setfName(resultSet.getString("FIRST_NAME"));
                user.setlName(resultSet.getString("LAST_NAME"));
                user.setGender(resultSet.getString("GENDER"));
                user.setPersonalCode(resultSet.getString("PERSONAL_CODE"));
                user.setBirthDate(resultSet.getDate("BIRTH_DATE"));
                user.setAddress(resultSet.getString("Address"));
                user.setPhoneNumber(resultSet.getInt("M_PHONE_NUMBER"));
                user.setMobilePhoneNumber(resultSet.getInt("PHONE_NUMBER"));
                user.setCompany(resultSet.getString("COMPANY"));
                user.setJobTitle(resultSet.getString("JOB_TITLE"));
                user.setSalary(resultSet.getString("SALARY"));
            }
            return user;
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }
// Need to merge with getById
    @Override
    public User getByLogin(String login) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from users where login = ?");
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("ID"));
                user.setLogin(resultSet.getString("LOGIN"));
                user.setPassword(resultSet.getString("LOGIN_PW"));
                user.setPassword(resultSet.getString("ACCESS_LEVEL"));
                user.setfName(resultSet.getString("FIRST_NAME"));
                user.setlName(resultSet.getString("LAST_NAME"));
                user.setGender(resultSet.getString("GENDER"));
                user.setPersonalCode(resultSet.getString("PERSONAL_CODE"));
                user.setBirthDate(resultSet.getDate("BIRTH_DATE"));
                user.setAddress(resultSet.getString("Address"));
                user.setPhoneNumber(resultSet.getInt("M_PHONE_NUMBER"));
                user.setMobilePhoneNumber(resultSet.getInt("PHONE_NUMBER"));
                user.setCompany(resultSet.getString("COMPANY"));
                user.setJobTitle(resultSet.getString("JOB_TITLE"));
                user.setSalary(resultSet.getString("SALARY"));
            }
            return user;
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.getByLogin)");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

//    @Override
//    public List<User> getAll() throws DBException {
//        List<User> customers = new ArrayList<User>();
//        Connection connection = null;
//        try {
//            connection = getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement("select * from USERS");
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                User customer = new User();
//                customer.setCustomerId(resultSet.getLong("UserID"));
//                customer.setFirstName(resultSet.getString("FirstName"));
//                customer.setLastName(resultSet.getString("LastName"));
//                customers.add(customer);
//            }
//        } catch (Throwable e) {
//            System.out.println("Exception while getting customer list UserDAOImpl.getList()");
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
                    .prepareStatement("delete from users where ID = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(User user) throws DBException {
        if (user == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update users set first_name = ?, last_name = ? " +
                            "where ID = ?");
            preparedStatement.setString(1, user.getfName());
            preparedStatement.setString(2, user.getlName());
            preparedStatement.setLong(3, user.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void updateAddress(User user) throws DBException {
        if (user == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update users set address = ? " +
                            "where ID = ?");
            preparedStatement.setString(1, user.getAddress());
            preparedStatement.setLong(2, user.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.updateAdress()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }
    @Override
    public void updatelName(User user) throws DBException {
        if (user == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update users set last_name = ? " +
                            "where ID = ?");
            preparedStatement.setString(1, user.getlName());
            preparedStatement.setLong(2, user.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.updatelLame()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

}

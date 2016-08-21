package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
@Component
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
            preparedStatement.setString(3, user.getfName());
            preparedStatement.setString(4, user.getlName());
            preparedStatement.setString(5, user.getGender());
            preparedStatement.setString(6, user.getPersonalCode());
            preparedStatement.setDate(7, (java.sql.Date) user.getBirthDate());
            preparedStatement.setString(8, user.getAddress());
            preparedStatement.setInt(9, user.getMobilePhoneNumber());
            preparedStatement.setInt(10, user.getPhoneNumber());
            preparedStatement.setString(11, user.getCompany());
            preparedStatement.setString(12, user.getJobTitle());
            preparedStatement.setString(13, user.getSalary());
            preparedStatement.setString(14, user.getPhoto());

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
                    .prepareStatement("select * from users where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("login_pw"));
                user.setfName(resultSet.getString("first_name"));
                user.setlName(resultSet.getString("last_name"));
                user.setGender(resultSet.getString("gender"));
                user.setPersonalCode(resultSet.getString("personal_code"));
                user.setBirthDate(resultSet.getDate("birth_date"));
                user.setAddress(resultSet.getString("address"));
                user.setPhoneNumber(resultSet.getInt("m_phone_number"));
                user.setMobilePhoneNumber(resultSet.getInt("phone_number"));
                user.setCompany(resultSet.getString("company"));
                user.setJobTitle(resultSet.getString("job_title"));
                user.setSalary(resultSet.getString("salary"));
                user.setPhoto(resultSet.getString("photo"));
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
                user.setId(resultSet.getLong("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("login_pw"));
                user.setfName(resultSet.getString("first_name"));
                user.setlName(resultSet.getString("last_name"));
                user.setGender(resultSet.getString("gender"));
                user.setPersonalCode(resultSet.getString("personal_code"));
                user.setBirthDate(resultSet.getDate("birth_date"));
                user.setAddress(resultSet.getString("address"));
                user.setPhoneNumber(resultSet.getInt("m_phone_number"));
                user.setMobilePhoneNumber(resultSet.getInt("phone_number"));
                user.setCompany(resultSet.getString("company"));
                user.setJobTitle(resultSet.getString("job_title"));
                user.setSalary(resultSet.getString("salary"));
                user.setPhoto(resultSet.getString("photo"));
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

    @Override
    public List<User> getAll() throws DBException {
        List<User> users= new ArrayList<User>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("login_pw"));
                user.setfName(resultSet.getString("first_name"));
                user.setlName(resultSet.getString("last_name"));
                user.setGender(resultSet.getString("gender"));
                user.setPersonalCode(resultSet.getString("personal_code"));
                user.setBirthDate(resultSet.getDate("birth_date"));
                user.setAddress(resultSet.getString("address"));
                user.setPhoneNumber(resultSet.getInt("m_phone_number"));
                user.setMobilePhoneNumber(resultSet.getInt("phone_number"));
                user.setCompany(resultSet.getString("company"));
                user.setJobTitle(resultSet.getString("job_title"));
                user.setSalary(resultSet.getString("salary"));
                user.setPhoto(resultSet.getString("photo"));
                users.add(user);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list UserDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return users;
    }

    @Override
    public void delete(Long id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from users where id = ?");
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

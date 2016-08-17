package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.EmployeeDAO;
import lv.javaguru.java2.domain.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl extends DAOImpl implements EmployeeDAO {

    @Override
    public void create(Employee employee) throws DBException {
        if (employee == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into employees values (default, ?, ?,?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, employee.getLogin());
            preparedStatement.setString(2, employee.getPassword());
            preparedStatement.setString(3, employee.getfName());
            preparedStatement.setString(4, employee.getlName());
            preparedStatement.setString(5, employee.getGender());
            preparedStatement.setString(6, employee.getPersonalCode());
            preparedStatement.setDate(7, (java.sql.Date) employee.getBirthDate());
            preparedStatement.setString(8, employee.getAddress());
            preparedStatement.setInt(9, employee.getMobilePhoneNumber());
            preparedStatement.setInt(10, employee.getPhoneNumber());
            preparedStatement.setString(11, employee.getCompany());
            preparedStatement.setString(12, employee.getJobTitle());
            preparedStatement.setString(13, employee.getPhoto());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                employee.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute EmployeeDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public Employee getById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from employees where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Employee employee = null;
            if (resultSet.next()) {
                employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setLogin(resultSet.getString("login"));
                employee.setPassword(resultSet.getString("login_pw"));
                employee.setfName(resultSet.getString("first_name"));
                employee.setlName(resultSet.getString("last_name"));
                employee.setGender(resultSet.getString("gender"));
                employee.setPersonalCode(resultSet.getString("personal_code"));
                employee.setBirthDate(resultSet.getDate("birth_date"));
                employee.setAddress(resultSet.getString("address"));
                employee.setPhoneNumber(resultSet.getInt("m_phone_number"));
                employee.setMobilePhoneNumber(resultSet.getInt("phone_number"));
                employee.setCompany(resultSet.getString("company"));
                employee.setJobTitle(resultSet.getString("job_title"));
                employee.setPhoto(resultSet.getString("photo"));
            }
            return employee;
        } catch (Throwable e) {
            System.out.println("Exception while execute EmployeeDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }
// Need to merge with getById
    @Override
    public Employee getByLogin(String login) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from employees where login = ?");
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            Employee employee = null;
            if (resultSet.next()) {
                employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setLogin(resultSet.getString("login"));
                employee.setPassword(resultSet.getString("login_pw"));
                employee.setfName(resultSet.getString("first_name"));
                employee.setlName(resultSet.getString("last_name"));
                employee.setGender(resultSet.getString("gender"));
                employee.setPersonalCode(resultSet.getString("personal_code"));
                employee.setBirthDate(resultSet.getDate("birth_date"));
                employee.setAddress(resultSet.getString("address"));
                employee.setPhoneNumber(resultSet.getInt("m_phone_number"));
                employee.setMobilePhoneNumber(resultSet.getInt("phone_number"));
                employee.setCompany(resultSet.getString("company"));
                employee.setJobTitle(resultSet.getString("job_title"));
                employee.setPhoto(resultSet.getString("photo"));
            }
            return employee;
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.getByLogin)");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Employee> getAll() throws DBException {
        List<Employee> employees= new ArrayList<Employee>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employees");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setLogin(resultSet.getString("login"));
                employee.setPassword(resultSet.getString("login_pw"));
                employee.setfName(resultSet.getString("first_name"));
                employee.setlName(resultSet.getString("last_name"));
                employee.setGender(resultSet.getString("gender"));
                employee.setPersonalCode(resultSet.getString("personal_code"));
                employee.setBirthDate(resultSet.getDate("birth_date"));
                employee.setAddress(resultSet.getString("address"));
                employee.setPhoneNumber(resultSet.getInt("m_phone_number"));
                employee.setMobilePhoneNumber(resultSet.getInt("phone_number"));
                employee.setCompany(resultSet.getString("company"));
                employee.setJobTitle(resultSet.getString("job_title"));
                employee.setPhoto(resultSet.getString("photo"));
                employees.add(employee);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list EmployeeDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return employees;
    }

    @Override
    public void delete(Long id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from employees where id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute EmployeeDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(Employee employee) throws DBException {
        if (employee == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update employees set first_name = ?, last_name = ? " +
                            "where ID = ?");
            preparedStatement.setString(1, employee.getfName());
            preparedStatement.setString(2, employee.getlName());
            preparedStatement.setLong(3, employee.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute EmployeeDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void updateAddress(Employee employee) throws DBException {
        if (employee == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update employees set address = ? " +
                            "where ID = ?");
            preparedStatement.setString(1, employee.getAddress());
            preparedStatement.setLong(2, employee.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute EmployeeDAOImpl.updateAdress()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }
    @Override
    public void updatelName(Employee employee) throws DBException {
        if (employee == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update employees set last_name = ? " +
                            "where ID = ?");
            preparedStatement.setString(1, employee.getlName());
            preparedStatement.setLong(2, employee.getId());
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

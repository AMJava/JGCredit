package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.CommunicationDAO;
import lv.javaguru.java2.domain.Communication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CommunicationDAOImpl extends DAOImpl implements CommunicationDAO {

    @Override
    public void createCommunication(Communication communication) throws DBException {
        if (communication == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
            connection.prepareStatement("insert into communications values (default, ?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, communication.getBody());
            preparedStatement.setDate(2, (java.sql.Date) communication.getSentDate());
            preparedStatement.setString(3, communication.getComType());
            preparedStatement.setLong(4, communication.getUserId());
            preparedStatement.setLong(5, communication.getLoanId());
            preparedStatement.setLong(6, communication.getLoanExtId());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                communication.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute CommunicationDAOImpl.createCommunication()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public Communication getCommunicationById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from communications where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Communication communication = null;
            if (resultSet.next()) {
                communication = new Communication();
                communication.setId(resultSet.getLong("id"));
                communication.setBody(resultSet.getString("body"));
                communication.setSentDate(resultSet.getDate("sent_date"));
                communication.setComType(resultSet.getString("com_type"));
                communication.setUserId(resultSet.getLong("user_id"));
                communication.setLoanId(resultSet.getLong("loan_id"));
                communication.setLoanExtId(resultSet.getLong("loan_ext_id"));
            }
            return communication;
        } catch (Throwable e) {
            System.out.println("Exception while execute CommunicationDAOImpl.getCommunicationById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void deleteCommunication(Long id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
            .prepareStatement("delete from communications where id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute CommunicationDAOImpl.deleteCommunication()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Communication> getAllLoanCommunications(Long loanId, Long loanExtId) throws DBException {
        List<Communication> communications = new ArrayList<Communication>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = null;
            if(loanId == null) {
                preparedStatement = connection.prepareStatement("select * from communications where loan_ext_id = ?");
                preparedStatement.setLong(1, loanExtId);
            }
            else
            {
                preparedStatement = connection.prepareStatement("select * from communications where loan_id = ?");
                preparedStatement.setLong(1, loanId);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Communication communication = new Communication();
                communication.setId(resultSet.getLong("id"));
                communication.setBody(resultSet.getString("body"));
                communication.setSentDate(resultSet.getDate("sent_date"));
                communication.setComType(resultSet.getString("com_type"));
                communication.setUserId(resultSet.getLong("user_id"));
                communication.setLoanId(resultSet.getLong("loan_id"));
                communication.setLoanExtId(resultSet.getLong("loan_ext_id"));
                communications.add(communication);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting communication list CommunicationDAOImpl.getAllLoanCommunications()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return communications;
    }

}

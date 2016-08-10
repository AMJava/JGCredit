package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.AgreementDAO;
import lv.javaguru.java2.domain.Agreement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AgreementDAOImpl extends DAOImpl implements AgreementDAO {

    @Override
    public void createAgreement(Agreement agreement) throws DBException {
        if (agreement == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
            connection.prepareStatement("insert into agreements values (default, ?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setFloat(1, agreement.getLoanSum());
            preparedStatement.setFloat(2, agreement.getInterestRate());
            preparedStatement.setInt(3, agreement.getTerm());
            preparedStatement.setString(4, agreement.getTermUnit());
            preparedStatement.setDate(5, (java.sql.Date)agreement.getStartDate());
            preparedStatement.setDate(6, (java.sql.Date)agreement.getEndDate());
            preparedStatement.setString(7, agreement.getAgreementStatus());
            preparedStatement.setString(8, agreement.getExtendetFlag());
            preparedStatement.setLong(9, agreement.getUserId());
            preparedStatement.setString(10, agreement.getComments());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                agreement.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute AgreementDAOImpl.createAgreement()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public Agreement getByAgreementId(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from agreements where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Agreement agreement = null;
            if (resultSet.next()) {
                agreement = new Agreement();
                agreement.setId(resultSet.getLong("id"));
                agreement.setLoanSum(resultSet.getFloat("loan_sum"));
                agreement.setInterestRate(resultSet.getFloat("interest_rate"));
                agreement.setTerm(resultSet.getInt("term"));
                agreement.setTermUnit(resultSet.getString("term_unit"));
                agreement.setStartDate(resultSet.getDate("start_date"));
                agreement.setEndDate(resultSet.getDate("end_date"));
                agreement.setAgreementStatus(resultSet.getString("agreement_status"));
                agreement.setExtendetFlag(resultSet.getString("extendet_flag"));
                agreement.setUserId(resultSet.getLong("user_id"));
                agreement.setComments(resultSet.getString("comments"));
            }
            return agreement;
        } catch (Throwable e) {
            System.out.println("Exception while execute AgreementDAOImpl.getByAgreementId()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void deleteAgreement(Long id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
            .prepareStatement("delete from agreements where id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute AgreementDAOImpl.deleteAgreement()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void updateAgreementStatus(String status) throws DBException {
        if (status == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
            .prepareStatement("update agreements set status = ? " +
            "where ID = ?");
            preparedStatement.setString(1, status);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute AgreementDAOImpl.updateAgreementStatus()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Agreement> getAllUserAgreements(Long customerId) throws DBException {
        List<Agreement> agreements = new ArrayList<Agreement>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from customer where user_id = ?");
            preparedStatement.setLong(1, customerId);
           ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Agreement agreement = new Agreement();
                agreement.setId(resultSet.getLong("ID"));
                agreement.setLoanSum(resultSet.getFloat("loan_sum"));
                agreement.setInterestRate(resultSet.getFloat("interest_rate"));
                agreement.setTerm(resultSet.getInt("term"));
                agreement.setTermUnit(resultSet.getString("term_unit"));
                agreement.setStartDate(resultSet.getDate("start_date"));
                agreement.setEndDate(resultSet.getDate("end_date"));
                agreement.setAgreementStatus(resultSet.getString("agreement_status"));
                agreement.setExtendetFlag(resultSet.getString("extendet_flag"));
                agreement.setUserId(resultSet.getLong("user_id"));
                agreement.setComments(resultSet.getString("comments"));
                agreements.add(agreement);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list AgreementDAOImpl.getAllUserAgreements()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return agreements;
    }

}

package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.LoanExtDAO;
import lv.javaguru.java2.domain.LoanExt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LoanExtDAOImpl extends DAOImpl implements LoanExtDAO {

    @Override
    public void createLoanExt(LoanExt loanExt) throws DBException {
        if (loanExt == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
            connection.prepareStatement("insert into loans_ext values (default, ?,?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, loanExt.getExtType());
            preparedStatement.setString(2, loanExt.getExtStatus());
            preparedStatement.setDate(3, (java.sql.Date) loanExt.getExtDate());
            preparedStatement.setDate(4, (java.sql.Date) loanExt.getEndDate());
            preparedStatement.setBigDecimal(5, loanExt.getInterestRate());
            preparedStatement.setBigDecimal(6, loanExt.getCommision());
            preparedStatement.setLong(7, loanExt.getLoanId());
            preparedStatement.setString(8, loanExt.getBankAccountNumb());
            preparedStatement.setString(9, loanExt.getComments());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                loanExt.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute LoanExtDAOImpl.createLoanExt()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public LoanExt getLoanExtById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from loans_ext where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            LoanExt loanExt = null;
            if (resultSet.next()) {
                loanExt = new LoanExt();
                loanExt.setId(resultSet.getLong("id"));
                loanExt.setExtType(resultSet.getString("ext_type"));
                loanExt.setExtStatus(resultSet.getString("ext_status"));
                loanExt.setExtDate(resultSet.getDate("ext_date"));
                loanExt.setEndDate(resultSet.getDate("end_date"));
                loanExt.setInterestRate(resultSet.getBigDecimal("interest_rate"));
                loanExt.setCommision(resultSet.getBigDecimal("comission"));
                loanExt.setLoanId(resultSet.getLong("loan_id"));
                loanExt.setBankAccountNumb(resultSet.getString("bank_acc_number"));
                loanExt.setComments(resultSet.getString("comments"));
            }
            return loanExt;
        } catch (Throwable e) {
            System.out.println("Exception while execute LoanExtDAOImpl.getByLoanExtId()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void deleteLoanExt(Long id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
            .prepareStatement("delete from loans_ext where id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute LoanExtDAOImpl.deleteLoanExt()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void updateLoanExtStatus(String status) throws DBException {
        if (status == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
            .prepareStatement("update loans_ext set status = ? " +
            "where ID = ?");
            preparedStatement.setString(1, status);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute LoanExtDAOImpl.updateLoanExtStatus()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<LoanExt> getAllLoanExts(Long loanId) throws DBException {
        List<LoanExt> loanExtList = new ArrayList<LoanExt>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from customer where user_id = ?");
            preparedStatement.setLong(1, loanId);
           ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                LoanExt loanExt = new LoanExt();
                loanExt.setId(resultSet.getLong("id"));
                loanExt.setExtType(resultSet.getString("ext_type"));
                loanExt.setExtStatus(resultSet.getString("ext_status"));
                loanExt.setExtDate(resultSet.getDate("ext_date"));
                loanExt.setEndDate(resultSet.getDate("end_date"));
                loanExt.setInterestRate(resultSet.getBigDecimal("interest_rate"));
                loanExt.setCommision(resultSet.getBigDecimal("comission"));
                loanExt.setLoanId(resultSet.getLong("loan_id"));
                loanExt.setBankAccountNumb(resultSet.getString("bank_acc_number"));
                loanExt.setComments(resultSet.getString("comments"));
                loanExtList.add(loanExt);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting loanExt list LoanExtDAOImpl.getAllLoanExts()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return loanExtList;
    }

}

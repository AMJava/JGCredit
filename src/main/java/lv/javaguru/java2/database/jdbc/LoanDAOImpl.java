package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.LoanDAO;
import lv.javaguru.java2.domain.Loan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LoanDAOImpl extends DAOImpl implements LoanDAO {

    @Override
    public void createLoan(Loan loan) throws DBException {
        if (loan == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
            connection.prepareStatement("insert into loans values (default, ?,?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setBigDecimal(1, loan.getLoanSum());
            preparedStatement.setBigDecimal(2, loan.getInterestRate());
            preparedStatement.setInt(3, loan.getTerm());
            preparedStatement.setString(4, loan.getTermUnit());
            preparedStatement.setDate(5, (java.sql.Date) loan.getStartDate());
            preparedStatement.setDate(6, (java.sql.Date) loan.getEndDate());
            preparedStatement.setString(7, loan.getLoanStatus());
            preparedStatement.setString(8, loan.getExtendetFlag());
            preparedStatement.setLong(9, loan.getUserId());
            preparedStatement.setLong(10, loan.getEmployeeId());
            preparedStatement.setString(11, loan.getBankAccountNumb());
            preparedStatement.setString(12, loan.getComments());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                loan.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute LoanDAOImpl.createAgreement()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public Loan getLoanById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from loans where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Loan loan = null;
            if (resultSet.next()) {
                loan = new Loan();
                loan.setId(resultSet.getLong("id"));
                loan.setLoanSum(resultSet.getBigDecimal("loan_sum"));
                loan.setInterestRate(resultSet.getBigDecimal("interest_rate"));
                loan.setTerm(resultSet.getInt("term"));
                loan.setTermUnit(resultSet.getString("term_unit"));
                loan.setStartDate(resultSet.getDate("start_date"));
                loan.setEndDate(resultSet.getDate("end_date"));
                loan.setLoanStatus(resultSet.getString("agreement_status"));
                loan.setExtendetFlag(resultSet.getString("extendet_flag"));
                loan.setUserId(resultSet.getLong("user_id"));
                loan.setBankAccountNumb(resultSet.getString("bank_acc_number"));
                loan.setComments(resultSet.getString("comments"));
            }
            return loan;
        } catch (Throwable e) {
            System.out.println("Exception while execute LoanDAOImpl.getByLoanId()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void deleteLoan(Long id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
            .prepareStatement("delete from loans where id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute LoanDAOImpl.deleteLoan()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void updateLoanStatus(String status) throws DBException {
        if (status == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
            .prepareStatement("update loans set status = ? " +
            "where ID = ?");
            preparedStatement.setString(1, status);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute LoanDAOImpl.updateLoanStatus()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Loan> getAllUserLoans(Long userId) throws DBException {
        List<Loan> loans = new ArrayList<Loan>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from loans where user_id = ?");
            preparedStatement.setLong(1, userId);
           ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Loan loan = new Loan();
                loan.setId(resultSet.getLong("ID"));
                loan.setLoanSum(resultSet.getBigDecimal("loan_sum"));
                loan.setInterestRate(resultSet.getBigDecimal("interest_rate"));
                loan.setTerm(resultSet.getInt("term"));
                loan.setTermUnit(resultSet.getString("term_unit"));
                loan.setStartDate(resultSet.getDate("start_date"));
                loan.setEndDate(resultSet.getDate("end_date"));
                loan.setLoanStatus(resultSet.getString("agreement_status"));
                loan.setExtendetFlag(resultSet.getString("extendet_flag"));
                loan.setUserId(resultSet.getLong("user_id"));
                loan.setComments(resultSet.getString("comments"));
                loans.add(loan);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting loans list LoanDAOImpl.getAllUserLoans()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return loans;
    }

}

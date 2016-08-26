package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.PaymentDAO;
import lv.javaguru.java2.domain.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAOImpl extends DAOImpl implements PaymentDAO {

    @Override
    public void createPayment(Payment payment) throws DBException {
        if (payment == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
            connection.prepareStatement("insert into payments values (default, ?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, payment.getPaymentType());
            preparedStatement.setBigDecimal(2, payment.getPaymentSum());
            preparedStatement.setDate(3, (java.sql.Date) payment.getPaymentDate());
            preparedStatement.setString(4, payment.getBankAccountNumb());
            preparedStatement.setLong(5, payment.getLoanId());
            preparedStatement.setLong(6, payment.getLoanExtId());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                payment.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute PaymentDAOImpl.createLoanExt()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public Payment getPaymentById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from payments where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Payment payment = null;
            if (resultSet.next()) {
                payment = new Payment();
                payment.setId(resultSet.getLong("id"));
                payment.setPaymentType(resultSet.getString("payment_type"));
                payment.setPaymentSum(resultSet.getBigDecimal("payment_sum"));
                payment.setPaymentDate(resultSet.getDate("payment_date"));
                payment.setBankAccountNumb(resultSet.getString("bank_acc_number"));
                payment.setLoanId(resultSet.getLong("loan_id"));
                payment.setLoanExtId(resultSet.getLong("loan_ext_id"));
            }
            return payment;
        } catch (Throwable e) {
            System.out.println("Exception while execute PaymentDAOImpl.getPaymentById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void deletePayment(Long id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
            .prepareStatement("delete from payments where id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute PaymentDAOImpl.deletePayment()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Payment> getAllLoanPayments(Long loanId, Long loanExtId) throws DBException {
        List<Payment> payments = new ArrayList<Payment>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = null;
            if(loanId == null) {
                preparedStatement = connection.prepareStatement("select * from payments where loan_ext_id = ?");
                preparedStatement.setLong(1, loanExtId);
            }
            else
            {
                preparedStatement = connection.prepareStatement("select * from payments where loan_id = ?");
                preparedStatement.setLong(1, loanId);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Payment payment = new Payment();
                payment.setId(resultSet.getLong("id"));
                payment.setPaymentType(resultSet.getString("payment_type"));
                payment.setPaymentSum(resultSet.getBigDecimal("payment_sum"));
                payment.setPaymentDate(resultSet.getDate("payment_date"));
                payment.setBankAccountNumb(resultSet.getString("bank_acc_number"));
                payment.setLoanId(resultSet.getLong("loan_id"));
                payment.setLoanExtId(resultSet.getLong("loan_ext_id"));
                payments.add(payment);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting payments list PaymentDAOImpl.getAllLoanPayments()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return payments;
    }

}

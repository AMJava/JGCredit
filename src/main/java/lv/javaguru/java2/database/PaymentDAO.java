package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Payment;

import java.util.List;

/**
 * Created by Arturs on 10.08.2016.
 */
public interface PaymentDAO {

    void createPayment(Payment payment) throws DBException;

    Payment getPaymentById(Long id) throws DBException;

    void deletePayment(Long id) throws DBException;

    List<Payment> getAllLoanPayments(Long loanId, Long loanExtId) throws DBException;

}

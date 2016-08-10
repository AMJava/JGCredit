package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Agreement;
import java.util.List;

/**
 * Created by Arturs on 10.08.2016.
 */
public interface AgreementDAO {

    void createAgreement(Agreement agreement) throws DBException;

    Agreement getByAgreementId(Long id) throws DBException;

    void deleteAgreement(Long id) throws DBException;

    void updateAgreementStatus(String status) throws DBException;

    List<Agreement> getAllUserAgreements(Long customerId) throws DBException;
}

package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Communication;

import java.util.List;

public interface CommunicationDAO {

    void createCommunication(Communication communication) throws DBException;

    Communication getCommunicationById(Long id) throws DBException;

    void deleteCommunication(Long id) throws DBException;

    List<Communication> getAllLoanCommunications(Long LoanId, Long LoanExtId) throws DBException;

}

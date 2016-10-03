package lv.javaguru.java2.database;

import lv.javaguru.java2.businesslogic.exceptions.DBException;
import lv.javaguru.java2.domain.Communication;

import java.sql.SQLException;

public interface CommunicationDAO extends BaseDAO<Communication>  {

    Communication getByUserId(Long id) throws DBException, SQLException;
}

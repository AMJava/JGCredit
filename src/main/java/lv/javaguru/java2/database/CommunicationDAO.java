package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Communication;
import lv.javaguru.java2.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface CommunicationDAO extends BaseDAO<Communication>  {

    Communication getByUserId(Long id) throws DBException, SQLException;
}

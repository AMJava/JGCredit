package lv.javaguru.java2.servlet.mvc;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public interface MVCController {

    MVCModel executeGetRequest(HttpServletRequest request) throws SQLException;

    MVCModel executePostRequest(HttpServletRequest request) throws SQLException;

}

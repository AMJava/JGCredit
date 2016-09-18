package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.businesslogic.exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

public interface MVCController {

    MVCModel executeGetRequest(HttpServletRequest request) throws SQLException;

    MVCModel executePostRequest(HttpServletRequest request) throws SQLException, ParseException, ServiceException;

}

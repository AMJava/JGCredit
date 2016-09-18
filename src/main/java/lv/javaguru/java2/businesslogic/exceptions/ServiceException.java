package lv.javaguru.java2.businesslogic.exceptions;

/**
 * Created by Anastasija on 18.09.2016.
 */
public class ServiceException extends Exception  {
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public ServiceException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public ServiceException() {
        super();
    }
}

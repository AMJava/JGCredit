package lv.javaguru.java2.businesslogic.exceptions;

/**
 * Created by Anastasija on 18.09.2016.
 */
public class UnAuthorizedUserException extends Exception  {
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public UnAuthorizedUserException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public UnAuthorizedUserException() {
        super();
    }
}

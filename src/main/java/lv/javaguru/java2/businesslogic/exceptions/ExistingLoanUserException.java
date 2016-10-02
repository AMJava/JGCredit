package lv.javaguru.java2.businesslogic.exceptions;

/**
 * Created by Anastasija on 18.09.2016.
 */
public class ExistingLoanUserException extends Exception  {
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public ExistingLoanUserException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public ExistingLoanUserException() {
        super();
    }
}

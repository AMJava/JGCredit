package lv.javaguru.java2.businesslogic.exceptions;

import org.springframework.stereotype.Component;

/**
 * Created by Anastasija on 18.09.2016.
 */
@Component
public class ErrorResponse {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

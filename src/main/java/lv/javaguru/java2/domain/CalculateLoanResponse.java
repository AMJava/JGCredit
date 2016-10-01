package lv.javaguru.java2.domain;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonView;
import lv.javaguru.java2.domain.User;


public class CalculateLoanResponse {

    private Double total;

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

}

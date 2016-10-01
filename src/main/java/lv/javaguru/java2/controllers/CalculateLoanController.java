package lv.javaguru.java2.controllers;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.CalculateLoanResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculateLoanController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/api/calculateLoan")
    public CalculateLoanResponse getSearchResultViaAjax() {

        CalculateLoanResponse result = new CalculateLoanResponse();
        User user = new User();
        user.setFName("aaa");

        //users.add(user);
         result.setCode("200");
         result.setMsg("AAA");
        //  result.setResult(users);

        //CalculateLoanResponse will be converted into json format and send back to the request.
        return result;

    }
}
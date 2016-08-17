package lv.javaguru.java2.servlet.mvc;

import javax.servlet.http.HttpServletRequest;

public class ContactsController implements MVCController {

    public MVCModel execute(HttpServletRequest request) {
        return new MVCModel("Contacts", "/templates/user/contacts.jsp");
    }

}

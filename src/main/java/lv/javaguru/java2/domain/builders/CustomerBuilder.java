package lv.javaguru.java2.domain.builders;

import lv.javaguru.java2.domain.Customer;

import java.util.Date;

public class CustomerBuilder {

//    private String fName;
//    private String lName;
//    private String personCode;
//    private Date birthDate;
//    private String address;
//    private int phoneMob;
//    private int phoneLand;
//    private String workPlace;
//    private String workPosition;


    private CustomerBuilder() { }

    public static CustomerBuilder createBuilder() {
        return new CustomerBuilder();
    }

    public Customer buildPerson(String fName,String lName,String personCode,Date birthDate,
                          String address,int phoneMob,int phoneLand,String workPlace,
                          String workPosition) {
        Customer customer = new Customer();
        customer.setfName(fName);
        customer.setlName(lName);
        customer.setPersonCode(personCode);
        customer.setBirthDate(birthDate);
        customer.setAddress(address);
        customer.setPhoneMob(phoneMob);
        customer.setPhoneLand(phoneLand);
        customer.setWorkPlace(workPlace);
        customer.setWorkPosition(workPosition);
        return customer;
    }
}

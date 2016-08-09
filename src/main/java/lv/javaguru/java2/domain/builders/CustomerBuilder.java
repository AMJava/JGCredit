package lv.javaguru.java2.domain.builders;

import lv.javaguru.java2.domain.Customer;

import java.util.Date;

public class CustomerBuilder {

//    private String fName;
//    private String lName;
//    private String personalCode;
//    private Date birthDate;
//    private String address;
//    private int mobilePhoneNumber;
//    private int phoneNumber;
//    private String company;
//    private String jobTitle;


    private CustomerBuilder() { }

    public static CustomerBuilder createBuilder() {
        return new CustomerBuilder();
    }

    public Customer buildPerson(String fName,String lName,String personalCode,Date birthDate,
                          String address,int mobilePhoneNumber,int phoneNumber,String company,
                          String jobTitle) {
        Customer customer = new Customer();
        customer.setfName(fName);
        customer.setlName(lName);
        customer.setPersonalCode(personalCode);
        customer.setBirthDate(birthDate);
        customer.setAddress(address);
        customer.setMobilePhoneNumber(mobilePhoneNumber);
        customer.setPhoneNumber(phoneNumber);
        customer.setCompany(company);
        customer.setJobTitle(jobTitle);
        return customer;
    }
}

package lv.javaguru.java2.domain.builders;

import lv.javaguru.java2.domain.User;

import java.util.Date;

public class UserBuilder {

//    private String fName;
//    private String lName;
//    private String personalCode;
//    private Date birthDate;
//    private String address;
//    private int mobilePhoneNumber;
//    private int phoneNumber;
//    private String company;
//    private String jobTitle;


    private UserBuilder() { }

    public static UserBuilder createBuilder() {
        return new UserBuilder();
    }

    public User buildPerson(String fName, String lName, String personalCode, Date birthDate,
                            String address, String mobilePhoneNumber, String phoneNumber, String company,
                            String jobTitle) {
        User user = new User();
        user.setfName(fName);
        user.setlName(lName);
        user.setPersonalCode(personalCode);
        user.setBirthDate(birthDate);
        user.setAddress(address);
        user.setMobilePhoneNumber(mobilePhoneNumber);
        user.setPhoneNumber(phoneNumber);
        user.setCompany(company);
        user.setJobTitle(jobTitle);
        return user;
    }
}

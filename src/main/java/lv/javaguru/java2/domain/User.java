package lv.javaguru.java2.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", columnDefinition = "int")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "login_pw")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String fName;

    @Column(name = "last_name")
    private String lName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "personal_code")
    private String personalCode;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "address")
    private String address;

    @Column(name = "m_phone_number")
    private String mobilePhoneNumber;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "company_name")
    private String company;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "salary")
    private String salary;

    @Column(name = "photo", columnDefinition = "longblob")
    private byte[] photo;

    public User() {
    }

    public User(Long id, String login, String password, String email, String fName, String lName, String gender, String personalCode, Date birthDate,
                String address, String mobilePhoneNumber, String phoneNumber, String company,
                String jobTitle, String salary, byte[] photo) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.photo = photo;
        this.fName = fName;
        this.lName = lName;
        this.gender = gender;
        this.personalCode = personalCode;
        this.birthDate = birthDate;
        this.address = address;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.phoneNumber = phoneNumber;
        this.company = company;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

}

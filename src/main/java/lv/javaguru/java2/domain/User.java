package lv.javaguru.java2.domain;

import lv.javaguru.java2.domain.Base.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

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

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "company_name")
    private String company;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "salary")
    private String salary;

    @Column(name = "secret_qeastion")
    private String question;

    @Column(name = "secret_answer")
    private String answer;

    @Column(name = "photo", columnDefinition = "longblob")
    private byte[] photo;

    @Column(name = "term", columnDefinition = "char")
    private String term;

    public User() {
    }

    public User(Long id, String login, String password, String email, String fName, String lName, String gender, String personalCode, Date birthDate,
                String address, String phoneNumber, String company,
                String jobTitle, String salary, String question, String answer, byte[] photo, String term) {
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
        this.phoneNumber = phoneNumber;
        this.company = company;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.question = question;
        this.answer = answer;
        this.term = term;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return "{" +
        "\"Id\":" + "\"" + id + "\"" +
        ", \"login\":" + "\"" + login + "\"" +
        ", \"personalCode\":" + "\"" + personalCode + "\"" +
        ", \"birthDate\":" + "\"" + birthDate + "\"" +
        ", \"address\":" + "\"" + address + "\"" +
        ", \"phoneNumber\":" + "\"" + phoneNumber + "\"" +
        ", \"company\":" + "\"" + company + "\"" +
        ", \"jobTitle\":" + "\"" + jobTitle + "\"" +
        ", \"salary\":" + "\"" + salary + "\"" +
        ", \"quastion\":" + "\"" + question + "\"" +
        ", \"answer\":" + "\"" + answer + "\"" +
        ", \"gender\":" + "\"" + gender + "\"" +
        ", \"email\":" + "\"" + email + "\"" +
        ", \"name\":" + "\"" + fName + "\"" +
        ", \"phone\":" + "\"" + lName + "\"" +
        ", \"password\":" + "\"" + password + "\"" +
        ", \"photo\":" + "\"" + photo + "\"" +
        ", \"term\":" + "\"" + term + "\"" +
        '}';
    }
}

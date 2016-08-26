package lv.javaguru.java2.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Arturs on 09.08.2016.
 */
public class Loan {
    private Long id;
    private BigDecimal loanSum;
    private BigDecimal interestRate;
    private int term;
    private String termUnit;
    private Date startDate;
    private Date endDate;
    private String loanStatus;
    private String extendetFlag;
    private Long userId;
    private Long employeeId;
    private String bankAccountNumb;
    private String comments;

    public Loan() {
    }

    public Loan(BigDecimal loanSum, BigDecimal interestRate, int term, String termUnit, Date startDate, Date endDate,
                String loanStatus, String extendetFlag, Long userId, Long employeeId,
                String bankAccountNumb, String comments) {
        this.loanSum = loanSum;
        this.interestRate = interestRate;
        this.term = term;
        this.termUnit = termUnit;
        this.startDate = startDate;
        this.endDate = endDate;
        this.loanStatus = loanStatus;
        this.extendetFlag = extendetFlag;
        this.userId = userId;
        this.employeeId = employeeId;
        this.bankAccountNumb = bankAccountNumb;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getLoanSum() {
        return loanSum;
    }

    public void setLoanSum(BigDecimal loanSum) {
        this.loanSum = loanSum;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public String getTermUnit() {
        return termUnit;
    }

    public void setTermUnit(String termUnit) {
        this.termUnit = termUnit;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

    public String getExtendetFlag() {
        return extendetFlag;
    }

    public void setExtendetFlag(String extendetFlag) {
        this.extendetFlag = extendetFlag;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getBankAccountNumb() {
        return bankAccountNumb;
    }

    public void setBankAccountNumb(String bankAccountNumb) {
        this.bankAccountNumb = bankAccountNumb;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

package lv.javaguru.java2.domain;

import lv.javaguru.java2.domain.Base.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Arturs on 09.08.2016.
 */
@Entity
@Table(name = "loans")
public class Loan extends BaseEntity {

    @Column(name = "loan", columnDefinition = "decimal")
    private Double loan;

    @Column(name = "loan_sum", columnDefinition = "decimal")
    private Double loanSum;

    @Column(name = "duration")
    private int duration;

    @Column(name = "term_unit")
    private String term;

    @Column(name = "term_payment", columnDefinition = "decimal")
    private Double termPayment;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "extended_date")
    private Date extendedDate;

    @Column(name = "loan_status")
    private String loanStatus;

    @Column(name = "extended_flag")
    private String extendedFlag;

    @Column(name = "user_id", columnDefinition = "int")
    private Long userId;

    @Column(name = "employee_id", columnDefinition = "int")
    private Long employeeId;

    @Column(name = "bank_acc_number")
    private String bankAccountNumb;

    @Column(name = "comments")
    private String comments;

    public Loan() {
    }

    public Loan(Long id, Double loan, Double loanSum, int duration, String term, Double termPayment, Date startDate, Date endDate, Date extendedDate, String loanStatus, String extendedFlag, Long userId, Long employeeId, String bankAccountNumb, String comments) {
        this.id = id;
        this.loan = loan;
        this.loanSum = loanSum;
        this.duration = duration;
        this.term = term;
        this.termPayment = termPayment;
        this.startDate = startDate;
        this.endDate = endDate;
        this.extendedDate = extendedDate;
        this.loanStatus = loanStatus;
        this.extendedFlag = extendedFlag;
        this.userId = userId;
        this.employeeId = employeeId;
        this.bankAccountNumb = bankAccountNumb;
        this.comments = comments;
    }

    public Double getTermPayment() {
        return termPayment;
    }

    public void setTermPayment(Double termPayment) {
        this.termPayment = termPayment;
    }

    public Double getLoan() {
        return loan;
    }

    public void setLoan(Double loan) {
        this.loan = loan;
    }

    public Double getLoanSum() {
        return loanSum;
    }

    public void setLoanSum(Double loanSum) {
        this.loanSum = loanSum;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
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

    public Date getExtendedDate() {
        return extendedDate;
    }

    public void setExtendedDate(Date extendedDate) {
        this.extendedDate = extendedDate;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

    public String getExtendedFlag() {
        return extendedFlag;
    }

    public void setExtendedFlag(String extendedFlag) {
        this.extendedFlag = extendedFlag;
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

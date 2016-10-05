package lv.javaguru.java2.dto;

import lv.javaguru.java2.domain.Base.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Blob;
import java.util.Date;

/**
 * Created by Arturs on 09.08.2016.
 */

public class LoanDTO{

    private Long id;

    private Double loan;

    private Double loanSum;

    private int duration;

    private String term;

    private Double termPayment;

    private Date startDate;

    private Date endDate;

    private Date extendedDate;

    private String loanStatus;

    private String extendedFlag;

    private Long userId;

    private Long employeeId;

    private String bankAccountNumb;

    private String comments;

    private String agreementTeam;

    private Blob agreement;

    public LoanDTO() {
    }

    public LoanDTO(Long id, Double loan, Double loanSum, int duration, String term, Double termPayment, Date startDate, Date endDate, Date extendedDate, String loanStatus, String extendedFlag, Long userId, Long employeeId, String bankAccountNumb, String comments, Blob agreement) {
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
        this.agreement = agreement;
    }

    public Blob getAgreement() {
        return agreement;
    }

    public void setAgreement(Blob agreement) {
        this.agreement = agreement;
    }

    public String getAgreementTeam() {
        return agreementTeam;
    }

    public void setAgreementTeam(String agreementTeam) {
        this.agreementTeam = agreementTeam;
    }

    public Double getTermPayment() {
        return termPayment;
    }

    public void setTermPayment(Double termPayment) {
        this.termPayment = termPayment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "LoanDTO{" +
        "id=" + id +
        ", loan=" + loan +
        ", loanSum=" + loanSum +
        ", duration=" + duration +
        ", term='" + term + '\'' +
        ", termPayment=" + termPayment +
        ", startDate=" + startDate +
        ", endDate=" + endDate +
        ", extendedDate=" + extendedDate +
        ", loanStatus='" + loanStatus + '\'' +
        ", extendedFlag='" + extendedFlag + '\'' +
        ", userId=" + userId +
        ", employeeId=" + employeeId +
        ", bankAccountNumb='" + bankAccountNumb + '\'' +
        ", comments='" + comments + '\'' +
        ", agreementTeam='" + agreementTeam + '\'' +
        '}';
    }
}

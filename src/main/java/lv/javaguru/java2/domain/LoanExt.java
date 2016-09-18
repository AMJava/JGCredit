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
@Table(name = "loans_ext")
public class LoanExt extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", columnDefinition = "int")
    private Long id;

    @Column(name = "ext_type")
    private String extType;

    @Column(name = "ext_status")
    private String extStatus;

    @Column(name = "ext_date")
    private Date extDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "interest_rate")
    private BigDecimal interestRate;

    @Column(name = "comission")
    private BigDecimal commision;

    @Column(name = "loan_id", columnDefinition = "int")
    private Long loanId;

    @Column(name = "bank_acc_number")
    private String bankAccountNumb;

    @Column(name = "comments")
    private String comments;

    public LoanExt() {
    }

    public LoanExt(String extType, String extStatus, Date extDate, Date endDate,
                   BigDecimal interestRate, BigDecimal commision, Long loanId,
                   String bankAccountNumb, String comments) {
        this.extType = extType;
        this.extStatus = extStatus;
        this.extDate = extDate;
        this.endDate = endDate;
        this.interestRate = interestRate;
        this.commision = commision;
        this.loanId = loanId;
        this.bankAccountNumb = bankAccountNumb;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExtType() {
        return extType;
    }

    public void setExtType(String extType) {
        this.extType = extType;
    }

    public String getExtStatus() {
        return extStatus;
    }

    public void setExtStatus(String extStatus) {
        this.extStatus = extStatus;
    }

    public Date getExtDate() {
        return extDate;
    }

    public void setExtDate(Date extDate) {
        this.extDate = extDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getCommision() {
        return commision;
    }

    public void setCommision(BigDecimal commision) {
        this.commision = commision;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
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

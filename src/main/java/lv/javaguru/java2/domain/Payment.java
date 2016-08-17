package lv.javaguru.java2.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

/**
 * Created by Arturs on 09.08.2016.
 */
public class Payment {
    private Long id;
    private String paymentType;
    private float paymentSum;
    private Date paymentDate;
    private String bankAccountNumb;
    private Long loanId;
    private Long loanExtId;

    public Payment() {
    }

    public Payment(String paymentType, float paymentSum, Date paymentDate,
                   String bankAccountNumb, Long loanId, Long loanExtId) {
        this.paymentType = paymentType;
        this.paymentSum = paymentSum;
        this.paymentDate = paymentDate;
        this.loanId = loanId;
        this.loanExtId = loanExtId;
        this.bankAccountNumb = bankAccountNumb;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String payment_type) {
        this.paymentType = paymentType;
    }

    public Float getPaymentSum() {
        return paymentSum;
    }

    public void setPaymentSum(Float paymentSum) {
        this.paymentSum = paymentSum;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Long getLoanExtId() {
        return loanExtId;
    }

    public void setLoanExtId(Long loanExtId) {
        this.loanExtId = loanExtId;
    }

    public String getBankAccountNumb() {
        return bankAccountNumb;
    }

    public void setBankAccountNumb(String bankAccountNumb) {
        this.bankAccountNumb = bankAccountNumb;
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

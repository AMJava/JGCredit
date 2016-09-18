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
@Table(name = "payments")
public class Payment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", columnDefinition = "int")
    private Long id;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "payment_sum")
    private BigDecimal paymentSum;

    @Column(name = "payment_date")
    private Date paymentDate;

    @Column(name = "bank_acc_number")
    private String bankAccountNumb;


    @Column(name = "loan_id", columnDefinition = "int")
    private Long loanId;

    @Column(name = "loan_ext_id", columnDefinition = "int")
    private Long loanExtId;

    public Payment() {
    }

    public Payment(String paymentType, BigDecimal paymentSum, Date paymentDate,
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

    public BigDecimal getPaymentSum() {
        return paymentSum;
    }

    public void setPaymentSum(BigDecimal paymentSum) {
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

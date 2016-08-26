package lv.javaguru.java2.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Arturs on 09.08.2016.
 */
@Entity
@Table(name = "communications")
public class Communication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", columnDefinition = "int")
    private Long id;

    @Column(name = "body")
    private String body;

    @Column(name = "sent_date")
    private Date sentDate;

    @Column(name = "com_type")
    private String comType;

    @Column(name = "user_id", columnDefinition = "int")
    private Long userId;

    @Column(name = "loan_id", columnDefinition = "int")
    private Long loanId;

    @Column(name = "loan_ext_id", columnDefinition = "int")
    private Long loanExtId;

    public Communication() {
    }

    public Communication(String body, Date sentDate, String comType, Long userId, Long loanId, Long loanExtId) {
        this.body = body;
        this.sentDate = sentDate;
        this.comType = comType;
        this.userId = userId;
        this.loanExtId = loanExtId;
        this.loanId = loanId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLoanExtId() {
        return loanExtId;
    }

    public void setLoanExtId(Long loanExtId) {
        this.loanExtId = loanExtId;
    }

    public String getComType() {
        return comType;
    }

    public void setComType(String comType) {
        this.comType = comType;
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

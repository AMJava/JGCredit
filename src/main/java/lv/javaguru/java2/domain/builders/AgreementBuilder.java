package lv.javaguru.java2.domain.builders;

import lv.javaguru.java2.domain.Customer;

import java.util.Date;
import lv.javaguru.java2.domain.Agreement;

/**
 * Created by Arturs on 09.08.2016.
 */
public class AgreementBuilder {
 //   private Long id;
 //   private float loanSum;
 //   private float interestRate;
 //   private int term;
 //   private String termUnit;
 //   private String startDate;
 //   private String endDate;
 //   private String agreementStatus;
 //   private String extendetFlag;
 //   private Long userId;
 //   private String comments;


    private AgreementBuilder() { }

    public static AgreementBuilder createAgreement() {
        return new AgreementBuilder();
    }

    public Agreement buildAgreement(float loanSum, float interestRate, int term,
                                    String termUnit, String startDate, String endDate, String agreementStatus,
                                    String extendetFlag, Long userId, String comments) {
        Agreement agreement = new Agreement();
        agreement.setLoanSum(loanSum);
        agreement.setInterestRate(interestRate);
        agreement.setTerm(term);
        agreement.setTermUnit(termUnit);
        agreement.setStartDate(startDate);
        agreement.setEndDate(endDate);
        agreement.setAgreementStatus(agreementStatus);
        agreement.setExtendetFlag(extendetFlag);
        agreement.setUserId(userId);
        agreement.setComments(comments);
        return agreement;
    }
}

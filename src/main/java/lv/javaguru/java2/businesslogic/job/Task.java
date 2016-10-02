package lv.javaguru.java2.businesslogic.job;

import lv.javaguru.java2.businesslogic.CommunicationService;
import lv.javaguru.java2.businesslogic.exceptions.CommunicationException;
import lv.javaguru.java2.controllers.ErrorHandlingController;
import lv.javaguru.java2.database.LoanDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import javax.mail.MessagingException;
import java.sql.SQLException;

public class Task {
    @Autowired
    private LoanDAO loanDAO;

    @Autowired
    CommunicationService communicationService;

    private static Logger logger = LoggerFactory.getLogger(ErrorHandlingController.class);

    @Scheduled(initialDelayString = "10000", fixedDelayString = "86400000")
    public void doTask(){
        logger.info("Job started");
        try {
            communicationService.sendWarningEmail(loanDAO.getUserWeekLoans());
        } catch (SQLException e) {
            logger.error(e.toString());
        } catch (MessagingException e) {
            logger.error(e.toString());
        } catch (CommunicationException e) {
            logger.error(e.toString());
        }
        logger.info("Job finished");
    }
}

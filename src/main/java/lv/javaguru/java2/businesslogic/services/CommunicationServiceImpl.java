package lv.javaguru.java2.businesslogic.services;

import lv.javaguru.java2.businesslogic.CommunicationService;
import lv.javaguru.java2.businesslogic.exceptions.CommunicationException;
import lv.javaguru.java2.businesslogic.exceptions.ServiceException;
import lv.javaguru.java2.database.CommunicationDAO;
import lv.javaguru.java2.domain.Communication;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.sql.SQLException;

@Service
public class CommunicationServiceImpl implements CommunicationService {

    @Autowired
    private CommunicationDAO communicationDAO;

    @Autowired
    PasswordEncoder passwordEncoder;

    static Properties mailServerProperties;
    static Session getMailSession;
    static MimeMessage generateMailMessage;

    @Transactional
    public Long create(Communication communication) throws SQLException, CommunicationException {

        Long CommunicationId = communicationDAO.create(communication);
        if(CommunicationId == null)
            throw new CommunicationException("Please Contact Second Line Support, communicationId is null");
        return CommunicationId;
    }

    @Transactional
    public void sendRestoreEmail(User user, String password) throws SQLException, MessagingException, CommunicationException {
        String sBody = "Your password for "+user.getLogin()+" is: "+password;
        Date today = new Date();
        generateAndSendEmail(sBody,user.getEmail(),"Password restored.");
        Communication communication = new Communication("Password restored.", sBody, today, "Outbound", "E-mail", user.getEmail(), user.getId(), null, null);
        Long CommunicationId = create(communication);
    }

    @Transactional
    public void sendChangeEmail(User user) throws SQLException, MessagingException, CommunicationException {
        String sBody = "Password for your account was changed";
        Date today = new Date();
        generateAndSendEmail(sBody,user.getEmail(),"Password changed.");
        Communication communication = new Communication("Password changed.", sBody, today, "Outbound", "E-mail", user.getEmail(), user.getId(), null, null);
        Long CommunicationId = create(communication);
    }

    public void generateAndSendEmail(String sBody, String sTo, String sSubject) throws MessagingException {
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");

        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(sTo));
        generateMailMessage.setSubject(sSubject);
        String emailBody = sBody + "<br><br> Regards, <br>JGCredit Group";
        generateMailMessage.setContent(emailBody, "text/html");

        Transport transport = getMailSession.getTransport("smtp");

        transport.connect("smtp.gmail.com", "TEST@gmail.com", "");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
    }
}

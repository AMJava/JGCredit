package lv.javaguru.java2.businesslogic.services;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.html.simpleparser.HTMLWorker;
import lv.javaguru.java2.businesslogic.CommunicationService;
import lv.javaguru.java2.businesslogic.exceptions.CommunicationException;
import lv.javaguru.java2.businesslogic.exceptions.ServiceException;
import lv.javaguru.java2.database.CommunicationDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.Communication;
import lv.javaguru.java2.domain.Loan;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.Date;
import java.util.List;
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
    private UserDAO userDAO;

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
    public void createUserMessage(User user, String subject, String message) throws SQLException, ServiceException, CommunicationException, MessagingException {
        String sBody = "Our manager will contact you soon";
        Date today = new Date();
        generateAndSendEmail(sBody,user.getEmail(),"Thank You for your question on JGCredit.lv");
        Communication communication = new Communication(subject, message, today, "Inbound", "E-mail", user.getEmail(), user.getId(), null);
        Long CommunicationId = create(communication);
    }

    @Transactional
    public void sendRestoreEmail(User user, String password) throws SQLException, MessagingException, CommunicationException {
        String sBody = "Your password for "+user.getLogin()+" is: "+password;
        Date today = new Date();
        generateAndSendEmail(sBody,user.getEmail(),"Password restored.");
        Communication communication = new Communication("Password restored.", sBody, today, "Outbound", "E-mail", user.getEmail(), user.getId(), null);
        Long CommunicationId = create(communication);
    }

    @Transactional
    public void sendRegEmail(User user) throws SQLException, MessagingException, CommunicationException {
        String sBody = "Welcome to JG Credit";
        Date today = new Date();
        generateAndSendEmail(sBody,user.getEmail(),"Welcome to JG Credit.");
        Communication communication = new Communication("Welcome to JG Credit.", sBody, today, "Outbound", "E-mail", user.getEmail(), user.getId(), null);
        Long CommunicationId = create(communication);
    }

    @Transactional
    public void sendLoanEmail(Long id, String email) throws MessagingException, CommunicationException, SQLException, IOException, DocumentException {
        String sBody = "Loan was created";
        User user = userDAO.getById(id);
        Date today = new Date();
        File pdf = generatePDF(user,today);
        //generateAndSendEmail(sBody,email,"Loan was created.");
       // Communication communication = new Communication("Welcome to JG Credit.", sBody, today, "Outbound", "E-mail", email, id, null);
       // Long CommunicationId = create(communication);
    }

    @Transactional
    public void sendChangeEmail(User user) throws SQLException, MessagingException, CommunicationException {
        String sBody = "Password for your account was changed";
        Date today = new Date();
        generateAndSendEmail(sBody,user.getEmail(),"Password changed.");
        Communication communication = new Communication("Password changed.", sBody, today, "Outbound", "E-mail", user.getEmail(), user.getId(), null);
        Long CommunicationId = create(communication);
    }

    @Transactional
    public void sendWarningEmail(List<Long> userIdList) throws SQLException, MessagingException, CommunicationException{
        if(userIdList.size() > 0){
            for(int i = 0; i<userIdList.size(); i++) {
                    User user = userDAO.getById(userIdList.get(i));
                    if(user != null){
                        String sBody = "You have only 7 days to pay your loan";
                        Date today = new Date();
                        generateAndSendEmail(sBody,user.getEmail(),"You have only 7 days to pay your loan.");
                        Communication communication = new Communication("You have only 7 days to pay your loan.", sBody, today, "Outbound", "E-mail", user.getEmail(), user.getId(), null);
                        Long CommunicationId = create(communication);
                    }
            }
        }
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

    public File generatePDF(User user, Date today) throws DocumentException,IOException {
        Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("temp/Agreement"+user.getId()+"-"+today.getTime()+".pdf"));
            document.open();
            Paragraph preface = new Paragraph("Agreement");
            preface.setAlignment(Element.ALIGN_CENTER);
            document.add(preface);
            document.setPageSize(PageSize.LETTER);
            document.addAuthor("JGCredit");
            document.addCreator("JGCredit");
            document.addSubject("Thanks for your support");
            document.addCreationDate();
            document.addTitle("Please read this");
            HTMLWorker htmlWorker = new HTMLWorker(document);
            String str =
            "<br>" +
            "<p>Dear "+user.getFName()+" "+ user.getLName()+" you have successfully signed an Agreement with JGCredit Group." +
            "</body></html>";
            htmlWorker.parse(new StringReader(str));
        document.close();
        return new File("temp/Agreement"+user.getId()+"-"+today.toString()+".pdf");
    }
}

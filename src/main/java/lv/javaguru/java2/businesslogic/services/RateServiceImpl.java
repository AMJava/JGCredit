package lv.javaguru.java2.businesslogic.services;

import lv.javaguru.java2.businesslogic.*;
import lv.javaguru.java2.businesslogic.exceptions.CommunicationException;
import lv.javaguru.java2.businesslogic.exceptions.ServiceException;
import lv.javaguru.java2.businesslogic.exceptions.UnAuthorizedUserException;
import lv.javaguru.java2.database.RateDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.Rate;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.ConvertorDTO;
import lv.javaguru.java2.dto.UserDTO;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import java.security.SecureRandom;
import java.sql.SQLException;

@Service
public class RateServiceImpl implements RateService {

    @Autowired
    private RateDAO rateDAO;


    @Transactional
    public Rate findByTermAndDuration(int duration, String term) throws SQLException {

        return rateDAO.getByTermAndDuration(duration,term);
    }


}

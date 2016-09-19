package lv.javaguru.java2.businesslogic.services;

import lv.javaguru.java2.businesslogic.SessionUserDTOService;
import lv.javaguru.java2.dto.UserDTO;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Created by Arturs on 19.09.2016.
 */
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class SessionUserDTOServiceImpl implements SessionUserDTOService {
    private UserDTO userDTO;
    public UserDTO getUserDTO() {
        return userDTO;
    }
    public void setUser(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
    public boolean authorized() {
        return userDTO != null;
    }
}

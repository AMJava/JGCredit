package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.dto.UserDTO;

/**
 * Created by Arturs on 19.09.2016.
 */
public interface SessionUserDTOService {
    UserDTO getUserDTO();

    void setUser(UserDTO userDTO);

    boolean authorized();

}

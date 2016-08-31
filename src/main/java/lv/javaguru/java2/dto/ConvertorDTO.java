package lv.javaguru.java2.dto;

import lv.javaguru.java2.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arturs on 29.08.2016.
 */
@Component
public class ConvertorDTO {

    public UserDTO convertUserToDTO(User user) {

        if (user != null) {
            return new UserDTO(
            user.getId(),
            user.getLogin(),
            user.getPassword(),
            user.getEmail(),
            user.getFName(),
            user.getLName(),
            user.getGender(),
            user.getPersonalCode(),
            user.getBirthDate(),
            user.getAddress(),
            user.getPhoneNumber(),
            user.getCompany(),
            user.getJobTitle(),
            user.getSalary(),
            user.getQuestion(),
            user.getAnswer(),
            user.getPhoto());
        }
        return null;
    }

    public User convertUserFromDTO(UserDTO userDTO) {

        if (userDTO != null) {
            return new User(
            userDTO.getId(),
            userDTO.getLogin(),
            userDTO.getPassword(),
            userDTO.getEmail(),
            userDTO.getFName(),
            userDTO.getLName(),
            userDTO.getGender(),
            userDTO.getPersonalCode(),
            userDTO.getBirthDate(),
            userDTO.getAddress(),
            userDTO.getPhoneNumber(),
            userDTO.getCompany(),
            userDTO.getJobTitle(),
            userDTO.getSalary(),
            userDTO.getQuestion(),
            userDTO.getAnswer(),
            userDTO.getPhoto());
        }
        return null;
    }
}

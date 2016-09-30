package lv.javaguru.java2.unused.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import lv.javaguru.java2.database.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDAO userDao;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(final String username){

        lv.javaguru.java2.domain.User user = getUserByLogin(username);

        List<GrantedAuthority> authorities =  buildUserAuthority();

        return buildUserForAuthentication(user, authorities);

    }

    // Converts domain User user to
    // org.springframework.security.core.userdetails.User
    private UserPrincipal buildUserForAuthentication(lv.javaguru.java2.domain.User user,
                                                     List<GrantedAuthority> authorities) {

        // Creating user that will be stored by Spring security
        UserPrincipal userPrincipal = new UserPrincipal(user.getLogin(), user.getPassword(),
        true, true, true, true, authorities);
        // Adding domain user, so we can get it any where we want.
        userPrincipal.attachDomainUser(user);

        return  userPrincipal;
    }

    private List<GrantedAuthority> buildUserAuthority() {

        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>();
        result.add(new SimpleGrantedAuthority("LOGINNED_USER"));

        return result;
    }

    private lv.javaguru.java2.domain.User getUserByLogin(String username){
        lv.javaguru.java2.domain.User user = null;
        try {
            user = userDao.getByLogin(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    };

}

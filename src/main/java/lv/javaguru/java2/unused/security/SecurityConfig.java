package lv.javaguru.java2.unused.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
        .authorizeRequests()
        .antMatchers("/assets/**").permitAll()
        .antMatchers("/fonts/**").permitAll()
        .antMatchers("/images/**").permitAll()
        .antMatchers("/js/**").permitAll()
        .antMatchers("/styles/**").permitAll()
        .antMatchers("/user/**").access("hasRole('LOGINNED_USER')")
        .and()
        .formLogin()
        .loginPage("/login")
        .defaultSuccessUrl("/home")
        .permitAll()
        .and()
        .logout()
        .logoutUrl("/about")
        .permitAll()
        .and()
        .csrf().disable();
    }
}

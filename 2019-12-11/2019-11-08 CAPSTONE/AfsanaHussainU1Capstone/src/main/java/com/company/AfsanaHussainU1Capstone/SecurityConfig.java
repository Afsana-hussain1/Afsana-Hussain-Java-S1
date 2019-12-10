package com.company.AfsanaHussainU1Capstone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;


import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder authBuilder) throws Exception {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        authBuilder.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username, password, enabled from users where username = ?")
                .authoritiesByUsernameQuery(
                        "select username, authority from authorities where username = ?")
                .passwordEncoder(passwordEncoder);

    }


    public void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.httpBasic();

        httpSecurity.authorizeRequests()
               // .mvcMatchers("/loggedin").authenticated()

                .mvcMatchers(HttpMethod.PUT).authenticated()
                .mvcMatchers(HttpMethod.POST,"/tshirts").hasAuthority("ROLE_MANAGER")
                .mvcMatchers(HttpMethod.POST, "/games").hasAuthority("ROLE_MANAGER")
                .mvcMatchers(HttpMethod.POST,"/invoice").hasAuthority("ROLE_MANAGER")
                .mvcMatchers(HttpMethod.POST,"/consoles").hasAuthority("ROLE_MANAGER")
                .mvcMatchers(HttpMethod.DELETE,"/games/*").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.DELETE,"/invoice/*").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.DELETE,"/tshirt/*").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.DELETE,"/consoles/*").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.PUT,"/tshirt/*").hasAuthority("ROLE_STAFF")
                .mvcMatchers(HttpMethod.PUT,"/console/*").hasAuthority("ROLE_STAFF")
                .mvcMatchers(HttpMethod.PUT,"/invoice/*").hasAuthority("ROLE_STAFF")
                .mvcMatchers(HttpMethod.PUT,"/games/*").hasAuthority("ROLE_STAFF")
                 .anyRequest().permitAll();

        httpSecurity
                .logout()
                .clearAuthentication(true)
                .logoutSuccessUrl("/allDone")
                .deleteCookies("JSESSIONID")
                .deleteCookies("XSRF-TOKEN")
                .invalidateHttpSession(true);

        httpSecurity
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

    }
}

package com.clientproject.soms.wellbeing.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeRequests()
                .mvcMatchers("/").permitAll()
                .mvcMatchers("/Home").permitAll()
                .mvcMatchers("/bootstrap/*").permitAll()
                .mvcMatchers("/CreateActivity/*").authenticated()
                .mvcMatchers("/CreateActivity").hasRole("SERVICE_PROVIDER")
                .and()
                .formLogin()
                    .loginPage("/login");
    /*  Very important - Need to disable csrf to allow POST requests.
        Getting HTTP 403 Forbidden error if this is not disabled!! */
        httpSecurity.csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER");

        auth
                .inMemoryAuthentication()
                .withUser("bmw").password("{noop}password").roles("SERVICE_PROVIDER");
    }
}

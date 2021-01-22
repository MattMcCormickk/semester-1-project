package com.clientproject.soms.wellbeing.config;

import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

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
                .mvcMatchers("/AdminHome/*").authenticated()
                .mvcMatchers("/ActivityData/*").authenticated()
                .mvcMatchers("/AllUsers/*").authenticated()
                .mvcMatchers("/CaptureActivityForUser/*").authenticated()
                .mvcMatchers("/SelectedPage/*").authenticated()
                .mvcMatchers("/allActivities/*").authenticated()
                .mvcMatchers("/CustomizeActivity/*").authenticated()
                .mvcMatchers("/ContactAdmin/*").authenticated()
                .mvcMatchers("/ContactAdmin").hasAnyRole("SERVICE_PROVIDER", "ADMIN")
                .mvcMatchers("/CreateActivity").hasAnyRole("SERVICE_PROVIDER", "ADMIN")
                .mvcMatchers("/ActivityData").hasAnyRole("SERVICE_PROVIDER", "ADMIN")
                .mvcMatchers("/AllUsers").hasAnyRole("SERVICE_PROVIDER", "ADMIN")
                .mvcMatchers("/CaptureActivityForUser").hasAnyRole("SERVICE_PROVIDER", "ADMIN")
                .mvcMatchers("/allActivities").hasAnyRole("SERVICE_PROVIDER", "ADMIN")
                .mvcMatchers("/CustomizeActivity").hasAnyRole("SERVICE_PROVIDER", "ADMIN")
                .mvcMatchers("/SelectedPage").hasAnyRole("SERVICE_PROVIDER", "ADMIN")
		        .mvcMatchers("/AdminHome").hasRole("ADMIN")
                .and()
                .formLogin()
                    .usernameParameter("email")     // change authentication to email id
                    .loginPage("/login");
    /*  Very important - Need to disable csrf to allow POST requests.
        Getting HTTP 403 Forbidden error if this is not disabled!! */
        httpSecurity.csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

    /*  Read all the account credentials from a CSV file to avoid hardcoding in the application
        The Accounts.csv file has 'username', 'password' and 'role' values for multiple accounts.*/
        try {
            CSVReader reader = new CSVReader(new FileReader("Accounts.csv"));
            List<String[]> entries = reader.readAll();
            String[] entry;
            ArrayList<Account> accounts = new ArrayList<Account>();
            int count = 0;
            for (int i = 1; i < entries.size(); i++) {
                entry = entries.get(i);
                Account account = new Account(entry[0], entry[1], entry[2]);
                accounts.add(account);
            }

        /*  Based on the number of entries read from the CSV file, configure the authentication details
         in the below for loop */

            for (int i = 0; i < accounts.size(); i++) {
//                System.out.println(accounts.get(i).getUserName());
                auth
                        .inMemoryAuthentication()
                        .withUser(accounts.get(i).getUserName()).password("{noop}" + accounts.get(i).getPassword()).roles(accounts.get(i).getRole());
            }
        } catch(Exception e) {
            System.out.println("Caught exception while reading the CSV file " + e.getMessage());
        }

    }
}

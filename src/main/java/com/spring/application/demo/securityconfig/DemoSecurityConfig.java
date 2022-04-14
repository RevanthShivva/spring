package com.spring.application.demo.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource securityDataSource;
   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception{

       auth.jdbcAuthentication().dataSource(securityDataSource);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests().antMatchers("/lecturers/principle","/lecturers/showPrincipleLecturer","/lecturers/showStudent","/lecturers/showFormForDelete","/lecturers/save","/lecturers/showFormForUpdate","/lecturers/list","/lecturers/showFormForAdd").hasRole("PRINCIPLE")
             //  .antMatchers("/students/showPrincipleStudent","/lecturers/showStudentDetails","/students/showFormForDelete","/students/save","/students/showFormForUpdate","/students/list","/students/showFormForAdd").hasRole("PRINCIPLE")
             //  .antMatchers("/studentDetails/showFormForDelete","/studentDetails/save","/studentDetails/showFormForUpdate","/studentDetails/list","/studentDetails/showFormForAdd").hasRole("PRINCIPLE")
               .antMatchers("/lecturers/principle","/lecturers/showPrincipleLecturer","/lecturers/showStudent","/lecturers/showFormForDelete","/lecturers/save","/lecturers/showFormForUpdate","/lecturers/list","/lecturers/showFormForAdd").hasAnyRole("LECTURER","PRINCIPLE")
               .antMatchers("/students/showPrincipleStudent").hasAnyRole("STUDENT","PRINCIPLE")
               .and()
               .formLogin()
               .loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser")
               .permitAll().and().logout().permitAll().and().exceptionHandling()
               .accessDeniedPage("/access");
    }
}

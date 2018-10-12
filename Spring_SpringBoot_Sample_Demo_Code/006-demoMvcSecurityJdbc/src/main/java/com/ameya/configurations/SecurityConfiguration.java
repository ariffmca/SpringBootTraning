package com.ameya.configurations;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	  auth.jdbcAuthentication()
		.usersByUsernameQuery(
			"select username,password, enabled from users"
			+ " where username=?")
		.authoritiesByUsernameQuery(
			"select username, role from user_roles where username=?")
		.passwordEncoder(passwordEncoder()).dataSource(dataSource);
	}	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  http.authorizeRequests()
		.antMatchers("/hello").access("hasRole('ROLE_ADMIN')")		
		.anyRequest().permitAll()
		.and()
    	  .formLogin().loginPage("/login")
		  .usernameParameter("username").passwordParameter("password")
		.and().logout().logoutSuccessUrl("/login?logout")	
		 .and().exceptionHandling().accessDeniedPage("/403")
		.and().csrf();
	}
}
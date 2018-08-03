package com.skilldistillery.dmtool.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	        http
	        .csrf().disable()
	        .authorizeRequests()
	        .antMatchers(HttpMethod.OPTIONS, "/api/**").permitAll()  // For CORS, the preflight request will hit the OPTIONS on the route
	        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
	        .antMatchers(HttpMethod.GET, "/api/ping").permitAll()
	        .antMatchers("/api/register").permitAll()
	        .anyRequest().authenticated()
	        .and()
	        .httpBasic();

	        http
	        .sessionManagement()
	        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	  }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    String userQuery = "SELECT email, password, enabled FROM User WHERE email=?";
	    String authQuery = "SELECT email, role FROM User WHERE email=?";
	    auth
	      .jdbcAuthentication()
	      .dataSource(dataSource)
	      .usersByUsernameQuery(userQuery)
	      .authoritiesByUsernameQuery(authQuery)
	      .passwordEncoder(encoder);
	  }

}

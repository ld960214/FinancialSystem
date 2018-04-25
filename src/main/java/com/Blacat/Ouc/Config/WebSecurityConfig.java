package com.Blacat.Ouc.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.Blacat.Ouc.ResponseTools.JWTAuthenticationFilter;
import com.Blacat.Ouc.ResponseTools.JWTLoginFilter;
import com.Blacat.Ouc.ResponseTools.JwtUserService;
import com.Blacat.Ouc.Services.UserService;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	JwtUserService customUserService(){
		return new JwtUserService();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception{
		auth.userDetailsService(customUserService());
	}

	@Override
	protected void configure(HttpSecurity http)throws Exception{
		http.csrf().disable().authorizeRequests()
		.antMatchers("/login").permitAll()
		 .antMatchers("/assets/**").permitAll()
		 .antMatchers("/images/**").permitAll()
		 .antMatchers("/test").permitAll()
		 .antMatchers("/favicon.ico").permitAll()
		 .antMatchers("/register").permitAll()
		 .antMatchers("/api/user").permitAll()
		.antMatchers(HttpMethod.POST,"/api/login").permitAll()
		.anyRequest().authenticated()
		.and()
		.addFilterBefore(new JWTLoginFilter("/api/login",authenticationManager()), UsernamePasswordAuthenticationFilter.class)
		.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}

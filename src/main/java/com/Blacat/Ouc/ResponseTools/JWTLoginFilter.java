package com.Blacat.Ouc.ResponseTools;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.Blacat.Ouc.Entities.User;
import com.Blacat.Ouc.Services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

	public JWTLoginFilter(String url, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
		// TODO Auto-generated constructor stub
	}

	@Autowired
	UserService userService;
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		// TODO Auto-generated method stub
		JwtUser ur = new ObjectMapper().readValue(request.getInputStream(), JwtUser.class);
		return getAuthenticationManager().authenticate(
				new UsernamePasswordAuthenticationToken(ur.getUsername(), ur.getPassword(), Collections.emptyList()));
	}
	
	@Override
    protected void successfulAuthentication(
            HttpServletRequest req,
            HttpServletResponse res, FilterChain chain,
            Authentication auth) throws IOException, ServletException {
		JwtUser users = (JwtUser)auth.getPrincipal();
		String userid=String.valueOf(users.getUserid());
		
		com.Blacat.Ouc.ResponseTools.TokenService.addAuth(res,userid);
		
        
    }

}

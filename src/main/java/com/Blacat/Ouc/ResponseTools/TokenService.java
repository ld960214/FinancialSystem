package com.Blacat.Ouc.ResponseTools;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.OutputBuffer;
import org.dom4j.dom.DOMNodeHelper.EmptyNodeList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.origin.SystemEnvironmentOrigin;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.Blacat.Ouc.Entities.User;
import com.Blacat.Ouc.Services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static java.util.Collections.emptyList;

import java.io.IOException;
import java.io.OutputStream;



public class TokenService {
	
	static final long EXPIRATIONTIME = 1000*60*60*24*1; // 1 days
	static final String SECRET = "Whatashit";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";
    
    
    public static void addAuth(HttpServletResponse res,String username) throws IOException{
    	
    	String JWT = Jwts.builder()
    			.setSubject(username)
    			.setExpiration(new Date(System.currentTimeMillis()+EXPIRATIONTIME))
    			.signWith(SignatureAlgorithm.HS512,SECRET)
    			.compact();
    	res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
    	byte[] data = username.getBytes();
    	res.getOutputStream().write(data);
    }
    
    public static Authentication getAuth(HttpServletRequest req){
    	String token = req.getHeader(HEADER_STRING);
    	System.out.println(token);
    	if(token!=null){
    		String user = Jwts.parser()
    				.setSigningKey(SECRET)
    				.parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
    				.getBody()
    				.getSubject();
    		return user != null ?
    				new UsernamePasswordAuthenticationToken(user , null , emptyList()):
    				null;
    	}
    	return null;
    }
}

package com.skynet.translator.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.skynet.translator.entity.User;
import com.skynet.translator.exceptions.ValidateServiceException;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class TokenService {

	@Value("${jwt.password}")
	private String jwtSecret;
	
	public String createToken(User user) {
		Date now = new Date();
		Date expiredDate = new Date(now.getTime() + (1000*60*60));
		return Jwts.builder()
				.setSubject(user.getUsername())
				.setIssuedAt(now)
				.setExpiration(expiredDate)
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
				
	}
	
	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
			return true;
		} catch (UnsupportedJwtException e) {
			log.error("JWT in a particular format/configuration that does not match the format expected by the application: "+ e.getMessage());
		} catch (MalformedJwtException e) {
			log.error("JWT was not correctly constructed and should be rejected: "+e.getMessage());
		} catch (SignatureException e) {
			log.error("signature or verifying an existing signature of a JWT failed: "+e.getMessage());
		} catch (ExpiredJwtException e) {
			log.error(" JWT was accepted after it expired and must be rejected: "+ e.getMessage());
		} 
		
		return false;
	}

	public String getUsernameFromToken(String jwt) {
		try {
			return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwt).getBody().getSubject();
		} catch(Exception e) {
			log.error( e.getMessage(), e);
			throw new ValidateServiceException("Invalid Token");
		}
		
	}

	
}

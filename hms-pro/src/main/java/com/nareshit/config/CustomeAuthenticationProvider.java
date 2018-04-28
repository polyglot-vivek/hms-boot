package com.nareshit.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomeAuthenticationProvider implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		 String username = auth.getName();
	        String password = (String) auth.getCredentials();
	        System.out.println("user name is:\t"+username);
	        System.out.println("password is:\t"+password);
	        String role = null;
	        List<GrantedAuthority> rolesList = new ArrayList<GrantedAuthority>();
	        if((username != null && !username.isEmpty()) 
	        		&& (password != null && !password.isEmpty())) {
	        	//do ldap or db chekin
	        	role="admin";
	        	
	        	SimpleGrantedAuthority sga = new SimpleGrantedAuthority(role);
	        	rolesList.add(sga);
	        }
	        
	        return new UsernamePasswordAuthenticationToken(auth.getPrincipal(), password, rolesList);
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	

}

package com.nareshit.configuration;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
  public SecurityInitializer(){
	  super(WebSecurityConfigurer.class);
  }
}

package com.nareshit.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomeAuthenticationProvider authProvider;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http.antMatcher("/login*").authorizeRequests().anyRequest().authenticated().and()
		.formLogin().defaultSuccessUrl("/getDashBoard");*/
		System.out.println("=====New Configuration==========");
		http.authorizeRequests().antMatchers("/**").permitAll().and().formLogin()
		.loginProcessingUrl("/j_spring_security_check").failureUrl("/j_spring_security_check?error")
		.defaultSuccessUrl("/getDashBoard").usernameParameter("j_username").passwordParameter("j_password").and()
		.logout().deleteCookies("JSESSIONID").logoutSuccessUrl("/getHomePage").and().csrf().disable();
	}
	
	/*@Override
	@Bean
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider).build();
	}*/
	
	@Autowired
	public void registerGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider);
	}
}


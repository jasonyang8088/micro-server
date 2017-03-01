package com.micro;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableAuthorizationServer
@EnableResourceServer
@RestController
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}


	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}
	
	@Autowired
	protected void registerGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.inMemoryAuthentication()
				.withUser("user").password("password").roles("USER").and()
				.withUser("admin").password("password").roles("ADMIN", "USER").and()
				.withUser("manager").password("password").roles("MANAGER","USER").and()
				.withUser("guest").password("password").roles("GUEST");

	}
	
	@Configuration
	@Order(-20)
	protected static class LoginConfig extends WebSecurityConfigurerAdapter {

		@Override
		public void configure(HttpSecurity http) throws Exception {
			http
					.formLogin()
					.loginPage("/login")
						.and()
					.requestMatchers()
						.antMatchers("/login","/signout", "/oauth/authorize", "/oauth/confirm_access")
						.and()
					.logout()
						.logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
						.logoutSuccessUrl("/login")
						.and()
					.authorizeRequests()
						.antMatchers("/login","/login.html").permitAll()
						.anyRequest()
						.authenticated();
		}

	}
}

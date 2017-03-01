package com.micro.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
//		登陆后确认页面的跳转，可以在AuthorizationServerConfigurer	设置.autoApprove(true)自动跳转
//		registry.addViewController("/oauth/confirm_access").setViewName("authorize");
	}
}

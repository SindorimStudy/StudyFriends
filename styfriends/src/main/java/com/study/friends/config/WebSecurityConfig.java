package com.study.friends.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity
		// h2-console 옵션 disable
        .csrf().disable().headers().frameOptions().disable()
        .and().authorizeRequests()
			.antMatchers("/","oauth2/**","login/**","css/**","/images/**","/js/**","console/**","/h2-console/**")
			.permitAll()
		// 인증된 사용자만 접근 가
		.anyRequest().authenticated()
		.and().oauth2Login()
		.and().exceptionHandling()
		// 인증 없이 페이지에 접근할 경우 로그인으로 리다이렉
		.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"))
		.and().logout().logoutSuccessUrl("/");
	}

}

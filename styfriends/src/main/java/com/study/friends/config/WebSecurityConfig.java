package com.study.friends.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private final CustomOAuthUserService customOAuthUserService;

	@Override
    public void configure(WebSecurity webSecurity) throws Exception {
        // static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
        webSecurity.ignoring().antMatchers("/css/**", "/js/**", "/image/**", "/lib/**");
    }
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity
		// h2-console 옵션 disable
        .csrf().disable().headers().frameOptions().disable()
        .and().authorizeRequests()
			.antMatchers("/","/oauth2/**","/signin/**","/login/**","console/**","/h2-console/**")
			.permitAll()
		// 인증된 사용자만 접근 가능
		.anyRequest().authenticated()
		.and().exceptionHandling()
		// 인증 없이 페이지에 접근할 경우 리다이렉트
		.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/signin"))
		.and().logout().logoutSuccessUrl("/")
		.and().oauth2Login().userInfoEndpoint().userService(customOAuthUserService);
	}

}

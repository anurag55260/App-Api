package com.app.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.app.api.filter.JwtRequestFilter;

//@EnableWebSecurity // This enable web security
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	JwtRequestFilter requestJwtFilter;
	@Autowired
	private UserDetailsService userDetailsService;

	// This method is get call when AuthenticationManagerBuilder is build
	@Override // AUTHENTICATION part of application
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// set our configuration on this auth object
		/*
		 * auth.inMemoryAuthentication().withUser("anurag").password("anurag").roles(
		 * "USER").and().withUser("anurag1") .password("anurag").roles("ADMIN");
		 */
		auth.userDetailsService(userDetailsService);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return super.userDetailsService();
	}

	// login/authenticate
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers("/v2/api-docs", "/configuration/**", "/swagger*/**", "/webjars/**", "/authenticate1/**",
						"/authenticate/**", "/register/**")
				.permitAll().anyRequest().authenticated().and().exceptionHandling().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(requestJwtFilter, UsernamePasswordAuthenticationFilter.class);
	}
}

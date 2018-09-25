package com.gateway;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.faircloud.config.JwtConfig;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtConfig jwtConfig;

	@Bean
	public JwtConfig jwtConfig() {
		return new JwtConfig();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				// handle an authorized attempts
			.exceptionHandling()
			.authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED)).and()
			// Add a filter to validate the tokens with every request
			.addFilterAfter(new JwtAuthenticationFilter(jwtConfig), UsernamePasswordAuthenticationFilter.class)
			// authorization requests config
			.authorizeRequests()
			// allow all who are accessing "auth" service
			.antMatchers(HttpMethod.POST, jwtConfig.getUri()).permitAll()
			// must be an admin if trying to access admin area (authentication is also
			// required here)
			//.antMatchers("/gallery" + "/admin/**").hasRole("ADMIN")
			.antMatchers("/banquet/**").hasRole("USER")
			// Any other request must be authenticated
			.anyRequest().authenticated();
	}
}

package com.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableEurekaClient 		// It acts as a eureka client
@EnableZuulProxy		// Enable Zuul
public class GatewayApplication {

//	@Autowired
//	AuthenticationManager authenticationManager;
//	
//	@Bean
//	SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) throws Exception {
//		return http.httpBasic().and()
//				.csrf().disable()
//				.formLogin().disable()
//				.authenticationManager(authenticationManager)
//				.authorizeExchange()
//				.pathMatchers("/**").permitAll()
//				//.pathMatchers("/anything/**").authenticated()
//				//.antMatchers(HttpMethod.POST, jwtConfig.getUri()).permitAll()
//				.anyExchange().permitAll()
//				.and().build();
//		
		
		
		
		//return http
				//.authenticationManager(authenticationManager)
				//.securityContextRepository(securityContextRepository)
				//.authorizeExchange()
				//.pathMatchers(HttpMethod.OPTIONS).permitAll()
				//.pathMatchers("/auth").permitAll()


		
	//}
	
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;
	
	/*@Bean
    InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.builder()
        		.username("admin")
        		.password("{noop}admin")
        		.roles("ADMIN")
            .build();
        return new InMemoryUserDetailsManager(user);
    }*/
	
	@Bean 
	DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder);//aqui se le pasa el encoder
		return provider;						
	}
	
	 @Bean
	 AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
			
			AuthenticationManagerBuilder authBuilder =
					http.getSharedObject(AuthenticationManagerBuilder.class);
			
			return authBuilder
				.authenticationProvider(daoAuthenticationProvider())
				.build();
			
		}
	
	@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http.authorizeHttpRequests(
				(authz) -> authz
						.requestMatchers("/css/**", "/js/**", "/h2-console/**" , "/img/**" , "/fonts/**" 
								, "/home" , "/home/**" , "/" , "/login", "/regform/**" , "/addClient/submit" , "/error" ).permitAll()
						.requestMatchers("/admin/**").hasRole("ADMIN")
						.requestMatchers("/userMenu/**").hasRole("USER")
						.requestMatchers("/loggedUser/**").authenticated()
						.anyRequest().authenticated())
			.formLogin((loginz) -> loginz
					.loginPage("/login")
					.defaultSuccessUrl("/home" , true)
					.permitAll())
			.logout((logoutz) -> logoutz
					.logoutUrl("/logout")
					.logoutSuccessUrl("/home")
					.permitAll())
			.exceptionHandling(exceptionHandling -> exceptionHandling.accessDeniedPage("/error/**"));
    	
    	
		
		// Añadimos esto para poder seguir accediendo a la consola de H2
		// con Spring Security habilitado.
    	http.csrf(csrfz -> csrfz.disable());
    	http.headers(headersz -> headersz
    			.frameOptions(frameOptionsz -> frameOptionsz.disable()));
		
		return http.build();
	}
	
	
	
}

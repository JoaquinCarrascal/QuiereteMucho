package com.salesianostriana.dam.carrascalfrancojoaquinproyectospringt2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
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
		provider.setUserDetailsService(userDetailsService());
		provider.setPasswordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());//aqui se le pasa el encoder
		return provider;																		//en este caso se delega
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
				.requestMatchers("/css/**", "/js/**" , "/img/**" , "/fonts/**").permitAll()
				.anyRequest().authenticated())
			.formLogin((loginz) -> loginz
					.loginPage("/login").permitAll());

		return http.build();
		
	}
	
	
	
}

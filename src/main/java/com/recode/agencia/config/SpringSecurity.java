package com.recode.agencia.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	private final String admin = "ADMIN";
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests((authorize) -> authorize
						.requestMatchers("/").permitAll()
						.requestMatchers("/index").permitAll()
						.requestMatchers("/register/**").permitAll()
						.requestMatchers("*/static/**").permitAll()
						.requestMatchers("/css/**").permitAll()
						.requestMatchers("/js/**").permitAll()
						.requestMatchers("/clientes/**").permitAll()
						.requestMatchers("/image/**").permitAll()
						.requestMatchers("/destinos/**").permitAll()
						.requestMatchers("/promocoes/**").permitAll()
						.requestMatchers("/contato").permitAll()
						.requestMatchers("/pesquisa/**").permitAll()
						.requestMatchers("/detalheDestino").permitAll()
						.requestMatchers("/detalhePromocao").permitAll()
						.requestMatchers("/perfil/**").permitAll()		
						.requestMatchers("/adm").hasRole(admin)
							.requestMatchers("/users").hasRole(admin)
								.requestMatchers("/detalheCliente").hasRole(admin)
								.requestMatchers("/deletarCliente/**").hasRole(admin)
								.requestMatchers("/editarCliente/**").hasRole(admin)
								.requestMatchers("/registeradm/**").hasRole(admin)
								.requestMatchers("/editarCliente/**").hasRole(admin)
							.requestMatchers("/viagens").hasRole(admin)
								.requestMatchers("/cadastroDestino/**").hasRole(admin)
								.requestMatchers("/cadastrarDestino/**").hasRole(admin)
								.requestMatchers("/detalheViagem/**").hasRole(admin)
								.requestMatchers("/editarViagem/**").hasRole(admin)
								.requestMatchers("/deletarViagem/**").hasRole(admin)
							.requestMatchers("/reservas").hasRole(admin)
								.requestMatchers("/detalheReserva/**").hasRole(admin)
								.requestMatchers("/cadastroReserva/**").hasRole(admin)
								.requestMatchers("/deletarReserva/**").hasRole(admin)
						
						)
				.formLogin(form -> form
						.loginPage("/login")
						.loginProcessingUrl("/login")
						.defaultSuccessUrl("/index")
						.permitAll())
				.logout(logout -> logout
						.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
						.permitAll());
		
		return http.build();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
}

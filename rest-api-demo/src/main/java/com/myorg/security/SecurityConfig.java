package com.myorg.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	/*
	 * @Bean InMemoryUserDetailsManager userDetailsManager() {
	 * 
	 * UserDetails john =
	 * User.builder().username("john").password("{noop}john123").roles("EMPLOYEE").
	 * build();
	 * 
	 * UserDetails mary =
	 * User.builder().username("mary").password("{noop}mary123").roles("EMPLOYEE",
	 * "MANAGER") .build();
	 * 
	 * UserDetails raza = User.builder().username("raza").password("{noop}raza123")
	 * .roles("EMPLOYEE", "MANAGER", "ADMIN").build();
	 * 
	 * return new InMemoryUserDetailsManager(john, mary, raza); }
	 */

	@Bean
	UserDetailsManager userDetailsManager(DataSource dataSource) {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

		jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT user_id, pswd, active FROM members WHERE user_id=?");

		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT user_id, roles FROM roles WHERE user_id=?");

		return jdbcUserDetailsManager;
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer -> configurer.requestMatchers(HttpMethod.GET, "/customers/v1/api/list")
				.hasRole("EMPLOYEE").requestMatchers(HttpMethod.GET, "/customers/v1/api/getone/{cid}")
				.hasRole("EMPLOYEE").requestMatchers(HttpMethod.POST, "/customers/v1/api/save").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "/customers/v1/api/update/{cid}").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/customers/v1/api/delete/{cid}").hasRole("ADMIN"));

		http.csrf(csrf -> csrf.disable());
		http.httpBasic(Customizer.withDefaults());
		return http.build();
	}
}

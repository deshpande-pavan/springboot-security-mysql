package com.secureapp.springbootsecurity;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	 * @Bean public AuthenticationProvider authProvider(UserDetailsService
	 * userDetailsService) { DaoAuthenticationProvider daoProvider = new
	 * DaoAuthenticationProvider();
	 * daoProvider.setUserDetailsService(userDetailsService);
	 * daoProvider.setPasswordEncoder(new BCryptPasswordEncoder()); return
	 * daoProvider; }
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests().antMatchers("/login").permitAll()
		.anyRequest().authenticated();
		/*.formLogin()
		.loginPage("/login").permitAll()
		.and()
		.logout().invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/logout-success").permitAll();
*/
		}
}

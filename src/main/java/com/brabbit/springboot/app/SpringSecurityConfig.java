package com.brabbit.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.brabbit.springboot.app.auth.handler.LoginSuccessHandler;

@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private LoginSuccessHandler successHandler;
	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/", "/css/**", "/js/**","/login/**","/img/**",
				      "/registro_duenio/**","/registro/duenio/**",
				      "/registro_chofer/**","/registro/chofer/**",
				      "/registro/usuario/**","/registro_usuario/**",
				      "/registro_vehiculo/**","/registro/vehiculo/**").permitAll()
		.anyRequest().authenticated()
		.and()
        .formLogin()
		   .successHandler(successHandler)
		   .loginPage("/login")
		   .permitAll()
		.and()
		    .logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/error_403");
		
		http.headers().frameOptions().disable();
		http.csrf().disable();

	}

	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception
	{
	

	}
}

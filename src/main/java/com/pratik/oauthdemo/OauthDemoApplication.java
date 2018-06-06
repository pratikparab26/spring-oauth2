package com.pratik.oauthdemo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@SpringBootApplication
public class OauthDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthDemoApplication.class, args);
	}
	
	@Autowired
	public void authenticationManeger(AuthenticationManagerBuilder builder, UserRepositories repo) throws Exception{
		
		if(repo.count()==0){
			repo.save(new User("user","user",Arrays.asList(new Role("USER"))));
			builder.userDetailsService(new  UserDetailsService() {
				
				@Override
				public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
					// TODO Auto-generated method stub
					return new CustomerUserDetails(repo.findByUsername(s));
				}
			});
		}
	}
}

package com.samsung.premasterclassspringsecurity.security;

import com.samsung.premasterclassspringsecurity.domain.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable().authorizeHttpRequests().requestMatchers(HttpMethod.POST, "/user")
                .permitAll().requestMatchers(HttpMethod.GET, "/information/user").hasAuthority(Role.user.name())
                .requestMatchers(HttpMethod.GET, "/information/admin").hasAnyAuthority(Role.admin.name())
                .anyRequest().authenticated().and().httpBasic(Customizer.withDefaults()).build();
    }
}

package com.example.MilkStore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class ConfigSercurity{

    // ham bam
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
        .requestMatchers("/home","/picture/**","/js/**", "/css/**","/app/**","/fonts/**","/register","/saveUser","/search_milk","/list_milk","/sortASC","/sortDESC","/cart_milk","/cart_milk/{id}","/deleteCartList/{id}").permitAll()
        .anyRequest().authenticated())
        .formLogin(login -> login.loginPage("/login").permitAll()
        )
        .logout(logout -> logout.invalidateHttpSession(true).clearAuthentication(true)
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutSuccessUrl("/login?logout").permitAll());

        return httpSecurity.build();
    }
}

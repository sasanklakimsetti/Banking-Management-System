package com.bms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        Customizer<CsrfConfigurer<HttpSecurity>> custCsrf=new Customizer<CsrfConfigurer<HttpSecurity>>() {
//            @Override
//            public void customize(CsrfConfigurer<HttpSecurity> customizer) {
//                customizer.disable();
//            }
//        };

        // shortcut of the above code
        return httpSecurity
                .csrf(customizer->customizer.disable())
                .authorizeHttpRequests(request -> request
//                        .requestMatchers("/admin/create").permitAll()
//                        .requestMatchers("/admin/**").hasRole("ADMIN")
//                        .requestMatchers("/customer/**").hasRole("CUSTOMER")
//                        .requestMatchers("/register", "/login").permitAll()
//                        .anyRequest().authenticated()
                                .anyRequest().permitAll()
                )
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(
                        session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();

        //        httpSecurity.formLogin(Customizer.withDefaults());

    }
}

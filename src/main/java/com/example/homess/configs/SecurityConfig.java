package com.example.homess.configs;

import com.example.homess.authentication.JwtAuthenticationFilter;
import com.example.homess.authentication.LoginAuthenticationFilter;
import com.example.homess.authentication.UsernamePasswordAuthenticationProvider;
import com.example.homess.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider;
    JwtUtil jwtUtil;

    @Autowired
    public SecurityConfig(UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider, JwtUtil jwtUtil) {
        this.usernamePasswordAuthenticationProvider = usernamePasswordAuthenticationProvider;
        this.jwtUtil = jwtUtil;
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception{
        return new ProviderManager(usernamePasswordAuthenticationProvider);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
        http.formLogin((formLogin)->formLogin.disable());
        http.httpBasic((httpBasic)->httpBasic.disable());
        http.csrf((csrf)->csrf.disable());

        http.addFilterAt(new LoginAuthenticationFilter(jwtUtil, authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JwtAuthenticationFilter(jwtUtil),LoginAuthenticationFilter.class);

        http.authorizeHttpRequests(authz -> authz
                .requestMatchers(HttpMethod.POST,"/signup").permitAll()
                .requestMatchers(HttpMethod.POST,"/postwrite").hasAnyAuthority("1","0")
                .requestMatchers(HttpMethod.GET,"/postlist").permitAll()
                .requestMatchers(HttpMethod.GET,"/postview").permitAll()

                .requestMatchers(HttpMethod.GET,"/test").permitAll()
                .requestMatchers(HttpMethod.POST,"/test").hasAnyAuthority("1","0")
                .anyRequest().authenticated());

        return http.build();
    }
}


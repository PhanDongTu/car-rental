package com.project.thuexe.configuration;

import com.project.thuexe.Filter.JwtTokenFilter;
import com.project.thuexe.models.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    private final JwtTokenFilter jwtTokenFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(requests -> {
                    requests
                            .requestMatchers(
                                      "api/v1/users/login"
                                    , "api/v1/users/register"
                                     ,"api/v1/car/**"

                                     )
                                     .permitAll()

                                     .requestMatchers(POST,"/api/v1/car/**").hasAnyRole(Role.CAR_OWNER, Role.ADMIN)

                                     .requestMatchers(GET,"/api/v1/orders/**").hasAnyRole(Role.USER,Role.CAR_OWNER, Role.ADMIN)

                                     .requestMatchers(POST,"/api/v1/orders/**").hasAnyRole(Role.USER, Role.CAR_OWNER,Role.ADMIN)





                                   .anyRequest().authenticated();
                });
        return http.build();
    }
}

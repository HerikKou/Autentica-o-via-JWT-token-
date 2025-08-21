package Autenticacao.Autenticacao.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import Autenticacao.Autenticacao.Service.JwtFilter;
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain FilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                        .authorizeRequests()
                         .requestMatchers("/api/register", "/api/login").permitAll()
                        .anyRequest()
                        .authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                http.addFilterBefore(new JwtFilter(),UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    
}

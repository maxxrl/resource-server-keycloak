package com.maxxrl.resourceserver;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Collections;
import java.util.List;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().configurationSource(request -> setupCorsConfiguration()).and()
                .authorizeRequests()
                .mvcMatchers("/api/secured/**").hasAuthority("SCOPE_default-user-scope")

                .anyRequest().permitAll()
                .and()
                .oauth2ResourceServer()
                .jwt();
    }

    private CorsConfiguration setupCorsConfiguration() {
        List<String> frontendOrigins = Collections.singletonList("http://localhost:4200");
        CorsConfiguration cors = new CorsConfiguration();
        cors.setAllowedOrigins(frontendOrigins);
        cors.setAllowedHeaders(List.of("*"));
        return cors;
    }
}
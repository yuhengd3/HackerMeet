package com.yuheng.hackermeet.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.jwt.JwtValidators;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

// from https://auth0.com/docs/quickstart/backend/java-spring-security5
@EnableWebSecurity
public class SecurityConfig {
    @Value("${auth0.audience}")
    private String audience;

    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String issuer;

    @Bean
    JwtDecoder jwtDecoder() {
        NimbusJwtDecoder jwtDecoder = JwtDecoders.fromOidcIssuerLocation(issuer);

        OAuth2TokenValidator<Jwt> audienceValidator = new AudienceValidator(audience);
        OAuth2TokenValidator<Jwt> withIssuer = JwtValidators.createDefaultWithIssuer(issuer);
        OAuth2TokenValidator<Jwt> withAudience = new DelegatingOAuth2TokenValidator<>(withIssuer, audienceValidator);

        jwtDecoder.setJwtValidator(withAudience);

        return jwtDecoder;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.headers().frameOptions().sameOrigin();

        http.authorizeRequests()
                .mvcMatchers("/", "/h2-console", "/test").permitAll()
                .mvcMatchers("/h2-console/**").permitAll()
                .mvcMatchers("/api").authenticated()
                .mvcMatchers("/api/data").authenticated()
                .anyRequest().authenticated()
//                .mvcMatchers("/api/private-scoped").hasAuthority("SCOPE_read:messages")
                .and().cors()
                .and().oauth2ResourceServer().jwt();

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web ->
                web
                        .ignoring()
                        .antMatchers("/h2-console/**");

    }

    // Deprecated
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web
//            .ignoring()
//            .antMatchers("/h2-console/**");
//    }

//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.headers().frameOptions().disable();
//        http.headers().frameOptions().sameOrigin();
//
//        http.authorizeRequests()
//            .mvcMatchers("/", "/h2-console", "/test").permitAll()
//            .mvcMatchers("/h2-console/**").permitAll()
//            .mvcMatchers("/api").authenticated()
//            .mvcMatchers("/api/data").authenticated()
//            .anyRequest().permitAll()
//            .and().cors()
//            .and().oauth2ResourceServer().jwt();
//    }

}

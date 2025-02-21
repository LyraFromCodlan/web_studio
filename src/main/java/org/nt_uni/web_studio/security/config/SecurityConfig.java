package org.nt_uni.web_studio.security.config;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.nt_uni.web_studio.security.filter.ApiKeyAuthenticationFilter;
import org.nt_uni.web_studio.security.filter.JwtAuthenticationFilter;
import org.nt_uni.web_studio.security.filter.RestHeaderAuthFilter;
import org.nt_uni.web_studio.security.service.AuthUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final AuthUserDetailsService userDetailsService;

    @Bean
    PasswordEncoder passwordEncoder(){
        return SfgPasswordEncoderFactory.createDelegatingPasswordEncoder();
    }


    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(provider);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource())) // ✅ Добавлен CORS
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/login/**","/logout/**").permitAll()
                        .requestMatchers("/order/register","/order/info/code/*","/dropdown/**").hasAnyAuthority("USER")
                        .requestMatchers("/hr/**", "/dropdown/**","/order/**").hasAnyAuthority("MANAGER","ADMIN")
                        .requestMatchers("/**").hasAuthority("ADMIN")
                        .anyRequest().authenticated()  // All other requests require authentication
                )
                .formLogin(
                        form -> form
                        .successHandler(new AuthSuccessHandler())
                        .failureHandler(new AuthFailHandler())
                ) // Enables default login page
                .logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/"))  // Logout configuration
                .addFilterBefore(headerFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new ApiKeyAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
        ;

        return http.build();
    }


    private RestHeaderAuthFilter headerFilter(AuthenticationManager authenticationManager){
        log.info("HeaderFilter Accessed");
        RestHeaderAuthFilter filter = new RestHeaderAuthFilter(new AntPathRequestMatcher("/**"));
        filter.setAuthenticationManager(authenticationManager);
        return filter;
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true);
        config.setAllowedOrigins(List.of("http://localhost:8080", "http://localhost:6060", "http://localhost"));
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("Content-Type", "Authorization"));

        source.registerCorsConfiguration("/**", config);
        return source;
    }
}

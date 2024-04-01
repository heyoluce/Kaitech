package system.crm.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import system.crm.web.security.JwtTokenFilter;
import system.crm.web.security.JwtTokenProvider;

import java.util.List;


@Configuration
@EnableMethodSecurity
@EnableWebSecurity
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
public class ApplicationConfig {

    private final JwtTokenProvider tokenProvider;
    private final ApplicationContext applicationContext;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @SneakyThrows
    public AuthenticationManager authenticationManager(
            final AuthenticationConfiguration configuration
    ) {
        return configuration.getAuthenticationManager();
    }

    @Bean
    @SneakyThrows
    public SecurityFilterChain filterChain(
            final HttpSecurity httpSecurity
    ) {
        httpSecurity
                .cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource()))
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .sessionManagement(sessionManagement ->
                        sessionManagement
                                .sessionCreationPolicy(
                                        SessionCreationPolicy.STATELESS
                                )
                )
                .exceptionHandling(configurer ->
                        configurer.authenticationEntryPoint(
                                        (request, response, exception) -> {
                                            response.setStatus(
                                                    HttpStatus.UNAUTHORIZED
                                                            .value()
                                            );
                                            response.getWriter()
                                                    .write("Unauthorized.");
                                        })
                                .accessDeniedHandler(
                                        (request, response, exception) -> {
                                            response.setStatus(
                                                    HttpStatus.FORBIDDEN
                                                            .value()
                                            );
                                            response.getWriter()
                                                    .write("Unauthorized.");
                                        }))
                .authorizeHttpRequests(configurer ->
                        configurer.requestMatchers("/api/v1/auth/**")
                                .permitAll()
                                .requestMatchers("/swagger-ui/**")
                                .permitAll()
                                .requestMatchers("/v3/api-docs/**")
                                .permitAll()
                                .anyRequest().authenticated())
                .anonymous(AbstractHttpConfigurer::disable)
                .addFilterBefore(new JwtTokenFilter(tokenProvider),
                        UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement()
                        .addList("bearerAuth"))
                .components(
                        new Components()
                                .addSecuritySchemes("bearerAuth",
                                        new SecurityScheme()
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")
                                )
                )
                .info(new Info()
                        .title("Kaitech CRM API")
                        .description("Demo Spring Boot application")
                        .version("1.0")
                );
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(List.of("https://localhost:5173"));
        corsConfiguration.setAllowedMethods(List.of("GET", "POST"));
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedHeaders(List.of("*"));
        corsConfiguration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }
    // CHECK
}
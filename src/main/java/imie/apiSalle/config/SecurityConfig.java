package imie.apiSalle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Désactive la protection CSRF
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/utilisateurs/**", "/api/**", "/formations/**").permitAll()  // Autorise l'accès à ces endpoints
                .anyRequest().authenticated()  // Requiert une authentification pour tout autre endpoint
            )
            .formLogin(form -> form.disable())  // Désactive le formulaire de connexion par défaut
            .httpBasic(basic -> basic.disable());  // Désactive l'authentification basique

        return http.build();
    }
}

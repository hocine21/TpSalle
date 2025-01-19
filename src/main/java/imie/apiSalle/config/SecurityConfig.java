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
            .csrf(csrf -> csrf.disable())  // Désactive CSRF pour permettre les requêtes POST
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/utilisateurs/**", "/api/**").permitAll()  // Autoriser tous les endpoints utilisateurs et API
                .anyRequest().authenticated()  // Protéger tout le reste
            )
            .formLogin(login -> login.disable())  // Désactive la page de login par défaut
            .httpBasic(basic -> basic.disable());  // Désactive l'authentification basique

        return http.build();
    }
}

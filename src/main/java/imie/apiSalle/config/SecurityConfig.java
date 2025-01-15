package imie.apiSalle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeHttpRequests()
            // Autoriser toutes les demandes pour ces routes
            .requestMatchers("/api/utilisateurs/connexion", "/api/utilisateurs/creer", "/api/utilisateurs/deconnexion").permitAll()
            // Restreindre les accès aux rôles spécifiques
            .requestMatchers("/api/promotions/**").hasRole("PROFS")
            .anyRequest().authenticated()
            .and()
            .sessionManagement()
            .maximumSessions(1); // Un utilisateur ne peut avoir qu'une session active

        return http.build();
    }

    // Gère les événements de session, par exemple pour invalider les sessions expirées
    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }
}

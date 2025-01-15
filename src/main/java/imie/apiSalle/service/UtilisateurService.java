package imie.apiSalle.service;

import imie.apiSalle.model.Utilisateur;
import imie.apiSalle.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Utilisateur creerUtilisateur(Utilisateur utilisateur) {
        // Vérification pour éviter les doublons d'email
        if (utilisateurRepository.findByEmail(utilisateur.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Un utilisateur avec cet email existe déjà.");
        }

        // Validation du mot de passe avec regex
        if (!isMotDePasseValide(utilisateur.getMotDePasse())) {
            throw new IllegalArgumentException("Le mot de passe ne respecte pas les critères de sécurité.");
        }

        // Hashage du mot de passe avant sauvegarde
        String motDePasseHashé = hashMotDePasse(utilisateur.getMotDePasse());
        utilisateur.setMotDePasse(motDePasseHashé);

        // Sauvegarde de l'utilisateur dans la base de données
        return utilisateurRepository.save(utilisateur);
    }

    // Méthode d'authentification
    public boolean authentifierUtilisateur(String email, String motDePasse) {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé"));

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(motDePasse, utilisateur.getMotDePasse());
    }

    // Méthode de validation du mot de passe avec une regex
    private boolean isMotDePasseValide(String motDePasse) {
        // Exemple de regex pour un mot de passe :
        // Au moins 8 caractères, une majuscule, une minuscule, un chiffre, et un caractère spécial
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return motDePasse.matches(regex);
    }

    // Méthode de hashage du mot de passe avec BCrypt
    private String hashMotDePasse(String motDePasse) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(motDePasse);
    }
}

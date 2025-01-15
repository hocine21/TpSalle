package imie.apiSalle.controller;

import imie.apiSalle.model.Utilisateur;
import imie.apiSalle.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession; // Correct import pour Jakarta EE

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    // Méthode pour créer un utilisateur
    @PostMapping("/creer")
    public ResponseEntity<Utilisateur> creerUtilisateur(@RequestBody Utilisateur utilisateur) {
        Utilisateur utilisateurCree = utilisateurService.creerUtilisateur(utilisateur);
        return ResponseEntity.status(HttpStatus.CREATED).body(utilisateurCree);
    }

    // Méthode pour se connecter et créer une session
    @PostMapping("/connexion")
    public ResponseEntity<String> connexionUtilisateur(@RequestBody Utilisateur utilisateur, HttpSession session) {
        try {
            boolean estAuthentifie = utilisateurService.authentifierUtilisateur(utilisateur.getEmail(), utilisateur.getMotDePasse());
            if (estAuthentifie) {
                // Ajouter l'utilisateur à la session
                session.setAttribute("utilisateur", utilisateur);
                return ResponseEntity.status(HttpStatus.OK).body("Connexion réussie");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Identifiants incorrects");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erreur lors de la connexion");
        }
    }

    // Méthode pour se déconnecter et invalider la session
    @PostMapping("/deconnexion")
    public ResponseEntity<String> deconnexionUtilisateur(HttpSession session) {
        try {
            // Invalider la session pour déconnecter l'utilisateur
            session.invalidate();
            return ResponseEntity.status(HttpStatus.OK).body("Déconnexion réussie");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erreur lors de la déconnexion");
        }
    }
}

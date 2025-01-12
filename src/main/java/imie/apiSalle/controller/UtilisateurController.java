package imie.apiSalle.controller;

import imie.apiSalle.model.Utilisateur;
import imie.apiSalle.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/creer")
    public ResponseEntity<Utilisateur> creerUtilisateur(@RequestBody Utilisateur utilisateur) {
        Utilisateur utilisateurCree = utilisateurService.creerUtilisateur(utilisateur);
        return ResponseEntity.status(HttpStatus.CREATED).body(utilisateurCree);
    }
}

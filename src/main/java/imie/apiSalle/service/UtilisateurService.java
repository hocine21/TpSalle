package imie.apiSalle.service;

import imie.apiSalle.model.Utilisateur;
import imie.apiSalle.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Utilisateur creerUtilisateur(Utilisateur utilisateur) {
        if (utilisateurRepository.findByEmail(utilisateur.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Un utilisateur avec cet email existe déjà.");
        }

        if (!isMotDePasseValide(utilisateur.getMotDePasse())) {
            throw new IllegalArgumentException("Le mot de passe ne respecte pas les critères de sécurité.");
        }

        String motDePasseHashé = hashMotDePasse(utilisateur.getMotDePasse());
        utilisateur.setMotDePasse(motDePasseHashé);

        return utilisateurRepository.save(utilisateur);
    }

    public boolean authentifierUtilisateur(String email, String motDePasse) {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé"));

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(motDePasse, utilisateur.getMotDePasse());
    }

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur getUtilisateurById(Integer id) {
        return utilisateurRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé"));
    }

    public Utilisateur updateUtilisateur(Integer id, Utilisateur utilisateurDetails) {
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé"));

        utilisateur.setNom(utilisateurDetails.getNom());
        utilisateur.setPrenom(utilisateurDetails.getPrenom());
        utilisateur.setEmail(utilisateurDetails.getEmail());
        if (!utilisateurDetails.getMotDePasse().isEmpty()) {
            utilisateur.setMotDePasse(hashMotDePasse(utilisateurDetails.getMotDePasse()));
        }
        utilisateur.setRole(utilisateurDetails.getRole());
        utilisateur.setRemarque(utilisateurDetails.getRemarque());

        return utilisateurRepository.save(utilisateur);
    }

    public void deleteUtilisateur(Integer id) {
        if (!utilisateurRepository.existsById(id)) {
            throw new IllegalArgumentException("Utilisateur non trouvé");
        }
        utilisateurRepository.deleteById(id);
    }

    private boolean isMotDePasseValide(String motDePasse) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return motDePasse.matches(regex);
    }

    private String hashMotDePasse(String motDePasse) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(motDePasse);
    }
}

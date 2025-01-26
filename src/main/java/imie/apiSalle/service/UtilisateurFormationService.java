package imie.apiSalle.service;

import imie.apiSalle.model.UtilisateurFormation;
import imie.apiSalle.model.UtilisateurFormationId;
import imie.apiSalle.repository.UtilisateurFormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurFormationService {

    @Autowired
    private UtilisateurFormationRepository repository;

    public List<UtilisateurFormation> findAll() {
        return repository.findAll();
    }

    public Optional<UtilisateurFormation> findById(UtilisateurFormationId id) {
        return repository.findById(id);
    }

    public UtilisateurFormation save(UtilisateurFormation utilisateurFormation) {
        return repository.save(utilisateurFormation);
    }

    public void deleteById(UtilisateurFormationId id) {
        repository.deleteById(id);
    }
}

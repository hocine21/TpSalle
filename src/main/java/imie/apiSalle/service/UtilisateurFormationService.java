package imie.apiSalle.service;

import imie.apiSalle.model.UtilisateurFormation;
import imie.apiSalle.model.UtilisateurFormationId;
import imie.apiSalle.repository.UtilisateurFormationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurFormationService {

    private final UtilisateurFormationRepository repository;

    public UtilisateurFormationService(UtilisateurFormationRepository repository) {
        this.repository = repository;
    }

    public List<UtilisateurFormation> getRecurrentFormations() {
        return repository.findByRecurrance(true);
    }

    public UtilisateurFormation saveFormation(UtilisateurFormation formation) {
        return repository.save(formation);
    }

    public void deleteFormation(UtilisateurFormationId id) {
        repository.deleteById(id);
    }
}

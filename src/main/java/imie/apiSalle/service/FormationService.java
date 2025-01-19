package imie.apiSalle.service;

import imie.apiSalle.exception.ResourceNotFoundException;
import imie.apiSalle.model.Formation;
import imie.apiSalle.repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormationService {

    @Autowired
    private FormationRepository formationRepository;

    public List<Formation> getAllFormations() {
        return formationRepository.findAll();
    }

    public Optional<Formation> getFormationById(Integer id) {
        return formationRepository.findById(id);
    }

    public Formation createFormation(Formation formation) {
        return formationRepository.save(formation);
    }

    public Formation updateFormation(Integer id, Formation formationDetails) {
        Formation formation = formationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Formation not found for this id :: " + id));

        formation.setNomFormation(formationDetails.getNomFormation());
        // Mettez à jour d'autres propriétés si nécessaire

        return formationRepository.save(formation);
    }

    public void deleteFormation(Integer id) {
        Formation formation = formationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Formation not found for this id :: " + id));

        formationRepository.delete(formation);
    }
}

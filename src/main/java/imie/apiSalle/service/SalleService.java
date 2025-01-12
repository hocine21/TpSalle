package imie.apiSalle.service;
import imie.apiSalle.exception.ResourceNotFoundException;
import imie.apiSalle.model.Salle;
import imie.apiSalle.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalleService {

    @Autowired
    private SalleRepository salleRepository;

    public List<Salle> getAllSalles() {
        return salleRepository.findAll();
    }

    public Optional<Salle> getSalleById(Integer id) {
        return salleRepository.findById(id);
    }

    public Salle createSalle(Salle salle) {
        return salleRepository.save(salle);
    }

    public Salle updateSalle(Integer id, Salle salleDetails) {
        Salle salle = salleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Salle not found for this id :: " + id));

        salle.setNomSalle(salleDetails.getNomSalle());
        salle.setNmbrPlace(salleDetails.getNmbrPlace());
        salle.setDisponibilite(salleDetails.getDisponibilite());
        salle.setTypeSalle(salleDetails.getTypeSalle());

        return salleRepository.save(salle);
    }

    public void deleteSalle(Integer id) {
        Salle salle = salleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Salle not found for this id :: " + id));

        salleRepository.delete(salle);
    }
}

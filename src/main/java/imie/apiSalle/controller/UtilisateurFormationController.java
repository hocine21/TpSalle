package imie.apiSalle.controller;

import imie.apiSalle.model.UtilisateurFormation;
import imie.apiSalle.model.UtilisateurFormationId;
import imie.apiSalle.service.UtilisateurFormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/utilisateurFormation")
public class UtilisateurFormationController {

    @Autowired
    private UtilisateurFormationService service;

    @GetMapping
    public List<UtilisateurFormation> getAll() {
        return service.findAll();
    }

    @GetMapping("/{numSalle}/{idPromotion}/{idFormation}")
    public ResponseEntity<UtilisateurFormation> getById(
            @PathVariable Integer numSalle,
            @PathVariable Integer idPromotion,
            @PathVariable Integer idFormation) {
        
        UtilisateurFormationId id = new UtilisateurFormationId(numSalle, idPromotion, idFormation);
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UtilisateurFormation create(@RequestBody UtilisateurFormation utilisateurFormation) {
        return service.save(utilisateurFormation);
    }

    @DeleteMapping("/{numSalle}/{idPromotion}/{idFormation}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer numSalle,
            @PathVariable Integer idPromotion,
            @PathVariable Integer idFormation) {
        
        UtilisateurFormationId id = new UtilisateurFormationId(numSalle, idPromotion, idFormation);
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

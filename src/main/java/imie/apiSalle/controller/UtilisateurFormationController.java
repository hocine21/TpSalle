package imie.apiSalle.controller;

import imie.apiSalle.model.UtilisateurFormation;
import imie.apiSalle.model.UtilisateurFormationId;
import imie.apiSalle.service.UtilisateurFormationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formations")
public class UtilisateurFormationController {

    private final UtilisateurFormationService service;

    public UtilisateurFormationController(UtilisateurFormationService service) {
        this.service = service;
    }

    @GetMapping("/recurrence")
    public ResponseEntity<List<UtilisateurFormation>> getRecurringFormations() {
        return ResponseEntity.ok(service.getRecurrentFormations());
    }

    @PostMapping
    public ResponseEntity<UtilisateurFormation> createFormation(@RequestBody UtilisateurFormation formation) {
        return ResponseEntity.ok(service.saveFormation(formation));
    }

    @DeleteMapping("/{numSalle}/{idPromotion}/{idFormation}")
    public ResponseEntity<Void> deleteFormation(@PathVariable Integer numSalle,
                                                @PathVariable Integer idPromotion,
                                                @PathVariable Integer idFormation) {
        UtilisateurFormationId id = new UtilisateurFormationId(numSalle, idPromotion, idFormation);
        service.deleteFormation(id);
        return ResponseEntity.noContent().build();
    }
}

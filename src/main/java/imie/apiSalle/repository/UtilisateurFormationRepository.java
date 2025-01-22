package imie.apiSalle.repository;

import imie.apiSalle.model.UtilisateurFormation;
import imie.apiSalle.model.UtilisateurFormationId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtilisateurFormationRepository extends JpaRepository<UtilisateurFormation, UtilisateurFormationId> {
    List<UtilisateurFormation> findByRecurrance(Boolean recurrance);
}

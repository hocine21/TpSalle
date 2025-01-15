package imie.apiSalle.service;

import imie.apiSalle.model.Promotion;
import imie.apiSalle.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }

    public Optional<Promotion> getPromotionById(Integer id) {
        return promotionRepository.findById(id);
    }

    public Promotion createPromotion(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    public Promotion updatePromotion(Integer id, Promotion promotionDetails) {
        Promotion promotion = promotionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Promotion non trouvée avec ID : " + id));

        promotion.setNomPromotion(promotionDetails.getNomPromotion());
        promotion.setNmbrEtudiant(promotionDetails.getNmbrEtudiant());
        promotion.setAnneeScolaire(promotionDetails.getAnneeScolaire());

        return promotionRepository.save(promotion);
    }

    public void deletePromotion(Integer id) {
        promotionRepository.deleteById(id);
    }
}

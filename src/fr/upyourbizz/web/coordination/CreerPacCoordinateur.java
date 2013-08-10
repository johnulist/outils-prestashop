package fr.upyourbizz.web.coordination;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.upyourbizz.utils.exception.TechnicalException;
import fr.upyourbizz.web.dto.ProduitReferenceDto;
import fr.upyourbizz.web.service.GestionProduitService;

@Component
public class CreerPacCoordinateur {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(CreerPacCoordinateur.class);

    @Autowired
    private GestionProduitService gestionProduitService;

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    public List<ProduitReferenceDto> recupererListeProduitsComplete(
            List<Integer> listeIdProduitsReferences) throws TechnicalException {
        List<ProduitReferenceDto> resultat = new ArrayList<ProduitReferenceDto>();
        for (int idProduitRef : listeIdProduitsReferences) {
            resultat.add(gestionProduitService.recupererProduitReference(idProduitRef));
        }
        return resultat;
    }

    // ===== Accesseurs =======================================================

    // ===== Classes imbriquées ===============================================
}

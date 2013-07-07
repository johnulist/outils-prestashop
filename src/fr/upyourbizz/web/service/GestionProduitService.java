package fr.upyourbizz.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.upyourbizz.web.persistence.ProduitReferenceDao;

public class GestionProduitService {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(GestionProduitService.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================
    private ProduitReferenceDao produitReferenceDao;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    // TODO Corps de classe auto-généré

    // ===== Accesseurs =======================================================

    /**
     * Affecte produitReferenceDao
     * 
     * @param produitReferenceDao produitReferenceDao à affecter
     */
    public void setProduitReferenceDao(ProduitReferenceDao produitReferenceDao) {
        this.produitReferenceDao = produitReferenceDao;
    }

    // ===== Classes imbriquées ===============================================
}

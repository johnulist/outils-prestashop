package fr.upyourbizz.web.presentation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.upyourbizz.utils.exception.TechnicalException;
import fr.upyourbizz.web.persistence.ProduitReferenceDao;

public class testControleur {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(testControleur.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================
    ProduitReferenceDao produitReferenceDao;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    public void init() {
        logger.debug("Ca marche");
        try {
            produitReferenceDao.recupererProduitReference(1);
        }
        catch (TechnicalException e) {
            e.printStackTrace();
        }
    }

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

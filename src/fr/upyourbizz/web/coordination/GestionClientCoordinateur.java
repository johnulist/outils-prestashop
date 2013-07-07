package fr.upyourbizz.web.coordination;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.upyourbizz.web.service.GestionClientService;

public class GestionClientCoordinateur {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(GestionClientCoordinateur.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private GestionClientService gestionClientService;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    // TODO Corps de classe auto-généré

    // ===== Accesseurs =======================================================

    /**
     * Affecte gestionClientService
     * 
     * @param gestionClientService gestionClientService à affecter
     */
    public void setGestionClientService(GestionClientService gestionClientService) {
        this.gestionClientService = gestionClientService;
    }

    // ===== Classes imbriquées ===============================================
}

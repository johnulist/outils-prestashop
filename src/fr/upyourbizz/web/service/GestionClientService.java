/**
 * © 2013, Upyourbizz - All right reserved
 */
package fr.upyourbizz.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.upyourbizz.web.persistence.ClientDao;

/**
 * GestionClientService
 */
public class GestionClientService {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(GestionClientService.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private ClientDao clientDao;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    // TODO Corps de classe auto-généré

    // ===== Accesseurs =======================================================

    /**
     * Affecte clientDao
     * 
     * @param clientDao clientDao à affecter
     */
    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    // ===== Classes imbriquées ===============================================
}

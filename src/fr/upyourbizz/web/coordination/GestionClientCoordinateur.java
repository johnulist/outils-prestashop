package fr.upyourbizz.web.coordination;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.upyourbizz.utils.exception.TechnicalException;
import fr.upyourbizz.web.dto.ClientDto;
import fr.upyourbizz.web.service.GestionClientService;

@Component
public class GestionClientCoordinateur {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(GestionClientCoordinateur.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    @Autowired
    private GestionClientService gestionClientService;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    /**
     * Liste tous les clients de l'application
     * 
     * @return La liste des clients
     * @throws TechnicalException Exception technique
     */
    public List<ClientDto> listerClients() throws TechnicalException {
        return gestionClientService.listerClients();
    }

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

package fr.upyourbizz.web.coordination;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.upyourbizz.utils.exception.TechnicalException;
import fr.upyourbizz.web.dto.ClientDto;
import fr.upyourbizz.web.service.GestionClientService;

@Component
public class AjoutClientCoordinateur {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(AjoutClientCoordinateur.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================
    @Autowired
    private GestionClientService gestionClientService;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    /**
     * Ajout un client
     * 
     * @param nouveauClient Le client a ajouter
     * @throws TechnicalException Exception technique
     */
    public void ajouterClient(ClientDto nouveauClient) throws TechnicalException {
        gestionClientService.ajouterClient(nouveauClient);
    }

    /**
     * Modifie un client existant
     * 
     * @param nouveauClient
     * @throws TechnicalException Exception technique
     */
    public void modifierClient(ClientDto nouveauClient) throws TechnicalException {
        gestionClientService.modifierClient(nouveauClient);
    }

    // ===== Accesseurs =======================================================

    // ===== Classes imbriquées ===============================================
}

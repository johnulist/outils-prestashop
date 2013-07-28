package fr.upyourbizz.web.presentation.model;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import fr.upyourbizz.web.dto.ClientDto;

@Component
public class RechercheClientsModel {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(RechercheClientsModel.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private List<ClientDto> listeClients = new ArrayList<ClientDto>();

    private List<ClientDto> listeClientsFiltree;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    /**
     * Réinitialisation du modele
     */
    public void reinitialiser() {
        listeClients = new ArrayList<ClientDto>();

        listeClientsFiltree = new ArrayList<ClientDto>();

    }

    // ===== Accesseurs =======================================================

    /**
     * Retourne listeClients
     * 
     * @return listeClients
     */
    public List<ClientDto> getListeClients() {
        return listeClients;
    }

    /**
     * Affecte listeClients
     * 
     * @param listeClients listeClients à affecter
     */
    public void setListeClients(List<ClientDto> listeClients) {
        this.listeClients = listeClients;
    }

    /**
     * Retourne listeClientsFiltree
     * 
     * @return listeClientsFiltree
     */
    public List<ClientDto> getListeClientsFiltree() {
        return listeClientsFiltree;
    }

    /**
     * Affecte listeClientsFiltree
     * 
     * @param listeClientsFiltree listeClientsFiltree à affecter
     */
    public void setListeClientsFiltree(List<ClientDto> listeClientsFiltree) {
        this.listeClientsFiltree = listeClientsFiltree;
    }

    // ===== Classes imbriquées ===============================================

}

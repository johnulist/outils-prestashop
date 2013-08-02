/**
 * © 2013, Upyourbizz - All right reserved
 */
package fr.upyourbizz.web.presentation.controller;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.upyourbizz.utils.exception.TechnicalException;
import fr.upyourbizz.web.ListeEcrans;
import fr.upyourbizz.web.ListeParamsContexte;
import fr.upyourbizz.web.coordination.GestionClientCoordinateur;
import fr.upyourbizz.web.dto.ClientDto;
import fr.upyourbizz.web.presentation.model.ContexteModel;
import fr.upyourbizz.web.presentation.model.GestionClientsModel;
import fr.upyourbizz.web.presentation.model.RechercheClientsModel;

/**
 * GestionClientController
 */
@Component
public class GestionClientsController extends AbstractController {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(GestionClientsController.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    @Autowired
    private RechercheClientsModel rechercheClientsModel;

    @Autowired
    private GestionClientsModel gestionClientsModel;

    @Autowired
    private GestionClientCoordinateur gestionClientCoordinateur;

    @Autowired
    private ContexteModel contexte;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    public void init() {
        if (!FacesContext.getCurrentInstance().isPostback()) {
            FacesContext fc = FacesContext.getCurrentInstance();
            Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
            String income = params.get("income");
            rechercheClientsModel.reinitialiser();
            try {
                List<ClientDto> listeClients = gestionClientCoordinateur.listerClients();
                rechercheClientsModel.getListeClients().addAll(listeClients);
                rechercheClientsModel.getListeClientsFiltree().addAll(listeClients);
            }
            catch (TechnicalException e) {
                e.printStackTrace();
                redirectionVersPageErreurTechnique(e.getMessage(),
                        e.getCause().getCause().getMessage());
            }
        }
    }

    /**
     * L'utilisateur vient de sélectionner un client dans le processus de
     * création d'un PAC
     * 
     * @param clientDto Le client sélectionné
     * @return La règle de navigation conduisant à la liste des produits.
     */
    public String creationPacClientSelectionne() {
        contexte.ajouterParam(ListeParamsContexte.ID_CLIENT.getNom(),
                gestionClientsModel.getClientSelectionne().getIdClient());
        return ListeEcrans.LISTE_PRODUITS.getNom();
    }

    public String retour() {
        return gestionClientsModel.getIncome();
    }

    // ===== Accesseurs =======================================================

    // ===== Classes imbriquées ===============================================
}

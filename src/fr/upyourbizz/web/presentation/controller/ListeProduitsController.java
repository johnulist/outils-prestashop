package fr.upyourbizz.web.presentation.controller;

import java.util.List;

import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.upyourbizz.utils.exception.TechnicalException;
import fr.upyourbizz.web.coordination.ListeProduitsCoordinateur;
import fr.upyourbizz.web.presentation.model.ListeProduitsModel;

public class ListeProduitsController {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(ListeProduitsController.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private ListeProduitsModel listeProduitsModel;

    private ListeProduitsCoordinateur listeProduitsCoordinateur;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    public void init() {
        if (!FacesContext.getCurrentInstance().isPostback()) {
            try {
                listeProduitsModel.getFamille().clear();
                List<String> famille = listeProduitsCoordinateur.listerFamille();
            }
            catch (TechnicalException e) {
                e.printStackTrace();
                // TODO Rediriger vers écran erreur technique
            }
        }
        listeProduitsModel.getFamille().clear();
        listeProduitsModel.getFamille().add(
                listeProduitsModel.new Famille("E-Marketing", "EMARKETING.jpg"));
        listeProduitsModel.getFamille().add(
                listeProduitsModel.new Famille("Graphisme", "GRAPHISME.jpg"));
        listeProduitsModel.getFamille().add(
                listeProduitsModel.new Famille("Marqueting", "MARKETING.jpg"));
        listeProduitsModel.getFamille().add(
                listeProduitsModel.new Famille("Sites-internet", "SITES-INTERNET.jpg"));
    }

    // ===== Accesseurs =======================================================

    /**
     * Affecte listeProduitsModel
     * 
     * @param listeProduitsModel listeProduitsModel à affecter
     */
    public void setListeProduitsModel(ListeProduitsModel listeProduitsModel) {
        this.listeProduitsModel = listeProduitsModel;
    }

    // ===== Classes imbriquées ===============================================
}

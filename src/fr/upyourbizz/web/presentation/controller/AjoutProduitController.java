/**
 * © 2013, Upyourbizz - All right reserved
 */
package fr.upyourbizz.web.presentation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.upyourbizz.web.presentation.model.AjoutProduitModel;
import fr.upyourbizz.web.presentation.model.AjoutProduitModel.PrixDegressif;

/**
 * AjoutProduitController
 */
public class AjoutProduitController {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(AjoutProduitController.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private AjoutProduitModel ajoutProduitModel;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    public void init() {
        if (!FacesContext.getCurrentInstance().isPostback()) {
            PrixDegressif prixDeg1 = ajoutProduitModel.new PrixDegressif(0, 1000, 10F);
            PrixDegressif prixDeg2 = ajoutProduitModel.new PrixDegressif(1001, 2000, 8F);
            List<PrixDegressif> listePrixDegressif = new ArrayList<PrixDegressif>();
            listePrixDegressif.add(prixDeg1);
            listePrixDegressif.add(prixDeg2);
            ajoutProduitModel.setListePrixDegressifProduit(listePrixDegressif);
        }
    }

    public void ajoutPrixDegressif() {
        PrixDegressif nouveauPrix = ajoutProduitModel.new PrixDegressif(
                ajoutProduitModel.getBorneInferieure(), ajoutProduitModel.getBorneSuperieure(),
                ajoutProduitModel.getCoutUnitaire());
        ajoutProduitModel.getListePrixDegressifProduit().add(nouveauPrix);
        ajoutProduitModel.setBorneInferieure(0);
        ajoutProduitModel.setBorneSuperieure(0);
        ajoutProduitModel.setCoutUnitaire(0F);
    }

    /**
     * Suppression d'un élément du tableau des prix dégressifs de l'onglet prix
     * 
     * @param prixDegressifSelectionne prix sélectionné dans le tableau
     * @param event Evenement JSF reçu
     */
    public void suppressionPrixDegressif(PrixDegressif prixDegressifSelectionne) {
        ajoutProduitModel.getListePrixDegressifProduit().remove(prixDegressifSelectionne);
    }

    // ===== Accesseurs =======================================================

    /**
     * Affecte ajoutProduitModel
     * 
     * @param ajoutProduitModel ajoutProduitModel à affecter
     */
    public void setAjoutProduitModel(AjoutProduitModel ajoutProduitModel) {
        this.ajoutProduitModel = ajoutProduitModel;
    }

    // ===== Classes imbriquées ===============================================
}

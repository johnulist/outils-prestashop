package fr.upyourbizz.web.presentation.controller;

import java.util.List;

import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.upyourbizz.utils.exception.TechnicalException;
import fr.upyourbizz.web.coordination.ListeProduitsCoordinateur;
import fr.upyourbizz.web.dto.ProduitFamilleDto;
import fr.upyourbizz.web.dto.ProduitReferenceDto;
import fr.upyourbizz.web.dto.ProduitSousFamilleDto;
import fr.upyourbizz.web.presentation.model.ListeProduitsModel;
import fr.upyourbizz.web.presentation.model.ListeProduitsModel.Famille;

public class ListeProduitsController {

    // ===== Attributs statiques ==============================================

    private final Logger logger = LoggerFactory.getLogger(ListeProduitsController.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private ListeProduitsModel listeProduitsModel;

    private ListeProduitsCoordinateur listeProduitsCoordinateur;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    public void init() {
        if (!FacesContext.getCurrentInstance().isPostback()) {
            listeProduitsModel.setAfficherSousFamille(false);
            listeProduitsModel.setAfficherProduits(false);
            try {
                listeProduitsModel.getFamille().clear();
                List<ProduitFamilleDto> famille = listeProduitsCoordinateur.listerFamille();
                for (ProduitFamilleDto produitFamilleDto : famille) {
                    listeProduitsModel.getFamille().add(
                            listeProduitsModel.new Famille(produitFamilleDto.getNomFamille(),
                                    produitFamilleDto.getUrlImage()));
                }
            }
            catch (TechnicalException e) {
                e.printStackTrace();
                // TODO Rediriger vers écran erreur technique
            }
        }
    }

    /**
     * Fonction appellée lors de la sélection d'une famille. Affiche ces sous
     * famille
     * 
     * @param familleSelectionnee La famille que l'utilisateur a sélectionné
     */
    public void selectionFamille(Famille familleSelectionnee) {
        logger.debug("Nouvelle famille sélectionnes:" + familleSelectionnee.getNomFamille());
        try {
            listeProduitsModel.getSousFamille().clear();
            List<ProduitSousFamilleDto> sousFamille = listeProduitsCoordinateur.listerSousFamille(familleSelectionnee.getNomFamille());
            for (ProduitSousFamilleDto produitSousFamilleDto : sousFamille) {
                listeProduitsModel.getSousFamille().add(
                        listeProduitsModel.new Famille(produitSousFamilleDto.getNomFamille(),
                                produitSousFamilleDto.getUrlImage()));
            }
        }
        catch (TechnicalException e) {
            e.printStackTrace();
            // TODO Rediriger vers écran erreur technique
        }
        listeProduitsModel.setAfficherSousFamille(true);
    }

    /**
     * Fonction appellée lors de la sélection d'une sous famille. Affiche ces
     * produits
     * 
     * @param sousFamilleSelectionnee La famille que l'utilisateur a sélectionné
     */
    public void selectionSousFamille(Famille sousFamilleSelectionnee) {
        logger.debug("Nouvelle sous famille selectionnes:"
                + sousFamilleSelectionnee.getNomFamille());
        try {
            List<ProduitReferenceDto> listeProduit = listeProduitsCoordinateur.listerProduitsReference(sousFamilleSelectionnee.getNomFamille());
            listeProduitsModel.getProduits().clear();
            for (ProduitReferenceDto produitReferenceDto : listeProduit) {
                listeProduitsModel.getProduits().add(
                        listeProduitsModel.new Produit(produitReferenceDto.getIdProduit(),
                                produitReferenceDto.getNom(), produitReferenceDto.getReference(),
                                produitReferenceDto.getUrlImgIconeProduit()));
            }
            if (listeProduitsModel.getProduits().size() > 0) {
                listeProduitsModel.setAfficherProduits(true);
            }
            else {
                listeProduitsModel.setAfficherProduits(false);
            }
        }
        catch (TechnicalException e) {
            e.printStackTrace();
            // TODO Rediriger vers écran erreur technique
        }
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

    /**
     * Affecte listeProduitsCoordinateur
     * 
     * @param listeProduitsCoordinateur listeProduitsCoordinateur à affecter
     */
    public void setListeProduitsCoordinateur(ListeProduitsCoordinateur listeProduitsCoordinateur) {
        this.listeProduitsCoordinateur = listeProduitsCoordinateur;
    }

    // ===== Classes imbriquées ===============================================
}

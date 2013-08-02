package fr.upyourbizz.web.presentation.controller;

import java.util.List;

import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.upyourbizz.utils.exception.TechnicalException;
import fr.upyourbizz.web.ListeEcrans;
import fr.upyourbizz.web.ListeParamsContexte;
import fr.upyourbizz.web.coordination.ListeProduitsCoordinateur;
import fr.upyourbizz.web.dto.ProduitFamilleDto;
import fr.upyourbizz.web.dto.ProduitReferenceDto;
import fr.upyourbizz.web.dto.ProduitSousFamilleDto;
import fr.upyourbizz.web.presentation.model.ContexteModel;
import fr.upyourbizz.web.presentation.model.ListeProduitsModel;
import fr.upyourbizz.web.presentation.model.ListeProduitsModel.Famille;
import fr.upyourbizz.web.presentation.model.ListeProduitsModel.Produit;

@Component
public class ListeProduitsController extends AbstractController {

    // ===== Attributs statiques ==============================================

    private final Logger logger = LoggerFactory.getLogger(ListeProduitsController.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================
    @Autowired
    private ListeProduitsModel listeProduitsModel;

    @Autowired
    private ContexteModel contexte;

    @Autowired
    private ListeProduitsCoordinateur listeProduitsCoordinateur;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    public void init() {
        if (!FacesContext.getCurrentInstance().isPostback()) {
            listeProduitsModel.setAfficherSousFamille(false);
            listeProduitsModel.setAfficherProduits(false);
            lectureParamsContexte();
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

    private void lectureParamsContexte() {
        // TODO Fonctionnement a revoir
        // Harmoniser la navigation
        if (contexte.getParams().containsKey(ListeParamsContexte.ID_CLIENT.getNom())) {
            listeProduitsModel.setContextePage("pac");
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
                String descriptionCourte = produitReferenceDto.getDescriptionCourte();
                if (descriptionCourte.length() > 40) {
                    descriptionCourte = descriptionCourte.substring(0, 36);
                }
                listeProduitsModel.getProduits().add(
                        listeProduitsModel.new Produit(produitReferenceDto.getIdProduit(),
                                produitReferenceDto.getNom(), produitReferenceDto.getReference(),
                                produitReferenceDto.getUrlImgIconeProduit(), descriptionCourte));
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

    public String modifierProduit(Produit produit) {
        contexte.setIncome(ListeEcrans.LISTE_PRODUITS.getNom());
        contexte.ajouterParam("idProduit", produit.getIdProduitReference());
        return ListeEcrans.AJOUT_PRODUITS.getNom();
    }

    /**
     * L'utilisateur vient de sélectionner un client dans le processus de
     * création d'un PAC
     * 
     * @param clientDto Le client sélectionné
     * @return La règle de navigation conduisant à la liste des produits.
     */
    public String creationPacProduitSelectionne() {
        contexte.ajouterParam(ListeParamsContexte.ID_PRODUIT.getNom(),
                listeProduitsModel.getProduitSelectionne().getIdProduitReference());
        return ListeEcrans.CREER_PAC.getNom();
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

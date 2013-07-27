/**
 * © 2013, Upyourbizz - All right reserved
 */
package fr.upyourbizz.web.presentation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;

import org.primefaces.event.TabChangeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.upyourbizz.utils.adaptateur.AjoutProduitAdaptateur;
import fr.upyourbizz.utils.exception.TechnicalException;
import fr.upyourbizz.web.coordination.AjoutProduitCoordinateur;
import fr.upyourbizz.web.dto.Option;
import fr.upyourbizz.web.dto.PrixDegressif;
import fr.upyourbizz.web.dto.ProduitFamilleDto;
import fr.upyourbizz.web.dto.ProduitReferenceDto;
import fr.upyourbizz.web.dto.ProduitSousFamilleDto;
import fr.upyourbizz.web.presentation.model.AjoutProduitModel;

/**
 * AjoutProduitController
 */
@Component
@Scope("request")
public class AjoutProduitController extends AbstractController {

    // ===== Attributs statiques ==============================================

    private final Logger logger = LoggerFactory.getLogger(AjoutProduitController.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    @Autowired
    private AjoutProduitModel ajoutProduitModel;

    @Autowired
    private AjoutProduitCoordinateur ajoutProduitCoordinateur;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    public void init() {

        if (!FacesContext.getCurrentInstance().isPostback()) {
            ajoutProduitModel.reinitialiser();
            try {
                List<ProduitFamilleDto> listeFamille = ajoutProduitCoordinateur.listerFamille();
                ajoutProduitModel.getListeFamilles().add(new SelectItem(""));
                for (ProduitFamilleDto famille : listeFamille) {
                    ajoutProduitModel.getListeFamilles().add(
                            new SelectItem(famille.getNomFamille()));
                }
            }
            catch (TechnicalException e) {
                e.printStackTrace();
                redirectionVersPageErreurTechnique(e.getMessage(),
                        e.getCause().getCause().getMessage());
            }
        }
    }

    /**
     * Fonction appellée lorsque l'utilisateur change la valeur du champs
     * famille
     * 
     * @param event
     */
    public void selectionFamille(AjaxBehaviorEvent event) {
        String nouvelleValeur = (String) ((UIOutput) event.getSource()).getValue();
        logger.debug("Selection d'une famille:" + nouvelleValeur);
        if (!nouvelleValeur.isEmpty()) {
            try {
                List<ProduitSousFamilleDto> listeFamille = ajoutProduitCoordinateur.listerSousFamille(nouvelleValeur);
                ajoutProduitModel.getListeSousFamilles().clear();
                for (ProduitSousFamilleDto sousFamille : listeFamille) {
                    ajoutProduitModel.getListeSousFamilles().add(
                            new SelectItem(sousFamille.getNomFamille()));
                }
            }
            catch (TechnicalException e) {
                e.printStackTrace();
                redirectionVersPageErreurTechnique(e.getMessage(),
                        e.getCause().getCause().getMessage());
            }
        }
    }

    public void ajoutPrixDegressif() {
        PrixDegressif nouveauPrix = new PrixDegressif(ajoutProduitModel.getBorneInferieure(),
                ajoutProduitModel.getBorneSuperieure(), ajoutProduitModel.getCoutUnitaire());
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

    public void afficherPartieNouvelleOption() {
        ajoutProduitModel.setAfficherPartieNouvelleOption(true);
    }

    public void modifierOption(Option optionAModifier) {
        // On affecte les éléments à la vue
        ajoutProduitModel.setOptionNom(optionAModifier.getNom());
        ajoutProduitModel.setOptionReference(optionAModifier.getReference());
        ajoutProduitModel.setOptionObligatoire(optionAModifier.isObligatoire());
        ajoutProduitModel.setOptionCoutUnitaireFixe(optionAModifier.getCoutUnitaireFixe());
        ajoutProduitModel.setListeOptionPrixDegressifProduit(optionAModifier.getListePrixDegressif());

        // On sauvegarde les anciennes valeurs
        Option optionAvantModif = new Option(optionAModifier.getNom(),
                optionAModifier.getReference(), optionAModifier.isObligatoire());
        optionAvantModif.setCoutUnitaireFixe(optionAModifier.getCoutUnitaireFixe());
        optionAvantModif.setListePrixDegressif(optionAModifier.getListePrixDegressif());
        ajoutProduitModel.setOptionAvantModification(optionAvantModif);

        ajoutProduitModel.getListeOptions().remove(optionAModifier);
        ajoutProduitModel.setAfficherPartieNouvelleOption(true);
    }

    public void suppressionOption(Option optionASupprimer) {
        ajoutProduitModel.getListeOptions().remove(optionASupprimer);
    }

    public void ajouterNouvelleOption() {
        Option nouvelleOption = new Option(ajoutProduitModel.getOptionNom(),
                ajoutProduitModel.getOptionReference(), ajoutProduitModel.isOptionObligatoire());
        if (ajoutProduitModel.getOptionCoutUnitaireFixe() != 0) {
            nouvelleOption.setCoutUnitaireFixe(ajoutProduitModel.getOptionCoutUnitaireFixe());
        }
        else {
            nouvelleOption.setListePrixDegressif(ajoutProduitModel.getListeOptionPrixDegressifProduit());
        }

        ajoutProduitModel.getListeOptions().add(nouvelleOption);
        ajoutProduitModel.setOptionAvantModification(null);
        ajoutProduitModel.reinitialiserAjoutOption();
        ajoutProduitModel.setAfficherPartieNouvelleOption(false);
    }

    public void annulerAjouterNouvelleOption() {
        if (ajoutProduitModel.getOptionAvantModification() != null) {
            ajoutProduitModel.getListeOptions().add(ajoutProduitModel.getOptionAvantModification());
            ajoutProduitModel.setOptionAvantModification(null);
        }
        ajoutProduitModel.reinitialiserAjoutOption();
        ajoutProduitModel.setAfficherPartieNouvelleOption(false);
    }

    public void ajouterOptionPrixDegressif() {
        PrixDegressif nouveauPrix = new PrixDegressif(ajoutProduitModel.getOptionBorneInferieure(),
                ajoutProduitModel.getOptionBorneSuperieure(),
                ajoutProduitModel.getOptionCoutUnitaire());
        ajoutProduitModel.getListeOptionPrixDegressifProduit().add(nouveauPrix);
        ajoutProduitModel.setOptionBorneInferieure(0);
        ajoutProduitModel.setOptionBorneSuperieure(0);
        ajoutProduitModel.setOptionCoutUnitaire(0F);
    }

    public void suppressionOptionPrixDegressif(PrixDegressif prixDegressifSelectionne) {
        ajoutProduitModel.getListeOptionPrixDegressifProduit().remove(prixDegressifSelectionne);
    }

    public String enregistrerProduit() {
        Map<String, Object> champsObligatoires = new HashMap<String, Object>();
        champsObligatoires.put("Nom", ajoutProduitModel.getNom());
        champsObligatoires.put("Référence", ajoutProduitModel.getReference());
        champsObligatoires.put("Famille", ajoutProduitModel.getFamilleSelectionnee());
        champsObligatoires.put("Sous Famille", ajoutProduitModel.getSousFamilleSelectionnee());
        champsObligatoires.put("Description Courte", ajoutProduitModel.getDescriptionCourte());
        champsObligatoires.put("Description Offre", ajoutProduitModel.getDescriptionOffre());
        champsObligatoires.put("Avantages", ajoutProduitModel.getAvantages());
        champsObligatoires.put("Bénéfices", ajoutProduitModel.getBenefices());
        champsObligatoires.put("Coût nominal", ajoutProduitModel.getCoutNominal());

        if (controlerChampsObligatoires(champsObligatoires)) {
            ProduitReferenceDto produitReferenceDto = AjoutProduitAdaptateur.preparationEnregistrementModel(ajoutProduitModel);
            // ajoutProduitCoordinateur.
            if (produitReferenceDto.getIdProduit() != 0) {
                ajoutProduitCoordinateur.modifierProduitReference(produitReferenceDto);
            }
            else {
                ajoutProduitCoordinateur.ajouterProduitReference(produitReferenceDto);
            }
        }

        return "";
    }

    public void onTabChange(TabChangeEvent event) {
        // this.setTab1("tab1.xhtml");
        // this.setTab2("tab2.xhtml"）;
        logger.debug("Changement de tab");
    }

    // ===== Accesseurs =======================================================

    // ===== Classes imbriquées ===============================================
}

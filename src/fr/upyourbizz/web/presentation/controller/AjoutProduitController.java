/**
 * © 2013, Upyourbizz - All right reserved
 */
package fr.upyourbizz.web.presentation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.upyourbizz.utils.adaptateur.AjoutProduitAdaptateur;
import fr.upyourbizz.web.coordination.AjoutProduitCoordinateur;
import fr.upyourbizz.web.dto.ProduitReferenceDto;
import fr.upyourbizz.web.presentation.model.AjoutProduitModel;
import fr.upyourbizz.web.presentation.model.AjoutProduitModel.Option;
import fr.upyourbizz.web.presentation.model.AjoutProduitModel.PrixDegressif;

/**
 * AjoutProduitController
 */
public class AjoutProduitController extends AbstractController {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(AjoutProduitController.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private AjoutProduitModel ajoutProduitModel;

    private AjoutProduitCoordinateur ajoutProduitCoordinateur;

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
        Option optionAvantModif = ajoutProduitModel.new Option(optionAModifier.getNom(),
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
        Option nouvelleOption = ajoutProduitModel.new Option(ajoutProduitModel.getOptionNom(),
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
        PrixDegressif nouveauPrix = ajoutProduitModel.new PrixDegressif(
                ajoutProduitModel.getOptionBorneInferieure(),
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
        }

        return "";
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

    /**
     * Affecte ajoutProduitCoordinateur
     * 
     * @param ajoutProduitCoordinateur ajoutProduitCoordinateur à affecter
     */
    public void setAjoutProduitCoordinateur(AjoutProduitCoordinateur ajoutProduitCoordinateur) {
        this.ajoutProduitCoordinateur = ajoutProduitCoordinateur;
    }

    // ===== Classes imbriquées ===============================================
}

/**
 * © 2013, Upyourbizz - All right reserved
 */
package fr.upyourbizz.utils.adaptateur;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.upyourbizz.web.dto.PrixDegressifProduitDto;
import fr.upyourbizz.web.dto.ProduitOptionsDto;
import fr.upyourbizz.web.dto.ProduitReferenceDto;
import fr.upyourbizz.web.dto.ProduitSousFamilleDto;
import fr.upyourbizz.web.presentation.model.AjoutProduitModel;

/**
 * AjoutProduitAdaptateur
 */
public class AjoutProduitAdaptateur {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(AjoutProduitAdaptateur.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    public static ProduitReferenceDto preparationEnregistrementModel(AjoutProduitModel model) {
        ProduitSousFamilleDto sousFamille = new ProduitSousFamilleDto();
        sousFamille.setNomFamille(model.getSousFamilleSelectionnee());

        ProduitReferenceDto nouveauProduit = new ProduitReferenceDto(sousFamille,
                model.getReference(), model.getNom(), model.getDescriptionCourte(), "",
                model.getDescriptionOffre(), model.getAvantages(), model.getBenefices(),
                model.getUrlImgIllustrationProduit(), model.getUrlImgIconeProduit(),
                model.getUrlImgProcessus(), model.getCoutNominal(), "");
        if (model.getPrixUnitaireFixe() != 0F) {
            nouveauProduit.setPrixUnitaire(model.getPrixUnitaireFixe());
        }
        else {
            PrixDegressifProduitDto prixDegressifProduitDto = new PrixDegressifProduitDto();
            prixDegressifProduitDto.setTableauPrixDegressif(model.getListePrixDegressifProduit());
            nouveauProduit.setPrixDegressifProduit(prixDegressifProduitDto);
        }
        if (model.getListeOptions().size() > 0) {
            ProduitOptionsDto produitOptionDto = new ProduitOptionsDto();
            produitOptionDto.setListeOption(model.getListeOptions());
            nouveauProduit.setProduitOptions(produitOptionDto);
        }
        return nouveauProduit;
    }

    /**
     * Adapte la liste de rôle à la vue
     * 
     * @param produitRef
     * @param model
     */
    public static void adapterProduitPourVue(ProduitReferenceDto produitRef, AjoutProduitModel model) {
        model.setNom(produitRef.getNom());
        model.setReference(produitRef.getReference());
        model.setFamilleSelectionnee(produitRef.getFamille().getNomFamille());
        model.setSousFamilleSelectionnee(produitRef.getSousFamille().getNomFamille());
        model.setDescriptionCourte(produitRef.getDescriptionCourte());
        model.setDescriptionOffre(produitRef.getDescriptionOffreHtml());
        model.setAvantages(produitRef.getAvantagesHtml());
        model.setBenefices(produitRef.getBeneficesHtml());
        model.setCoutNominal(produitRef.getCoutNominal());
        model.setPrixUnitaireFixe(produitRef.getPrixUnitaire());
        // model.setListePrixDegressifProduit = new ArrayList<PrixDegressif>();

        // model.setListeOptions(produitRef.get)
        model.setUrlImgIllustrationProduit(produitRef.getUrlImgIllustrationProduit());
        model.setUrlImgIconeProduit(produitRef.getUrlImgIconeProduit());
        model.setUrlImgProcessus(produitRef.getUrlImgProcessus());
    }
    // ===== Accesseurs =======================================================

    // ===== Classes imbriquées ===============================================
}

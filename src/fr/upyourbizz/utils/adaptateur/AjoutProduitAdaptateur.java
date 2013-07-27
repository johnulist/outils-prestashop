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
    // ===== Accesseurs =======================================================

    // ===== Classes imbriquées ===============================================
}

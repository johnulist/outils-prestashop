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
import fr.upyourbizz.web.presentation.model.AjoutProduitModel.Option;
import fr.upyourbizz.web.presentation.model.AjoutProduitModel.PrixDegressif;

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
            for (PrixDegressif prixDegressif : model.getListeOptionPrixDegressifProduit()) {
                prixDegressifProduitDto.ajouterPrixDegressif(null,
                        prixDegressif.getBorneInferieure(), prixDegressif.getBorneSuperieure(),
                        prixDegressif.getPrixUnitaire());
            }
            nouveauProduit.setPrixDegressifProduit(prixDegressifProduitDto);
        }
        if (model.getListeOptions().size() > 0) {
            ProduitOptionsDto produitOptionDto = new ProduitOptionsDto();
            for (Option produitOption : model.getListeOptions()) {
                ProduitOptionsDto produitOptionsDto = new ProduitOptionsDto();
                fr.upyourbizz.web.dto.ProduitOptionsDto.Option nouvelOption = produitOptionsDto.new Option(
                        produitOption.getNom(), produitOption.getReference(),
                        produitOption.isObligatoire());
                if (produitOption.getCoutUnitaireFixe() != 0F) {
                    nouvelOption.setCoutUnitaireFixe(produitOption.getCoutUnitaireFixe());
                }
                else {
                    for (PrixDegressif prixDegressif : produitOption.getListePrixDegressif()) {
                        nouvelOption.ajouterPrixDegressif(null, prixDegressif.getBorneInferieure(),
                                prixDegressif.getBorneSuperieure(), prixDegressif.getPrixUnitaire());
                    }
                }
                produitOptionDto.getListeOption().add(nouvelOption);

            }

        }
        return nouveauProduit;
    }
    // ===== Accesseurs =======================================================

    // ===== Classes imbriquées ===============================================
}

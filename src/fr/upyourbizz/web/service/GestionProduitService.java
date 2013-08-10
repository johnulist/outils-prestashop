package fr.upyourbizz.web.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import fr.upyourbizz.utils.exception.TechnicalException;
import fr.upyourbizz.web.dto.OptionReference;
import fr.upyourbizz.web.dto.PrixDegressif;
import fr.upyourbizz.web.dto.ProduitFamilleDto;
import fr.upyourbizz.web.dto.ProduitReferenceDto;
import fr.upyourbizz.web.dto.ProduitSousFamilleDto;
import fr.upyourbizz.web.persistence.ProduitReferenceDao;

public class GestionProduitService {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(GestionProduitService.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================
    private ProduitReferenceDao produitReferenceDao;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    /**
     * Liste les différentes familles de produits
     * 
     * @return La liste des familles
     * @throws TechnicalException Exception technique
     */
    public List<ProduitFamilleDto> listerFamille() throws TechnicalException {
        return produitReferenceDao.listerFamille();
    }

    /**
     * Liste les différentes sous familles des produits
     * 
     * @param nomFamille Le nom de la famille des sous famille à remonter
     * @return Une liste des sous famille associées à la famille passée en
     *         paramètre
     * @throws TechnicalException Exception technique
     */
    public List<ProduitSousFamilleDto> listerSousFamille(String nomFamille)
            throws TechnicalException {
        return produitReferenceDao.listerSousFamille(nomFamille);
    }

    /**
     * Liste les produits références appartenant à la sous famille passée en
     * paramètre
     * 
     * @param nomSousFamille
     * @return La liste des produit référence
     * @throws TechnicalException Exception technique
     */
    public List<ProduitReferenceDto> listerProduitsReference(String nomSousFamille)
            throws TechnicalException {
        return produitReferenceDao.listerProduitsReference(nomSousFamille);
    }

    @Transactional(rollbackFor = { TechnicalException.class })
    public void ajouterProduitReference(ProduitReferenceDto produitReference)
            throws TechnicalException {
        int idProduitRef = produitReferenceDao.ajouterProduitReference(
                produitReference.getSousFamille().getNomFamille(), produitReference.getReference(),
                produitReference.getNom(), produitReference.getDescriptionCourte(),
                produitReference.getDescriptionLongueHtml(),
                produitReference.getDescriptionOffreHtml(), produitReference.getAvantagesHtml(),
                produitReference.getBeneficesHtml(), produitReference.getCoutNominal(),
                produitReference.getPrixUnitaire(),
                produitReference.getUrlImgIllustrationProduit(),
                produitReference.getUrlImgIconeProduit(), produitReference.getUrlImgProcessus());

        for (PrixDegressif prixDegressif : produitReference.getPrixDegressifProduit().getTableauPrixDegressif()) {
            produitReferenceDao.ajouterPrixDegressif(idProduitRef, prixDegressif);
        }
        if (produitReference.getListeOption() != null) {
            for (OptionReference nouvelleOption : produitReference.getListeOption()) {
                ajouterOptionProduit(idProduitRef, nouvelleOption);
            }
        }
    }

    @Transactional(rollbackFor = { TechnicalException.class })
    public void modifierProduitReference(ProduitReferenceDto produitReference)
            throws TechnicalException {
        produitReferenceDao.modifierProduitReference(produitReference.getIdProduit(),
                produitReference.getSousFamille().getNomFamille(), produitReference.getReference(),
                produitReference.getNom(), produitReference.getDescriptionCourte(),
                produitReference.getDescriptionLongueHtml(),
                produitReference.getDescriptionOffreHtml(), produitReference.getAvantagesHtml(),
                produitReference.getBeneficesHtml(), produitReference.getCoutNominal(),
                produitReference.getPrixUnitaire(),
                produitReference.getUrlImgIllustrationProduit(),
                produitReference.getUrlImgIconeProduit(), produitReference.getUrlImgProcessus());

        // Suppression des prix degressifs existant
        produitReferenceDao.supprimerPrixDegressif(produitReference.getIdProduit());

        for (PrixDegressif prixDegressif : produitReference.getPrixDegressifProduit().getTableauPrixDegressif()) {
            produitReferenceDao.ajouterPrixDegressif(produitReference.getIdProduit(), prixDegressif);
        }

        // Suppression des options liées au produit
        produitReferenceDao.supprimerPrixDegressifOption(produitReference.getIdProduit());
        produitReferenceDao.supprimerOptionProduit(produitReference.getIdProduit());

        if (produitReference.getListeOption() != null) {
            for (OptionReference nouvelleOption : produitReference.getListeOption()) {
                ajouterOptionProduit(produitReference.getIdProduit(), nouvelleOption);
            }
        }
    }

    @Transactional(rollbackFor = { TechnicalException.class })
    private void ajouterOptionProduit(int idProduitRef, OptionReference nouvelleOption)
            throws TechnicalException {
        int idProduitOption = produitReferenceDao.ajouterOptionProduit(idProduitRef, nouvelleOption);
        if (nouvelleOption.getListePrixDegressif() != null) {
            for (PrixDegressif prixDegressif : nouvelleOption.getListePrixDegressif()) {
                produitReferenceDao.ajouterPrixDegressifOption(idProduitOption, prixDegressif);
            }
        }

    }

    /**
     * Récupère le produit référence dont l'id est passé en paramètre
     * 
     * @param idProduitReference L'id du produit de référence
     * @return Le produit de référence
     * @throws TechnicalException
     */
    public ProduitReferenceDto recupererProduitReference(int idProduitReference)
            throws TechnicalException {
        ProduitReferenceDto resultat = produitReferenceDao.recupererProduitReference(idProduitReference);
        resultat.setListeOption(produitReferenceDao.listerOptionProduitReference(idProduitReference));
        return resultat;
    }

    // ===== Accesseurs =======================================================

    /**
     * Affecte produitReferenceDao
     * 
     * @param produitReferenceDao produitReferenceDao à affecter
     */
    public void setProduitReferenceDao(ProduitReferenceDao produitReferenceDao) {
        this.produitReferenceDao = produitReferenceDao;
    }

    // ===== Classes imbriquées ===============================================
}

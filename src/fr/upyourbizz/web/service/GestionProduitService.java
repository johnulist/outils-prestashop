package fr.upyourbizz.web.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import fr.upyourbizz.utils.exception.TechnicalException;
import fr.upyourbizz.web.dto.Option;
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
        if (produitReference.getProduitOptions() != null) {
            for (Option nouvelleOption : produitReference.getProduitOptions().getListeOption()) {
                ajouterOptionProduit(idProduitRef, nouvelleOption);
            }
        }
    }

    @Transactional(rollbackFor = { TechnicalException.class })
    private void ajouterOptionProduit(int idProduitRef, Option nouvelleOption)
            throws TechnicalException {
        produitReferenceDao.ajouterOptionProduit(idProduitRef, nouvelleOption);
        if (nouvelleOption.getListePrixDegressif() != null) {
            for (PrixDegressif prixDegressif : nouvelleOption.getListePrixDegressif()) {
                produitReferenceDao.ajouterPrixDegressifOption(idProduitRef, prixDegressif);
            }
        }

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

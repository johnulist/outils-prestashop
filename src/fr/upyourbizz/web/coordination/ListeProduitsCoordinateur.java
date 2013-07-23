package fr.upyourbizz.web.coordination;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.upyourbizz.utils.exception.TechnicalException;
import fr.upyourbizz.web.dto.ProduitFamilleDto;
import fr.upyourbizz.web.dto.ProduitReferenceDto;
import fr.upyourbizz.web.dto.ProduitSousFamilleDto;
import fr.upyourbizz.web.service.GestionProduitService;

/**
 * ListeProduitsCoordinateur
 */
@Named
public class ListeProduitsCoordinateur {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(ListeProduitsCoordinateur.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================
    @Inject
    private GestionProduitService gestionProduitService;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    /**
     * Liste les différentes familles de produits
     * 
     * @return La liste des familles
     * @throws TechnicalException Exception technique
     */
    public List<ProduitFamilleDto> listerFamille() throws TechnicalException {
        return gestionProduitService.listerFamille();
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
        return gestionProduitService.listerSousFamille(nomFamille);
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
        return gestionProduitService.listerProduitsReference(nomSousFamille);
    }

    // ===== Accesseurs =======================================================

    // ===== Classes imbriquées ===============================================
}

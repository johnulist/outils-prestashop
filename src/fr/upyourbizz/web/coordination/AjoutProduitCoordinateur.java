package fr.upyourbizz.web.coordination;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.upyourbizz.utils.exception.TechnicalException;
import fr.upyourbizz.web.dto.ProduitFamilleDto;
import fr.upyourbizz.web.dto.ProduitReferenceDto;
import fr.upyourbizz.web.dto.ProduitSousFamilleDto;
import fr.upyourbizz.web.service.GestionProduitService;

public class AjoutProduitCoordinateur {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(AjoutProduitCoordinateur.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private GestionProduitService gestionProduitService;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    public void ajouterProduitReference(ProduitReferenceDto produitReference)
            throws TechnicalException {
        gestionProduitService.ajouterProduitReference(produitReference);
    }

    public void modifierProduitReference(ProduitReferenceDto produitReference)
            throws TechnicalException {
        gestionProduitService.ajouterProduitReference(produitReference);
    }

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

    // ===== Accesseurs =======================================================

    /**
     * Affecte gestionProduitService
     * 
     * @param gestionProduitService gestionProduitService à affecter
     */
    public void setGestionProduitService(GestionProduitService gestionProduitService) {
        this.gestionProduitService = gestionProduitService;
    }

    // ===== Classes imbriquées ===============================================
}

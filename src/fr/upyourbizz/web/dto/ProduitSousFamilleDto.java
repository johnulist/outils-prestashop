/**
 * © 2013, Upyourbizz - All right reserved
 */
package fr.upyourbizz.web.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ProduitFamille
 */
public class ProduitSousFamilleDto {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(ProduitSousFamilleDto.class);

    // ===== Attributs ========================================================

    private int idSousFamille;

    private String nomFamille;

    private String description;

    // ===== Accesseurs =======================================================

    /**
     * Retourne idSousFamille
     * 
     * @return idSousFamille
     */
    public int getIdSousFamille() {
        return idSousFamille;
    }

    /**
     * Affecte idSousFamille
     * 
     * @param idSousFamille idSousFamille à affecter
     */
    public void setIdSousFamille(int idSousFamille) {
        this.idSousFamille = idSousFamille;
    }

    /**
     * Retourne nomFamille
     * 
     * @return nomFamille
     */
    public String getNomFamille() {
        return nomFamille;
    }

    /**
     * Affecte nomFamille
     * 
     * @param nomFamille nomFamille à affecter
     */
    public void setNomFamille(String nomFamille) {
        this.nomFamille = nomFamille;
    }

    /**
     * Retourne description
     * 
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Affecte description
     * 
     * @param description description à affecter
     */
    public void setDescription(String description) {
        this.description = description;
    }

}

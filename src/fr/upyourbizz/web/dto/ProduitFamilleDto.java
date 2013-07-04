/**
 * © 2013, Upyourbizz - All right reserved
 */
package fr.upyourbizz.web.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ProduitFamille
 */
public class ProduitFamilleDto {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(ProduitFamilleDto.class);

    // ===== Attributs ========================================================

    private int idFamille;

    private String nomFamille;

    private String description;

    // ===== Accesseurs =======================================================

    /**
     * Retourne idFamille
     * 
     * @return idFamille
     */
    public int getIdFamille() {
        return idFamille;
    }

    /**
     * Affecte idFamille
     * 
     * @param idFamille idFamille à affecter
     */
    public void setIdFamille(int idFamille) {
        this.idFamille = idFamille;
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

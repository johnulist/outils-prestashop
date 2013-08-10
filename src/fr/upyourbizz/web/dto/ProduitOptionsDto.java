/**
 * © 2013, Upyourbizz - All right reserved
 */
package fr.upyourbizz.web.dto;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ProduitOptionDto
 */
public class ProduitOptionsDto {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(ProduitOptionsDto.class);

    // ===== Méthodes statiques ===============================================

    List<OptionReference> listeOption = new ArrayList<OptionReference>();

    // ===== Attributs ========================================================

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    // ===== Accesseurs =======================================================

    /**
     * Retourne listeOption
     * 
     * @return listeOption
     */
    public List<OptionReference> getListeOption() {
        return listeOption;
    }

    /**
     * Affecte listeOption
     * 
     * @param listeOption listeOption à affecter
     */
    public void setListeOption(List<OptionReference> listeOption) {
        this.listeOption = listeOption;
    }

    // ===== Classes imbriquées ===============================================
}

package fr.upyourbizz.web.dto;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PrixDegressifProduitDto
 */
public class PrixDegressifProduitDto {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(PrixDegressifProduitDto.class);

    // ===== Attributs ========================================================

    private List<PrixDegressif> tableauPrixDegressif = new ArrayList<PrixDegressif>();

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    /**
     * @param idPrixDegressif
     * @param borneInferieure
     * @param borneSuperieure
     * @param prixUnitaire
     */
    public void ajouterPrixDegressif(Integer idPrixDegressif, int borneInferieure,
            int borneSuperieure, float prixUnitaire) {
        tableauPrixDegressif.add(new PrixDegressif(idPrixDegressif, borneInferieure,
                borneSuperieure, prixUnitaire));
    }

    // ===== Accesseurs =======================================================

    /**
     * Retourne tableauPrixDegressif
     * 
     * @return tableauPrixDegressif
     */
    public List<PrixDegressif> getTableauPrixDegressif() {
        return tableauPrixDegressif;
    }

    /**
     * Affecte tableauPrixDegressif
     * 
     * @param tableauPrixDegressif tableauPrixDegressif à affecter
     */
    public void setTableauPrixDegressif(List<PrixDegressif> tableauPrixDegressif) {
        this.tableauPrixDegressif = tableauPrixDegressif;
    }

    // ===== Classes imbriquées ===============================================
}

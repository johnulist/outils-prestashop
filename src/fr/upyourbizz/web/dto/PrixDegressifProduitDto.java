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
    public void ajouterPrixDegressif(int idPrixDegressif, int borneInferieure, int borneSuperieure,
            float prixUnitaire) {
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
    /**
     * PrixDegressif
     */
    public class PrixDegressif {

        private int idPrixDegressif;

        private int borneInferieure;

        private int borneSuperieure;

        private float prixUnitaire;

        /**
         * Retourne idPrixDegressif
         * 
         * @return idPrixDegressif
         */
        public int getIdPrixDegressif() {
            return idPrixDegressif;
        }

        /**
         * @param idPrixDegressif id du prix dégressif
         * @param borneInferieure borne inférieur (par rapport quantité)
         * @param borneSuperieure borne supérieur (par rapport quantité)
         * @param prixUnitaire prix du produit avec une quantité comprise entre
         *            la borne suppérieure et la borne inférieure
         */
        public PrixDegressif(int idPrixDegressif, int borneInferieure, int borneSuperieure,
                float prixUnitaire) {
            super();
            this.idPrixDegressif = idPrixDegressif;
            this.borneInferieure = borneInferieure;
            this.borneSuperieure = borneSuperieure;
            this.prixUnitaire = prixUnitaire;
        }

        /**
         * Affecte idPrixDegressif
         * 
         * @param idPrixDegressif idPrixDegressif à affecter
         */
        public void setIdPrixDegressif(int idPrixDegressif) {
            this.idPrixDegressif = idPrixDegressif;
        }

        /**
         * Retourne borneInferieure
         * 
         * @return borneInferieure
         */
        public int getBorneInferieure() {
            return borneInferieure;
        }

        /**
         * Affecte borneInferieure
         * 
         * @param borneInferieure borneInferieure à affecter
         */
        public void setBorneInferieure(int borneInferieure) {
            this.borneInferieure = borneInferieure;
        }

        /**
         * Retourne borneSuperieure
         * 
         * @return borneSuperieure
         */
        public int getBorneSuperieure() {
            return borneSuperieure;
        }

        /**
         * Affecte borneSuperieure
         * 
         * @param borneSuperieure borneSuperieure à affecter
         */
        public void setBorneSuperieure(int borneSuperieure) {
            this.borneSuperieure = borneSuperieure;
        }

        /**
         * Retourne prixUnitaire
         * 
         * @return prixUnitaire
         */
        public float getPrixUnitaire() {
            return prixUnitaire;
        }

        /**
         * Affecte prixUnitaire
         * 
         * @param prixUnitaire prixUnitaire à affecter
         */
        public void setPrixUnitaire(float prixUnitaire) {
            this.prixUnitaire = prixUnitaire;
        }

    }

}

/**
 * © 2013, Upyourbizz - All right reserved
 */
package fr.upyourbizz.web.presentation.model;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ListeProduits
 */
public class ListeProduitsModel {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(ListeProduitsModel.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private List<Famille> famille = new ArrayList<Famille>();

    private List<Famille> sousFamille = new ArrayList<Famille>();

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    // ===== Accesseurs =======================================================

    /**
     * Retourne famille
     * 
     * @return famille
     */
    public List<Famille> getFamille() {
        return famille;
    }

    /**
     * Affecte famille
     * 
     * @param famille famille à affecter
     */
    public void setFamille(List<Famille> famille) {
        this.famille = famille;
    }

    /**
     * Retourne sousFamille
     * 
     * @return sousFamille
     */
    public List<Famille> getSousFamille() {
        return sousFamille;
    }

    /**
     * Affecte sousFamille
     * 
     * @param sousFamille sousFamille à affecter
     */
    public void setSousFamille(List<Famille> sousFamille) {
        this.sousFamille = sousFamille;
    }

    // ===== Classes imbriquées ===============================================
    public class Famille {

        private String nomFamille = "";

        private String imgUrl = "";

        public Famille(String nomFamille, String imgUrl) {
            super();
            this.nomFamille = nomFamille;
            this.imgUrl = imgUrl;
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
         * Retourne imgUrl
         * 
         * @return imgUrl
         */
        public String getImgUrl() {
            return imgUrl;
        }

        /**
         * Affecte imgUrl
         * 
         * @param imgUrl imgUrl à affecter
         */
        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }
    }
}

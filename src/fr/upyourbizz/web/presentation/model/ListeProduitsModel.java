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

    private List<Produit> produits = new ArrayList<Produit>();;

    private boolean afficherSousFamille;

    private boolean afficherProduits;

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

    /**
     * Retourne produits
     * 
     * @return produits
     */
    public List<Produit> getProduits() {
        return produits;
    }

    /**
     * Affecte produits
     * 
     * @param produits produits à affecter
     */
    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    /**
     * Retourne afficherSousFamille
     * 
     * @return afficherSousFamille
     */
    public boolean isAfficherSousFamille() {
        return afficherSousFamille;
    }

    /**
     * Affecte afficherSousFamille
     * 
     * @param afficherSousFamille afficherSousFamille à affecter
     */
    public void setAfficherSousFamille(boolean afficherSousFamille) {
        this.afficherSousFamille = afficherSousFamille;
    }

    /**
     * Retourne afficherProduits
     * 
     * @return afficherProduits
     */
    public boolean isAfficherProduits() {
        return afficherProduits;
    }

    /**
     * Affecte afficherProduits
     * 
     * @param afficherProduits afficherProduits à affecter
     */
    public void setAfficherProduits(boolean afficherProduits) {
        this.afficherProduits = afficherProduits;
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

    public class Produit {

        private int idProduitReference;

        private String nomProduit;

        private String referenceProduit;

        private String urlImgIconeProduit;

        public Produit(int idProduitReference, String nomProduit, String referenceProduit,
                String urlImgIconeProduit) {
            super();
            this.idProduitReference = idProduitReference;
            this.nomProduit = nomProduit;
            this.referenceProduit = referenceProduit;
            this.urlImgIconeProduit = urlImgIconeProduit;
        }

        /**
         * Retourne idProduitReference
         * 
         * @return idProduitReference
         */
        public int getIdProduitReference() {
            return idProduitReference;
        }

        /**
         * Affecte idProduitReference
         * 
         * @param idProduitReference idProduitReference à affecter
         */
        public void setIdProduitReference(int idProduitReference) {
            this.idProduitReference = idProduitReference;
        }

        /**
         * Retourne nomProduit
         * 
         * @return nomProduit
         */
        public String getNomProduit() {
            return nomProduit;
        }

        /**
         * Affecte nomProduit
         * 
         * @param nomProduit nomProduit à affecter
         */
        public void setNomProduit(String nomProduit) {
            this.nomProduit = nomProduit;
        }

        /**
         * Retourne referenceProduit
         * 
         * @return referenceProduit
         */
        public String getReferenceProduit() {
            return referenceProduit;
        }

        /**
         * Affecte referenceProduit
         * 
         * @param referenceProduit referenceProduit à affecter
         */
        public void setReferenceProduit(String referenceProduit) {
            this.referenceProduit = referenceProduit;
        }

        /**
         * Retourne urlImgIconeProduit
         * 
         * @return urlImgIconeProduit
         */
        public String getUrlImgIconeProduit() {
            return urlImgIconeProduit;
        }

        /**
         * Affecte urlImgIconeProduit
         * 
         * @param urlImgIconeProduit urlImgIconeProduit à affecter
         */
        public void setUrlImgIconeProduit(String urlImgIconeProduit) {
            this.urlImgIconeProduit = urlImgIconeProduit;
        }
    }
}

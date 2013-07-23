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

    List<Option> listeOption = new ArrayList<Option>();

    // ===== Attributs ========================================================

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    // ===== Accesseurs =======================================================

    /**
     * Retourne listeOption
     * 
     * @return listeOption
     */
    public List<Option> getListeOption() {
        return listeOption;
    }

    /**
     * Affecte listeOption
     * 
     * @param listeOption listeOption à affecter
     */
    public void setListeOption(List<Option> listeOption) {
        this.listeOption = listeOption;
    }

    // ===== Classes imbriquées ===============================================
    public class Option {

        private String nom = "";

        private String reference = "";

        private boolean obligatoire;

        private float coutUnitaireFixe;

        private List<PrixDegressif> listePrixDegressif = new ArrayList<PrixDegressif>();

        public Option(String nom, String reference, boolean obligatoire) {
            super();
            this.nom = nom;
            this.reference = reference;
            this.obligatoire = obligatoire;
        }

        /**
         * @param idPrixDegressif
         * @param borneInferieure
         * @param borneSuperieure
         * @param prixUnitaire
         */
        public void ajouterPrixDegressif(Integer idPrixDegressif, int borneInferieure,
                int borneSuperieure, float prixUnitaire) {
            listePrixDegressif.add(new PrixDegressif(borneInferieure, borneSuperieure, prixUnitaire));
        }

        /**
         * Retourne nom
         * 
         * @return nom
         */
        public String getNom() {
            return nom;
        }

        /**
         * Affecte nom
         * 
         * @param nom nom à affecter
         */
        public void setNom(String nom) {
            this.nom = nom;
        }

        /**
         * Retourne reference
         * 
         * @return reference
         */
        public String getReference() {
            return reference;
        }

        /**
         * Affecte reference
         * 
         * @param reference reference à affecter
         */
        public void setReference(String reference) {
            this.reference = reference;
        }

        /**
         * Retourne obligatoire
         * 
         * @return obligatoire
         */
        public boolean isObligatoire() {
            return obligatoire;
        }

        /**
         * Affecte obligatoire
         * 
         * @param obligatoire obligatoire à affecter
         */
        public void setObligatoire(boolean obligatoire) {
            this.obligatoire = obligatoire;
        }

        /**
         * Retourne coutUnitaireFixe
         * 
         * @return coutUnitaireFixe
         */
        public float getCoutUnitaireFixe() {
            return coutUnitaireFixe;
        }

        /**
         * Affecte coutUnitaireFixe
         * 
         * @param coutUnitaireFixe coutUnitaire à affecter
         */
        public void setCoutUnitaireFixe(float coutUnitaireFixe) {
            this.coutUnitaireFixe = coutUnitaireFixe;
        }

        /**
         * Retourne listePrixDegressif
         * 
         * @return listePrixDegressif
         */
        public List<PrixDegressif> getListePrixDegressif() {
            return listePrixDegressif;
        }

        /**
         * Affecte listePrixDegressif
         * 
         * @param listePrixDegressif listePrixDegressif à affecter
         */
        public void setListePrixDegressif(List<PrixDegressif> listePrixDegressif) {
            this.listePrixDegressif = listePrixDegressif;
        }

    }

    public class PrixDegressif {

        private int borneInferieure;

        private int borneSuperieure;

        private float prixUnitaire;

        public PrixDegressif(int borneInferieure, int borneSuperieure, float prixUnitaire) {
            super();
            this.borneInferieure = borneInferieure;
            this.borneSuperieure = borneSuperieure;
            this.prixUnitaire = prixUnitaire;
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

package fr.upyourbizz.web.presentation.model;

import java.util.ArrayList;
import java.util.List;

public class ProduitPac {

    // ===== Attributs statiques ==============================================

    private String nomOnglet;

    private int quantite;

    private String commentaire;

    private int duree;

    private float prixCalcule;

    private List<ProduitPacOption> listeOptions = new ArrayList<ProduitPacOption>();

    public ProduitPac(String nomOnglet, int quantite, String commentaire, int duree,
            float prixCalcule) {
        super();
        this.nomOnglet = nomOnglet;
        this.quantite = quantite;
        this.commentaire = commentaire;
        this.duree = duree;
        this.prixCalcule = prixCalcule;
    }

    /**
     * Retourne nomOnglet
     * 
     * @return nomOnglet
     */
    public String getNomOnglet() {
        return nomOnglet;
    }

    /**
     * Affecte nomOnglet
     * 
     * @param nomOnglet nomOnglet à affecter
     */
    public void setNomOnglet(String nomOnglet) {
        this.nomOnglet = nomOnglet;
    }

    /**
     * Retourne quantite
     * 
     * @return quantite
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Affecte quantite
     * 
     * @param quantite quantite à affecter
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    /**
     * Retourne commentaire
     * 
     * @return commentaire
     */
    public String getCommentaire() {
        return commentaire;
    }

    /**
     * Affecte commentaire
     * 
     * @param commentaire commentaire à affecter
     */
    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    /**
     * Retourne duree
     * 
     * @return duree
     */
    public int getDuree() {
        return duree;
    }

    /**
     * Affecte duree
     * 
     * @param duree duree à affecter
     */
    public void setDuree(int duree) {
        this.duree = duree;
    }

    /**
     * Retourne prixCalcule
     * 
     * @return prixCalcule
     */
    public float getPrixCalcule() {
        return prixCalcule;
    }

    /**
     * Affecte prixCalcule
     * 
     * @param prixCalcule prixCalcule à affecter
     */
    public void setPrixCalcule(float prixCalcule) {
        this.prixCalcule = prixCalcule;
    }

    /**
     * Retourne listeOptions
     * 
     * @return listeOptions
     */
    public List<ProduitPacOption> getListeOptions() {
        return listeOptions;
    }

    /**
     * Affecte listeOptions
     * 
     * @param listeOptions listeOptions à affecter
     */
    public void setListeOptions(List<ProduitPacOption> listeOptions) {
        this.listeOptions = listeOptions;
    }

}

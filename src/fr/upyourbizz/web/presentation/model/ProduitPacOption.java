package fr.upyourbizz.web.presentation.model;

import fr.upyourbizz.web.dto.OptionReference;

public class ProduitPacOption {

    // ===== Attributs statiques ==============================================

    private String nom;

    private int duree;

    private float prixCalcule;

    private boolean obligatoire;

    private boolean retenue;

    private OptionReference optionRef;

    public ProduitPacOption(String nom, int duree, float prixCalcule, boolean obligatoire,
            boolean retenue, OptionReference optionRef) {
        super();
        this.nom = nom;
        this.duree = duree;
        this.prixCalcule = prixCalcule;
        this.obligatoire = obligatoire;
        this.retenue = retenue;
        this.optionRef = optionRef;
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
     * Retourne retenue
     * 
     * @return retenue
     */
    public boolean isRetenue() {
        return retenue;
    }

    /**
     * Affecte retenue
     * 
     * @param retenue retenue à affecter
     */
    public void setRetenue(boolean retenue) {
        this.retenue = retenue;
    }

    /**
     * Retourne optionRef
     * 
     * @return optionRef
     */
    public OptionReference getOptionRef() {
        return optionRef;
    }

    /**
     * Affecte optionRef
     * 
     * @param optionRef optionRef à affecter
     */
    public void setOptionRef(OptionReference optionRef) {
        this.optionRef = optionRef;
    }

}

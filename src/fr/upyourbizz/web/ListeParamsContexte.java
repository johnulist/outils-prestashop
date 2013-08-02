package fr.upyourbizz.web;

public enum ListeParamsContexte {
    ID_CLIENT("idClient"), ID_PRODUIT("idProduit");

    private String nom;

    private ListeParamsContexte(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}

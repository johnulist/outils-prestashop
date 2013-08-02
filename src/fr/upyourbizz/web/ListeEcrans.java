package fr.upyourbizz.web;

public enum ListeEcrans {
    LISTE_PRODUITS("liste_produits", "liste-produits.xhtml"), AJOUT_PRODUITS("ajout_produits",
            "ajout-produits.xhtml"), CREER_PAC("creer_pac", "creer-pac.xhtml");

    private String nom;

    private String url;

    private ListeEcrans(String nom, String url) {
        this.nom = nom;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getNom() {
        return nom;
    }
}

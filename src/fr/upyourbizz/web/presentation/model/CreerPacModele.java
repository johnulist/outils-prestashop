package fr.upyourbizz.web.presentation.model;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import fr.upyourbizz.web.dto.ProduitReferenceDto;

@Component
public class CreerPacModele {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(CreerPacModele.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    /**
     * Map contenant la liste des produits à utiliser pour le PAC
     */
    private Map<Integer, ProduitReferenceDto> listeProduitsRefChoisis;

    private ProduitReferenceDto produitReferenceSelectionne;

    private Map<Integer, List<ProduitPac>> listeProduitsPac;

    private List<ProduitPac> produitsAffichesOnglets;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    // ===== Accesseurs =======================================================

    /**
     * Retourne listeProduitsRefChoisis
     * 
     * @return listeProduitsRefChoisis
     */
    public Map<Integer, ProduitReferenceDto> getListeProduitsRefChoisis() {
        return listeProduitsRefChoisis;
    }

    /**
     * Affecte listeProduitsRefChoisis
     * 
     * @param listeProduitsRefChoisis listeProduitsRefChoisis à affecter
     */
    public void setListeProduitsRefChoisis(Map<Integer, ProduitReferenceDto> listeProduitsRefChoisis) {
        this.listeProduitsRefChoisis = listeProduitsRefChoisis;
    }

    /**
     * Retourne produitReferenceSelectionne
     * 
     * @return produitReferenceSelectionne
     */
    public ProduitReferenceDto getProduitReferenceSelectionne() {
        return produitReferenceSelectionne;
    }

    /**
     * Affecte produitReferenceSelectionne
     * 
     * @param produitReferenceSelectionne produitReferenceSelectionne à affecter
     */
    public void setProduitReferenceSelectionne(ProduitReferenceDto produitReferenceSelectionne) {
        this.produitReferenceSelectionne = produitReferenceSelectionne;
    }

    /**
     * Retourne listeProduitsPac
     * 
     * @return listeProduitsPac
     */
    public Map<Integer, List<ProduitPac>> getListeProduitsPac() {
        return listeProduitsPac;
    }

    /**
     * Affecte listeProduitsPac
     * 
     * @param listeProduitsPac listeProduitsPac à affecter
     */
    public void setListeProduitsPac(Map<Integer, List<ProduitPac>> listeProduitsPac) {
        this.listeProduitsPac = listeProduitsPac;
    }

    /**
     * Retourne produitsAffichesOnglets
     * 
     * @return produitsAffichesOnglets
     */
    public List<ProduitPac> getProduitsAffichesOnglets() {
        return produitsAffichesOnglets;
    }

    /**
     * Affecte produitsAffichesOnglets
     * 
     * @param produitsAffichesOnglets produitsAffichesOnglets à affecter
     */
    public void setProduitsAffichesOnglets(List<ProduitPac> produitsAffichesOnglets) {
        this.produitsAffichesOnglets = produitsAffichesOnglets;
    }

    // ===== Classes imbriquées ===============================================
}

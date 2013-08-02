package fr.upyourbizz.web.presentation.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ContexteModel {

    // ===== Attributs statiques ==============================================

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private final Logger logger = LoggerFactory.getLogger(ContexteModel.class);

    private String name;

    private List<String> utilisateurRoles = new ArrayList<String>();

    private String income = "";

    private String outcome = "";

    private final Map<String, Object> params = new HashMap<String, Object>();

    // ===== Constructeurs ====================================================

    ContexteModel() {
        logger.debug("Constructeur de ContexteVb appelé");
    }

    // ===== Méthodes =========================================================

    /**
     * Ajoute un paramètre qui sera exploté dans un autre écran
     * 
     * @param nom Le nom du paramètre
     * @param valeur Sa valeur
     */
    public void ajouterParam(String nom, Object valeur) {
        params.put(nom, valeur);
    }

    public void supprimerParam(String nom) {
        params.remove(nom);
    }

    // ===== Accesseurs =======================================================
    /**
     * Retourne name
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Affecte name
     * 
     * @param name name à affecter
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retourne income
     * 
     * @return income
     */
    public String getIncome() {
        return income;
    }

    /**
     * Affecte income
     * 
     * @param income income à affecter
     */
    public void setIncome(String income) {
        this.income = income;
    }

    /**
     * Retourne outcome
     * 
     * @return outcome
     */
    public String getOutcome() {
        return outcome;
    }

    /**
     * Affecte outcome
     * 
     * @param outcome outcome à affecter
     */
    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    /**
     * Retourne params
     * 
     * @return params
     */
    public Map<String, Object> getParams() {
        return params;
    }

    /**
     * Retourne utilisateurRoles
     * 
     * @return utilisateurRoles
     */
    public List<String> getUtilisateurRoles() {
        return utilisateurRoles;
    }

    /**
     * Affecte utilisateurRoles
     * 
     * @param utilisateurRoles utilisateurRoles à affecter
     */
    public void setUtilisateurRoles(List<String> utilisateurRoles) {
        this.utilisateurRoles = utilisateurRoles;
    }

}

/**
 * © 2013, Upyourbizz - All right reserved
 */
package fr.upyourbizz.web.dto;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * UtilisateurDto
 */
public class UtilisateurDto {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(UtilisateurDto.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private int idUtilisateur;

    private String nom;

    private String prenom;

    private String login;

    private String password;

    private String email;

    private DateTime dateCreation;

    private DateTime derniereConnexion;

    private String role;

    private String niveau;

    private boolean actif;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    /**
     * @param idUtilisateur
     * @param nom
     * @param prenom
     * @param login
     * @param password
     * @param email
     * @param role
     * @param niveau
     * @param actif
     */
    public UtilisateurDto(int idUtilisateur, String nom, String prenom, String login,
            String password, String email, String role, String niveau, boolean actif) {
        super();
        this.idUtilisateur = idUtilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
        this.niveau = niveau;
        this.actif = actif;
    }

    // ===== Accesseurs =======================================================

    /**
     * Retourne idUtilisateur
     * 
     * @return idUtilisateur
     */
    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    /**
     * Affecte idUtilisateur
     * 
     * @param idUtilisateur idUtilisateur à affecter
     */
    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
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
     * Retourne prenom
     * 
     * @return prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Affecte prenom
     * 
     * @param prenom prenom à affecter
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Retourne login
     * 
     * @return login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Affecte login
     * 
     * @param login login à affecter
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Retourne password
     * 
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Affecte password
     * 
     * @param password password à affecter
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retourne email
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Affecte email
     * 
     * @param email email à affecter
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retourne dateCreation
     * 
     * @return dateCreation
     */
    public DateTime getDateCreation() {
        return dateCreation;
    }

    /**
     * Affecte dateCreation
     * 
     * @param dateCreation dateCreation à affecter
     */
    public void setDateCreation(DateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * Retourne derniereConnexion
     * 
     * @return derniereConnexion
     */
    public DateTime getDerniereConnexion() {
        return derniereConnexion;
    }

    /**
     * Affecte derniereConnexion
     * 
     * @param derniereConnexion derniereConnexion à affecter
     */
    public void setDerniereConnexion(DateTime derniereConnexion) {
        this.derniereConnexion = derniereConnexion;
    }

    /**
     * Retourne role
     * 
     * @return role
     */
    public String getRole() {
        return role;
    }

    /**
     * Affecte role
     * 
     * @param role role à affecter
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Retourne niveau
     * 
     * @return niveau
     */
    public String getNiveau() {
        return niveau;
    }

    /**
     * Affecte niveau
     * 
     * @param niveau niveau à affecter
     */
    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    /**
     * Retourne actif
     * 
     * @return actif
     */
    public boolean isActif() {
        return actif;
    }

    /**
     * Affecte actif
     * 
     * @param actif actif à affecter
     */
    public void setActif(boolean actif) {
        this.actif = actif;
    }

    // ===== Classes imbriquées ===============================================
}

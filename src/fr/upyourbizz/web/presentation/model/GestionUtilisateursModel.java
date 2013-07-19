/**
 * © 2013, Upyourbizz - All right reserved
 */
package fr.upyourbizz.web.presentation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AjoutUtilisateursModel
 */
public class GestionUtilisateursModel {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(GestionUtilisateursModel.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================
    /*
     * Tableau liste utilisateurs
     */
    List<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();

    private boolean afficherPartieNouvelUtilisateur = false;

    private Utilisateur utilisateurAvantModification = null;

    /*
     * Ajout nouvel utilisateur
     */

    private int idUtilisateur = -1;

    private String utilisateurNom = "";

    private String utilisateurPrenom = "";

    private String utilisateurEmail = "";

    private String utilisateurLogin = "";

    private String utilisateurMdp = "";

    private String utilisateurMdpConfirmation = "";

    private List<SelectItem> listeRoles = new ArrayList<SelectItem>();

    private String roleSelectionne = "";

    private List<SelectItem> listeNiveaux = new ArrayList<SelectItem>();;

    private String niveauSelectionne = "";

    private boolean utilisateurActif;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    public void reinitialiser() {
        listeUtilisateurs = new ArrayList<Utilisateur>();
        afficherPartieNouvelUtilisateur = false;
        utilisateurAvantModification = null;

        reinitialiserChampsUtilisateur();
        listeRoles = new ArrayList<SelectItem>();
        roleSelectionne = "";
        listeNiveaux = new ArrayList<SelectItem>();
        niveauSelectionne = "";
    }

    public void reinitialiserChampsUtilisateur() {
        idUtilisateur = -1;
        utilisateurNom = "";
        utilisateurPrenom = "";
        utilisateurEmail = "";
        utilisateurLogin = "";
        utilisateurMdp = "";
        utilisateurMdpConfirmation = "";
        utilisateurActif = false;
    }

    // ===== Accesseurs =======================================================

    /**
     * Retourne listeUtilisateurs
     * 
     * @return listeUtilisateurs
     */
    public List<Utilisateur> getListeUtilisateurs() {
        return listeUtilisateurs;
    }

    /**
     * Affecte listeUtilisateurs
     * 
     * @param listeUtilisateurs listeUtilisateurs à affecter
     */
    public void setListeUtilisateurs(List<Utilisateur> listeUtilisateurs) {
        this.listeUtilisateurs = listeUtilisateurs;
    }

    /**
     * Retourne afficherPartieNouvelUtilisateur
     * 
     * @return afficherPartieNouvelUtilisateur
     */
    public boolean isAfficherPartieNouvelUtilisateur() {
        return afficherPartieNouvelUtilisateur;
    }

    /**
     * Affecte afficherPartieNouvelUtilisateur
     * 
     * @param afficherPartieNouvelUtilisateur afficherPartieNouvelUtilisateur à
     *            affecter
     */
    public void setAfficherPartieNouvelUtilisateur(boolean afficherPartieNouvelUtilisateur) {
        this.afficherPartieNouvelUtilisateur = afficherPartieNouvelUtilisateur;
    }

    /**
     * Retourne utilisateurAvantModification
     * 
     * @return utilisateurAvantModification
     */
    public Utilisateur getUtilisateurAvantModification() {
        return utilisateurAvantModification;
    }

    /**
     * Affecte utilisateurAvantModification
     * 
     * @param utilisateurAvantModification utilisateurAvantModification à
     *            affecter
     */
    public void setUtilisateurAvantModification(Utilisateur utilisateurAvantModification) {
        this.utilisateurAvantModification = utilisateurAvantModification;
    }

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
     * Retourne utilisateurNom
     * 
     * @return utilisateurNom
     */
    public String getUtilisateurNom() {
        return utilisateurNom;
    }

    /**
     * Affecte utilisateurNom
     * 
     * @param utilisateurNom utilisateurNom à affecter
     */
    public void setUtilisateurNom(String utilisateurNom) {
        this.utilisateurNom = utilisateurNom;
    }

    /**
     * Retourne utilisateurPrenom
     * 
     * @return utilisateurPrenom
     */
    public String getUtilisateurPrenom() {
        return utilisateurPrenom;
    }

    /**
     * Affecte utilisateurPrenom
     * 
     * @param utilisateurPrenom utilisateurPrenom à affecter
     */
    public void setUtilisateurPrenom(String utilisateurPrenom) {
        this.utilisateurPrenom = utilisateurPrenom;
    }

    /**
     * Retourne utilisateurEmail
     * 
     * @return utilisateurEmail
     */
    public String getUtilisateurEmail() {
        return utilisateurEmail;
    }

    /**
     * Affecte utilisateurEmail
     * 
     * @param utilisateurEmail utilisateurEmail à affecter
     */
    public void setUtilisateurEmail(String utilisateurEmail) {
        this.utilisateurEmail = utilisateurEmail;
    }

    /**
     * Retourne utilisateurLogin
     * 
     * @return utilisateurLogin
     */
    public String getUtilisateurLogin() {
        return utilisateurLogin;
    }

    /**
     * Affecte utilisateurLogin
     * 
     * @param utilisateurLogin utilisateurLogin à affecter
     */
    public void setUtilisateurLogin(String utilisateurLogin) {
        this.utilisateurLogin = utilisateurLogin;
    }

    /**
     * Retourne utilisateurMdp
     * 
     * @return utilisateurMdp
     */
    public String getUtilisateurMdp() {
        return utilisateurMdp;
    }

    /**
     * Affecte utilisateurMdp
     * 
     * @param utilisateurMdp utilisateurMdp à affecter
     */
    public void setUtilisateurMdp(String utilisateurMdp) {
        this.utilisateurMdp = utilisateurMdp;
    }

    /**
     * Retourne utilisateurMdpConfirmation
     * 
     * @return utilisateurMdpConfirmation
     */
    public String getUtilisateurMdpConfirmation() {
        return utilisateurMdpConfirmation;
    }

    /**
     * Affecte utilisateurMdpConfirmation
     * 
     * @param utilisateurMdpConfirmation utilisateurMdpConfirmation à affecter
     */
    public void setUtilisateurMdpConfirmation(String utilisateurMdpConfirmation) {
        this.utilisateurMdpConfirmation = utilisateurMdpConfirmation;
    }

    /**
     * Retourne listeRoles
     * 
     * @return listeRoles
     */
    public List<SelectItem> getListeRoles() {
        return listeRoles;
    }

    /**
     * Affecte listeRoles
     * 
     * @param listeRoles listeRoles à affecter
     */
    public void setListeRoles(List<SelectItem> listeRoles) {
        this.listeRoles = listeRoles;
    }

    /**
     * Retourne listeNiveaux
     * 
     * @return listeNiveaux
     */
    public List<SelectItem> getListeNiveaux() {
        return listeNiveaux;
    }

    /**
     * Affecte listeNiveaux
     * 
     * @param listeNiveaux listeNiveaux à affecter
     */
    public void setListeNiveaux(List<SelectItem> listeNiveaux) {
        this.listeNiveaux = listeNiveaux;
    }

    /**
     * Retourne roleSelectionne
     * 
     * @return roleSelectionne
     */
    public String getRoleSelectionne() {
        return roleSelectionne;
    }

    /**
     * Affecte roleSelectionne
     * 
     * @param roleSelectionne roleSelectionne à affecter
     */
    public void setRoleSelectionne(String roleSelectionne) {
        this.roleSelectionne = roleSelectionne;
    }

    /**
     * Retourne niveauSelectionne
     * 
     * @return niveauSelectionne
     */
    public String getNiveauSelectionne() {
        return niveauSelectionne;
    }

    /**
     * Affecte niveauSelectionne
     * 
     * @param niveauSelectionne niveauSelectionne à affecter
     */
    public void setNiveauSelectionne(String niveauSelectionne) {
        this.niveauSelectionne = niveauSelectionne;
    }

    /**
     * Retourne utilisateurActif
     * 
     * @return utilisateurActif
     */
    public boolean isUtilisateurActif() {
        return utilisateurActif;
    }

    /**
     * Affecte utilisateurActif
     * 
     * @param utilisateurActif utilisateurActif à affecter
     */
    public void setUtilisateurActif(boolean utilisateurActif) {
        this.utilisateurActif = utilisateurActif;
    }

    // ===== Classes imbriquées ===============================================
    public class Utilisateur {

        private int idUtilisateur;

        private String login;

        private String password;

        private String prenom;

        private String nom;

        private String email;

        private String role;

        private String niveau;

        private Date dateCreation;

        private boolean actif;

        /**
         * Ajout d'un nouvel utilisateur
         * 
         * @param idUtilisateur id de l'utilisateur
         * @param login Login de l'utilisateur
         * @param password Le mot de passe de l'utilisateur
         * @param prenom Le prénom de l'utilisateur
         * @param nom Le nom de l'utilisateur
         * @param email L'email de l'utilisateur
         * @param role Le rôle de l'utilisateur
         * @param niveau Le niveau de l'utilisateur
         * @param dateCreation La date de création de l'utilisateur
         * @param actif Indique si l'utilisateur est actif
         */
        public Utilisateur(int idUtilisateur, String login, String password, String prenom,
                String nom, String email, String role, String niveau, Date dateCreation,
                boolean actif) {
            super();
            this.idUtilisateur = idUtilisateur;
            this.login = login;
            this.password = password;
            this.prenom = prenom;
            this.nom = nom;
            this.email = email;
            this.role = role;
            this.niveau = niveau;
            this.dateCreation = dateCreation;
            this.actif = actif;
        }

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
         * Retourne dateCreation
         * 
         * @return dateCreation
         */
        public Date getDateCreation() {
            return dateCreation;
        }

        /**
         * Affecte dateCreation
         * 
         * @param dateCreation dateCreation à affecter
         */
        public void setDateCreation(Date dateCreation) {
            this.dateCreation = dateCreation;
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

    }
}

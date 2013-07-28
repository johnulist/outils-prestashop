package fr.upyourbizz.web.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientDto {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(ClientDto.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private int idClient;

    private String societeNom = "";

    private String siret = "";

    private String formeJuridique = "";

    private Float tvaIntercommunautaire = 0F;

    private String telephoneFixe = "";

    private String dirigeantNom = "";

    private String dirigeantPrenom = "";

    private String adresse = "";

    private String ville = "";

    private String codePostal = "";

    private String secteurActiviteSelectionne = "";

    private String contactNom = "";

    private String contactPrenom = "";

    private String contactFonction = "";

    private String contactTelephoneFixe = "";

    private String contactTelephonePortable = "";

    private String contactEmail = "";

    private String commentaire = "";

    private String urlImg = "";

    /**
     * @param idClient L'id du client
     * @param societeNom
     * @param siret
     * @param formeJuridique
     * @param tvaIntercommunautaire
     * @param telephoneFixe
     * @param dirigeantNom
     * @param dirigeantPrenom
     * @param adresse
     * @param ville
     * @param codePostal
     * @param secteurActiviteSelectionne
     * @param contactNom
     * @param contactPrenom
     * @param contactFonction
     * @param contactTelephoneFixe
     * @param contactTelephonePortable
     * @param contactEmail
     * @param commentaire
     * @param urlImg
     */
    public ClientDto(int idClient, String societeNom, String siret, String formeJuridique,
            Float tvaIntercommunautaire, String telephoneFixe, String dirigeantNom,
            String dirigeantPrenom, String adresse, String ville, String codePostal,
            String secteurActiviteSelectionne, String contactNom, String contactPrenom,
            String contactFonction, String contactTelephoneFixe, String contactTelephonePortable,
            String contactEmail, String commentaire, String urlImg) {
        super();
        this.idClient = idClient;
        this.societeNom = societeNom;
        this.siret = siret;
        this.formeJuridique = formeJuridique;
        this.tvaIntercommunautaire = tvaIntercommunautaire;
        this.telephoneFixe = telephoneFixe;
        this.dirigeantNom = dirigeantNom;
        this.dirigeantPrenom = dirigeantPrenom;
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
        this.secteurActiviteSelectionne = secteurActiviteSelectionne;
        this.contactNom = contactNom;
        this.contactPrenom = contactPrenom;
        this.contactFonction = contactFonction;
        this.contactTelephoneFixe = contactTelephoneFixe;
        this.contactTelephonePortable = contactTelephonePortable;
        this.contactEmail = contactEmail;
        this.commentaire = commentaire;
        this.urlImg = urlImg;
    }

    /**
     * @param societeNom
     * @param ville
     * @param secteurActiviteSelectionne
     */
    public ClientDto(String societeNom, String ville, String secteurActiviteSelectionne) {
        super();
        this.societeNom = societeNom;
        this.ville = ville;
        this.secteurActiviteSelectionne = secteurActiviteSelectionne;
    }

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    // ===== Accesseurs =======================================================

    /**
     * Retourne idClient
     * 
     * @return idClient
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * Affecte idClient
     * 
     * @param idClient idClient à affecter
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    /**
     * Retourne societeNom
     * 
     * @return societeNom
     */
    public String getSocieteNom() {
        return societeNom;
    }

    /**
     * Affecte societeNom
     * 
     * @param societeNom societeNom à affecter
     */
    public void setSocieteNom(String societeNom) {
        this.societeNom = societeNom;
    }

    /**
     * Retourne siret
     * 
     * @return siret
     */
    public String getSiret() {
        return siret;
    }

    /**
     * Affecte siret
     * 
     * @param siret siret à affecter
     */
    public void setSiret(String siret) {
        this.siret = siret;
    }

    /**
     * Retourne formeJuridique
     * 
     * @return formeJuridique
     */
    public String getFormeJuridique() {
        return formeJuridique;
    }

    /**
     * Affecte formeJuridique
     * 
     * @param formeJuridique formeJuridique à affecter
     */
    public void setFormeJuridique(String formeJuridique) {
        this.formeJuridique = formeJuridique;
    }

    /**
     * Retourne tvaIntercommunautaire
     * 
     * @return tvaIntercommunautaire
     */
    public Float getTvaIntercommunautaire() {
        return tvaIntercommunautaire;
    }

    /**
     * Affecte tvaIntercommunautaire
     * 
     * @param tvaIntercommunautaire tvaIntercommunautaire à affecter
     */
    public void setTvaIntercommunautaire(Float tvaIntercommunautaire) {
        this.tvaIntercommunautaire = tvaIntercommunautaire;
    }

    /**
     * Retourne telephoneFixe
     * 
     * @return telephoneFixe
     */
    public String getTelephoneFixe() {
        return telephoneFixe;
    }

    /**
     * Affecte telephoneFixe
     * 
     * @param telephoneFixe telephoneFixe à affecter
     */
    public void setTelephoneFixe(String telephoneFixe) {
        this.telephoneFixe = telephoneFixe;
    }

    /**
     * Retourne dirigeantNom
     * 
     * @return dirigeantNom
     */
    public String getDirigeantNom() {
        return dirigeantNom;
    }

    /**
     * Affecte dirigeantNom
     * 
     * @param dirigeantNom dirigeantNom à affecter
     */
    public void setDirigeantNom(String dirigeantNom) {
        this.dirigeantNom = dirigeantNom;
    }

    /**
     * Retourne dirigeantPrenom
     * 
     * @return dirigeantPrenom
     */
    public String getDirigeantPrenom() {
        return dirigeantPrenom;
    }

    /**
     * Affecte dirigeantPrenom
     * 
     * @param dirigeantPrenom dirigeantPrenom à affecter
     */
    public void setDirigeantPrenom(String dirigeantPrenom) {
        this.dirigeantPrenom = dirigeantPrenom;
    }

    /**
     * Retourne adresse
     * 
     * @return adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Affecte adresse
     * 
     * @param adresse adresse à affecter
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * Retourne ville
     * 
     * @return ville
     */
    public String getVille() {
        return ville;
    }

    /**
     * Affecte ville
     * 
     * @param ville ville à affecter
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    /**
     * Retourne codePostal
     * 
     * @return codePostal
     */
    public String getCodePostal() {
        return codePostal;
    }

    /**
     * Affecte codePostal
     * 
     * @param codePostal codePostal à affecter
     */
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    /**
     * Retourne secteurActiviteSelectionne
     * 
     * @return secteurActiviteSelectionne
     */
    public String getSecteurActiviteSelectionne() {
        return secteurActiviteSelectionne;
    }

    /**
     * Affecte secteurActiviteSelectionne
     * 
     * @param secteurActiviteSelectionne secteurActiviteSelectionne à affecter
     */
    public void setSecteurActiviteSelectionne(String secteurActiviteSelectionne) {
        this.secteurActiviteSelectionne = secteurActiviteSelectionne;
    }

    /**
     * Retourne contactNom
     * 
     * @return contactNom
     */
    public String getContactNom() {
        return contactNom;
    }

    /**
     * Affecte contactNom
     * 
     * @param contactNom contactNom à affecter
     */
    public void setContactNom(String contactNom) {
        this.contactNom = contactNom;
    }

    /**
     * Retourne contactPrenom
     * 
     * @return contactPrenom
     */
    public String getContactPrenom() {
        return contactPrenom;
    }

    /**
     * Affecte contactPrenom
     * 
     * @param contactPrenom contactPrenom à affecter
     */
    public void setContactPrenom(String contactPrenom) {
        this.contactPrenom = contactPrenom;
    }

    /**
     * Retourne contactFonction
     * 
     * @return contactFonction
     */
    public String getContactFonction() {
        return contactFonction;
    }

    /**
     * Affecte contactFonction
     * 
     * @param contactFonction contactFonction à affecter
     */
    public void setContactFonction(String contactFonction) {
        this.contactFonction = contactFonction;
    }

    /**
     * Retourne contactTelephoneFixe
     * 
     * @return contactTelephoneFixe
     */
    public String getContactTelephoneFixe() {
        return contactTelephoneFixe;
    }

    /**
     * Affecte contactTelephoneFixe
     * 
     * @param contactTelephoneFixe contactTelephoneFixe à affecter
     */
    public void setContactTelephoneFixe(String contactTelephoneFixe) {
        this.contactTelephoneFixe = contactTelephoneFixe;
    }

    /**
     * Retourne contactTelephonePortable
     * 
     * @return contactTelephonePortable
     */
    public String getContactTelephonePortable() {
        return contactTelephonePortable;
    }

    /**
     * Affecte contactTelephonePortable
     * 
     * @param contactTelephonePortable contactTelephonePortable à affecter
     */
    public void setContactTelephonePortable(String contactTelephonePortable) {
        this.contactTelephonePortable = contactTelephonePortable;
    }

    /**
     * Retourne contactEmail
     * 
     * @return contactEmail
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     * Affecte contactEmail
     * 
     * @param contactEmail contactEmail à affecter
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
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
     * Retourne urlImg
     * 
     * @return urlImg
     */
    public String getUrlImg() {
        return urlImg;
    }

    /**
     * Affecte urlImg
     * 
     * @param urlImg urlImg à affecter
     */
    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    // ===== Classes imbriquées ===============================================
}

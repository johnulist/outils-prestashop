package fr.upyourbizz.web.dto;

public class EtatPacDto {

    // ===== Attributs statiques ==============================================

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private int idEtatPac;

    private String etatPAc;

    // ===== Constructeurs ====================================================

    public EtatPacDto(int idEtatPac, String etatPAc) {
        super();
        this.idEtatPac = idEtatPac;
        this.etatPAc = etatPAc;
    }

    // ===== Méthodes =========================================================

    // ===== Accesseurs =======================================================

    /**
     * Retourne idEtatPac
     * 
     * @return idEtatPac
     */
    public int getIdEtatPac() {
        return idEtatPac;
    }

    /**
     * Affecte idEtatPac
     * 
     * @param idEtatPac idEtatPac à affecter
     */
    public void setIdEtatPac(int idEtatPac) {
        this.idEtatPac = idEtatPac;
    }

    /**
     * Retourne etatPAc
     * 
     * @return etatPAc
     */
    public String getEtatPAc() {
        return etatPAc;
    }

    /**
     * Affecte etatPAc
     * 
     * @param etatPAc etatPAc à affecter
     */
    public void setEtatPAc(String etatPAc) {
        this.etatPAc = etatPAc;
    }

    // ===== Classes imbriquées ===============================================
}

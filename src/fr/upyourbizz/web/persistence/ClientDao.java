package fr.upyourbizz.web.persistence;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClientDao
 */
public class ClientDao {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(ClientDao.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private DataSource ds;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    // TODO Corps de classe auto-généré

    // ===== Accesseurs =======================================================

    /**
     * Affecte ds
     * 
     * @param ds ds à affecter
     */
    public void setDs(DataSource ds) {
        this.ds = ds;
    }

    // ===== Classes imbriquées ===============================================
}

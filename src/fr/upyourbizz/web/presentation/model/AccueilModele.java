package fr.upyourbizz.web.presentation.model;

import java.io.Serializable;

import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class AccueilModele implements Serializable {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(AccueilModele.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private DashboardModel model;

    // ===== Constructeurs ====================================================

    // ===== Méthodes =========================================================

    /**
     * Constructeur
     */
    public AccueilModele() {
        model = new DefaultDashboardModel();
        DashboardColumn column1 = new DefaultDashboardColumn();
        DashboardColumn column2 = new DefaultDashboardColumn();

        column1.addWidget("administration");
        column1.addWidget("production");
        column1.addWidget("ventes");

        column2.addWidget("commercial");
        column2.addWidget("communication");

        model.addColumn(column1);
        model.addColumn(column2);
    }

    // ===== Accesseurs =======================================================

    /**
     * Retourne model
     * 
     * @return model
     */
    public DashboardModel getModel() {
        return model;
    }

    /**
     * Affecte model
     * 
     * @param model model à affecter
     */
    public void setModel(DashboardModel model) {
        this.model = model;
    }

    // ===== Classes imbriquées ===============================================
}

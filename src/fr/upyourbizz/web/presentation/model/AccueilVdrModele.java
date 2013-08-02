package fr.upyourbizz.web.presentation.model;

import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.upyourbizz.web.dto.AnnonceDto;
import fr.upyourbizz.web.dto.DerniereVenteDto;
import fr.upyourbizz.web.dto.HistoClientDto;
import fr.upyourbizz.web.dto.StatistiquesDto;

@Component
@Scope("session")
public class AccueilVdrModele {

    // ===== Attributs statiques ==============================================

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(AccueilVdrModele.class);

    // ===== Méthodes statiques ===============================================

    // ===== Attributs ========================================================

    private DashboardModel model;

    private final List<AnnonceDto> listeAnnonces;

    private final List<HistoClientDto> listeHistoClient;

    private final List<StatistiquesDto> listeStatistiques;

    private List<DerniereVenteDto> listeDerniereVentes;

    // ===== Constructeurs ====================================================

    /**
     * Constructeur
     */
    public AccueilVdrModele() {
        model = new DefaultDashboardModel();
        DashboardColumn column1 = new DefaultDashboardColumn();
        DashboardColumn column2 = new DefaultDashboardColumn();

        column1.addWidget("annonces");
        column1.addWidget("histoRchCli");
        column1.addWidget("navigation");

        column2.addWidget("dernieresVentes");
        column2.addWidget("produitsFav");
        column2.addWidget("statistiques");

        model.addColumn(column1);
        model.addColumn(column2);

        listeAnnonces = new ArrayList<AnnonceDto>();
        listeHistoClient = new ArrayList<HistoClientDto>();
        listeStatistiques = new ArrayList<StatistiquesDto>();
        listeDerniereVentes = new ArrayList<DerniereVenteDto>();
    }

    // ===== Méthodes =========================================================

    // ===== Accesseurs =======================================================

    /**
     * Retourne listeHistoClient
     * 
     * @return listeHistoClient
     */
    public List<HistoClientDto> getListeHistoClient() {
        return listeHistoClient;
    }

    /**
     * Retourne listeStatistiques
     * 
     * @return listeStatistiques
     */
    public List<StatistiquesDto> getListeStatistiques() {
        return listeStatistiques;
    }

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

    /**
     * Retourne listeAnnonces
     * 
     * @return listeAnnonces
     */
    public List<AnnonceDto> getListeAnnonces() {
        return listeAnnonces;
    }

    /**
     * Retourne listeDerniereVentes
     * 
     * @return listeDerniereVentes
     */
    public List<DerniereVenteDto> getListeDerniereVentes() {
        return listeDerniereVentes;
    }

    /**
     * Affecte listeDerniereVentes
     * 
     * @param listeDerniereVentes listeDerniereVentes à affecter
     */
    public void setListeDerniereVentes(List<DerniereVenteDto> listeDerniereVentes) {
        this.listeDerniereVentes = listeDerniereVentes;
    }

    // ===== Classes imbriquées ===============================================
}

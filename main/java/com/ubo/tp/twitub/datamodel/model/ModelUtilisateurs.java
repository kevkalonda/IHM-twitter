package main.java.com.ubo.tp.twitub.datamodel.model;

import main.java.com.ubo.tp.twitub.component.Utilisateurs;
import main.java.com.ubo.tp.twitub.controller.HomeController;
import main.java.com.ubo.tp.twitub.controller.SearchController;
import main.java.com.ubo.tp.twitub.core.Twitub;

import javax.swing.*;

public class ModelUtilisateurs implements Observer{
    Utilisateurs utilisateurs;
    HomeController homeController;
    SearchController searchController;
    Session session;
    public ModelUtilisateurs(Session session, HomeController homeController, SearchController searchController){

        this.homeController = homeController;
        this.searchController = searchController;
        this.session = session;
        this.utilisateurs = new Utilisateurs(searchController.getUsers(), this.session, this.homeController, this.searchController);
    }



    public JPanel showUtilisateur(){

        return utilisateurs;
    }

    public void repaint() {
        utilisateurs.removeAll();
        this.utilisateurs.add(new Utilisateurs(searchController.getUsers(), session,this.homeController, this.searchController));
        this.utilisateurs.revalidate();
        this.utilisateurs.repaint();
    }

    /**
     * Mise à jour de la vue
     */
    @Override
    public void update() {
        this.repaint();
    }
}

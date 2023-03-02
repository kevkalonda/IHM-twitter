package main.java.com.ubo.tp.twitub.datamodel.model;

import main.java.com.ubo.tp.twitub.component.Home;

import main.java.com.ubo.tp.twitub.controller.HomeController;
import main.java.com.ubo.tp.twitub.controller.MesTwitsController;
import main.java.com.ubo.tp.twitub.controller.SearchController;
import main.java.com.ubo.tp.twitub.core.Twitub;

import javax.swing.*;

public class ModelHome implements Observer {

    Twitub twitub;
    Home home;
    HomeController homeController;
    SearchController searchController;

    public ModelHome(Twitub twitub, HomeController homeController, SearchController searchController) {
        this.home = new Home(twitub.getAllTwits(), twitub.getSession().getUser(), homeController, searchController);
        this.searchController = searchController;
        this.twitub = twitub;
        this.homeController = homeController;
    }

    /**
     *
     * @return {@link JPanel}
     */
    public JPanel showHome() {
        return home;
    }

    /**
     *
     */
    public void rafraichir() {
        home.removeAll();
        home.add(new Home(twitub.getAllTwits(), twitub.getSession().getUser(), homeController, searchController)) ;
        this.home.revalidate();
        this.home.repaint();
    }

    @Override
    public void update() {
        rafraichir();
    }
}

package main.java.com.ubo.tp.twitub.datamodel.model;

import main.java.com.ubo.tp.twitub.component.Home;
import main.java.com.ubo.tp.twitub.controller.MesTwitsController;
import main.java.com.ubo.tp.twitub.core.Twitub;

import javax.swing.*;

public class ModelHome implements Observer {

    Twitub twitub;
    Home home;
    MesTwitsController mesTwitsController;

    public ModelHome(Twitub twitub, MesTwitsController mesTwitsController) {
        this.home = new Home(twitub.getAllTwits(), twitub.getTagUser(), mesTwitsController);
        this.twitub = twitub;
        this.mesTwitsController = mesTwitsController;
    }

    public JPanel showHome() {
        return home;
    }

    public void rafraichir() {

        home.removeAll();
        home.add(new Home(twitub.getAllTwits(), twitub.getTagUser(), this.mesTwitsController)) ;
        this.home.revalidate();
        this.home.repaint();
    }

    @Override
    public void update() {
        rafraichir();
    }
}

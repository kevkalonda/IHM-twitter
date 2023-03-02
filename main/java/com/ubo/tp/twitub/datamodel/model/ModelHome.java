package main.java.com.ubo.tp.twitub.datamodel.model;

import main.java.com.ubo.tp.twitub.component.Home;
import main.java.com.ubo.tp.twitub.core.Twitub;

public class ModelHome implements Observer {

    Twitub twitub;

    Home home;

    public ModelHome(Twitub twitub) {
        this.home = new Home(twitub.getAllTwits(), twitub.getTagUser());
        this.twitub = twitub;
    }

    public Home showHome() {
        return home = new Home(twitub.getAllTwits(), twitub.getTagUser());
    }

    public void repaint() {
        this.twitub.getTwitubMainView().show(this.showHome());

    }

    @Override
    public void update() {
        repaint();
    }
}

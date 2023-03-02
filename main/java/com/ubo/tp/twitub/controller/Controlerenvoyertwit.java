package main.java.com.ubo.tp.twitub.controller;

import main.java.com.ubo.tp.twitub.datamodel.IDatabase;
import main.java.com.ubo.tp.twitub.datamodel.Twit;
import main.java.com.ubo.tp.twitub.datamodel.User;

public class Controlerenvoyertwit {
    IDatabase database;
    IController controller;
    User user;

    public Controlerenvoyertwit(IDatabase database, IController controller,User user) {
        this.database = database;
        this.controller = controller;
        this.user=user;
    }

    public void publier(String cpt) {
        Twit twit= new Twit(this.user,cpt);
        this.database.addTwit(twit);
        this.controller.showHome();
    }
}
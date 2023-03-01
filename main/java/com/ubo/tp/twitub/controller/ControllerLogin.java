package main.java.com.ubo.tp.twitub.controller;

import main.java.com.ubo.tp.twitub.datamodel.IDatabase;

public class ControllerLogin {
    IDatabase database;
    IController controller;

    public ControllerLogin(IDatabase database, IController controller) {
        this.database = database;
        this.controller = controller;
    }

    public void connexion(String cpt, String mdp) {

        if(cpt.length()>0 && mdp.length()>0){
            controller.showHome();
        }
    }
}

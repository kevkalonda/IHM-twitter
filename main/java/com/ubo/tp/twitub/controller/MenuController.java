package main.java.com.ubo.tp.twitub.controller;

import main.java.com.ubo.tp.twitub.datamodel.model.Session;

public class MenuController {

    IController controller;
    Session session;

    public MenuController(IController controller,Session session){
        this.controller = controller;
        this.session = session;
    }

    public Session getSession() {
        return session;
    }

    public void redirectInscription(){
        this.controller.showSignIn();
    }

    public void redirectConnexion(){
        this.controller.showLogin();
    }

    public void redirectProfil(){
        this.controller.showProfil();
    }
}

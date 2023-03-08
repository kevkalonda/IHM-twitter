package main.java.com.ubo.tp.twitub.controller;

import main.java.com.ubo.tp.twitub.core.EntityManager;
import main.java.com.ubo.tp.twitub.datamodel.IDatabase;
import main.java.com.ubo.tp.twitub.datamodel.User;
import main.java.com.ubo.tp.twitub.datamodel.model.Session;

public class ProfilController {
    EntityManager entityManager;
    IController controller;
    Session session;
    public ProfilController(EntityManager entityManager, IController controller, Session user){
        this.controller = controller;
        this.entityManager = entityManager;
        this.session =user;
    }

    public User getSession() {
        return this.session.getUser();
    }

    public void redirectAllTwit() {
        this.controller.showHome();
    }
}

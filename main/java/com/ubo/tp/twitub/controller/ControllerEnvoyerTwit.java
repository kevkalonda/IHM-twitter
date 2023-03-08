package main.java.com.ubo.tp.twitub.controller;

import main.java.com.ubo.tp.twitub.core.EntityManager;
import main.java.com.ubo.tp.twitub.datamodel.Twit;
import main.java.com.ubo.tp.twitub.datamodel.User;
import main.java.com.ubo.tp.twitub.datamodel.model.Session;

public class ControllerEnvoyerTwit {
    EntityManager entityManager;
    IController controller;
    Session session;

    public ControllerEnvoyerTwit(EntityManager entityManager, IController controller, Session session) {
        this.entityManager = entityManager;
        this.controller = controller;
        this.session = session;
    }

    public void publier(String texte) {
        Twit twit = new Twit(session.getUser(), texte);
        this.entityManager.sendTwit(twit);
        controller.showHome();
    }

    public void redirectAllTwits() {
        controller.showHome();
    }
}
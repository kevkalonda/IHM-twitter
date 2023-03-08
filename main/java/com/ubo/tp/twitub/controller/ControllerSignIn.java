package main.java.com.ubo.tp.twitub.controller;

import main.java.com.ubo.tp.twitub.core.EntityManager;
import main.java.com.ubo.tp.twitub.datamodel.IDatabase;
import main.java.com.ubo.tp.twitub.datamodel.User;

import javax.swing.*;
import java.util.HashSet;
import java.util.UUID;

public class ControllerSignIn {
    IController controller;
    EntityManager entityManager;
    IDatabase database;

    public ControllerSignIn(IController controller, EntityManager entityManager, IDatabase database) {
        this.controller = controller;
        this.entityManager = entityManager;
        this.database = database;
    }

    public void createUser(String sexe, String name, String prenom, String mail, String mdp, String login) {

        String tagName = login;
        User user = new User(UUID.randomUUID(), tagName, mdp, name, new HashSet<>(), "");
        user.setmMail(mail);
        user.setSexe(sexe);
        user.setmPrenom(prenom);
        if (!userExist(login)) {
            entityManager.sendUser(user);
            controller.showLogin();
        } else {
            //System.out.println("User exists");
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "OUPS, choisir un autre Tag !");

        }
    }

    private boolean userExist(String login) {
        for (User user : database.getUsers()) {
            if (user.getUserTag().equals(login)) {
                return true;
            }
        }
        return false;
    }
}

package main.java.com.ubo.tp.twitub.controller;

import main.java.com.ubo.tp.twitub.datamodel.IDatabase;
import main.java.com.ubo.tp.twitub.datamodel.User;
import main.java.com.ubo.tp.twitub.datamodel.model.ListTwits;
import main.java.com.ubo.tp.twitub.datamodel.model.ListUsers;
import main.java.com.ubo.tp.twitub.datamodel.model.Session;

import javax.swing.*;
import java.util.Set;

public class ControllerLogin {
    IDatabase database;
    IController controller;
    Session session;
    ListTwits listTwits;
    ListUsers listUsers;

    public ControllerLogin(IDatabase database, IController controller, Session session, ListTwits listTwits, ListUsers listUsers) {
        this.database = database;
        this.controller = controller;
        this.session = session;
        this.listTwits = listTwits;
        this.listUsers = listUsers;
    }

    public void connexion(String cpt, String mdp) {
        Set<User> allUser = database.getUsers();
        boolean connected = false;
        for (User user : allUser) {
            //System.out.println(mdp);
            if (user.getUserTag().equals(cpt) && user.getUserPassword().equals(mdp)) {
                //System.out.println(mdp);
                session.setUser(user);
                listTwits.setSession(this.session);
                listTwits.setTwitSet(this.database.getTwits());
                listUsers.setListUser(this.database.getUsers());
                controller.showUser();
                connected = true;
            }
        }
        if (!connected) {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Vérifiez votre Tag ou votre mot de passe ");

        }
    }
}

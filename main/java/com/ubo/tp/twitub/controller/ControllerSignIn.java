package main.java.com.ubo.tp.twitub.controller;

import main.java.com.ubo.tp.twitub.datamodel.Database;
import main.java.com.ubo.tp.twitub.datamodel.IDatabase;
import main.java.com.ubo.tp.twitub.datamodel.User;

import java.util.HashSet;
import java.util.UUID;

public class ControllerSignIn {
    IDatabase database;
    IController controller;

    public ControllerSignIn(IDatabase database, IController controller){
        this.database = database;
        this.controller = controller;
    }

    public void createUser(Object [] tab ){
        String tagName = "@"+tab[1].toString();
        User user = new User(UUID.randomUUID(), tagName, tab[4].toString(), tab[1].toString(),new HashSet<>(),"");
        user.setmMail(tab[3].toString());
        user.setSexe(tab[0].toString());
        user.setmPrenom(tab[2].toString());
        System.out.println(user);
        //database.addUser(user);
    }
}

package main.java.com.ubo.tp.twitub.controller;

import main.java.com.ubo.tp.twitub.datamodel.IDatabase;

public class ProfilController {
    IDatabase database;
    IController controller;

    public ProfilController(IDatabase database, IController controller){
        this.controller = controller;
        this.database = database;
    }
}

package main.java.com.ubo.tp.twitub.controller;

import main.java.com.ubo.tp.twitub.datamodel.IDatabase;
import main.java.com.ubo.tp.twitub.datamodel.Twit;
import main.java.com.ubo.tp.twitub.datamodel.User;
import main.java.com.ubo.tp.twitub.datamodel.model.ListTwits;
import main.java.com.ubo.tp.twitub.datamodel.model.ListUsers;
import main.java.com.ubo.tp.twitub.datamodel.model.Session;

import java.util.HashSet;
import java.util.Set;

public class SearchController {
    IController controller;
    IDatabase database;
    ListTwits listTwits;
    Session session;
    ListUsers listUsers;

    public SearchController(IController controller , IDatabase database, ListTwits listTwits, Session session, ListUsers listUsers){
        this.controller =controller;
        this.database = database;
        this.listTwits = listTwits;
        this.session = session;
        this.listUsers = listUsers;
    }

    public ListUsers getListUsers() {
        return listUsers;
    }

    public Set<Twit> getTwits(){
        return this.database.getTwits();
    }

    public Set<User> getUsers(){
        return this.database.getUsers();
    }

    public Session getSession() {
        return session;
    }

    /**
     *
     * @return
     */
    public ListTwits getListTwits() {
        return listTwits;
    }

    public void showResultRecherche(String tag){
        User userFind = database.findUserByTag(tag);
        if( userFind != null){
            Set<User> user = new HashSet<>();
            user.add(userFind);
            listUsers.setListUser(user);
        }else {
            listUsers.setListUser(new HashSet<>());
        }
        this.controller.showResultSearchUser();
    }

    public void showResultRechercheTwit(String tag){

        if(tag.charAt(0)=='@'){
            listTwits.setOptionRecherche(tag.substring(1));
            this.getTwitsWithUserTag();

        }else if(tag.charAt(0)=='#'){
            listTwits.setOptionRecherche(tag.substring(1));
            this.getTwitsWithTag();
        }else{
            listTwits.setOptionRecherche(tag);
            this.getTwitsWithUserTagAndTag();
        }
        this.controller.showResultSearchTwit();
    }

    public void getTwitsWithUserTag(){
        if(listTwits.getOptionRecherche().length() >0){
            Set<Twit> all = database.getTwitsWithUserTag(listTwits.getOptionRecherche());
            all.addAll(database.getTwitsByUserTag(listTwits.getOptionRecherche()));
            listTwits.setTwitSet(all);
        }
    }

    public void getTwitsWithTag(){
        if(listTwits.getOptionRecherche().length() >0){
            listTwits.setTwitSet(database.getTwitsWithTag(listTwits.getOptionRecherche()));
        }
    }

    public void getTwitsWithUserTagAndTag(){
        if(listTwits.getOptionRecherche().length() >0){
            Set<Twit> all = database.getTwitsWithUserTag(listTwits.getOptionRecherche());
            all.addAll(database.getTwitsWithTag(listTwits.getOptionRecherche()));
            listTwits.setTwitSet(all);
        }
    }


    public void redirectAddTwit() {
        this.controller.showAddTwit();
    }

    public void redirectMesTwits() {
        this.controller.showUser();
    }

    public void redirectHome() {
        this.controller.showHome();
    }

    public void redirectUsers() {
        this.controller.showUser();
    }
}

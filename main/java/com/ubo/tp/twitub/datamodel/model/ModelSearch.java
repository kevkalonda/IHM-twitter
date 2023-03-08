package main.java.com.ubo.tp.twitub.datamodel.model;

import main.java.com.ubo.tp.twitub.component.SearchResultTwits;
import main.java.com.ubo.tp.twitub.component.SearchResultUser;
import main.java.com.ubo.tp.twitub.controller.HomeController;
import main.java.com.ubo.tp.twitub.controller.SearchController;

import javax.swing.*;

public class ModelSearch implements Observer{

    SearchResultTwits searchResultTwits;
    SearchResultUser searchResultUser;
    SearchController searchController;
    HomeController homeController;
    ListTwits  listTwits;
    ListUsers listUsers;

    public ModelSearch (SearchController searchController, HomeController homeController){
        this.homeController = homeController;
        this.searchController = searchController;
        this.listTwits = searchController.getListTwits();
        this.listUsers = searchController.getListUsers();
        this.searchResultTwits = new SearchResultTwits(searchController.getTwits(),searchController.getSession().getUser(), searchController);
        this.searchResultUser = new SearchResultUser(searchController.getUsers(), searchController.getSession(), searchController, homeController);
    }

    public JPanel showResultTwits(){
        repaint();
        return this.searchResultTwits;
    }

    public JPanel showResultUsers(){
        repaintSearchUser();
        return this.searchResultUser;
    }

    public void repaintSearchUser(){
        if(listTwits.getSession() != null){
            searchResultUser.removeAll();
            searchResultUser.add(new SearchResultUser(listUsers.getListUser(),listTwits.getSession(),searchController, this.homeController));
            searchResultUser.validate();
            searchResultUser.repaint();
        }
    }

    public void repaint(){
        if(listTwits.getSession() != null){
            searchResultTwits.removeAll();
            searchResultTwits.add(new SearchResultTwits(listTwits.getTwitSet(),listTwits.getSession().getUser(), searchController));
            searchResultTwits.validate();
            searchResultTwits.repaint();
        }
    }


    @Override
    public void update() {
        this.repaint();
    }
}

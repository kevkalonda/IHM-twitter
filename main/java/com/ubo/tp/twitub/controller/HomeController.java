package main.java.com.ubo.tp.twitub.controller;

import main.java.com.ubo.tp.twitub.core.Twitub;
import main.java.com.ubo.tp.twitub.datamodel.IDatabase;
import main.java.com.ubo.tp.twitub.datamodel.IDatabaseObserver;
import main.java.com.ubo.tp.twitub.datamodel.Twit;
import main.java.com.ubo.tp.twitub.datamodel.User;
import main.java.com.ubo.tp.twitub.datamodel.model.Observable;
import main.java.com.ubo.tp.twitub.datamodel.model.Observer;

import java.util.HashSet;
import java.util.Set;


public class HomeController implements IDatabaseObserver, Observable {

    Set<Observer> observers;


    public HomeController() {
        observers = new HashSet<>();

    }


    /**
     * Notification lorsqu'un Twit est ajouté en base de données.
     *
     * @param addedTwit
     */
    @Override
    public void notifyTwitAdded(Twit addedTwit) {
        System.out.println("ouiiiii add");
        notifyObservers();
    }

    /**
     * Notification lorsqu'un Twit est supprimé de la base de données.
     *
     * @param deletedTwit
     */
    @Override
    public void notifyTwitDeleted(Twit deletedTwit) {
        notifyObservers();
    }

    /**
     * Notification lorsqu'un Twit est modifié en base de données.
     *
     * @param modifiedTwit
     */
    @Override
    public void notifyTwitModified(Twit modifiedTwit) {
        notifyObservers();
    }

    /**
     * Notification lorsqu'un utilisateur est ajouté en base de données.
     *
     * @param addedUser
     */
    @Override
    public void notifyUserAdded(User addedUser) {
        notifyObservers();
    }

    /**
     * Notification lorsqu'un utilisateur est supprimé de la base de données.
     *
     * @param deletedUser
     */
    @Override
    public void notifyUserDeleted(User deletedUser) {
        notifyObservers();
    }

    /**
     * Notification lorsqu'un utilisateur est modifié en base de données.
     *
     * @param modifiedUser
     */
    @Override
    public void notifyUserModified(User modifiedUser) {
        notifyObservers();
    }

    /**
     * @param observer
     */
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * @param observer
     */
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     *
     */
    @Override
    public void notifyObservers() {
        for(Observer observer : this.observers){
            observer.update();
        }
    }
}

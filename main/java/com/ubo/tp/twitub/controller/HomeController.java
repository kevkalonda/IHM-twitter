package main.java.com.ubo.tp.twitub.controller;

import main.java.com.ubo.tp.twitub.datamodel.IDatabaseObserver;
import main.java.com.ubo.tp.twitub.datamodel.Twit;
import main.java.com.ubo.tp.twitub.datamodel.User;

import java.util.Set;


public class HomeController implements IDatabaseObserver {

    Set<Twit> twitList;
    Set<User> userList;
    User user;
    IController controller;

    public Set<Twit> getTwitList() {
        return twitList;
    }

    public Set<User> getUserList() {
        return userList;
    }

    public HomeController(Set<Twit> twitList, Set<User> userList, User user, IController controller) {
        this.twitList = twitList;
        this.userList = userList;
        this.user = user;
        this.controller = controller;
    }

    /**
     * Notification lorsqu'un Twit est ajouté en base de données.
     *
     * @param addedTwit
     */
    @Override
    public void notifyTwitAdded(Twit addedTwit) {
        System.out.println("ouiiiii add");
        twitList.add(addedTwit);
    }

    /**
     * Notification lorsqu'un Twit est supprimé de la base de données.
     *
     * @param deletedTwit
     */
    @Override
    public void notifyTwitDeleted(Twit deletedTwit) {
        twitList.remove(deletedTwit);
    }

    /**
     * Notification lorsqu'un Twit est modifié en base de données.
     *
     * @param modifiedTwit
     */
    @Override
    public void notifyTwitModified(Twit modifiedTwit) {
        if (twitList.contains(modifiedTwit)) {
            twitList.add(modifiedTwit);
        }
    }

    /**
     * Notification lorsqu'un utilisateur est ajouté en base de données.
     *
     * @param addedUser
     */
    @Override
    public void notifyUserAdded(User addedUser) {
        userList.add(addedUser);
    }

    /**
     * Notification lorsqu'un utilisateur est supprimé de la base de données.
     *
     * @param deletedUser
     */
    @Override
    public void notifyUserDeleted(User deletedUser) {
        userList.remove(deletedUser);
    }

    /**
     * Notification lorsqu'un utilisateur est modifié en base de données.
     *
     * @param modifiedUser
     */
    @Override
    public void notifyUserModified(User modifiedUser) {
        if (userList.contains(modifiedUser)) {
            userList.add(modifiedUser);
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

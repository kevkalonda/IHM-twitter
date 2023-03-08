package main.java.com.ubo.tp.twitub.datamodel.model;

import main.java.com.ubo.tp.twitub.datamodel.Twit;

import java.util.HashSet;
import java.util.Set;

public class ListTwits {
    String optionRecherche;
    Set<Twit> twitSet;
    Session session;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String getOptionRecherche() {
        return optionRecherche;
    }

    public void setOptionRecherche(String optionRecherche) {
        this.optionRecherche = optionRecherche;
    }

    public void setTwitSet(Set<Twit> twitSet) {
        this.twitSet = twitSet;
    }

    public Set<Twit> getTwitSet() {
        return twitSet;
    }

    public void reload(){
        this.optionRecherche ="";
        this.twitSet = new HashSet<>();
    }
}

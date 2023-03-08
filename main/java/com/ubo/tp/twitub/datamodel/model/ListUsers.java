package main.java.com.ubo.tp.twitub.datamodel.model;

import main.java.com.ubo.tp.twitub.datamodel.User;

import java.util.HashSet;
import java.util.Set;

public class ListUsers {
    Set<User> listUser;

    public  ListUsers(){
        listUser = new HashSet<>();
    }

    public Set<User> getListUser() {
        return listUser;
    }

    public void setListUser(Set<User> listUser) {
        this.listUser = listUser;
    }
}

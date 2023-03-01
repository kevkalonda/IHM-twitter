package main.java.com.ubo.tp.twitub.events.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Handler implements ActionListener {
    /**
     * Invoked when an action occurs.
     *
     * @param event {@link ActionEvent}
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println(  event.getSource() + " cliqué !");
    }
}

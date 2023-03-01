package main.java.com.ubo.tp.twitub.component;

import main.java.com.ubo.tp.twitub.datamodel.Twit;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class MesTwits extends JScrollPane {
    Set<Twit> listTwit;
    public MesTwits(Set<Twit> listTwit){
        this.listTwit= listTwit;
        JScrollPane pane = new JScrollPane();
        JPanel  panel= new JPanel();

        //Spécifier la position et la taille du JPanel
        panel.setLayout(new GridBagLayout());
        int compteur = 4;

        for(Twit twit : listTwit){
            JPanel  panelTwit = new JPanel();
            panel.setLayout(new GridBagLayout());
            boolean isActive = false;
            panelTwit.setBackground(Color.lightGray);

            JTextArea  text = new JTextArea (250, 200);
            text.setEditable(isActive);
            text.append(twit.getText());

            JLabel label = new JLabel(twit.getTwiter().getUserTag());

            JButton suivre = createButton("Modifier");
            suivre.setBackground(Color.blue);
            suivre.setForeground(Color.white);
/*
            panelTwit.add(label, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
                    GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
            panelTwit.add(text, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
                    GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
            panelTwit.add(suivre, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
                    GridBagConstraints.NONE, new Insets(0, 0, 50, 0), 0, 15));

            panel.add(panelTwit, new GridBagConstraints(1, compteur, 0, 0, 0, 0, GridBagConstraints.CENTER,
                    GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

            compteur++;*/
 /*
        wARDA
         */

            pane.add(label, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
                    GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 100));
            pane.add(text, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
                    GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 50));
        }

//
//        pane.add(panel, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.NONE,
//                GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        this.add(pane);
    }

    private JButton createButton(String name){
        JButton btn = new JButton(name);
        return btn;
    }
}

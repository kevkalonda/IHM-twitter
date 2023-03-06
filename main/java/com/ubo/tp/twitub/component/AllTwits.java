package main.java.com.ubo.tp.twitub.component;

import main.java.com.ubo.tp.twitub.datamodel.Twit;
import main.java.com.ubo.tp.twitub.datamodel.User;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.Set;

public class AllTwits extends JPanel {
    /**
     * Constructor
     *
     * @param listTwit {@link Set<Twit>}
     */
    JPanel panel;

    public AllTwits(Set<Twit> listTwit, User user) {
        JPanel  all= new JPanel();

         panel= new JPanel();
         panel.setLayout(new GridBagLayout());
        //Spécifier la position et la taille du JPanel
        //panel.setLayout(new GridBagLayout());
        int compteur = 1;
        System.out.println("Nombre de twits..."+listTwit.size());

        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int i = 1;
        if(listTwit.size() == 0){
            JLabel aucunTwit = new JLabel("Aucun twit");
            aucunTwit.setFont(new Font(aucunTwit.getName(), aucunTwit.getFont().getStyle(), 40));
            aucunTwit.setForeground(Color.red);
            panel.add(aucunTwit, new GridBagConstraints(0, i, 1, 1, 1, 1, GridBagConstraints.CENTER,
                    GridBagConstraints.NONE, new Insets(0, 0, 0, 0), (int) 0, 0));
        }
        for(Twit twit: listTwit){
            JPanel panel1 = new JPanel();
            panel1.setLayout(new GridBagLayout());
            panel1.setBorder(
                    BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE)
            );
            JLabel label = new JLabel(twit.getTwiter().getUserTag());
            JLabel tagUser = new JLabel(twit.getText());
            Date date = new Date(twit.getEmissionDate());
            JLabel twitter = new JLabel(date.toString());

            panel1.add(label, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
                    GridBagConstraints.NONE, new Insets(0, 0, 0, 0), (int) screenSize.getWidth() - 400, 5));
            panel1.add(tagUser, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
                    GridBagConstraints.NONE, new Insets(10, 0, 0, 0), (int) screenSize.getWidth() - 400, 5));
            panel1.add(twitter, new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.CENTER,
                    GridBagConstraints.NONE, new Insets(10, (int)screenSize.getWidth() - 380, 0, 0), 0, 5));

            panel.add(panel1, new GridBagConstraints(0, i, 1, 1, 1, 1, GridBagConstraints.CENTER,
                    GridBagConstraints.NONE, new Insets(0, 0, 0, 0), (int) 0, 0));
            i++;
        }
        this.add(panel);
    }

    public boolean isFollow(Set<String> list, String tag){
        return list.contains(tag);
    }
    private JButton createButton(String name){
        JButton btn = new JButton(name);
        return btn;
    }
}

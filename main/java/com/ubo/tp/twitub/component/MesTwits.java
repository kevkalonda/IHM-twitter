package main.java.com.ubo.tp.twitub.component;

import main.java.com.ubo.tp.twitub.datamodel.Twit;
import main.java.com.ubo.tp.twitub.datamodel.User;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class MesTwits extends JPanel {
    Set<Twit> listTwit;
    public MesTwits(Set<Twit> listTwit, User user){
        this.listTwit = listTwit;
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        /**
         * here
         */
        AllTwits allTwits = new AllTwits(listTwit, user);
        allTwits.setBackground(Color.lightGray);
        allTwits.setBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE)
        );
        JButton suivre = createButton("Mes twit");
        suivre.setBackground(Color.blue);
        suivre.setForeground(Color.white);

        JLabel label = new JLabel( "Welcome ");
        label.setFont(new Font(label.getName(),label.getFont().getStyle(), 20));

        JLabel nom = new JLabel("Nom");
        label.setFont(new Font(nom.getName(),nom.getFont().getStyle(), 15));

        JLabel prenom = new JLabel("Prenom");
        prenom.setFont(new Font(prenom.getName(),prenom.getFont().getStyle(), 15));

        JLabel tag = new JLabel("@Nom");
        tag.setFont(new Font(tag.getName(),tag.getFont().getStyle(), 15));


        panel.add(label, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(0, 0, 25, 0), (int) 0, 0));
        panel.add(tag, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(0, 250, 25, 0), (int) 0, 0));
        panel.add(nom, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(0, 0, 10, 0), (int) 0, 0));
        panel.add(prenom, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(0, 250, 10, 0), (int) 0, 0));
        panel.add(suivre, new GridBagConstraints(0, 3, 2, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(0, 0, 10, 0), (int) 0, 0));
        panel.add(allTwits, new GridBagConstraints(0, 4, 2, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(0, 0, 10, 0), (int) 0, 0));

        this.add(panel);
    }

    private JButton createButton(String name){
        JButton btn = new JButton(name);
        return btn;
    }
}

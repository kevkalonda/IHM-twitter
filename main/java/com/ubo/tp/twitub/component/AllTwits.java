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
        JPanel all = new JPanel();

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.white);


        int compteur = 1;
        System.out.println("Nombre de twits..." + listTwit.size());

        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int i = 1;
        if(listTwit.size() == 0){
            JLabel aucunTwit = new JLabel("Aucun Twit trouvé");
            aucunTwit.setFont(new Font("Calibri", Font.BOLD, 40));
            aucunTwit.setForeground(Color.red);
            panel.add(aucunTwit, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
                    GridBagConstraints.CENTER, new Insets(2, 0, 1, 0), 0, 0));
        }
        for (Twit twit : listTwit) {
            JPanel panel1 = new JPanel();
            panel1.setLayout(new GridBagLayout());
            panel1.setBorder(
                    BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 255, 90))
            );
            JLabel userLabel = new JLabel("@" + twit.getTwiter().getUserTag());
            userLabel.setForeground(new Color(0, 0, 255, 110));
            userLabel.setFont(new Font(userLabel.getName(), userLabel.getFont().getStyle(), 16));
            //JLabel twitLabel = new JLabel(twit.getText());
            JTextArea twitLabel = new JTextArea(twit.getText());
            twitLabel.setEditable(false);
            twitLabel.setLineWrap(true);
            twitLabel.setWrapStyleWord(true);
            twitLabel.setBackground(Color.white);
            twitLabel.setBorder(
                    BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 255, 5))
            );

            Date date = new Date(twit.getEmissionDate());
            JLabel dateLabel = new JLabel(date.toString());
            dateLabel.setForeground(new Color(0, 0, 255, 80));
            panel1.setBackground(Color.white);

            panel1.add(userLabel, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
                    GridBagConstraints.BOTH, new Insets(0, 10, 0, 0), 10, 5));
            panel1.add(twitLabel, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.WEST,
                    GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));
            /**
             * renomer la variable de dateLabel
             * la ligne suivante est à remplacer
             */
            dateLabel.setHorizontalAlignment(JLabel.RIGHT);
            panel1.add(dateLabel, new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.EAST,
                    GridBagConstraints.BOTH, new Insets(10, 0, 0, 10), 0, 5));

            panel.add(panel1, new GridBagConstraints(0, i, 1, 1, 1, 1, GridBagConstraints.CENTER,
                    GridBagConstraints.HORIZONTAL, new Insets(2, 0, 1, 0), 0, 0));
            i++;
        }
        this.setLayout(new GridBagLayout());
        this.add(panel, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(0, 0, 1, 0), 0, 0));
    }
}
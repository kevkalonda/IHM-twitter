package main.java.com.ubo.tp.twitub.component;

import main.java.com.ubo.tp.twitub.datamodel.Twit;
import main.java.com.ubo.tp.twitub.datamodel.User;

import javax.swing.*;
import java.awt.*;
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
        //Spécifier la position et la taille du JPanel
        panel.setLayout(new GridBagLayout());
        int compteur = 1;
        System.out.println("Nombre de twits..."+listTwit.size());
        for(Twit twit : listTwit){
            JPanel  panelTwit = new JPanel();
            panelTwit.setBackground(Color.lightGray);
            panel.setBorder(
                    BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE)
            );

            JTextArea  text = new JTextArea (250, 200);
            text.setFont(new Font("Serif", Font.PLAIN, 17));
            text.setLineWrap(true);
            text.setWrapStyleWord(false);
            text.setEditable(false);
            text.append("Mes twits..."+twit.getText());
            System.out.println("Mes twits..."+twit.getText());

            JLabel label = new JLabel(twit.getTwiter().getUserTag());

            JButton suivre = createButton("suivre");
            suivre.setBackground(Color.blue);
            suivre.setForeground(Color.white);

//            panelTwit.add(label, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
//                    GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
//            panelTwit.add(text, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
//                    GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
//            if(isFollow(user.getFollows(), twit.getTwiter().getUserTag())){
//                panelTwit.add(suivre, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
//                        GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
//            }
//
//            all.add(panelTwit, new GridBagConstraints(1, compteur, 0, 0, 0, 0, GridBagConstraints.CENTER,
//                    GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
            //            compteur++;
            panel.add(text);

        }
        this.add(panel);


//        JScrollPane panelScroll = new JScrollPane(all);
//        this.add(panelScroll, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.NONE,
//                GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    }

    public boolean isFollow(Set<String> list, String tag){
        return list.contains(tag);
    }
    private JButton createButton(String name){
        JButton btn = new JButton(name);
        return btn;
    }
}

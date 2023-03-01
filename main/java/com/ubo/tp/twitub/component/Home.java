package main.java.com.ubo.tp.twitub.component;

import main.java.com.ubo.tp.twitub.controller.HomeController;

import javax.swing.*;
import java.awt.*;

public class Home extends JPanel {
    HomeController homeController;
    public Home(HomeController homeController){
        this.homeController = homeController;

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
/**
 * here
 */
        AllTwits allTwits = new AllTwits(homeController.getTwitList(), homeController.getUser());
        allTwits.setBackground(Color.lightGray);
        allTwits.setBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE)
        );
        JButton suivre = createButton("Mes twit");
        suivre.setBackground(Color.blue);
        suivre.setForeground(Color.white);

        panel.add(allTwits,new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(0, 0, 100, 0), 0, 0));
        panel.add(suivre,new GridBagConstraints(1, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        this.add(panel);
    }

    private JButton createButton(String name){
        JButton btn = new JButton(name);
        return btn;
    }
}

package main.java.com.ubo.tp.twitub.component;

import main.java.com.ubo.tp.twitub.controller.HomeController;
import main.java.com.ubo.tp.twitub.controller.IController;
import main.java.com.ubo.tp.twitub.controller.SearchController;
import main.java.com.ubo.tp.twitub.datamodel.User;
import main.java.com.ubo.tp.twitub.datamodel.model.Session;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class Utilisateurs extends JPanel {
    Set<User> allUsers;
    Session session;
    HomeController controller;
    SearchController searchController;

    public Utilisateurs(Set<User> allUsers, Session session, HomeController controller, SearchController searchController) {
        this.allUsers = allUsers;
        this.session = session;
        this.controller = controller;
        this.searchController =searchController;

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        /**
         * here
         */
        AllUsers allUsers1 = new AllUsers(allUsers, session, controller);
        allUsers1.setBackground(Color.lightGray);
        allUsers1.setBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE)
        );

        JButton suivre = createButton("les twits");
        suivre.setBackground(Color.blue);
        suivre.setForeground(Color.white);
        suivre.setFont(new Font("Calibri", Font.BOLD, 20));

        suivre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Utilisateurs.this.controller.showHome();
            }
        });

        JButton users = createButton("Users");
        users.setBackground(Color.lightGray);
        users.setForeground(Color.blue);
        users.setFont(new Font("Calibri", Font.BOLD, 20));

        JButton mesTwits = createButton("Twitter");
        mesTwits.setBackground(Color.blue);
        mesTwits.setForeground(Color.white);
        mesTwits.setFont(new Font("Calibri", Font.BOLD, 20));

        mesTwits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Utilisateurs.this.controller.redirectAddTwit();
            }
        });

        ImageIcon image = new ImageIcon("main/resources/images/search.png");

        Icon icon = new ImageIcon(image.getImage().getScaledInstance(60, 30, Image.SCALE_DEFAULT));
        JTextField search =  new JTextField();
        JButton searchButton =  new JButton(icon);
        searchButton.setBorder(
                BorderFactory.createMatteBorder(1,1,1,1, new Color(0,0,0,0 ))
        );
        searchButton.setBackground(new Color(0,0,0,0 ));
        searchButton.setOpaque(false);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userTag = search.getText();
                if(userTag.length()>0){
                    Utilisateurs.this.searchController.showResultRecherche(userTag);
                }
            }
        });


        JLabel label = new JLabel("Welcome ");
        label.setFont(new Font(label.getName(), label.getFont().getStyle(), 20));

        JLabel nom = new JLabel("Nom");
        label.setFont(new Font(nom.getName(), nom.getFont().getStyle(), 15));

        JLabel prenom = new JLabel("Prenom");
        prenom.setFont(new Font(prenom.getName(), prenom.getFont().getStyle(), 15));

        JLabel tag = new JLabel("@Nom");
        tag.setFont(new Font(tag.getName(), tag.getFont().getStyle(), 15));


        JScrollPane scrollPane = new JScrollPane(allUsers1);
        //scrollPane.setVerticalScrollBarPolicy(scrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension((int) (screenSize.getWidth() - 200), (int) (screenSize.getHeight() - 400)));

        panel.add(label, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.EAST,
                GridBagConstraints.NONE, new Insets(0, 0, 10, 100), 0, 0));
        panel.add(tag, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.EAST,
                GridBagConstraints.NONE, new Insets(0, 0, 10, 0), 0, 0));
        panel.add(nom, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.EAST,
                GridBagConstraints.NONE, new Insets(0, 0, 10, 100), 0, 0));
        panel.add(prenom, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.EAST,
                GridBagConstraints.NONE, new Insets(0, 0, 10, 0), 0, 0));

        panel.add(search, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(0, 0, 10, 200), (int) 250, 8));
        panel.add(searchButton, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(0, 200, 10, 0), (int) 0, 5));


        panel.add(suivre, new GridBagConstraints(0, 3, 2, 1, 1, 1, GridBagConstraints.WEST,
                GridBagConstraints.NONE, new Insets(50, 0, 20, 0), 30, 5));
        panel.add(users, new GridBagConstraints(0, 3, 2, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(50, 0, 20, 0), 30, 5));
        panel.add(mesTwits, new GridBagConstraints(0, 3, 2, 1, 1, 1, GridBagConstraints.EAST,
                GridBagConstraints.NONE, new Insets(50, 0, 20, 0), 30, 5));

        panel.add(scrollPane, new GridBagConstraints(0, 4, 2, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(0, 0, 10, 0), 0, 0));


        this.setLayout(new GridBagLayout());
        this.add(panel,new GridBagConstraints(0, 4, 2, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(0, 0, 10, 0), 0, 0));
    }

    private JButton createButton(String name) {
        JButton btn = new JButton(name);
        return btn;
    }
}
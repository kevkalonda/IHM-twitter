package main.java.com.ubo.tp.twitub.component;

import main.java.com.ubo.tp.twitub.controller.HomeController;

import main.java.com.ubo.tp.twitub.controller.SearchController;
import main.java.com.ubo.tp.twitub.datamodel.Twit;
import main.java.com.ubo.tp.twitub.datamodel.User;
import main.java.com.ubo.tp.twitub.datamodel.model.Session;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class Home extends JPanel {
    Set<Twit> twitList;
    User userConnect;

    HomeController homeController;
    SearchController searchController;
    public Home(Set<Twit> twitList, User user, HomeController homeController, SearchController searchController) {
        userConnect = user;
        this.twitList = twitList;
        this.homeController = homeController;
        this.searchController = searchController;
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        /**
         * here
         */
        AllTwits allTwits = new AllTwits(twitList, user);
        allTwits.setBackground(Color.lightGray);
        allTwits.setBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE)
        );

        JButton suivre = createButton("les twits");
        suivre.setBackground(Color.lightGray);
        suivre.setForeground(Color.blue);
        suivre.setFont(new Font("Calibri", Font.BOLD, 20));

        JButton users = createButton("Users");
        users.setBackground(Color.blue);
        users.setForeground(Color.white);
        users.setFont(new Font("Calibri", Font.BOLD, 20));

        JButton mesTwits = createButton("Twitter");
        mesTwits.setBackground(Color.blue);
        mesTwits.setForeground(Color.white);
        mesTwits.setFont(new Font("Calibri", Font.BOLD, 20));

        users.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home.this.homeController.redirectMesTwits();
            }
        });

        mesTwits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home.this.homeController.redirectAddTwit();
            }
        });

        ImageIcon logo = new ImageIcon("main/resources/images/index.png");
        ImageIcon logoImage = new ImageIcon(logo.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        JLabel labelLogoImage = new JLabel(logoImage);


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
                String searchString = search.getText();
                if(searchString.length()>0){
                    Home.this.searchController.showResultRechercheTwit(searchString);
                }
            }
        });

        JLabel label = new JLabel("Welcome ");
        label.setFont(new Font(label.getName(), label.getFont().getStyle(), 20));

        JLabel nom = new JLabel("Nom");
        label.setFont(new Font(nom.getName(), nom.getFont().getStyle(), 15));

        JLabel prenom = new JLabel("Prenom");
        prenom.setFont(new Font(prenom.getName(), prenom.getFont().getStyle(), 15));

        JLabel tag = new JLabel(this.verif(user));
        tag.setFont(new Font(tag.getName(), tag.getFont().getStyle(), 15));


        JScrollPane scrollPane = new JScrollPane(allTwits);
        //scrollPane.setVerticalScrollBarPolicy(scrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension((int) (screenSize.getWidth() - 280), (int) (screenSize.getHeight() - 400)));


        panel.add(label, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.EAST,
                GridBagConstraints.NONE, new Insets(0, 0, 10, 100), (int) 0, 0));
        panel.add(tag, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.EAST,
                GridBagConstraints.NONE, new Insets(0, 0, 10, 0), (int) 0, 0));


        panel.add(nom, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.EAST,
                GridBagConstraints.NONE, new Insets(0, 0, 10, 100), (int) 0, 0));
        panel.add(prenom, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.EAST,
                GridBagConstraints.NONE, new Insets(0, 0, 10, 0), (int) 0, 0));

        panel.add(search, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(0, 0, 10, 200), (int) 250, 8));
        panel.add(searchButton, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(0, 200, 10, 0), (int) 0, 5));

        panel.add(suivre, new GridBagConstraints(0, 3, 2, 1, 1, 1, GridBagConstraints.WEST,
                GridBagConstraints.NONE, new Insets(50, 0, 20, 0), (int) 30, 5));
        panel.add(users, new GridBagConstraints(0, 3, 2, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(50, 0, 20, 0), (int) 30, 5));
        panel.add(mesTwits, new GridBagConstraints(0, 3, 2, 1, 1, 1, GridBagConstraints.EAST,
                GridBagConstraints.NONE, new Insets(50, 0, 20, 0), (int) 30, 5));

        panel.add(scrollPane, new GridBagConstraints(0, 4, 2, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(0, 0, 10, 0), (int) 0, 0));


        this.add(panel);
    }

    public void refresh(){
        System.out.println("iciii");
        this.repaint();
    }

    private JButton createButton(String name){
        JButton btn = new JButton(name);
        return btn;
    }

    private String verif(User user){
        if(user != null){
            return user.getUserTag();
        }else {
            return "@Non connecté";
        }
    }
}
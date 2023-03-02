package main.java.com.ubo.tp.twitub.component;

import main.java.com.ubo.tp.twitub.controller.ProfilController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Profil extends JPanel{
    JPanel panel;
    ProfilController profilController;
    private final String imgUrl = "H:\\IHM\\img\\logo.jpg";
    /*
     * Constructeur.
     *
     * @param database , Base de donnÃ©es de l'application.
     */
    public Profil(ProfilController controller) {
        // Création de la fenetre principale
        panel = new JPanel();
        this.profilController=controller;
        panel.setLayout(new GridBagLayout());

        setVisible(true);


        JButton btnDeconnexion = createButton("Annuler");
        btnDeconnexion.setBackground(new Color(
                0,0,255,100
        ));
        btnDeconnexion.setForeground(Color.WHITE);
        btnDeconnexion.setFont(new Font("Calibri", Font.BOLD, 15));
        btnDeconnexion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Profil.this.profilController.redirectAllTwit();
            }
        });


        //Profil titre
        JLabel connectionLabel = new JLabel();
        connectionLabel.setText("Votre profil :");
        connectionLabel.setFont(new Font("Calibri", Font.BOLD, 40));
        connectionLabel.setForeground(new Color(0,0,255,120));

        //Nom
        JLabel nomLabel = new JLabel();
        nomLabel.setText("Nom :");
        JTextField nameField = new JTextField(this.profilController.getSession().getName());
        nameField.setEditable(false);
        nameField.setBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE)
        );
        //Prenom
        JLabel prenomLabel = new JLabel();
        prenomLabel.setText("Prénom :");
        JTextField prenomField = new JTextField(this.profilController.getSession().getmPrenom());
        prenomField.setEditable(false);
        prenomField.setBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE)
        );
        //Lemail
        JLabel mailLabel = new JLabel();
        mailLabel.setText("E-Mail :");
        JTextField mailField = new JTextField(this.profilController.getSession().getmMail());
        mailField.setEditable(false);
        mailField.setBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE)
        );
        //Password
        JLabel passLabel = new JLabel();
        passLabel.setText("Password :");
        JPasswordField passwordField = new JPasswordField(this.profilController.getSession().getUserPassword());
        passwordField.setEditable(false);
        passwordField.setBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE)
        );


        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        panel.setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());

        panel.add(connectionLabel, new GridBagConstraints(0, 0, 1, 1, 0, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(0, 50, 40, 0), 0, 0));


        panel.add(nomLabel, new GridBagConstraints(1, 1, 1, 1, 0, 1, GridBagConstraints.CENTER,
                GridBagConstraints.CENTER, new Insets(0, 0, 15, 0), 0, 0));


        panel.add(nameField, new GridBagConstraints(2, 1, 0, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(0, 10, 15, (int)screenSize.getWidth()/2), 0, 20));


        panel.add(prenomLabel, new GridBagConstraints(1, 2, 1, 1, 0, 1, GridBagConstraints.CENTER,
                GridBagConstraints.CENTER, new Insets(0, 0, 15, 0), 0, 0));
        panel.add(prenomField, new GridBagConstraints(2, 2, 0, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(0, 10, 15, (int)screenSize.getWidth()/2), 0, 20));


        panel.add(mailLabel, new GridBagConstraints(1, 3, 1, 1, 0, 1, GridBagConstraints.CENTER,
                GridBagConstraints.CENTER, new Insets(0, 00, 15, 0), 0, 0));

        panel.add(mailField, new GridBagConstraints(2, 3, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(0, 10, 15, (int)screenSize.getWidth()/2), 0, 20));


        panel.add(passLabel, new GridBagConstraints(1, 4, 1, 1, 0, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(0, 0, 15, 0), 0, 0));

        panel.add(passwordField, new GridBagConstraints(2, 4, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(0, 10, 15, (int)screenSize.getWidth()/2), 0, 20));

        panel.add(btnDeconnexion, new GridBagConstraints(2, 6, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(40, 400, 100, (int)screenSize.getWidth()/2), 0, 0));

        this.add(panel,new GridBagConstraints(2, 6, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(50, 0, 50, 0), 0, 0));


    }


    private JButton createButton(String name) {
        JButton btn = new JButton(name);
        btn.setBounds(20, 260, 200, 28);
        return btn;
    }
}

package main.java.com.ubo.tp.twitub.component;

import javax.swing.*;
import java.awt.*;

public class Profil extends JPanel{
    JPanel panel;
    private final String imgUrl = "H:\\IHM\\img\\logo.jpg";
    /*
     * Constructeur.
     *
     * @param database , Base de donnÃ©es de l'application.
     */
    public Profil() {
        // Création de la fenetre principale
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        panel.setBackground(Color.lightGray);
        panel.setBorder(
                BorderFactory.createMatteBorder(20, 10, 10, 10, Color.white)
        );

        setVisible(true);

        JButton btnConnexion = createButton("Sauvegarder");
        btnConnexion.setBackground(Color.lightGray);
        btnConnexion.setForeground(Color.black);
        btnConnexion.setFont(new Font("Calibri", Font.BOLD, 15));


        JButton btnDeconnexion = createButton("Annuler");
        btnDeconnexion.setBackground(Color.blue);
        btnDeconnexion.setForeground(Color.WHITE);
        btnDeconnexion.setFont(new Font("Calibri", Font.BOLD, 15));



        //Profil titre
        JLabel connectionLabel = new JLabel();
        connectionLabel.setText("Votre profil :");
        connectionLabel.setFont(new Font("Calibri", Font.BOLD, 40));
        connectionLabel.setForeground(Color.black);

        //Nom
        JLabel nomLabel = new JLabel();
        nomLabel.setText("Nom :");
        JTextField nameField = new JTextField();
        nameField.setBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE)
        );
        //Prenom
        JLabel prenomLabel = new JLabel();
        prenomLabel.setText("Prénom :");
        JTextField prenomField = new JTextField();
        prenomField.setBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE)
        );
        //Lemail
        JLabel mailLabel = new JLabel();
        mailLabel.setText("E-Mail :");
        JTextField mailField = new JTextField();
        mailField.setBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE)
        );
        //Password
        JLabel passLabel = new JLabel();
        passLabel.setText("Password :");
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE)
        );



        panel.add(connectionLabel, new GridBagConstraints(0, 0, 1, 1, 0, 1, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(0, 100, 0, 0), 0, 0));


        panel.add(nomLabel, new GridBagConstraints(1, 1, 1, 1, 0, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(50, 100, 50, 0), 0, 0));

        panel.add(nameField, new GridBagConstraints(2, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(50, 0, 50, 900), 0, 0));

        panel.add(prenomLabel, new GridBagConstraints(1, 2, 1, 1, 0, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(50, 100, 50, 0), 0, 0));

        panel.add(prenomField, new GridBagConstraints(2, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(50, 0, 50, 900), 0, 0));

        panel.add(mailLabel, new GridBagConstraints(1, 3, 1, 1, 0, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(50, 100, 50, 0), 0, 0));

        panel.add(mailField, new GridBagConstraints(2, 3, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(50, 0, 50, 900), 0, 0));


        panel.add(passLabel, new GridBagConstraints(1, 4, 1, 1, 0, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(50, 100, 50, 0), 0, 0));

        panel.add(passwordField, new GridBagConstraints(2, 4, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(50, 0, 50, 900), 0, 0));

        panel.add(btnConnexion, new GridBagConstraints(2, 5, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(10, 400, 5, 900), 0, 0));
        panel.add(btnDeconnexion, new GridBagConstraints(2, 6, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(0, 400, 100, 900), 0, 0));

        this.add(panel);


    }


    private JButton createButton(String name) {
        JButton btn = new JButton(name);
        btn.setBounds(20, 260, 200, 28);
        return btn;
    }
}

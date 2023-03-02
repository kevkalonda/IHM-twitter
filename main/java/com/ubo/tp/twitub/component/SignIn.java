package main.java.com.ubo.tp.twitub.component;

import main.java.com.ubo.tp.twitub.controller.ControllerSignIn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignIn extends JPanel {

    ControllerSignIn controller;

    public SignIn(ControllerSignIn controller) {
        this.controller = controller;
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.lightGray);

        JButton btnConnexion = createButton("S'inscrire");
        btnConnexion.setBounds(150, 300, 150, 30);
        btnConnexion.setBackground(Color.BLUE);
        btnConnexion.setForeground(Color.WHITE);
        btnConnexion.setFont(new Font("Calibri", Font.BOLD, 20));

        //Connexion
        JLabel connectionLabel = new JLabel();
        connectionLabel.setText("Créer un compte ");
        connectionLabel.setFont(new Font("Calibri", Font.BOLD, 40));
        connectionLabel.setForeground(Color.blue);
        //Sexe
        String[] sexe = {"Mme", "Mlle", "Mr", "Autre"};

        JLabel sexeLabel = new JLabel();
        sexeLabel.setText("Sexe :");
        JComboBox<String> jComboBox = new JComboBox<>(sexe);


        //Nom
        JLabel nomLabel = new JLabel();
        nomLabel.setText("Nom :");
        JTextField nameField = new JTextField();

        //Prenom
        JLabel prenomLabel = new JLabel();
        prenomLabel.setText("Prénom :");
        JTextField prenomField = new JTextField();


        //Login
        JLabel loginLabel = new JLabel();
        loginLabel.setText("Tag :");
        JTextField tagField = new JTextField();

        //Le mail
        JLabel mailLabel = new JLabel();
        mailLabel.setText("E-Mail :");
        JTextField mailField = new JTextField();

        //Password
        JLabel passLabel = new JLabel();
        passLabel.setText("Password :");
        JPasswordField passwordField = new JPasswordField();

        btnConnexion.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */

            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] tab = new Object[6];
                String sexe = jComboBox.getSelectedItem().toString();
                String name = nameField.getText();
                String prenom = prenomField.getText();
                String mail = mailField.getText();
                String mdp = passwordField.getText();
                String tag = tagField.getText();


                if (passwordField.getPassword().length <= 0 && nameField.getText().length() <= 0
                        && prenomField.getText().length() <= 0 && tagField.getText().length() <= 0) {
                    passwordField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
                    nameField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
                    prenomField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
                    tagField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
                } else {
                    passwordField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
                    nameField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
                    prenomField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
                    tagField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));

                    if (passwordField.getPassword().length > 0 && nameField.getText().length() > 0
                            && prenomField.getText().length() > 0 && tagField.getText().length() > 0) {
                        SignIn.this.controller.createUser(sexe, name, prenom, mail, mdp, tag);
                    } else {
                        if (passwordField.getPassword().length <= 0) {
                            passwordField.repaint();
                            passwordField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
                        } else {
                            passwordField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
                            if (tagField.getText().length() <= 0) {
                                tagField.repaint();
                                tagField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
                            } else {
                                tagField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
                                if (nameField.getText().length() <= 0) {
                                    nameField.repaint();
                                    nameField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
                                } else {
                                    nameField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
                                    if (prenomField.getText().length() <= 0) {
                                        prenomField.repaint();
                                        prenomField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

        //Ajout des labels la frame
        panel.add(connectionLabel, new GridBagConstraints(0, 0, 0, 0, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(200, 0, 800, 0), 0, 20));

        panel.add(sexeLabel, new GridBagConstraints(0, 0, 0, 0, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(200, 0, 600, 100), 200, 0));
        panel.add(jComboBox, new GridBagConstraints(0, 0, 0, 0, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(200, 0, 600, 0), 150, 0));

        panel.add(nomLabel, new GridBagConstraints(0, 0, 0, 0, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(200, 0, 500, 100), 200, 20));
        panel.add(nameField, new GridBagConstraints(0, 0, 0, 0, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(200, 0, 500, 0), 200, 20));

        panel.add(prenomLabel, new GridBagConstraints(0, 0, 0, 0, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(200, 0, 400, 100), 200, 20));
        panel.add(prenomField, new GridBagConstraints(0, 0, 0, 0, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(200, 0, 400, 0), 200, 20));

        panel.add(mailLabel, new GridBagConstraints(0, 0, 0, 0, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(200, 0, 300, 100), 200, 20));
        panel.add(mailField, new GridBagConstraints(0, 0, 0, 0, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(200, 0, 300, 0), 200, 20));


        panel.add(loginLabel, new GridBagConstraints(0, 0, 0, 0, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(200, 0, 200, 100), 200, 20));
        panel.add(tagField, new GridBagConstraints(0, 0, 0, 0, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(200, 0, 200, 0), 200, 20));


        panel.add(passLabel, new GridBagConstraints(0, 0, 0, 0, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(200, 0, 100, 100), 200, 20));
        panel.add(passwordField, new GridBagConstraints(0, 0, 0, 0, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(200, 0, 100, 0), 200, 20));

        panel.add(btnConnexion, new GridBagConstraints(0, 0, 0, 0, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(210, 0, 0, 0), 80, 20));
        this.add(panel);
    }
    private JButton createButton(String name) {
        JButton btn = new JButton(name);
        btn.setBounds(20, 260, 200, 28);
        return btn;
    }
}

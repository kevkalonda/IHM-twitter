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
        //Avatar
//       JFileChooser chooser = new JFileChooser();
//        FileNameExtensionFilter filter = new FileNameExtensionFilter(
//                "JPG & GIF Images", "jpg", "gif");
//        chooser.setFileFilter(filter);
//        int returnVal = chooser.showOpenDialog(null);
//        if(returnVal == JFileChooser.APPROVE_OPTION) {
//            System.out.println("You chose to open this file: " +
//                    chooser.getSelectedFile().getName());
//        }

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
        loginLabel.setText("Login :");
        JTextField loginField = new JTextField();

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
                Object[] tab = new Object[5];
                tab[0] = jComboBox.getSelectedItem();
                tab[1] = nameField.getText();
                tab[2] = prenomField.getText();
                tab[3] = mailField.getText();
                tab[4] = passwordField.getPassword().toString();
                SignIn.this.controller.createUser(tab);
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
        panel.add(loginField, new GridBagConstraints(0, 0, 0, 0, 0, 0, GridBagConstraints.CENTER,
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

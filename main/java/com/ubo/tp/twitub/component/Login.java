package main.java.com.ubo.tp.twitub.component;

import main.java.com.ubo.tp.twitub.controller.ControllerLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JPanel{
    ControllerLogin controller;

    public Login(ControllerLogin controller){
        this.controller = controller;
        JPanel panel = new JPanel();
        //Spécifier la position et la taille du JPanel
        panel.setLayout(new GridBagLayout());
        //Spécifier la couleur d'arrière-plan du JPanel
        panel.setBackground(Color.lightGray);

        JButton btnConnexion = createButton("Se connecter");
        btnConnexion.setBackground(Color.blue);
        btnConnexion.setForeground(Color.white);
        btnConnexion.setFont(new Font("Calibri", Font.BOLD, 20));

        JTextField textField1 = createTextField("", new Point(20, 40));
        JLabel passLabel = createLabel("PASSWORD");
        JLabel cptLabel = createLabel("LOGIN ");
        JLabel titre = createLabel("CONNEXION");
        titre.setFont(new Font("Calibri", Font.BOLD, 40));
        titre.setForeground(Color.blue);
        JPasswordField passwordField = new JPasswordField();

        btnConnexion.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                Login.this.controller.connexion(textField1.getText(), passwordField.getPassword().toString());
            }
        });

        panel.add(titre, new GridBagConstraints(0, 0, 0, 0, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(150, 0, 350, 0), 0, 20));
        panel.add(cptLabel, new GridBagConstraints(0, 0, 0, 0, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(150, 0, 250, 100), 200, 0));
        panel.add(textField1, new GridBagConstraints(0, 0, 0, 0, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(150, 0, 250, 0), 200, 15));
        panel.add(passLabel, new GridBagConstraints(0, 0, 0, 0, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(150, 0, 150, 100), 200, 0));
        panel.add(passwordField, new GridBagConstraints(0, 0, 0, 0, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(150, 0, 150, 0), 200, 15));
        panel.add(btnConnexion, new GridBagConstraints(0, 0, 0, 0, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(150, 0, 50, 0), 0, 15));
        this.add(panel);
    }

    /**
     *
     * @param name
     * @param p
     * @return
     */
    private JTextField createTextField(String name, Point p){
        JTextField textField = new JTextField(name);
        textField.setBounds(p.x,p.y,200,28);
        return textField;
    }

    /**
     *
     * @param name
     * @return
     */
    private JLabel createLabel(String name){
        JLabel label = new JLabel();
        label.setText(name);
        return label;
    }

    /**
     *
     * @param name
     * @return
     */
    private JButton createButton(String name){
        JButton btn = new JButton(name);
        btn.setBounds(20,120,200,30);
        return btn;
    }
}

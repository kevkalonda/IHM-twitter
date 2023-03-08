package main.java.com.ubo.tp.twitub.component;

import main.java.com.ubo.tp.twitub.controller.ControllerEnvoyerTwit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Twitpanel extends JPanel {

    ControllerEnvoyerTwit controlerenvoyertwit;

    JPanel panel;

    public JPanel getPanel() {
        return panel;
    }

    private final String imgUrl = "H:\\IHM\\img\\logo.jpg";
    /*
     * Constructeur.
     *
     * @param database , Base de donnÃ©es de l'application.
     */

    public Twitpanel(ControllerEnvoyerTwit c) {
        this.controlerenvoyertwit=c;
        // CrÃ©ation de la fenetre principale
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        panel.setBackground(Color.white);
        panel.setBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE)
        );
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

        setVisible(true);


        JButton btnConnexion = createButton("Publier");
        btnConnexion.setBackground(Color.BLUE);
        btnConnexion.setForeground(Color.WHITE);
        btnConnexion.setFont(new Font("Calibri", Font.BOLD, 20));

        //Logo
        String imgUrl = "H:\\IHM\\img\\logo.jpg";
        ImageIcon icone = new ImageIcon(imgUrl);


        //Crétion de JLable avec un alignement gauche
        JLabel jlabel = new JLabel(icone, JLabel.CENTER);


        //Crér twit titre
        JLabel connectionLabel = new JLabel();
        connectionLabel.setText("Publier un Twit ");
        connectionLabel.setFont(new Font("Calibri", Font.BOLD, 30));
        connectionLabel.setForeground(Color.BLACK);


        //Text twit avec limite 250 caractÃ¨res
        JTextArea textField = new JTextArea(250,200);
        textField.setFont(new Font("Serif", Font.PLAIN, 17));
        textField.setLineWrap(true);
        textField.setWrapStyleWord(true);
        textField.setDocument (new JTextFieldLimit(250));
        JScrollPane jsp = new JScrollPane(textField);
        jsp.setBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE)
        );

        jsp.setPreferredSize(new Dimension((int) (screenSize.getWidth() - 280), (int) (screenSize.getHeight() - 100)));

        JButton annulerButton = createButton("Annuler");
        annulerButton.setBackground(Color.lightGray);
        annulerButton.setForeground(Color.blue);
        annulerButton.setFont(new Font("Calibri", Font.BOLD, 20));

        annulerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Twitpanel.this.controlerenvoyertwit.redirectAllTwits();
            }
        });

        /**
         * Action listerner boutton
         */
        btnConnexion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String twit= textField.getText();
                if(twit.length()>0){
                    Twitpanel.this.controlerenvoyertwit.publier(twit);
                }else {
                    jsp.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.red));
                    textField.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.red));
                }
            }
        });
        //Ajout des labels Ã  la frame
        panel.add(jlabel, new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(connectionLabel, new GridBagConstraints(0, 2, 1, 1, 1, 0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(0, 0, 5, 0), 0, 0));

        panel.add(jsp, new GridBagConstraints(0, 3, 1, 1, 1, 2, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 50, 0, 50), 0, 100));

        panel.add(btnConnexion, new GridBagConstraints(0, 4, 1, 1, 1, 1, GridBagConstraints.WEST,
                GridBagConstraints.NONE, new Insets(20, 200, 20, 0), 0, 0));
        panel.add(annulerButton, new GridBagConstraints(0, 4, 1, 1, 1, 1, GridBagConstraints.EAST,
                GridBagConstraints.NONE, new Insets(20, 0, 20, 200), 0, 0));
        this.add(panel);
    }


    private JButton createButton(String name) {
        JButton btn = new JButton(name);
        btn.setBounds(20, 260, 200, 28);
        return btn;
    }
}


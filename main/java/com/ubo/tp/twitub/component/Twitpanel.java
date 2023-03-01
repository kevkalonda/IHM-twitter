package main.java.com.ubo.tp.twitub.component;

import javax.swing.*;
import java.awt.*;

public class Twitpanel extends JPanel {

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

    public Twitpanel() {
        // CrÃ©ation de la fenetre principale
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        panel.setBackground(Color.white);
        panel.setBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE)
        );

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
        textField.setWrapStyleWord(false);
        textField.setDocument (new JTextFieldLimit(250));
        JScrollPane jsp = new JScrollPane(textField);
        jsp.setBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE)
        );



        //Ajout des labels Ã  la frame
        panel.add(jlabel, new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(connectionLabel, new GridBagConstraints(0, 2, 1, 1, 1, 0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(0, 0, 5, 0), 0, 0));

        panel.add(jsp, new GridBagConstraints(0, 3, 1, 1, 1, 2, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, new Insets(5, 50, 0, 50), 0, 100));

        panel.add(btnConnexion, new GridBagConstraints(0, 4, 1, 1, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(20, 0, 20, 0), 0, 0));
        this.add(panel);
    }


    private JButton createButton(String name) {
        JButton btn = new JButton(name);
        btn.setBounds(20, 260, 200, 28);
        return btn;
    }
}


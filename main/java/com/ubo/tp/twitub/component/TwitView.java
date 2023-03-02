package main.java.com.ubo.tp.twitub.component;

import javax.swing.*;
import java.awt.*;

public class TwitView extends JPanel {
    JPanel panel;
    /*
     * Constructeur.
     *
     * @param database , Base de données de l'application.
     */
    public TwitView() {

        JPanel panel = new JPanel();
        //Spécifier la position et la taille du JPanel
        panel.setLayout(new GridBagLayout());
        //Spécifier la couleur d'arrière-plan du JPanel
        panel.setBackground(Color.lightGray);

        JButton btnConnexion = createButton("Retour");
        btnConnexion.setBackground(Color.blue);
        btnConnexion.setForeground(Color.white);
        btnConnexion.setFont(new Font("Calibri", Font.BOLD, 20));

        JTextField textField1 = createTextField("", new Point(20, 40));
        JLabel twitLabel = createLabel("Twit");
        JLabel userLabel = createLabel("@User ");
        JLabel dateLabel = createLabel("Date");
        dateLabel.setFont(new Font("Calibri", Font.ITALIC, 10));
        dateLabel.setForeground(Color.blue);
        userLabel.setForeground(Color.blue);
        JTextField textField2 = createTextField("", new Point(20, 40));




        panel.add(userLabel, new GridBagConstraints(0, 3, 0, 0, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(50, 10, 360, 100), 200, 0));

        panel.add(textField1, new GridBagConstraints(1, 3, 0, 0, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(50, 10, 360, 0), 200, 15));

        panel.add(twitLabel, new GridBagConstraints(0, 2, 0, 0, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(170, 10, 260, 100), 200, 0));

        panel.add(textField2, new GridBagConstraints(0, 2, 0, 0, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(170, 10, 260, 0), 200, 150));

        panel.add(dateLabel, new GridBagConstraints(0, 0, 0, 0, 0, 3, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(10, 170, 380, 0), 0, 20));

        panel.add(btnConnexion, new GridBagConstraints(0, 5, 0, 0, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(200, 0, 10, 0), 0, 15));
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
        textField.setEditable(false);
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

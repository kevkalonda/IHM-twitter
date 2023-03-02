package main.java.com.ubo.tp.twitub.ihm;

import main.java.com.ubo.tp.twitub.component.Login;
import main.java.com.ubo.tp.twitub.controller.ControllerLogin;
import main.java.com.ubo.tp.twitub.controller.MenuController;
import main.java.com.ubo.tp.twitub.core.EntityManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe de la vue principale de l'application.
 */
public class TwitubMainView {


    /**
     * Fenetre du bouchon
     */
    protected JFrame mFrame;

    MenuController menuController;

    /**
     * Gestionnaire de bdd et de fichier.
     */
    protected EntityManager mEntityManager;

    private final String imgUrl = "H:\\IHM\\img\\index.png";

    /**
     * Constructeur.
     *
     * @param  entityManager, Base de données de l'application.
     */
    public TwitubMainView( EntityManager entityManager, MenuController menuController) {
        this.mEntityManager = entityManager;
        this.menuController = menuController;
    }

    public JFrame getmFrame() {
        return mFrame;
    }

    public void setmFrame(JFrame mFrame) {
        this.mFrame = mFrame;
    }

    public void show(JPanel panel) {
        this.mFrame.getContentPane().removeAll();
        this.mFrame.getContentPane().add(panel);
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        TwitubMainView.this.mFrame.setSize(screenSize.getSize());
        mFrame.setVisible(true);
        mFrame.pack();
    }
    /**
     * Lance l'afficahge de l'IHM.
     */
    public void showGUI(ControllerLogin controllerLogin) {
        // Init auto de l'IHM au cas ou ;)
        if (mFrame == null) {
            this.initGUI(controllerLogin);
        }

        // Affichage dans l'EDT
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Custom de l'affichage
                JFrame frame = TwitubMainView.this.mFrame;
                Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
                //frame.setLocation(0,0);
                frame.setSize(screenSize.getSize());

                // Affichage
                TwitubMainView.this.mFrame.setVisible(true);
                TwitubMainView.this.mFrame.setSize(screenSize.getSize());
                TwitubMainView.this.mFrame.pack();
            }
        });
    }


    /**
     * Initialisation de l'IHM
     */
    protected void initGUI(ControllerLogin controllerLogin) {

        // Création de la fenetre principale
        mFrame = new JFrame("LUMWANGA");
        mFrame.setLayout(new GridBagLayout());

        ImageIcon icone = new ImageIcon(imgUrl);
        Image image = icone.getImage();
        Image newImage = image.getScaledInstance(40, 40, 10);
        //Création de JLable avec un alignement gauche
        JLabel jlabel = new JLabel(icone);


        JMenu menu;
        JMenuItem e1, e2, e3, e4;
        JMenuBar menubar = new JMenuBar();

        menu = new JMenu("Menu");
        e1 = new JMenuItem("Inscription");
        e2 = new JMenuItem("Connexion");
        e3 = new JMenuItem("Profil");
        e4 = new JMenuItem("Deconnexion");

        e1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TwitubMainView.this.menuController.redirectInscription();
            }
        });

        e2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TwitubMainView.this.menuController.redirectInscription();
            }
        });

        e3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TwitubMainView.this.menuController.redirectProfil();
            }
        });

        e4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TwitubMainView.this.menuController.getSession().setUser(null);
                TwitubMainView.this.menuController.redirectConnexion();
                //System.out.println("You Loged OUT !");
            }

        });

        menu.add(e1);
        menu.add(e2);
        menu.add(e3);
        menu.add(e4);
        menubar.add(menu);

        mFrame.setIconImage(newImage);
        mFrame.setJMenuBar(menubar);
        Login l = new Login(controllerLogin);

        mFrame.add(l,new GridBagConstraints(0, 0, 0, 0, 0, 0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 10, 0));
    }
}

package main.java.com.ubo.tp.twitub.core;

import main.java.com.ubo.tp.twitub.component.*;
import main.java.com.ubo.tp.twitub.controller.*;
import main.java.com.ubo.tp.twitub.datamodel.*;
import main.java.com.ubo.tp.twitub.datamodel.model.ModelHome;
import main.java.com.ubo.tp.twitub.datamodel.model.Observer;
import main.java.com.ubo.tp.twitub.events.file.IWatchableDirectory;
import main.java.com.ubo.tp.twitub.events.file.WatchableDirectory;
import main.java.com.ubo.tp.twitub.ihm.TwitubMainView;
import main.java.com.ubo.tp.twitub.ihm.TwitubMock;

import java.io.File;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

/**
 * Classe principale l'application.
 *
 * @author S.Lucas
 */
public class Twitub implements IController {
    /**
     * Base de données.
     */
    protected IDatabase mDatabase;

    /**
     * Controller du principale
     */
    protected IController mController;

    protected ControllerSignIn controllerSignIn;

    /**
     * Controller du view Login
     */
    ControllerLogin controllerLogin;

    /**
     * Controller du view Login
     */
    HomeController homeController;

    /**
     * Controller du view voir un twit
     */
    Controlerenvoyertwit controlerenvoyertwit;

    MesTwitsController mesTwitsController;

    /**
     * Gestionnaire des entités contenu de la base de données.
     */
    protected EntityManager mEntityManager;

    /**
     * Vue principale de l'application.
     */
    protected TwitubMainView mMainView;

    /**
     * Classe de surveillance de répertoire
     */
    protected IWatchableDirectory mWatchableDirectory;


    /**
     * Répertoire d'échange de l'application.
     */
    protected String mExchangeDirectoryPath;

    /**
     * Indique si le mode bouchoné est activé.
     */
    protected boolean mIsMockEnabled = true;

    /**
     * Nom de la classe de l'UI.
     */
    protected String mUiClassName;

    protected User tagUser;

    protected ModelHome modelHome;

    public User getTagUser() {
        return tagUser;
    }

    public void setTagUser(User tagUser) {
        this.tagUser = tagUser;
    }

    /**
     * Constructeur.
     */
    public Twitub() {
        // Init du look and feel de l'application
        this.initLookAndFeel();

        // Initialisation de la base de données
        this.initDatabase();


        // Initialisation du controller
        this.initController();

        if (this.mIsMockEnabled) {
            // Initialisation du bouchon de travail
            this.initMock();
        }
        // Initialisation de l'IHM
        this.initGui();


        // Initialisation du répertoire d'échange
        this.initDirectory("H:\\IHM\\BDD");

    }

    private void initModel() {
        modelHome = new ModelHome(this, mesTwitsController);
    }

    private void initController() {
        controllerSignIn = new ControllerSignIn(mDatabase, this);
        controllerLogin = new ControllerLogin(mDatabase, this);
        homeController = new HomeController();
        controlerenvoyertwit = new Controlerenvoyertwit(mDatabase, this, null);
        mesTwitsController = new MesTwitsController(this);

        initModel();
    }

    /**
     * Initialisation du look and feel de l'application.
     */
    protected void initLookAndFeel() {
    }

    public Set<Twit> getAllTwits() {
        return this.mDatabase.getTwits();
    }



    /**
     * Initialisation de l'interface graphique.
     */
    protected void initGui() {
        // this.mMainView...
        int randomInt = new Random().nextInt(99999);
        String userName = "MockUser" + randomInt;
        User newUser = new User(UUID.randomUUID(), userName, "--", userName, new HashSet<>(), "");
        this.tagUser = newUser;
        this.homeController.addObserver(this.modelHome);
        this.mMainView = new TwitubMainView(this.mEntityManager);
        mMainView.showGUI(controllerLogin);
    }

    /**
     * Initialisation du répertoire d'échange (depuis la conf ou depuis un file
     * chooser). <br/>
     * <b>Le chemin doit obligatoirement avoir été saisi et être valide avant de
     * pouvoir utiliser l'application</b>
     */
    protected void initDirectory() {
    }

    /**
     * Indique si le fichier donné est valide pour servire de répertoire
     * d'échange
     *
     * @param directory , Répertoire à tester.
     */
    protected boolean isValideExchangeDirectory(File directory) {
        // Valide si répertoire disponible en lecture et écriture
        return directory != null && directory.exists() && directory.isDirectory() && directory.canRead()
                && directory.canWrite();
    }

    /**
     * Initialisation du mode bouchoné de l'application
     */
    protected void initMock() {
        TwitubMock mock = new TwitubMock(this.mDatabase, this.mEntityManager);
        mock.showGUI();
    }

    /**
     * Initialisation de la base de données
     */
    protected void initDatabase() {
        mDatabase = new Database();
        mEntityManager = new EntityManager(mDatabase);
        mDatabase.addObserver(new WatchableDataBase());


    }

    /**
     * Initialisation du répertoire d'échange (depuis la conf ou depuis un file
     * chooser). <br/>
     * <b>Le chemin doit obligatoirement avoir été saisi et être valide avant de
     * pouvoir utiliser l'application</b>
     *
     * @param directoryPath
     */
    public void initDirectory(String directoryPath) {
        mDatabase.addObserver(this.homeController);
        mExchangeDirectoryPath = directoryPath;
        mWatchableDirectory = new WatchableDirectory(directoryPath);
        mEntityManager.setExchangeDirectory(directoryPath);

        mWatchableDirectory.initWatching();
        mWatchableDirectory.addObserver(mEntityManager);

    }

    public void show() {
        // ... setVisible?
    }

    @Override
    public void showHome() {
        mMainView.show(modelHome.showHome());
    }

    @Override
    public void showLogin() {
        mMainView.show(new Login(controllerLogin));
    }

    @Override
    public void showSignIn() {
        mMainView.show(new SignIn(controllerSignIn));
    }

    @Override
    public void showProfil() {
        mMainView.show(new Profil());
    }

    @Override
    public void showAddTwit() {
        mMainView.show(new Twitpanel(controlerenvoyertwit).getPanel());
    }

    @Override
    public void showMyTwits() {
        mMainView.show(new MesTwits(mDatabase.getTwitsWithTag(this.tagUser.getUserTag()), this.tagUser));
    }


}

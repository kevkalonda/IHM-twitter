package main.java.com.ubo.tp.twitub.component;

import javax.swing.*;
import java.util.List;

public class Menu extends JMenuBar {

    public Menu(List<String> maneMenuItems, String name) {
        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu(name);

        for (String nameNenuItem : maneMenuItems) {
            JMenuItem menuItem = new JMenuItem(nameNenuItem);
            menu.add(menuItem);
        }
        menubar.add(menu);
        this.add(menubar);
    }
}

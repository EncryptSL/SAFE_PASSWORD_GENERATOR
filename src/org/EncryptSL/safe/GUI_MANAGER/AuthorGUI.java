package org.EncryptSL.safe.GUI_MANAGER;

import org.EncryptSL.safe.Main;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class AuthorGUI {

    public void AUTHOR_GUI() {
        JFrame author_panel = new JFrame("INFORMATION ABOUT PROGRAM");
        JPanel panel_of_author = new JPanel();
        ImageIcon imageIcon = new ImageIcon(Main.class.getResource("/resources/photos/icon.png"));

        JLabel author_name = new JLabel();
        JLabel info_description = new JLabel();
        JLabel info_description_2 = new JLabel();
        JLabel info_description_3 = new JLabel();

        author_panel.setVisible(true);
        author_panel.setIconImage(imageIcon.getImage());
        author_panel.setSize(500, 500);
        author_panel.setLocationRelativeTo(null);
        author_panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        author_name.setText("Author is EncryptSL alias YODA1999.");
        info_description.setText("Program can generate password about your power!");
        info_description_2.setText("You can write any number and generator generate password for you.");
        info_description_3.setText("Recommended: Mimimum save password is 15 Bits.");

        JButton button = new JButton();
        button.setText("Click to Control Password");

        button.addActionListener(e -> {
            try {
                final URI uri = new URI("https://howsecureismypassword.net");
                open(uri);
            } catch (URISyntaxException e1) {
                e1.printStackTrace();
            }

        });

        panel_of_author.add(author_name);
        panel_of_author.add(info_description);
        panel_of_author.add(info_description_2);
        panel_of_author.add(info_description_3);
        panel_of_author.add(button);
        author_panel.add(panel_of_author, BorderLayout.CENTER);
    }

    private static void open(URI uri) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(uri);
            } catch (IOException e) { /* TODO: error handling */ }
        } else { /* TODO: error handling */ }
    }

}

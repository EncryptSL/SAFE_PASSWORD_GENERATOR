package org.EncryptSL.safe;

import org.EncryptSL.safe.GUI_MANAGER.AudioManager;
import org.EncryptSL.safe.GUI_MANAGER.AuthorGUI;

import javax.swing.*;
import java.util.Random;


public class Main {

    private static AuthorGUI authorGUI = new AuthorGUI();
    private static AudioManager audioManager = new AudioManager();

    public static void main(String[] args) {
        JFrame frame = new JFrame("SAFE-PASSWORD-GENERATOR BY YODA1999(ENCRYPTSL)");
        ImageIcon imageIcon = new ImageIcon(Main.class.getResource("/resources/photos/icon.png"));
        JLabel write_num = new JLabel("Zde prosím napiš číslo:");
        JTextField text = new JTextField(50);
        JTextField pass_power = new JTextField(5);
        JPanel p = new JPanel();
        audioManager.loopmusic();

        JButton pass_gener = new JButton("GENERATE PASSWORD");
        JButton author = new JButton("INFORMATION");

        frame.setVisible(true);
        frame.setSize(600, 150);
        frame.setIconImage(imageIcon.getImage());
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pass_gener.addActionListener(e -> {
            if(!pass_power.getText().matches("")) {
                if(!(Integer.valueOf(pass_power.getText()) > 256 || Integer.valueOf(pass_power.getText()) < 3)) {
                    Random r = new Random();
                    StringBuilder stodvacetosmbit = new StringBuilder();
                    String first_code = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ#?!";
                    for (int i = 0; i < Integer.valueOf(pass_power.getText()); i++) {
                        stodvacetosmbit.append(first_code.charAt(r.nextInt(first_code.length())));
                    }
                    JOptionPane.showMessageDialog(null, "Lenght of Your Password is " + stodvacetosmbit.length());
                    text.setText(stodvacetosmbit.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Your Integer is " + pass_power.getText() + " but must be lower then 256 and higher then 3. Minimum save password is 15 bits.", "ERROR PLEASE READ THIS WINDOW", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "You must write number for power of your pass.", "ERROR PLEASE READ THIS WINDOW", JOptionPane.ERROR_MESSAGE);
            }
        });

        author.addActionListener(e -> {
            authorGUI.AUTHOR_GUI();
        });

        p.add(write_num);
        p.add(pass_power);
        p.add(text);
        p.add(pass_gener);
        p.add(author);
        frame.add(p);
    }
}

package main.java.com;

import main.java.com.View.Homepage;

import javax.swing.*;
import java.security.Principal;

public class App extends JFrame {
    public static void main(String[] args) {

        JFrame jf = new JFrame();
        jf.setTitle("Lumine Glam");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setContentPane(new Homepage().jPanelPrincipal);
        jf.setSize(500,500);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

    }
}
package main.java.com.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homepage {
    public JPanel jPanelPrincipal;
    public JMenuBar jMenuBarPrincipal;
    public JMenu jMenuPrincipal;
    public JMenuItem jMenuItemPessoas;
    public JMenuItem jMenuItemProdutos;

    public Homepage() {
        jMenuItemPessoas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new People();
            }
        });

        jMenuItemProdutos.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {new Products();}
        });
    }
}

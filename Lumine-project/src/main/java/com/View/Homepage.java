package main.java.com.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homepage {
    public JPanel jPanelPrincipal;
    public JMenuBar jMenuBarPrincipal;
    public JMenu jMenuCadastro;
    public JMenuItem jMenuItemPessoas;
    public JMenuItem jMenuItemProdutos;
    public JPanel jPanelTopo;
    public JPanel jPanelImagem;
    private JMenu jMenuRelatorio;
    private JMenu jMenuSair;
    private JMenuItem jMenuItemSair;

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

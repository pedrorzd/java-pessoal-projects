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
    private JMenu jMenuVendas;
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

        jMenuItemSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resposta = JOptionPane.showConfirmDialog(null, "Deseja sair?",
                        "Saida do Sistema", JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION){
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Obrigado por ficar!");
                }
            }
        });

    }
}

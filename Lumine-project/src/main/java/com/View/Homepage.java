package main.java.com.View;

import main.java.com.Model.Usuarios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Homepage extends JFrame {
    public JPanel jPanelPrincipal;
    public JMenuBar jMenuBarPrincipal;
    public JMenu jMenuCadastro;
    public JMenuItem jMenuItemVendedor;
    public JMenuItem jMenuItemProdutos;
    public JPanel jPanelTopo;
    public JPanel jPanelImagem;
    private JMenu jMenuRelatorio;
    private JMenu jMenuSair;
    private JMenu jMenuVendas;
    private JMenuItem jMenuItemSair;
    private JMenuItem jMenuItemFornecedor;
    private JMenuItem vendas;
    private JMenuItem jMenuItemCliente;
    private JMenuItem JMenuItemUsuario;

    public Homepage() {
        setContentPane(jPanelPrincipal);
        setSize(850,750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        jMenuItemVendedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Vendedores();
            }
        });

        jMenuItemProdutos.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {new Produtos();}
        });

        jMenuItemFornecedor.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {new Fornecedores();}
        });

        jMenuItemCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {new Clientes();}
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

        vendas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Vendas();
            }
        });
    }
}

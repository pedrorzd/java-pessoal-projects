package main.java.com.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Produtos extends JFrame {
    public JPanel jPanelProdutos;
    private JTextField textFieldCodigo;
    private JTextField textFieldNome;
    private JTextField textFieldPrecoEntrada;
    private JButton saveButton;
    private JPanel JPanelButtons;
    private JButton editarButton;
    private JPanel JPanelDados;
    private JComboBox comboBoxFornecedor;
    private JTextField textFieldQuantidade;
    private JTextField textFieldPrecoVenda;
    private JButton limparButton;
    private JButton excluirButton;

    public Produtos(){
        setContentPane(jPanelProdutos);
        setSize(600,450);
        setTitle("Cadastro de Produtos");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}

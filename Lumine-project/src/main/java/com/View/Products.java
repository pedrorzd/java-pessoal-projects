package main.java.com.View;

import javax.swing.*;

public class Products extends JFrame {
    public JPanel jPanelProdutos;
    private JTextField textFieldCodigo;
    private JTextField textFieldNome;
    private JTextField textFieldPrecoEntrada;
    private JButton saveButton;
    private JPanel JPanelButtons;
    private JButton editarButton;
    private JButton limparButton;
    private JPanel JPanelDados;
    private JTextField textFieldFornecedor;

    public Products(){
        setContentPane(jPanelProdutos);
        setSize(600,450);
        setTitle("Cadastro de Produtos");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }
}

package main.java.com.View;

import javax.swing.*;

public class Products extends JFrame {
    public JPanel jPanelProdutos;
    private JTextField textFieldCodigo;
    private JTextField textFieldNome;
    private JTextField textFieldPrecoEntrada;
    private JButton saveButton;

    public Products(){
        setContentPane(jPanelProdutos);
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }
}

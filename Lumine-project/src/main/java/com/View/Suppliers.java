package main.java.com.View;

import javax.swing.*;


public class Suppliers extends JFrame {
    public JPanel JPanelSuppliers;
    private JPanel JPanelInputs;
    private JPanel JPanelButtons;
    private JButton limparButton;
    private JButton apagarButton;
    private JButton editarButton;
    private JButton confirmarButton;
    private JRadioButton ativoRadioButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JRadioButton inativoRadioButton;
    private JTextField textField6;

    public Suppliers() {
        setContentPane(JPanelSuppliers);
        setSize(600,450);
        setTitle("Cadastro de Fornecedores");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

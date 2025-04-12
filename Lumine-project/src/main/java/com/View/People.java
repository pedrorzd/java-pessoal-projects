package main.java.com.View;

import javax.swing.*;

public class People extends JFrame {
    public JPanel jPanelPessoas;
    private JButton saveButton;
    private JTextField textFieldName;
    private JTextField textFieldEmail;
    private JTextField textFieldCpf;
    private JTextField textFieldTelefone;

    public People() {
        setContentPane(jPanelPessoas);
        setSize(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }
}



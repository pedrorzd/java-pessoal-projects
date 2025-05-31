package main.java.com.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class People extends JFrame {
    public JPanel jPanelPessoas;
    private JButton saveButton;
    private JTextField textFieldName;
    private JTextField textFieldEmail;
    private JTextField textFieldCpf;
    private JTextField textFieldTelefone;
    private JButton editarButton;
    private JButton limparButton;
    private JButton excluirButton;
    private JPanel jPanelButtons;
    private JPanel JPanelnputs;

    public People() {
        setContentPane(jPanelPessoas);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Pessoas");
        setSize(600,450);
        setLocationRelativeTo(null);
        setVisible(true);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}



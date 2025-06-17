package main.java.com.View;

import main.java.com.Controller.ClientesDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clientes extends JFrame {
    private JPanel JPanelClientes;
    private JPanel JPanelDados;
    private JTextField textFieldNome;
    private JTextField textFieldCPF;
    private JTextField textFieldEmail;
    private JTextField textFieldTelefone;
    private JTextField textFieldEndereco;
    private JPanel JPanelButtons;
    private JButton excluirButton;
    private JButton editarButton;
    private JButton limparButton;
    private JButton salvarButton;

    public Clientes() {
        setSize(500,500);
        setContentPane(JPanelClientes);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        //botao de salvar
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldNome.getText().toString().trim();
                String cpf = textFieldCPF.getText().toString().trim();
                String email = textFieldEmail.getText().toString().trim();
                String telefone = textFieldTelefone.getText().toString().trim();
                String endereco = textFieldEndereco.getText().toString().trim();

                main.java.com.Model.Clientes cliente = new main.java.com.Model.Clientes();
                cliente.setNome(nome);
                cliente.setCpf(cpf);
                cliente.setEmail(email);
                cliente.setTelefone(telefone);
                cliente.setEndereco(endereco);

                ClientesDAO clientesDAO = new ClientesDAO();
                clientesDAO.InserirClienteBD(cliente);
            }
        });
        //botao de limpar
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparDados();
            }
        });
        //botao de editar
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        //botao de excluir
        /*
        excluirButton.addActionListener(new ActionListener() {

        });
         */
    }

    public void limparDados() {
        textFieldNome.setText("");
        textFieldCPF.setText("");
        textFieldEmail.setText("");
        textFieldTelefone.setText("");
        textFieldEndereco.setText("");

    }
}

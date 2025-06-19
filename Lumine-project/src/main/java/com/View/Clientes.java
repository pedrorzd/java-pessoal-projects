package main.java.com.View;

import main.java.com.Controller.ClientesDAO;
import main.java.com.DAO.FabricaConexao;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

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
    private JTextField textFieldId;
    private JPanel JPanelTabela;
    private JTable tableClientes;

    public Clientes() {
        setSize(800,700);
        setContentPane(JPanelClientes);
        setTitle("Cadastro de Clientes");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        carregarDados();

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

                limparDados();
                carregarDados();
            }
        });
        //botao de limpar
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparDados();
                carregarDados();
            }
        });
        //botao de editar
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(textFieldId.getText().toString());
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
                cliente.setId(id);

                ClientesDAO clientesDAO = new ClientesDAO();
                clientesDAO.alteraDados(cliente);

                limparDados();
                carregarDados();
            }
        });
        //botao de excluir
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(textFieldId.getText().toString());

                main.java.com.Model.Clientes cliente = new main.java.com.Model.Clientes();
                cliente.setId(id);

                ClientesDAO clientesDAO = new ClientesDAO();
                clientesDAO.deletaDados(cliente);

                limparDados();
                carregarDados();
            }
        });

        //selecionar linha tabela
        tableClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e){
                if(!e.getValueIsAdjusting()){
                    int linhaSelecionada = tableClientes.getSelectedRow();
                    if(linhaSelecionada != -1){
                        textFieldId.setText(tableClientes.getValueAt(linhaSelecionada, 0).toString());
                        textFieldNome.setText(tableClientes.getValueAt(linhaSelecionada, 1).toString());
                        textFieldCPF.setText(tableClientes.getValueAt(linhaSelecionada, 2).toString());
                        textFieldEmail.setText(tableClientes.getValueAt(linhaSelecionada, 3).toString());
                        textFieldTelefone.setText(tableClientes.getValueAt(linhaSelecionada, 4).toString());
                        textFieldEndereco.setText(tableClientes.getValueAt(linhaSelecionada, 5).toString());
                    }
                }
            }
        });

    }

    public void carregarDados() {
        try(Connection conn = FabricaConexao.conectar()){
            String query = "SELECT id, nome, cpf, email, telefone, endereco FROM clientes";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            Vector<String> colunas = new Vector<>();
            colunas.add("ID");
            colunas.add("Nome");
            colunas.add("CPF");
            colunas.add("Email");
            colunas.add("Telefone");
            colunas.add("Endereco");

            Vector<Vector<Object>> dados = new Vector<>();
            while (rs.next()) {
                Vector<Object> linha = new Vector<>();
                linha.add(rs.getInt("id"));
                linha.add(rs.getString("nome"));
                linha.add(rs.getString("cpf"));
                linha.add(rs.getString("email"));
                linha.add(rs.getString("telefone"));
                linha.add(rs.getString("endereco"));
                dados.add(linha);
            }
            tableClientes.setModel(new DefaultTableModel(dados, colunas));
            tableClientes.setRowHeight(20);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void limparDados() {
        textFieldNome.setText("");
        textFieldCPF.setText("");
        textFieldEmail.setText("");
        textFieldTelefone.setText("");
        textFieldEndereco.setText("");

    }
}

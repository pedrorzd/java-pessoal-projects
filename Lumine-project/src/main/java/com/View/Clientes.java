package main.java.com.View;

import main.java.com.Controller.ClienteDAO;
import main.java.com.DAO.FabricaConexao;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class Clientes extends JFrame {
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
    private JPanel tabelaClientes;
    private JTable tabelaCliente;

    public Clientes() {
        setContentPane(jPanelPessoas);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Pessoas");
        setSize(600,450);
        setLocationRelativeTo(null);
        setVisible(true);
        carregarDados();

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carregarDados();

                String nome = textFieldName.getText().toString().trim();
                String cpf = textFieldCpf.getText().toString().trim();
                String email = textFieldEmail.getText().toString().trim();
                String telefone = textFieldTelefone.getText().toString().trim();

                main.java.com.Model.Clientes people = new main.java.com.Model.Clientes();
                people.setNome(nome);
                people.setCpf(cpf);
                people.setEmail(email);
                people.setTelefone(telefone);

                ClienteDAO salvaClienteBanco = new ClienteDAO();
                salvaClienteBanco.InserirClienteBD(people);
            }
        });
        /*
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // textid dando erro por que é o campo do ID, como no meu nao tem, da um erro
                int id = Integer.parseInt(textId.getText().toString());
                main.java.com.Model.Clientes clientes = new main.java.com.Model.Clientes();
                clientes.setId(id);
                ClienteDAO cliDAO = new ClienteDAO();
                cliDAO.deletaDados(clientes);
                carregarDados();
                limpaDados();
            }
        });
         */
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpaDados();
            }
        });


        //selecionar linha da tabela
        tabelaCliente.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()){
                    int linhaSelecionada = tabelaCliente.getSelectedRow();
                    if (linhaSelecionada !=1){

                        textFieldName.setText(tabelaCliente.getValueAt(linhaSelecionada, 0).toString());
                        textFieldCpf.setText(tabelaCliente.getValueAt(linhaSelecionada, 1).toString());
                        textFieldEmail.setText(tabelaCliente.getValueAt(linhaSelecionada, 2).toString());
                        textFieldTelefone.setText(tabelaCliente.getValueAt(linhaSelecionada, 3).toString());

                    }
                }
            }
        });
    }

    public void carregarDados(){
        try(Connection conn = FabricaConexao.conectar()){

            String query = "Select id, nome, cpf, endereco, telefone From Clientes";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            Vector<String> colunas = new Vector<>();
            colunas.add("Id");
            colunas.add("Nome");
            colunas.add("Cpf");
            colunas.add("Endereço");
            colunas.add("Telefone");

            Vector<Vector<Object>> dados = new Vector<>();
            while (rs.next()){
                Vector<Object> linha = new Vector<>();
                linha.add(rs.getString("id"));
                linha.add(rs.getString("nome"));
                linha.add(rs.getString("cpf"));
                linha.add(rs.getString("endereco"));
                linha.add(rs.getString("telefone"));
                dados.add(linha);
            }
            //cria tabela com linhas e colunas
            tabelaCliente.setModel(new DefaultTableModel(dados, colunas));
            tabelaCliente.setRowHeight(30);
        }
        catch (SQLException e){
            System.out.println("Erro ao obter clientes " + e.getMessage());
        }
    }

    public void limpaDados(){
        textFieldTelefone.setText("");
        textFieldEmail.setText("");
        textFieldCpf.setText("");
        textFieldName.setText("");
    }
}



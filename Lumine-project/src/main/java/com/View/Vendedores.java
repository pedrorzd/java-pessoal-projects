package main.java.com.View;

import main.java.com.Controller.ClientesDAO;
import main.java.com.Controller.VendedorDAO;
import main.java.com.DAO.FabricaConexao;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class Vendedores extends JFrame {
    public JPanel jPanelVendedores;
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
    private JPanel tabelaVendedores;
    private JTable tabelaVendedor;
    private JTextField textFieldEndereco;

    public Vendedores() {
        setContentPane(jPanelVendedores);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Vendedores");
        setSize(600,450);
        setLocationRelativeTo(null);
        setVisible(true);
        carregarDados();

        //botao de acicionar vendedor no BD
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carregarDados();

                String nome = textFieldName.getText().toString().trim();
                String cpf = textFieldCpf.getText().toString().trim();
                String endereco = textFieldEndereco.getText().toString().trim();
                String email = textFieldEmail.getText().toString().trim();
                String telefone = textFieldTelefone.getText().toString().trim();

                main.java.com.Model.Vendedores vendedor = new main.java.com.Model.Vendedores();
                vendedor.setNome(nome);
                vendedor.setCpf(cpf);
                vendedor.setEndereco(endereco);
                vendedor.setEmail(email);
                vendedor.setTelefone(telefone);

                VendedorDAO vendedorDAO = new VendedorDAO();
                vendedorDAO.InserirVendedorBD(vendedor);

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
        tabelaVendedor.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()){
                    int linhaSelecionada = tabelaVendedor.getSelectedRow();
                    if (linhaSelecionada !=1){

                        textFieldName.setText(tabelaVendedor.getValueAt(linhaSelecionada, 0).toString());
                        textFieldCpf.setText(tabelaVendedor.getValueAt(linhaSelecionada, 1).toString());
                        textFieldEmail.setText(tabelaVendedor.getValueAt(linhaSelecionada, 2).toString());
                        textFieldTelefone.setText(tabelaVendedor.getValueAt(linhaSelecionada, 3).toString());

                    }
                }
            }
        });
    }

    public void carregarDados(){
        try(Connection conn = FabricaConexao.conectar()){

            String query = "Select id, nome, cpf, endereco, telefone, email From Clientes";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            Vector<String> colunas = new Vector<>();
            colunas.add("Id");
            colunas.add("Nome");
            colunas.add("Cpf");
            colunas.add("Endereço");
            colunas.add("Telefone");
            colunas.add("Email");

            Vector<Vector<Object>> dados = new Vector<>();
            while (rs.next()){
                Vector<Object> linha = new Vector<>();
                linha.add(rs.getString("id"));
                linha.add(rs.getString("nome"));
                linha.add(rs.getString("cpf"));
                linha.add(rs.getString("endereco"));
                linha.add(rs.getString("telefone"));
                linha.add(rs.getString("email"));
                dados.add(linha);
            }
            //cria tabela com linhas e colunas
            tabelaVendedor.setModel(new DefaultTableModel(dados, colunas));
            tabelaVendedor.setRowHeight(30);
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
        textFieldEndereco.setText("");
    }
}



package main.java.com.View;

import main.java.com.Controller.FornecedoresDAO;
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


public class Fornecedores extends JFrame {
    public JPanel JPanelSuppliers;
    private JPanel JPanelInputs;
    private JPanel JPanelButtons;
    private JButton apagarButton;
    private JButton editarButton;
    private JButton adicionarButton;
    private JRadioButton ativoRadioButton;
    private JTextField textFieldTipoProduto;
    private JTextField textFieldNome;
    private JTextField textFieldEndereco;
    private JTextField textFieldCnpj;
    private JTextField textFieldTelefone;
    private JRadioButton inativoRadioButton;
    private JTextField textFieldEmail;
    private JButton limparButton;
    private JTextField textFieldId;
    private JTable tableFornecedores;

    public Fornecedores() {
        setContentPane(JPanelSuppliers);
        setSize(800,700);
        setTitle("Cadastro de Fornecedores");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        carregarDados();

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldNome.getText();
                String telefone = textFieldTelefone.getText();
                String cnpj = textFieldCnpj.getText();
                String email = textFieldEmail.getText();
                String endereco = textFieldEndereco.getText();
                String tipoProduto = textFieldTipoProduto.getText();
                String status = null;
                if (ativoRadioButton.isSelected()) {
                    inativoRadioButton.setSelected(false);
                    status = "Ativo";
                }
                else if (inativoRadioButton.isSelected()) {
                    ativoRadioButton.setSelected(false);
                    status = "Inativo";
                }

                main.java.com.Model.Fornecedores fornecedor = new main.java.com.Model.Fornecedores();
                fornecedor.setNomeFornecedor(nome);
                fornecedor.setCnpj(cnpj);
                fornecedor.setEndereco(endereco);
                fornecedor.setEmailFornecedor(email);
                fornecedor.setTelefoneFornecedor(telefone);
                fornecedor.setProduto(tipoProduto);
                fornecedor.setStatusDeAtividade(status);

                FornecedoresDAO fornecedoresDAO = new FornecedoresDAO();
                fornecedoresDAO.inserirFornecedor(fornecedor);

                limparDados();
                carregarDados();
            }
        });
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparDados();
                carregarDados();
            }
        });
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(textFieldId.getText().toString());
                String nome = textFieldNome.getText().toString().trim();
                String telefone = textFieldTelefone.getText().toString().trim();
                String cnpj = textFieldCnpj.getText().toString().trim();
                String email = textFieldEmail.getText().toString().trim();
                String endereco = textFieldEndereco.getText().toString().trim();
                String tipoProduto = textFieldTipoProduto.getText().toString().trim();
                String status = null;
                if (ativoRadioButton.isSelected()) {
                    inativoRadioButton.setSelected(false);
                    status = "Ativo";
                }
                else if (inativoRadioButton.isSelected()) {
                    ativoRadioButton.setSelected(false);
                    status = "Inativo";
                }

                main.java.com.Model.Fornecedores fornecedor = new main.java.com.Model.Fornecedores();
                fornecedor.setNomeFornecedor(nome);
                fornecedor.setCnpj(cnpj);
                fornecedor.setEndereco(endereco);
                fornecedor.setEmailFornecedor(email);
                fornecedor.setTelefoneFornecedor(telefone);
                fornecedor.setProduto(tipoProduto);
                fornecedor.setStatusDeAtividade(status);

                FornecedoresDAO fornecedoresDAO = new FornecedoresDAO();
                fornecedoresDAO.alterarFornecedor(fornecedor);

                limparDados();
                carregarDados();
            }
        });
        apagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(textFieldId.getText().toString());

                main.java.com.Model.Fornecedores fornecedor = new main.java.com.Model.Fornecedores();
                fornecedor.setId(id);

                FornecedoresDAO fornecedoresDAO = new FornecedoresDAO();
                fornecedoresDAO.excluirFornecedor(fornecedor);

                limparDados();
                carregarDados();
            }
        });

        tableFornecedores.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                if (!e.getValueIsAdjusting()){
                    int linha = tableFornecedores.getSelectedRow();
                    if (linha != -1){
                        textFieldId.setText(String.valueOf(tableFornecedores.getValueAt(linha,0)));
                        textFieldNome.setText(tableFornecedores.getValueAt(linha,1).toString());
                        textFieldCnpj.setText(tableFornecedores.getValueAt(linha,2).toString());
                        textFieldEndereco.setText(tableFornecedores.getValueAt(linha,3).toString());
                        textFieldEmail.setText(tableFornecedores.getValueAt(linha,4).toString());
                        textFieldTelefone.setText(tableFornecedores.getValueAt(linha,5).toString());
                        textFieldTipoProduto.setText(tableFornecedores.getValueAt(linha,6).toString());
                        inativoRadioButton.setSelected(false);
                        ativoRadioButton.setSelected(true);
                    }
                }
            }
        });
    }

    private void limparDados() {
        textFieldNome.setText("");
        textFieldTelefone.setText("");
        textFieldCnpj.setText("");
        textFieldEmail.setText("");
        textFieldEndereco.setText("");
        textFieldTipoProduto.setText("");
        inativoRadioButton.setSelected(false);
        ativoRadioButton.setSelected(false);
    }

    public void carregarDados() {
        try {
            Connection conn = FabricaConexao.conectar();
            String sql = "select * from fornecedores";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            Vector<String> colunas = new Vector<>();
            colunas.add("ID");
            colunas.add("Nome");
            colunas.add("CNPJ");
            colunas.add("Endereco");
            colunas.add("Email");
            colunas.add("Telefone");
            colunas.add("Produto");
            colunas.add("Status");

            Vector<Vector<Object>> dados = new Vector<>();
            while (rs.next()) {
                Vector<Object> linha = new Vector<>();
                linha.add(rs.getInt("id"));
                linha.add(rs.getString("nomeFornecedor"));
                linha.add(rs.getString("cnpj"));
                linha.add(rs.getString("endereco"));
                linha.add(rs.getString("emailFornecedor"));
                linha.add(rs.getString("telefoneFornecedor"));
                linha.add(rs.getString("produto"));
                linha.add(rs.getString("statusDeAtividade"));
                dados.add(linha);
            }
            tableFornecedores.setModel(new DefaultTableModel(dados, colunas));
            tableFornecedores.setRowHeight(20);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

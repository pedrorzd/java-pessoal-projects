package main.java.com.View;

import main.java.com.Controller.ProdutosDAO;
import main.java.com.DAO.FabricaConexao;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class Produtos extends JFrame {
    public JPanel jPanelProdutos;
    private JTextField textFieldCodigo;
    private JTextField textFieldNome;
    private JTextField textFieldPrecoEntrada;
    private JButton saveButton;
    private JPanel JPanelButtons;
    private JButton editarButton;
    private JPanel JPanelDados;
    private JComboBox comboBoxFornecedor;
    private JTextField textFieldQuantidade;
    private JTextField textFieldPrecoVenda;
    private JButton limparButton;
    private JButton excluirButton;
    private JTextField textFieldID;
    private JTable tableProduto;

    public Produtos(){
        setContentPane(jPanelProdutos);
        setSize(800,700);
        setTitle("Cadastro de Produtos");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        preencherComboFornecedor();
        carregaDados();

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = textFieldCodigo.getText().trim();
                String descricao = textFieldNome.getText().toString();
                double precoEntrada = Double.parseDouble(textFieldPrecoEntrada.getText().trim());
                double precoVenda = Double.parseDouble(textFieldPrecoVenda.getText().trim());
                int quantidade = Integer.parseInt(textFieldQuantidade.getText().trim());
                String fornecedor = (String) comboBoxFornecedor.getSelectedItem();

                main.java.com.Model.Produtos produtos = new main.java.com.Model.Produtos();
                produtos.setCodigo(codigo);
                produtos.setDescricao(descricao);
                produtos.setPrecoEntrada(precoEntrada);
                produtos.setPrecoVenda(precoVenda);
                produtos.setQuantidade(quantidade);
                produtos.setFornecedor(fornecedor);

                ProdutosDAO produtosDAO = new ProdutosDAO();
                produtosDAO.inserirProdutoBD(produtos);

                limpaDados();
                carregaDados();
            }
        });

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(textFieldID.getText().trim());
                String codigo = textFieldCodigo.getText().trim();
                String descricao = textFieldNome.getText().toString();
                double precoEntrada = Double.parseDouble(textFieldPrecoEntrada.getText().trim());
                double precoVenda = Double.parseDouble(textFieldPrecoVenda.getText().trim());
                int quantidade = Integer.parseInt(textFieldQuantidade.getText().trim());
                String fornecedor = comboBoxFornecedor.getSelectedItem().toString();
                System.out.println(fornecedor);

                main.java.com.Model.Produtos produtos = new main.java.com.Model.Produtos();
                produtos.setCodigo(codigo);
                produtos.setDescricao(descricao);
                produtos.setPrecoEntrada(precoEntrada);
                produtos.setPrecoVenda(precoVenda);
                produtos.setQuantidade(quantidade);
                produtos.setFornecedor(fornecedor);
                produtos.setId(id);

                ProdutosDAO produtosDAO = new ProdutosDAO();
                produtosDAO.alterarDados(produtos);

                carregaDados();
                limpaDados();

            }
        });

        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpaDados();
                carregaDados();
            }
        });

        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(textFieldID.getText().trim());

                main.java.com.Model.Produtos produtos = new main.java.com.Model.Produtos();
                produtos.setId(id);

                ProdutosDAO produtosDAO = new ProdutosDAO();
                produtosDAO.excluirDados(produtos);

                limpaDados();
                carregaDados();
            }
        });

        tableProduto.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                if(!e.getValueIsAdjusting()){
                    int linha = tableProduto.getSelectedRow();
                    if(linha != -1){
                        textFieldID.setText(String.valueOf(tableProduto.getValueAt(linha,0)));
                        textFieldCodigo.setText(String.valueOf(tableProduto.getValueAt(linha,1)));
                        textFieldNome.setText(String.valueOf(tableProduto.getValueAt(linha,2)));
                        textFieldPrecoEntrada.setText(String.valueOf(tableProduto.getValueAt(linha,3)));
                        textFieldPrecoVenda.setText(String.valueOf(tableProduto.getValueAt(linha,4)));
                        textFieldQuantidade.setText(String.valueOf(tableProduto.getValueAt(linha,5)));
                        comboBoxFornecedor.setSelectedItem(String.valueOf(tableProduto.getValueAt(linha,6)));
                    }
                }
            }
        });

    }

    public void limpaDados() {
        textFieldCodigo.setText("");
        textFieldNome.setText("");
        textFieldPrecoEntrada.setText("");
        textFieldPrecoVenda.setText("");
        textFieldQuantidade.setText("");
        comboBoxFornecedor.setSelectedIndex(0);
        textFieldID.setText("");
    }

    public void carregaDados(){
        try {
            Connection conn = FabricaConexao.conectar();
            String sql = "select * from produtos";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            Vector<String> colunas = new Vector<>();
            colunas.add("ID");
            colunas.add("Código");
            colunas.add("Descricao");
            colunas.add("PrecoEntrada");
            colunas.add("PrecoVenda");
            colunas.add("Quantidade");
            colunas.add("Fornecedor");

            Vector<Vector<Object>> dados = new Vector<>();
            while(rs.next()){
                Vector<Object> linha = new Vector<>();
                linha.add(rs.getInt("id"));
                linha.add(rs.getString("codProduto"));
                linha.add(rs.getString("descricao"));
                linha.add(rs.getDouble("precoCompra"));
                linha.add(rs.getDouble("precoVenda"));
                linha.add(rs.getInt("qtdeEstoque"));
                linha.add(rs.getString("fornecedor"));
                dados.add(linha);
            }
            tableProduto.setModel(new DefaultTableModel(dados, colunas));
            tableProduto.setRowHeight(20);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void preencherComboFornecedor(){
        try {
            String query = "SELECT nomeFornecedor FROM fornecedores";
            PreparedStatement pstmt = FabricaConexao.conectar().prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                comboBoxFornecedor.addItem(rs.getString("nomeFornecedor"));
            }
            pstmt.close();
            rs.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

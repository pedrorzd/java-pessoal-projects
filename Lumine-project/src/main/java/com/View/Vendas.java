package main.java.com.View;

import javax.swing.*;

import main.java.com.Controller.ClientesDAO;
import main.java.com.Controller.VendedorDAO;
import main.java.com.DAO.FabricaConexao;
import main.java.com.Model.Clientes;
import main.java.com.Model.Vendedores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Vendas extends JFrame{
    private JButton novaVendaButton;
    private JButton finalizarVendaButton;
    private JButton sairButton;
    private JComboBox comboBoxVendedor;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBoxCliente;
    private JRadioButton cartãoDeCréditoRadioButton;
    private JRadioButton PIXRadioButton;
    private JRadioButton boletoRadioButton;
    private JRadioButton cartãoDébitoRadioButton;
    private JTextField textField3;
    private JTextField textField5;
    private StringBuilder itensSelecionados;
    private JPanel JPanelVendas;
    private JButton inserirButton;
    private JComboBox jcbProduto;
    private JLabel labelListaProd;
    private JLabel labelValorTotal;

    double acumulado = 0.0;

    public Vendas(){
        setSize(850,750);
        setContentPane(JPanelVendas);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        preencherComboProduto();
        preencherComboClintes();
        preencherComboVendedores();

        itensSelecionados = new StringBuilder("Valor total: <br>");
        jcbProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeSelecionado = (String) jcbProduto.getSelectedItem();
                if (nomeSelecionado != null){
                    try {
                        String sql = "SELECT precoVenda, codProduto FROM produtos WHERE descricao = ?";
                        PreparedStatement ps = FabricaConexao.conectar().prepareStatement(sql);
                        ps.setString(1, nomeSelecionado);
                        ResultSet rs = ps.executeQuery();
                        if (rs.next()){
                            double preco = rs.getDouble("precoVenda");
                            textField5.setText(String.format("%.2f", preco));
                            String codigo = rs.getString("codProduto");
                            textField3.setText(codigo);
                        }
                        else{
                            textField5.setText("Não encontrado");
                        }
                    }
                    catch (SQLException ex){
                        JOptionPane.showMessageDialog(null, "Erro ao buscar preço: "+ ex.getMessage());
                    }
                }
            }
        });

        inserirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 String nomeProduto = (String) jcbProduto.getSelectedItem();
                 String precoProduto = (String) textField5.getText();

                 String precoProdutoTexto = textField5.getText();

                 if (!precoProdutoTexto.isEmpty()){
                     precoProdutoTexto = precoProdutoTexto.replace("," , ".");
                     double precoProdutoValor = Double.parseDouble(precoProdutoTexto);

                     acumulado += precoProdutoValor;

                     textField5.setText("");

                     itensSelecionados.append(nomeProduto).append("<br>");
                     itensSelecionados.append(precoProdutoTexto).append("<br>");
                     labelListaProd.setText("<html>" + itensSelecionados.toString()+"</html>");

                     labelValorTotal.setText("Valor total :" + String.format("%.2f", acumulado));
                 }
            }
        });

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        novaVendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpaDados();
            }
        });
        finalizarVendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpaDados();
            }
        });
    }

    public void limpaDados(){
        textField1.setText("");
        textField2.setText("");
        comboBoxCliente.setSelectedIndex(0);
        comboBoxVendedor.setSelectedIndex(0);
        jcbProduto.setSelectedIndex(0);
        textField3.setText("");
        textField5.setText("");
        PIXRadioButton.setSelected(false);
        boletoRadioButton.setSelected(false);
        cartãoDeCréditoRadioButton.setSelected(false);
        cartãoDébitoRadioButton.setSelected(false);
        itensSelecionados.setLength(0);
        labelListaProd.setText("");
        labelValorTotal.setText("");
    }

    private void preencherComboProduto(){
        try {
            String sql = "SELECT descricao FROM produtos";
            PreparedStatement ps = FabricaConexao.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                jcbProduto.addItem(rs.getString("descricao"));
            }
            rs.close();
            ps.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    private void preencherComboClintes(){
        try {
            Clientes clientes = new Clientes();
            ClientesDAO cli = new ClientesDAO();
            ResultSet rs = cli.ListaClientes();
            ArrayList<String> listaClientes = new ArrayList<>();
            while (rs.next()){
                clientes.setNome(rs.getNString("nome"));
                clientes.setCpf(rs.getNString("cpf"));
                listaClientes.add(clientes.getNome()+"-"+clientes.getCpf());
            }
            for (String pecorrer : listaClientes){
                comboBoxCliente.addItem(pecorrer);
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    private void preencherComboVendedores(){
      try {
          Vendedores vendedor = new Vendedores();
          VendedorDAO cli = new VendedorDAO();
          ResultSet rs = cli.ListaVendedores();
          ArrayList<String> listaVendedores = new ArrayList<>();
          while (rs.next()) {
            vendedor.setNome(rs.getNString("nome"));
            vendedor.setCpf(rs.getNString("cpf"));
            listaVendedores.add(vendedor.getNome()+"-"+vendedor.getCpf());
          }
          for (String pecorrer : listaVendedores){
              comboBoxVendedor.addItem(pecorrer);
          }
      }
      catch (SQLException e){
            throw new RuntimeException(e);
      }

    }
}

package main.java.com.View;

import javax.swing.*;

import main.java.com.Controller.ClienteDAO;
import main.java.com.DAO.FabricaConexao;
import main.java.com.Model.Clientes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Sell extends JFrame{
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
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JPanel JPanelVendas;
    private JButton inserirButton;
    private JComboBox jcbProduto;

    public Sell(){
        setSize(1300,1000);
        setContentPane(JPanelVendas);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        preencherComboProduto();
        preencherComboClintes();

        jcbProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeSelecionado = (String) jcbProduto.getSelectedItem();
                if (nomeSelecionado != null){
                    try {
                        String sql = "SELECT precoVenda FROM produtos WHERE descricao = ?";
                        PreparedStatement ps = FabricaConexao.conectar().prepareStatement(sql);
                        ps.setString(1, nomeSelecionado);
                        ResultSet rs = ps.executeQuery();
                        if (rs.next()){
                            double preco = rs.getDouble("precoVenda");
                            textField5.setText(String.format("%.2f", preco));
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
            ClienteDAO cli = new ClienteDAO();
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

}

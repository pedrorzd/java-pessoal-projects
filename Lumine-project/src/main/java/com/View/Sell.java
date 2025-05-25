package main.java.com.View;

import javax.swing.*;

import main.java.com.Controller.ClienteDAO;
import main.java.com.View.Homepage;

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
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JPanel JPanelVendas;

    public Sell(){
        setSize(1300,1000);
        setContentPane(JPanelVendas);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        //preencherComboClientes();
        //preencherComboClientes();
    }
    private void preencherComboClintes(){
        try {
            ModelClientes clientes = new ModelClientes();
            ClienteDAO cli = new ClienteDAO();
            ResultSet rs = cli.ListaClientes();
            ArrayList<String> listaClientes = new ArrayList<>();
            while (rs.next()){
                clientes.setNome(rs.getNString("nome"));
                clientes.setCpf(rs.getNString("cpf"));
                listaClientes.add(clientes.getNome()+ "-"+clientes.getCpf());
            }
            for (String pecorrer : listaClientes){
                jcbClientes.addItem(pecorrer);
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}

package main.java.com.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import main.java.com.Controller.LoginDAO;
import main.java.com.Model.Usuarios;

public class Login extends JFrame {
    public JPanel JPanelLogin;
    public JPanel JPanelLateral;
    public JPanel JPanelUsuario;
    public JTextField JFieldUsuario;
    public JPanel JPanelSenha;
    public JPasswordField JFieldSenha;
    public JPanel JPanelButtons;
    public JButton JButtonLimpar;
    public JButton JButtonLogin;
    public JComboBox JClasse;

    public Login(){

        JButtonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = JFieldUsuario.getText();
                String senha = new String(JFieldSenha.getPassword());
                String perfil = String.valueOf(JClasse.getSelectedItem());
                //objeto da classe de verificacao
                LoginDAO loginDAO = new LoginDAO();

                Usuarios resultado = loginDAO.validarLogin (usuario, senha, perfil);

                if (resultado != null) {
                    JOptionPane.showMessageDialog(null,
                            "Login efetuado com sucesso! " +
                                    "\nUsuário: " + usuario +
                                    "\nPerfil do Usuário: " + perfil
                    );
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(JPanelLogin);
                    frame.dispose();
                    SwingUtilities.invokeLater(() -> {
                        Homepage telaPrincipal = new Homepage();

                        if (resultado.getPerfil().equals("usuario")){
                            telaPrincipal.jMenuCadastro.setVisible(false);
                            telaPrincipal.setVisible(true);
                        }
                        else {
                            telaPrincipal.setVisible(true);
                        }
                    });

                }
                else if (usuario.isEmpty() || senha.isEmpty() || perfil.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"O login falhou!!"+
                            "\nAlgum dado obrigatório ficou de fora, preencha todos!");
                }
                else {
                    JOptionPane.showMessageDialog(null,"O login falhou!!"+
                            "\nVerifique os dados e tente novamente!");
                    JFieldUsuario.requestFocus();
                    JFieldUsuario.setText("");
                    JFieldSenha.setText("");
                }
            }
        });


        JFieldUsuario.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
            }
        });
    }
}
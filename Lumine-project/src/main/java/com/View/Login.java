package main.java.com.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.java.com.View.*;

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

                if (usuario.equals("Pedro") && senha.equals("12345")) {
                    JOptionPane.showMessageDialog(null,
                            "Login efetuado com sucesso! " +
                                    "\nUsuário: " + usuario +
                                    "\nPerfil do Usuário: " + perfil
                    );
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(JPanelLogin);
                    frame.dispose();
                    SwingUtilities.invokeLater(() -> {
                        Homepage telaPrincipal = new Homepage();
                        telaPrincipal.setVisible(true);
                    });
                } else if (usuario.isEmpty() || senha.isEmpty() || perfil.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"O login falhou!!"+
                            "\nAlgum dado obrigatório ficou de fora, preencha todos!");
                } else {
                    JOptionPane.showMessageDialog(null,"O login falhou!!"+
                            "\nVerifique os dados e tente novamente!");
                    JFieldUsuario.requestFocus();
                    JFieldUsuario.setText("");
                    JFieldSenha.setText("");
                }
            }
        });

    }
}

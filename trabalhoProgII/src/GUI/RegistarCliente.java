package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Entidades.Cliente;
import ExceptionMessage.ExisteUserException;
import PrivilegiosEntidades.PrivilegiosGeral;

public class RegistarCliente extends JFrame {
    private JTextField TFlocalidade;
    private JTextField TFusername;
    private JTextField TFmorada;
    private JTextField TFtelefone;
    private JTextField TFNIF;
    private JTextField TFnome;
    private JTextField TFnCC;
    private JPanel registocliente;
    private JButton OKButton;
    private JButton clearButton;
    private JButton returnButton;
    private JTextField TFpassword;
    private PrivilegiosGeral privilegio;

    public RegistarCliente(JFrame frame) {
        privilegio = new PrivilegiosGeral();
        frame.add(registocliente);
        frame.pack();
        frame.setVisible(true);
        clearButton(frame);
        returnButton(frame);
        okButton(frame);
    }

    public void okButton(JFrame frame) {
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = TFusername.getText();
                String password = TFpassword.getText();
                String nome = TFnome.getText();
                int numCC = Integer.parseInt(TFnCC.getText());
                int numIF = Integer.parseInt(TFNIF.getText());
                int telefone = Integer.parseInt(TFtelefone.getText());
                String morada = TFmorada.getText();
                String localidade = TFlocalidade.getText();

                Cliente user = new Cliente(username, password, nome, numCC, numIF, telefone, morada, localidade);

                try {
                    privilegio.adicionarUser(user);
                    JOptionPane.showMessageDialog(null, "Cliente registado!");
                    registocliente.setVisible(false);
                    new Login(frame);
                } catch (ExisteUserException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });
    }

    public void clearButton(JFrame frame) {
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TFusername.setText("");
                TFpassword.setText("");
                TFnome.setText("");
                TFnCC.setText("");
                TFNIF.setText("");
                TFtelefone.setText("");
                TFmorada.setText("");
                TFlocalidade.setText("");
            }
        });
    }

    public void returnButton(JFrame frame) {
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registocliente.setVisible(false);
                new Registo(frame);
            }
        });
    }
}

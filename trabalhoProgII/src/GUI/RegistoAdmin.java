package GUI;

import Entidades.Admin;
import Entidades.DonoServico;
import ExceptionMessage.ExisteUserException;
import PrivilegiosEntidades.PrivilegiosGeral;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistoAdmin extends JFrame {

    private JPanel registoadmin;
    private JTextField TFlocalidade;
    private JTextField TFusername;
    private JTextField TFmorada;
    private JTextField TFtelefone;
    private JTextField TFNIF;
    private JTextField TFnome;
    private JTextField TFnCC;
    private JButton OKButton;
    private JButton clearButton;
    private JButton returnButton;
    private JTextField TFpassword;
    private JPasswordField PFpassword;
    private PrivilegiosGeral privilegio;

    public RegistoAdmin(JFrame frame){
        frame.add(registoadmin);
        frame.pack();
        frame.setVisible(true);
        returnButton(frame);
        clearButton(frame);
        privilegio = new PrivilegiosGeral();
        okbutton(frame);
    }

    public void returnButton(JFrame frame){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registoadmin.setVisible(false);
                new AdminRegisto(frame);
            }
        });
    }
    public void clearButton(JFrame frame) {

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TFusername.setText("");
                PFpassword.setText("");
                TFnome.setText("");
                TFnCC.setText("");
                TFNIF.setText("");
                TFtelefone.setText("");
                TFmorada.setText("");
                TFlocalidade.setText("");
            }
        });
    }
    public void okbutton(JFrame frame){

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

                Admin user = new Admin(username,password,nome,numCC,numIF,telefone,morada,localidade);

                try{
                    privilegio.adicionarUser(user);
                    JOptionPane.showMessageDialog(null,"Admin registado!");
                    registoadmin.setVisible(false);
                    new AdminRegisto(frame);
                }catch (ExisteUserException ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }

            }
        });
    }



}

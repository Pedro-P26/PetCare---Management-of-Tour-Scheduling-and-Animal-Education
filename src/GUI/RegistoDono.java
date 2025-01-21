package GUI;

import Entidades.DonoServico;
import ExceptionMessage.ExisteUserException;
import PrivilegiosEntidades.PrivilegiosGeral;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class RegistoDono extends JFrame {

    private JPanel registodono;
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
    private JTextField tfpassword;

    private PrivilegiosGeral privilegio;

    public RegistoDono(JFrame frame){
        privilegio = new PrivilegiosGeral();
        frame.add(registodono);
        frame.pack();
        frame.setVisible(true);
        returnButton(frame);
        clearButton(frame);
        okbutton(frame);

    }
    public void okbutton(JFrame frame){

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = TFusername.getText();
                String password = tfpassword.getText();
                String nome = TFnome.getText();
                int numCC = Integer.parseInt(TFnCC.getText());
                int numIF = Integer.parseInt(TFNIF.getText());
                int telefone = Integer.parseInt(TFtelefone.getText());
                String morada = TFmorada.getText();
                String localidade = TFlocalidade.getText();

                DonoServico user = new DonoServico(username,password,nome,numCC,numIF,telefone,morada,localidade);

                try{
                    privilegio.adicionarUser(user);
                    JOptionPane.showMessageDialog(null,"Dono registado!");
                    registodono.setVisible(false);
                    new Login(frame);
                }catch (ExisteUserException ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }

            }
        });
    }

    public void returnButton(JFrame frame){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registodono.setVisible(false);
                new Registo(frame);
            }
        });
    }

    public void clearButton(JFrame frame) {

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TFusername.setText("");
                tfpassword.setText("");
                TFnome.setText("");
                TFnCC.setText("");
                TFNIF.setText("");
                TFtelefone.setText("");
                TFmorada.setText("");
                TFlocalidade.setText("");
            }
        });


    }
}

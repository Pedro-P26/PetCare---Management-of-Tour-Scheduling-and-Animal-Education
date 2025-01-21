package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Entidades.*;
import ExceptionMessage.ExisteUserException;
import PrivilegiosEntidades.LoginM;
import Repositorios.Repositorio;

public class Login extends JFrame {
    private JPanel painel1;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JButton loginButton;
    private JButton registarButton;
    private JButton clearButton;
    private JButton EXITButton;
    private LoginM l;

    public Login(JFrame frame) {
        l = new LoginM();
        frame.add(painel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        clearButton.addActionListener(new clearbutton());
        loginbutton(frame);
        Registar(frame);
        exitbutton(frame);
    }

    public class clearbutton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textField1.setText("");
            passwordField1.setText("");
        }
    }
    public void loginbutton(JFrame frame){
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicarloginbutton(frame);
            }
        });
    }
    public void clicarloginbutton(JFrame frame){
        String username,password;

        username = textField1.getText();
        password = passwordField1.getText();

        try{
            User login = l.Login(username,password);
            if (login instanceof Cliente){
                painel1.setVisible(false);
                new ClienteRegisto(frame);
            }else{
                if(login instanceof Admin){
                    painel1.setVisible(false);
                    new AdminRegisto(frame);
                }else{
                    if(login instanceof DonoServico){
                        painel1.setVisible(false);
                        new DonoRegisto(frame);
                    }else{
                        if(login instanceof Funcionario){
                            painel1.setVisible(false);
                            new FuncionarioRegisto(frame);
                        }
                    }
                }
            }

        } catch (ExisteUserException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    public void Registar(JFrame frame){
        registarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                painel1.setVisible(false);
                Registo registo = new Registo(frame);
                registo.setVisible(true);
            }
        });
    }

    public void exitbutton(JFrame frame){

        EXITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}

   /* public void loginbutton(JFrame frame) {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicarloginbutton(frame);
            }
        });
    }

    public void clicarloginbutton(JFrame frame) {
        String username, password;
        username = textField1.getText();
        password = passwordField1.getText();

        try {
            User login = l.Login(username, password);
            if (login instanceof Cliente) {
                painel1.setVisible(false);
                new ClienteRegisto(frame);
            }
        }
    }
}*/
        /*clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                passwordField1.setText("");
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField1.getText();
                String password = new String(passwordField1.getPassword());

                try {
                    login.login(username, password);
                    JOptionPane.showMessageDialog(null, "Login successful!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Login failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        registarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistarCliente registarCliente = new RegistarCliente();
                registarCliente.setVisible(true);
            }
        });
    }*/




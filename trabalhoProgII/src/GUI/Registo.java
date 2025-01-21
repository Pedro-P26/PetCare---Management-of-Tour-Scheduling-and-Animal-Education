package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registo extends JFrame {

    private JButton backButton;
    private JPanel registo;
    private JButton registarDonoButton;
    private JButton registarClienteButton;

    public Registo(JFrame frame){
        frame.add(registo);
        frame.pack();
        frame.setVisible(true);
        backButton(frame);
        registarDonoButton(frame);
        registarClienteButton(frame);
        frame.setSize(400, 300);
    }

    public void backButton(JFrame frame){
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registo.setVisible(false);
                new Login(frame);
            }
        });
    }

    public void registarDonoButton(JFrame frame){
        registarDonoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registo.setVisible(false);
                new RegistoDono(frame);
            }
        });
    }

    public void registarClienteButton(JFrame frame){
        registarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registo.setVisible(false);
                new RegistarCliente(frame);
            }
        });
    }
}

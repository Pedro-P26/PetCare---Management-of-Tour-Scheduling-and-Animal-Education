package GUI;

import Entidades.Animal;
import Entidades.User;
import ExceptionMessage.ExisteAnimalException;
import PrivilegiosEntidades.PrivilegiosCliente;
import Repositorios.Repositorio;
import Repositorios.RepositorioFicheiros;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class RegistarAnimal extends JFrame {
    private JTextField TFnomeAnimal;
    private JTextField TFespecie;
    private JTextField TFraca;
    private JButton clearbutton;
    private JButton introduzirbutton;
    private JPanel registaranimal;
    private JButton returnButton;
    private JTextField TFnchip;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JSpinner spinner3;
    private PrivilegiosCliente privilegio;

    public RegistarAnimal(JFrame frame, User iniUser) {
        privilegio = new PrivilegiosCliente();
        frame.add(registaranimal);
        frame.pack();
        frame.setVisible(true);
        clearButton(frame);
        returnButton(frame,iniUser);
        frame.setSize(700, 400);
        okButton(frame,Repositorio.getInstance().getAnimais());
        Date data = new Date();
        int ano = data.getYear() +1900;
        spinner1.setModel(new SpinnerNumberModel(1,1,31,1));
        spinner2.setModel(new SpinnerNumberModel(1,1,12,1));
        spinner3.setModel(new SpinnerNumberModel(2000,1900,ano,1));

    }

    public void clearButton(JFrame frame) {
        clearbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TFespecie.setText("");
                TFraca.setText("");
                TFnomeAnimal.setText("");
                spinner1.setValue(0);
                spinner2.setValue(0);
                spinner3.setValue(0);
            }
        });
    }

    public void returnButton(JFrame frame,User iniUser) {
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registaranimal.setVisible(false);
                new ClienteRegisto(frame);
            }
        });
    }

    public void okButton(JFrame frame, List<Animal> animais) {
        introduzirbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = TFnomeAnimal.getText();
                String raca= TFraca.getText();
                String especie = TFespecie.getText();
                int nchip = Integer.parseInt(TFnchip.getText());

                int dia = (int) spinner1.getValue();
                int mes = (int) spinner2.getValue();
                int ano = (int) spinner3.getValue();
                Date datanasc = new Date(ano-1900,mes,dia);
                System.out.println("Data:"+datanasc);

                Animal animal = new Animal (nome,especie,raca,nchip,datanasc,Repositorio.getInstance().getIniUser().getUsername());

                try{
                    privilegio.adicionarAnimal(animal,animais);
                    RepositorioFicheiros.serializarAnimal();
                    JOptionPane.showMessageDialog(null,"Animal Inserido!!");
                    registaranimal.setVisible(false);
                    new ClienteRegisto(frame);
                }catch (ExisteAnimalException ex){
                    JOptionPane.showMessageDialog(null,"Dados invalidos!!");
                }
            }
        });
    }


}

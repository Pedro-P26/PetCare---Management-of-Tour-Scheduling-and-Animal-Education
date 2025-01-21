package GUI;

import Entidades.Funcionario;
import Entidades.User;
import ExceptionMessage.ExisteFuncionarioException;
import ExceptionMessage.ExisteUserException;
import PrivilegiosEntidades.PrivilegiosDono;
import PrivilegiosEntidades.PrivilegiosGeral;
import Repositorios.Repositorio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.List;

public class RegistarFuncionario extends JFrame{
    private JTextField tfusername;
    private JTextField tfpassword;
    private JTextField tfnome;
    private JTextField tfnumcc;
    private JTextField tfnif;
    private JTextField tftelefone;
    private JTextField tfmorada;
    private JTextField tflocalidade;
    private JTextField tfsalario;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JSpinner spinner3;
    private JSpinner spinner4;
    private JButton clearButton;
    private JButton adicionarButton;
    private JTextField tfprofissao;
    private JButton returnButton;
    private JPanel registarfuncionario;
    private JComboBox comboBox1;
    private PrivilegiosDono privilegioD;
    private PrivilegiosGeral privilegioG;


    public RegistarFuncionario(JFrame frame, User iniUser){
        frame.add(registarfuncionario);
        frame.pack();
        frame.setVisible(true);
        privilegioD = new PrivilegiosDono();
        privilegioG = new PrivilegiosGeral();

        String[] tipo = {" ", "veterinario", "educador_animal", "auxiliar", "secretario"};
        comboBox1.setModel(new DefaultComboBoxModel<>(tipo));

        //Hora inicio
        spinner1.setModel(new SpinnerNumberModel(1,0,23,1));
        spinner2.setModel(new SpinnerNumberModel(1,0,59,1));

        //Hora fim
        spinner3.setModel(new SpinnerNumberModel(1,0,23,1));
        spinner4.setModel(new SpinnerNumberModel(1,0,59,1));


        adicionarfuncioanrio(frame,Repositorio.getInstance().getFuncionarios());
        back(frame,iniUser);

    }
    public void back(JFrame frame,User iniUser){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registarfuncionario.setVisible(false);
                new DonoGereFuncionarios(frame);
            }
        });
    }

    public void adicionarfuncioanrio(JFrame frame, List<Funcionario> funcionarios){
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfusername.getText();
                String password = tfpassword.getText();
                String nome = tfnome.getText();
                int numcc = Integer.parseInt(tfnumcc.getText());
                int nif = Integer.parseInt(tfnif.getText());
                int telefone = Integer.parseInt(tftelefone.getText());
                String morada = tfmorada.getText();
                String localidade = tflocalidade.getText();
                //String profissao = tfprofissao.getText();
                float salario = Float.parseFloat(tfsalario.getText());
                int horainicio = (int)spinner1.getValue();
                int mininicio = (int)spinner2.getValue();
                int horafim = (int)spinner3.getValue();
                int minfim = (int)spinner4.getValue();

                Funcionario funcionario = new Funcionario(username,password,nome,numcc,nif,telefone,morada,localidade,Funcionario.Tipopro.valueOf(comboBox1.getSelectedItem().toString()),salario,new Time(horainicio,mininicio,0),new Time(horafim,minfim,0), Repositorio.getInstance().getIniUser().getUsername());

                try{
                    privilegioD.adicionarfuncionario(funcionario,funcionarios);
                }catch (ExisteFuncionarioException ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }

                try{
                    privilegioG.adicionarUser(funcionario);
                    JOptionPane.showMessageDialog(null,"Funcionario Registado!!");
                    registarfuncionario.setVisible(false);
                    new DonoGereFuncionarios(frame);
                }catch (ExisteUserException ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }



            }

        });
    }
}

package GUI;

import Entidades.PrestadorServico;
import Entidades.TipoServico;
import ExceptionMessage.ExisteException;
import PrivilegiosEntidades.PrivilegiosDono;
import Repositorios.Repositorio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonoRegistarEmpresa extends JFrame {

    private JPanel donoregistarempresa;
    private JTextField tfnome;
    private JTextField tfmorada;
    private JTextField tflocalidade;
    private JTextField tftelefone;
    private JButton returnButton;
    private JButton clearButton;
    private JButton OKButton;
    private JComboBox comboBox1;

    public DonoRegistarEmpresa(JFrame frame){
        frame.add(donoregistarempresa);
        frame.pack();
        frame.setVisible(true);

        //String[] tipo = {" ", "educacao_de_cao", "passio_de_cao", "educacao_de_gato", "tosquia"};
        //comboBox1.setModel(new DefaultComboBoxModel<>(tipo));

        returnButton(frame);
        clearButton(frame);
        okButton(frame);
        frame.setSize(700, 300);
    }
    public void returnButton(JFrame frame){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donoregistarempresa.setVisible(false);
                new DonoGereEmpresa(frame);
            }
        });

    }
    public void clearButton(JFrame frame) {

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfnome.setText("");
                tfmorada.setText("");
                tflocalidade.setText("");
                tftelefone.setText("");
            }
        });
    }

    public void okButton(JFrame frame){

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int telefone = 0;

                try{
                    telefone = Integer.parseInt(tftelefone.getText());
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,"Contém letras no nºtelefone");
                }
                String nome = tfnome.getText();
                String morada = tfmorada.getText();
                String localidade = tflocalidade.getText();

                PrestadorServico prestadorservico = new PrestadorServico(nome,morada,localidade,telefone, Repositorio.getInstance().getIniUser().getUsername());

                try{
                    PrivilegiosDono.AdicionarEmpresa(prestadorservico, Repositorio.getInstance().getPrestadorservicos(), Repositorio.getInstance().getLocalidadeprestador());
                }catch (ExisteException ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }

                JOptionPane.showMessageDialog(null,"Empresa adicionada comsucesso!");
                donoregistarempresa.setVisible(false);
                new DonoGereEmpresa(frame);
            }
        });
    }


}

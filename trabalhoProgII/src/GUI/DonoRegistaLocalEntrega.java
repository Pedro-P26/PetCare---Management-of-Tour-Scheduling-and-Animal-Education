package GUI;

import Entidades.LocalEntrega;
import Entidades.User;

import ExceptionMessage.LocalEntregaException;
import PrivilegiosEntidades.PrivilegiosDono;
import Repositorios.Repositorio;
import Repositorios.RepositorioFicheiros;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DonoRegistaLocalEntrega extends JFrame{
    private JPanel donoregistalocalentrega;
    private JTextField TFlocalidade;
    private JTextField TFtelefone;
    private JTextField TFnome;
    private JButton OKButton;
    private JButton clearButton;
    private JButton returnButton;
    private JComboBox comboBox1;
    private JTextField TFcodpostal;
    private JTextField tftiposervico;
    private PrivilegiosDono privilegio;


    public DonoRegistaLocalEntrega(JFrame frame, User iniUser){
        frame.add(donoregistalocalentrega);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(700, 300);
        privilegio = new PrivilegiosDono();

        String[] tipo = {" ", "educacao_de_cao", "passio_de_cao", "educacao_de_gato", "tosquia"};
        comboBox1.setModel(new DefaultComboBoxModel<>(tipo));


        back(frame,iniUser);
        removerdados(frame);
        adicionarentrega(frame,Repositorio.getInstance().getLocalentregas());

    }

    public void back(JFrame frame,User iniUser){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donoregistalocalentrega.setVisible(false);
                new DonoGereEmpresa(frame);
            }
        });
    }
    public void removerdados(JFrame frame){
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TFnome.setText("");
                TFlocalidade.setText("");
                TFtelefone.setText("");
                TFcodpostal.setText("");
            }
        });
    }

    public void adicionarentrega(JFrame frame, List<LocalEntrega> localentregas){
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = TFnome.getText();
                String localidade = TFlocalidade.getText();
                int telefone = Integer.parseInt(TFtelefone.getText());
                //String codpostal = TFcodpostal.getText();
                //String tiposervico = tftiposervico.getText();
                LocalEntrega entrega = new LocalEntrega(nome,localidade,telefone, Repositorio.getInstance().getIniUser().getUsername(),LocalEntrega.tiposervico.valueOf(comboBox1.getSelectedItem().toString()));

                try{
                    privilegio.AdicionarLocalEntrega(entrega,localentregas);
                    RepositorioFicheiros.serializarLocalEntrega();
                    JOptionPane.showMessageDialog(null,"Local Entrega Adicionado");
                    donoregistalocalentrega.setVisible(false);
                    new DonoGereEmpresa(frame);
                }catch (LocalEntregaException ex){
                    JOptionPane.showMessageDialog(null,"Erro Dados!!");
                }
            }

        });
    }
}

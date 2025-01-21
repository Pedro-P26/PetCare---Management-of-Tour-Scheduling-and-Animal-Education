package GUI;

import Entidades.LocalEntrega;
import Entidades.LocalRecolha;
import Entidades.User;
import ExceptionMessage.localrecolhaException;
import PrivilegiosEntidades.PrivilegiosDono;
import Repositorios.Repositorio;
import Repositorios.RepositorioFicheiros;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DonoRegistaLocalRecolha {
    private JPanel donoregistalocalrecolha;
    private JTextField TFmorada;
    private JButton OKButton;
    private JButton clearButton;
    private JButton returnButton;
    private JTextField TFlocalidade;
    private JTextField TFtelefone;
    private JComboBox comboBox1;
    private JTextField TFcodpostal;
    private JTextField tftiposervico;
    private PrivilegiosDono privilegio;


    public DonoRegistaLocalRecolha(JFrame frame, User iniUser){
        privilegio = new PrivilegiosDono();
        frame.add(donoregistalocalrecolha);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(700, 300);

        String[] tipo = {" ", "educacao_de_cao", "passio_de_cao", "educacao_de_gato", "tosquia"};
        comboBox1.setModel(new DefaultComboBoxModel<>(tipo));

        cleardados(frame);
        adicionarrecolha(frame,Repositorio.getInstance().getLocalrecolhas());
        back(frame,iniUser);

    }
    public void adicionarrecolha(JFrame frame, List<LocalRecolha> localrecolhas){
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String morada = TFmorada.getText();
                String localidade = TFlocalidade.getText();
                int telefone = Integer.parseInt(TFtelefone.getText());
                //String codpostal = TFcodpostal.getText();
                //String tipo = tftiposervico.getText();

                LocalRecolha recolha = new LocalRecolha(morada,localidade,telefone, Repositorio.getInstance().getIniUser().getUsername(), LocalRecolha.Tipo.valueOf(comboBox1.getSelectedItem().toString()));

                try{
                    privilegio.AdicionarLocalRecolha(recolha,localrecolhas);
                    RepositorioFicheiros.serializarLocalRecolha();
                    JOptionPane.showMessageDialog(null,"Local Recolha Adicionado");
                    donoregistalocalrecolha.setVisible(false);
                    new DonoGereEmpresa(frame);
                }catch (localrecolhaException ex){
                    JOptionPane.showMessageDialog(null,"Erro Dados!!");
                }
            }
        });
    }

    public void cleardados(JFrame frame){
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TFmorada.setText("");
                TFlocalidade.setText("");
                TFtelefone.setText("");
                TFcodpostal.setText("");
            }
        });
    }

    public void back(JFrame frame,User iniUSer){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donoregistalocalrecolha.setVisible(false);
                new DonoGereEmpresa(frame);
            }
        });
    }



}

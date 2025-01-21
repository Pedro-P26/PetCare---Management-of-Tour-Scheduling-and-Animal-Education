package GUI;

import Entidades.PrestadorServico;
import ExceptionMessage.changeinfoException;
import PrivilegiosEntidades.PrivilegiosDono;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonoAlteraInfoPrestador2 extends JFrame {
    private PrestadorServico prestador;

    private JPanel donoalterainfofuncionario2;
    private JTextField tfnome;
    private JTextField tfmorada;
    private JTextField tflocalidade;
    private JTextField tftelefone;
    private JButton returnButton;
    private JButton clearButton;
    private JButton alterarButton;

    public DonoAlteraInfoPrestador2(JFrame frame, PrestadorServico prestador){
        frame.add(donoalterainfofuncionario2);
        frame.pack();
        frame.setVisible(true);
        this.prestador = prestador;

        tfnome.setText(prestador.getNome());
        tfmorada.setText(prestador.getMorada());
        tflocalidade.setText(prestador.getLocalidade());
        tftelefone.setText(String.valueOf(prestador.getTelefone()));

        alterarinfo(frame);
        clear(frame);
        back(frame);
    }

    public void alterarinfo(JFrame frame){
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int telefone = 0;

                String nome = tfnome.getText();
                String morada = tfmorada.getText();
                String localidade = tflocalidade.getText();

                try{
                    telefone = Integer.parseInt(tftelefone.getText());
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,"Existe letras no numtele!!!");
                }

                prestador.setNome(nome);
                prestador.setMorada(morada);
                prestador.setLocalidade(localidade);
                prestador.setTelefone(telefone);

                try{
                    PrivilegiosDono.changeinfoprestador(prestador);
                    JOptionPane.showMessageDialog(null,"Alterado!!");
                    donoalterainfofuncionario2.setVisible(false);
                    new DonoGereEmpresa(frame);
                }catch (changeinfoException ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }

    public void back(JFrame frame){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donoalterainfofuncionario2.setVisible(false);
                new DonoGereEmpresa(frame);
            }
        });
    }

    public void clear(JFrame frame){
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




}

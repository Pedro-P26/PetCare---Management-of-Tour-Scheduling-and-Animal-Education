package GUI;

import Entidades.LocalEntrega;
import ExceptionMessage.changeinfoException;
import PrivilegiosEntidades.PrivilegiosDono;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonoAlteraInfoLocalEntrega2 extends JFrame {
    private JPanel donoalterainfolocalentrega2;
    private JTextField tfmorada;
    private JTextField tflocalidade;
    private JTextField tftelefone;
    private JTextField tfnomeprestador;
    private JButton returnButton;
    private JButton alterarButton;
    private LocalEntrega entrega;



    public DonoAlteraInfoLocalEntrega2(JFrame frame, LocalEntrega entrega){
        frame.add(donoalterainfolocalentrega2);
        frame.pack();
        frame.setVisible(true);
        this.entrega = entrega;

        tfmorada.setText(entrega.getMorada());
        tflocalidade.setText(entrega.getLocalidade());
        tftelefone.setText(String.valueOf(entrega.getTelefone()));
        tfnomeprestador.setText(entrega.getNomeprestador());
        //tftiposervico.setText(entrega.getTiposervico());


        alterardados(frame,entrega);
        //backreturn(frame,entrega);
    }



    public void alterardados(JFrame frame, LocalEntrega entrega){
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int telefone = 0;

                String morada = tfmorada.getText();
                String localidade = tflocalidade.getText();
                String nomeprestador = tfnomeprestador.getText();
                //String tiposervico = tftiposervico.getText();

                try{
                    telefone = Integer.parseInt(tftelefone.getText());
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,"Contém letras!!");
                }

                entrega.setTelefone(telefone);
                entrega.setMorada(morada);
                entrega.setLocalidade(localidade);
                entrega.setNomeprestador(nomeprestador);
                //entrega.setTiposervico(tiposervico);

                try{
                    PrivilegiosDono.alterarinfolocalentrega(entrega);
                    JOptionPane.showMessageDialog(null,"Alterado!!");
                    donoalterainfolocalentrega2.setVisible(false);
                    new DonoGereEmpresa(frame);
                }catch (changeinfoException ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }

   /* public void backreturn(JFrame frame, LocalEntrega entrega){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donoalterainfolocalentrega2.setVisible(false);
                new DonoAlteraInfoLocalEntrega1(frame, LocalEntrega entrega);
            }
        });
    }*/


}

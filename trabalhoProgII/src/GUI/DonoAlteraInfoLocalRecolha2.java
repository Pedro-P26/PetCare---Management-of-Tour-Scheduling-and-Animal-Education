package GUI;

import Entidades.LocalEntrega;
import Entidades.LocalRecolha;
import ExceptionMessage.changeinfoException;
import PrivilegiosEntidades.PrivilegiosDono;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonoAlteraInfoLocalRecolha2 {
    private JPanel donoalteralocalrecolha2;
    private JTextField tfmorada;
    private JTextField tflocalidade;
    private JTextField tftelefone;
    private JTextField tfnomeprestador;
    private JButton returnButton;
    private JButton alterarButton;
    private LocalRecolha recolha;

    public DonoAlteraInfoLocalRecolha2(JFrame frame, LocalRecolha recolha){
        frame.add(donoalteralocalrecolha2);
        frame.pack();
        frame.setVisible(true);
        this.recolha = recolha;

        tfmorada.setText(recolha.getMorada());
        tflocalidade.setText(recolha.getLocalidade());
        tftelefone.setText(String.valueOf(recolha.getTelefone()));
        tfnomeprestador.setText(recolha.getNomeprestador());
        //tftiposervico.setText(recolha.getTiposervico());

        alterardados(frame,recolha);

    }
    public void alterardados(JFrame frame, LocalRecolha recolha){
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

                recolha.setTelefone(telefone);
                recolha.setMorada(morada);
                recolha.setLocalidade(localidade);
                recolha.setNomeprestador(nomeprestador);
                //recolha.setTiposervico(tiposervico);

                try{
                    PrivilegiosDono.alterarinfolocalrecolha(recolha);
                    JOptionPane.showMessageDialog(null,"Alterado!!");
                    donoalteralocalrecolha2.setVisible(false);
                    new DonoGereEmpresa(frame);
                }catch (changeinfoException ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }
     /* public void backreturn(JFrame frame, LocalRecolha recolha){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donoalteralocalrecolha2.setVisible(false);
                new DonoAlteraInfoLocalRecolha1(frame, LocalRecolha recolha);
            }
        });
    }*/
}

package GUI;

import Entidades.LocalEntrega;
import Entidades.LocalRecolha;
import Entidades.PrestadorServico;
import PrivilegiosEntidades.PrivilegiosDono;
import Repositorios.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonoAlteraInfoLocalRecolha1 {
    private JPanel donoalterainfolocalrecolha1;
    private JTable table1;
    private JButton returnButton;
    private JButton alterarButton;
    private JComboBox comboBox1;
    private PrestadorServico nomepre;


    public DonoAlteraInfoLocalRecolha1(JFrame frame, PrestadorServico nomepre){
        frame.add(donoalterainfolocalrecolha1);
        frame.pack();
        frame.setVisible(true);
        this.nomepre = nomepre;

        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        table1.setModel(model);

        model.addColumn("Morada");
        model.addColumn("Localidade");
        model.addColumn("Telefone");
        model.addColumn("Nome Prestador");
        model.addColumn("Tipo Servico");

        for(LocalRecolha recolha : Repositorio.getInstance().getLocalrecolhas()){
            if(Repositorio.getInstance().getIniUser().getUsername().equals(recolha.getNomeprestador())){
                model.addRow(new Object[]{recolha.getMorada(),recolha.getLocalidade(),recolha.getTelefone()});
                comboBox1.addItem(recolha.getTelefone());
            }
        }
        alterarinfo(frame);
        backreturn(frame);

    }
    public void alterarinfo(JFrame frame){
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tele = (int) comboBox1.getSelectedItem();
                LocalRecolha recolha = PrivilegiosDono.escolherlocalrecolha(tele);
                donoalterainfolocalrecolha1.setVisible(false);
                new DonoAlteraInfoLocalRecolha2(frame,recolha);
            }
        });
    }
    public void backreturn(JFrame frame){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donoalterainfolocalrecolha1.setVisible(false);
                new EscolherPrestadorAltInfoLocalRecolha(frame);
            }
        });
    }
}

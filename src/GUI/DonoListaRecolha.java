package GUI;

import Entidades.LocalRecolha;
import Entidades.PrestadorServico;
import Repositorios.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonoListaRecolha extends JFrame {


    private JPanel donolistarecolha;
    private JTable table1;
    private JButton returnButton;
    private PrestadorServico nomepre;


    public DonoListaRecolha(JFrame frame, PrestadorServico nomepre){
        frame.add(donolistarecolha);
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
                model.addRow(new Object[]{recolha.getMorada(),recolha.getLocalidade(),recolha.getTelefone(),recolha.getNomeprestador(),recolha.getTipos()});
            }
        }
        returnback(frame);
    }

    public void returnback(JFrame frame){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donolistarecolha.setVisible(false);
                new DonoGereEmpresa(frame);
            }
        });
    }
}

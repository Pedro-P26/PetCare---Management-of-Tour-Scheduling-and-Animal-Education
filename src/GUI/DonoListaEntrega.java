package GUI;

import Entidades.LocalEntrega;
import Entidades.PrestadorServico;
import Repositorios.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonoListaEntrega extends JFrame {
    private JPanel donolistaentrega;
    private JTable table1;
    private JButton returnButton;
    private PrestadorServico nomepre;


    public DonoListaEntrega(JFrame frame, PrestadorServico nomepre){
        frame.add(donolistaentrega);
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

        for(LocalEntrega entrega : Repositorio.getInstance().getLocalentregas()){
            if(Repositorio.getInstance().getIniUser().getUsername().equals(entrega.getNomeprestador())){
                model.addRow(new Object[]{entrega.getMorada(),entrega.getLocalidade(),entrega.getTelefone(),entrega.getNomeprestador(),entrega.getTipo()});

            }
        }
        returnback(frame);
    }
    public void returnback(JFrame frame){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donolistaentrega.setVisible(false);
                new DonoGereEmpresa(frame);
            }
        });
    }
}

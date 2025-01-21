package GUI;

import Entidades.Servico;
import Repositorios.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminListaServicos extends JFrame{
    private JPanel adminlistaservicos;
    private JTable table1;
    private JButton returnButton;


    public AdminListaServicos(JFrame frame){
        frame.add(adminlistaservicos);
        frame.pack();
        frame.setVisible(true);

        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        table1.setModel(model);

        model.addColumn("Cliente");
        model.addColumn("Nchip Animal");
        model.addColumn("Status Serviço");
        model.addColumn("Nome Prestador");


        for(Servico ser : Repositorio.getInstance().getServicos()){
            //if(ser.getStatusservico().equals(StatusServico.CONFIRMADA)){
                model.addRow(new Object[]{ser.getUsercliente(),ser.getNchip(),ser.getStatusservico(),ser.getNomeprestador()});

        }
        voltaback(frame);
    }

    public void voltaback(JFrame frame){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminlistaservicos.setVisible(false);
                new AdminRegisto(frame);
            }
        });
    }
}

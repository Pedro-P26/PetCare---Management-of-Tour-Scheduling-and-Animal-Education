package GUI;

import Entidades.Servico;
import Enumerados.StatusServico;
import Repositorios.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteListaServicos extends JFrame{
    private JPanel clientelistaservicos;
    private JTable table1;
    private JButton returnButton;


    public ClienteListaServicos(JFrame frame){
        frame.add(clientelistaservicos);
        frame.pack();
        frame.setVisible(true);

        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        table1.setModel(model);

        model.addColumn("Data servico");
        model.addColumn("Nchip Animal");
        model.addColumn("Status Servico");
        model.addColumn("Tipo Servico");
        model.addColumn("Nome Prestador");



        for (Servico ser : Repositorio.getInstance().getServicos()){
            if(ser.getUsercliente().equals(Repositorio.getInstance().getIniUser().getUsername())){
                model.addRow(new Object[]{ser.getDataservico(),ser.getNchip(),ser.getStatusservico(),ser.getTiposervico(),ser.getNomeprestador()});

            }
        }
        voltarback(frame);
    }

    public void voltarback(JFrame frame){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientelistaservicos.setVisible(false);
                new ClienteRegisto(frame);
            }
        });
    }
}

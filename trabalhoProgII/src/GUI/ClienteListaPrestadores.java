package GUI;

import Entidades.PrestadorServico;
import Repositorios.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteListaPrestadores extends JFrame {
    private JPanel clientelistaprestadores;
    private JTable table1;
    private JButton returnButton;

    public ClienteListaPrestadores(JFrame frame){
        frame.add(clientelistaprestadores);
        frame.pack();
        frame.setVisible(true);
        returnback(frame);

        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        table1.setModel(model);

        model.addColumn("Nome");
        model.addColumn("Morada");
        model.addColumn("Localidade");
        model.addColumn("Telefone");
        model.addColumn("Dono Prestador");

        for(PrestadorServico prestador : Repositorio.getInstance().getPrestadorservicos()){
            model.addRow(new Object[]{prestador.getNome(),prestador.getMorada(),prestador.getLocalidade(),prestador.getTelefone(),prestador.getDono()});

        }

    }

    public void returnback(JFrame frame){
         returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientelistaprestadores.setVisible(false);
                new ClienteRegisto(frame);
            }
        });
    }

}

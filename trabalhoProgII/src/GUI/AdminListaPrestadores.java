package GUI;

import Entidades.PrestadorServico;
import Repositorios.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminListaPrestadores extends JFrame {
    private JPanel adminlistaprestador;
    private JTable table1;
    private JButton returnButton;

    public AdminListaPrestadores(JFrame frame){
        frame.add(adminlistaprestador);
        frame.pack();
        frame.setVisible(true);

        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        table1.setModel(model);
        model.addColumn("Nome");
        model.addColumn("Morada");
        model.addColumn("Localidade");
        model.addColumn("Telefone");

        for(PrestadorServico prestador : Repositorio.getInstance().getPrestadorservicos()){
            model.addRow(new Object[] {prestador.getNome(),prestador.getMorada(),prestador.getLocalidade(),prestador.getTelefone()});
        }


        backbutton(frame);
    }

    public void backbutton(JFrame frame){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminlistaprestador.setVisible(false);
                new AdminRegisto(frame);
            }
        });
    }
}

package GUI;

import Entidades.PrestadorServico;
import Repositorios.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectPrestadorRemoveFun {
    private JPanel removefun;
    private JTable table1;
    private JButton OKButton;
    private JButton returnButton;
    private JComboBox box_nomeprestador;
    public SelectPrestadorRemoveFun(JFrame frame){

        frame.add(removefun);
        frame.pack();
        frame.setVisible(true);
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        table1.setModel(model);

        model.addColumn("Nome Prestador");
        model.addColumn("Dono Prestador");
        model.addColumn("Localidade");
        model.addColumn("Morada");
        model.addColumn("Telefone");

        for(PrestadorServico pre : Repositorio.getInstance().getPrestadorservicos()){
            if(pre.getDono().equals(Repositorio.getInstance().getIniUser().getUsername())){
                model.addRow(new Object[]{pre.getNome(),pre.getDono(),pre.getLocalidade(),pre.getMorada(),pre.getTelefone()});

                box_nomeprestador.addItem(pre.getNome());
            }
        }
        returnnbutton(frame);
        ok(frame);
    }

    public void returnnbutton(JFrame frame){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removefun.setVisible(false);
                new DonoGereFuncionarios(frame);
            }
        });
    }

    public void ok(JFrame frame){
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeprestador = (String) box_nomeprestador.getSelectedItem();
                removefun.setVisible(false);
                new DonoRemoveFuncionario(frame,nomeprestador);
            }
        });
    }

}


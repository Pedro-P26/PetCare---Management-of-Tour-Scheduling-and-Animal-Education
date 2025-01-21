package GUI;

import Entidades.Animal;
import Repositorios.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteListarAnimais extends JFrame{
    private JPanel clientelistanimais;
    private JButton returnButton;
    private JTable table1;

    public ClienteListarAnimais(JFrame frame){
        frame.add(clientelistanimais);
        frame.pack();
        frame.setVisible(true);
        DefaultTableModel model = (DefaultTableModel)table1.getModel();
        table1.setModel(model);

        model.addColumn("Nome");
        model.addColumn("Especie");
        model.addColumn("Raça");
        model.addColumn("Nºchip");
        model.addColumn("Data Nascimento:");

        for(Animal animal : Repositorio.getInstance().getAnimais()){
            if(animal.getDono().equals(Repositorio.getInstance().getIniUser().getUsername())){
                model.addRow(new Object[] {animal.getNome(),animal.getEspecie(),animal.getRaca(),animal.getNchip(),animal.getDatanasc()});
            }
        }


        backbutton(frame);
    }

    public void backbutton(JFrame frame){

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientelistanimais.setVisible(false);
                new ClienteRegisto(frame);
            }
        });
    }
}

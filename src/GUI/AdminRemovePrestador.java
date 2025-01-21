package GUI;

import Entidades.PrestadorServico;
import PrivilegiosEntidades.PrivilegiosAdmin;
import Repositorios.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminRemovePrestador extends JFrame{
    private JPanel adminremoveprestador;
    private JTable table1;
    private JButton removerButton;
    private JButton returnButton;
    private JComboBox comboBox1;

    public AdminRemovePrestador(JFrame frame){
        frame.add(adminremoveprestador);
        frame.pack();
        frame.setVisible(true);
        backbutton(frame);

        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        table1.setModel(model);
        model.addColumn("Nome");
        model.addColumn("Morada");
        model.addColumn("Localidade");
        model.addColumn("Telefone");
        model.addColumn("Dono");

        for(PrestadorServico prestador : Repositorio.getInstance().getPrestadorservicos()){
            model.addRow(new Object[]{prestador.getNome(),prestador.getMorada(),prestador.getLocalidade(),prestador.getTelefone(),prestador.getDono()});
           comboBox1.addItem(prestador.getNome());
        }
        removerprestador(frame);
    }

    public void backbutton(JFrame frame){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminremoveprestador.setVisible(false);
                new AdminRegisto(frame);
            }
        });
    }

    public void removerprestador(JFrame frame){
        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nome = (String) comboBox1.getSelectedItem();
                PrestadorServico prestador = PrivilegiosAdmin.prestadornome(nome);
                PrivilegiosAdmin.removeprestador(prestador);

                JOptionPane.showMessageDialog(null,"Removido!!");
                adminremoveprestador.setVisible(false);
                new AdminRegisto(frame);
            }
        });
    }




}

package GUI;

import Entidades.Servico;
import Entidades.User;
import Enumerados.StatusServico;
import PrivilegiosEntidades.PrivilegiosDono;
import Repositorios.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonoAlteraServico extends JFrame {
    private JPanel donoalteraservico;
    private JTable table1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton returnButton;
    private JButton alterarButton;

    public DonoAlteraServico(JFrame frame, User iniUser){
        frame.add(donoalteraservico);
        frame.pack();
        frame.setVisible(true);

        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        table1.setModel(model);

        model.addColumn("Data Servico");
        model.addColumn("Cliente");
        model.addColumn("Status");

        for(Servico ser : Repositorio.getInstance().getServicos()){
            if(Repositorio.getInstance().getIniUser().getUsername().equals(ser.getNomeprestador())){
                model.addRow(new Object[]{ser.getDataservico(),ser.getUsercliente(),ser.getStatusservico()});
                comboBox1.addItem(ser.getUsercliente());
            }
        }

        comboBox2.addItem("Anular");
        comboBox2.addItem("Confirmar");

        alterarservico(frame);

    }


    public void alterarservico(JFrame frame){
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cliente = (String) comboBox1.getSelectedItem();
                String status = (String) comboBox2.getSelectedItem();

                StatusServico stat = null;

                if(status.equals("Confirmar"))
                    stat=StatusServico.CONFIRMADA;
                else
                    if(status.equals("Anular"))
                        stat=StatusServico.ANULADA;

                PrivilegiosDono.alterarservico(stat,cliente);
                JOptionPane.showMessageDialog(null,"Alterado!!");
                donoalteraservico.setVisible(false);
                new DonoRegisto(frame);
            }
        });
    }
}

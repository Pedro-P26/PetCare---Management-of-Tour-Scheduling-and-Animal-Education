package GUI;

import Entidades.LocalEntrega;
import Entidades.PrestadorServico;
import PrivilegiosEntidades.PrivilegiosDono;
import Repositorios.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonoAlteraInfoLocalEntrega1 extends JFrame{
    private JPanel donoalterainfolocalentrega1;
    private JTable table1;
    private JButton returnButton;
    private JButton alterarButton;
    private JComboBox comboBox1;
    private PrestadorServico nomepre;

    public DonoAlteraInfoLocalEntrega1(JFrame frame, PrestadorServico nomepre){
        frame.add(donoalterainfolocalentrega1);
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
                model.addRow(new Object[]{entrega.getMorada(),entrega.getLocalidade(),entrega.getTelefone()});
                comboBox1.addItem(entrega.getTelefone());
            }
        }

        backreturn(frame);
        alterarinfo(frame);


    }

    public void backreturn(JFrame frame){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donoalterainfolocalentrega1.setVisible(false);
                new EscolherPrestadorAltInfoLocalEntrega(frame);
            }
        });
    }

    public void alterarinfo(JFrame frame){
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tele = (int) comboBox1.getSelectedItem();
                LocalEntrega entrega = PrivilegiosDono.escolherlocalentrega(tele);
                donoalterainfolocalentrega1.setVisible(false);
                new DonoAlteraInfoLocalEntrega2(frame,entrega);
            }
        });
    }
}

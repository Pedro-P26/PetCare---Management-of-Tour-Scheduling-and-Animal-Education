package GUI;

import Entidades.PrestadorServico;
import PrivilegiosEntidades.PrivilegiosDono;
import Repositorios.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscolherPrestadorAltInfoLocalEntrega extends JFrame{
    private JPanel escolherprestadoraltinfolocalentrega;
    private JTable table1;
    private JButton returnButton;
    private JComboBox comboBox1;
    private JButton OKButton;

    public EscolherPrestadorAltInfoLocalEntrega(JFrame frame){
        frame.add(escolherprestadoraltinfolocalentrega);
        frame.pack();
        frame.setVisible(true);

        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        table1.setModel(model);

        model.addColumn("Nome");
        model.addColumn("Morada");
        model.addColumn("Localidade");
        model.addColumn("Telefone");
        model.addColumn("Dono");


        for(PrestadorServico prestador : Repositorio.getInstance().getPrestadorservicos()){
            if(prestador.getDono().equals(Repositorio.getInstance().getIniUser().getUsername())){
                model.addRow(new Object[]{prestador.getNome(),prestador.getMorada(),prestador.getLocalidade(),prestador.getTelefone(),prestador.getDono()});
                comboBox1.addItem(prestador.getNome());
            }
        }
        escolher(frame);
        backreturn(frame);

    }

    public void escolher (JFrame frame){
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = (String) comboBox1.getSelectedItem();
                PrestadorServico nomepre = PrivilegiosDono.escolherprestador(nome);
                escolherprestadoraltinfolocalentrega.setVisible(false);
                new DonoAlteraInfoLocalEntrega1(frame,nomepre);
            }
        });
    }

    public void backreturn(JFrame frame){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                escolherprestadoraltinfolocalentrega.setVisible(false);
                new DonoGereEmpresa(frame);
            }
        });
    }


}

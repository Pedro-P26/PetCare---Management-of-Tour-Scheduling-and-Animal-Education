package GUI;

import Entidades.PrestadorServico;
import PrivilegiosEntidades.PrivilegiosDono;
import Repositorios.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonoAlteraInfoPrestador1 extends JFrame {


    private JPanel donoalterainfoprestador1;
    private JTable table1;
    private JButton selectButton;
    private JButton returnButton;
    private JComboBox comboBox1;

    public DonoAlteraInfoPrestador1(JFrame frame){
        frame.add(donoalterainfoprestador1);
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
        alterarinfoprestador(frame);
    }

    public void alterarinfoprestador(JFrame frame){
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = (String) comboBox1.getSelectedItem();
                PrestadorServico prestador = PrivilegiosDono.escolherprestador(nome);
                donoalterainfoprestador1.setVisible(false);
                new DonoAlteraInfoPrestador2(frame,prestador);
            }
        });
    }

    public void back(JFrame frame){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donoalterainfoprestador1.setVisible(false);
                new DonoGereEmpresa(frame);
            }
        });
    }
}

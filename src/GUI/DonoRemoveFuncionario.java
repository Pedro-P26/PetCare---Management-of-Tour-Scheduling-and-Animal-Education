package GUI;

import Entidades.Funcionario;
import Entidades.User;
import PrivilegiosEntidades.PrivilegiosDono;
import Repositorios.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonoRemoveFuncionario extends JFrame {

    private JPanel donoremovefuncionario;
    private JTable table1;
    private JButton removerButton;
    private JButton returnButton;
    //private JTextField textfieldnumcc;
    //private JTextField textFieldnif;

    private JComboBox box_niffuncionario;
    public DonoRemoveFuncionario(JFrame frame, String nomeprestador) {


        frame.add(donoremovefuncionario);
        frame.pack();
        frame.setVisible(true);
        DefaultTableModel model = (DefaultTableModel)table1.getModel();
        table1.setModel(model);

        model.addColumn("Nome");
        model.addColumn("Username");
        model.addColumn("nCC");
        model.addColumn("nif");
        model.addColumn("telefone");
        model.addColumn("salario");

        for(Funcionario funcionario : Repositorio.getInstance().getFuncionarios()){
            if(Repositorio.getInstance().getIniUser().getUsername().equals(funcionario.getNomeprestador())){
                model.addRow(new Object[]{funcionario.getNome(),funcionario.getUsername(),funcionario.getNumeroCC(),funcionario.getNumeroIF(),funcionario.getTelefone(),((Funcionario)funcionario).getSalario()});
            box_niffuncionario.addItem(funcionario.getNumeroIF());
            }

        }
        remove(frame);
        buttonreturn(frame);

    }

    public void remove(JFrame frame){
        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             int niffuncionario=(int) box_niffuncionario.getSelectedItem();
             Funcionario fun = PrivilegiosDono.selecionarfunnif(niffuncionario);
             PrivilegiosDono.removeuser(fun);
             JOptionPane.showMessageDialog(null,"Removido!!");
             donoremovefuncionario.setVisible(false);
             new DonoGereFuncionarios(frame);
            }
        });
    }
    public void buttonreturn(JFrame frame){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donoremovefuncionario.setVisible(false);
                new DonoGereFuncionarios(frame);
            }
        });
    }
}
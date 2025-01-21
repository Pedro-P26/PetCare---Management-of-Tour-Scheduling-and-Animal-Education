package GUI;

import Entidades.Funcionario;
import Repositorios.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonoListaFuncionario extends JFrame{
    private JPanel donolistafuncionario;
    private JTable table1;
    private JButton returnButton;


    public DonoListaFuncionario(JFrame frame){
        frame.add(donolistafuncionario);
        frame.pack();
        frame.setVisible(true);

        DefaultTableModel model = (DefaultTableModel)table1.getModel();
        table1.setModel(model);

        model.addColumn("Nome");
        model.addColumn("Profissao");
        model.addColumn("Salario");
        model.addColumn("Hora Entrada");
        model.addColumn("Hora Saida");


        for (Funcionario funcionario : Repositorio.getInstance().getFuncionarios()){
            if(Repositorio.getInstance().getIniUser().getUsername().equals(funcionario.getNomeprestador())){
                model.addRow(new Object[]{funcionario.getNome(),funcionario.getProfissao(),funcionario.getSalario(),funcionario.getHoratioini(),funcionario.getHorariofim()});
            }
        }

        backreturn(frame);
    }


    public void backreturn(JFrame frame){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donolistafuncionario.setVisible(false);
                new DonoGereFuncionarios(frame);
            }
        });
    }
}

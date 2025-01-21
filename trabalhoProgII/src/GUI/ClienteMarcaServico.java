package GUI;

import Entidades.Animal;
import Entidades.PrestadorServico;
import Entidades.Servico;
import Enumerados.StatusServico;
import Enumerados.TipoServicos;
import ExceptionMessage.ServicoException;
import PrivilegiosEntidades.PrivilegiosCliente;
import Repositorios.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import static java.lang.String.valueOf;

public class ClienteMarcaServico extends JFrame{
    private JPanel clientemarcaservico;
    private JTable table1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JSpinner spinner3;
    private JSpinner spinner4;
    private JSpinner spinner5;
    private JButton OKButton;
    private JButton returnButton;
    private JComboBox comboBox3;


    public ClienteMarcaServico(JFrame frame){
         Repositorio r = Repositorio.getInstance();

         frame.add(clientemarcaservico);
         frame.pack();
         frame.setVisible(true);

        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.addColumn("Nome Prestador");
        model.addColumn("Morada");
        model.addColumn("Localidade");
        model.addColumn("Telefone");
        //model.addColumn("Tipo Consulta");
        //model.addColumn("Preço consulta");

        Date data = new Date();

        spinner1.setModel(new SpinnerNumberModel(1,1,31,1));
        spinner2.setModel(new SpinnerNumberModel(1,1,12,1));
        spinner3.setModel(new SpinnerNumberModel(data.getYear()+1900,data.getYear()+1900,data.getYear()+1901,1 ));
        spinner4.setModel(new SpinnerNumberModel(8,8,21,1));
        spinner5.setModel(new SpinnerNumberModel(0,0,59,30));


        for(Animal a : r.getAnimais()){
            if (a.getDono().equals(Repositorio.getInstance().getIniUser().getUsername())){
                comboBox1.addItem(a.getNchip());
            }
        }


        for(PrestadorServico pre : r.getPrestadorservicos()){
            model.addRow(new Object[]{pre.getNome(),pre.getMorada(),pre.getLocalidade(),pre.getTelefone()});///,pre.getTipo().getTipo().toString(),pre.getTipo().getPreco()});
            comboBox2.addItem(pre.getNome());
        }
        String[] tipo = {" ", "educacao_de_cao", "passio_de_cao", "educacao_de_gato", "tosquia"};
        comboBox3.setModel(new DefaultComboBoxModel<>(tipo));

        marcar(frame);
        returnback(frame);
    }

    public void marcar(JFrame frame){
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nchip = (int) comboBox1.getSelectedItem();
                String nomepre = (String) comboBox2.getSelectedItem();

                int dia = (int) spinner1.getValue();
                int mes = (int) spinner2.getValue();
                int ano = (int) spinner3.getValue();
                int hora = (int) spinner4.getValue();
                int min = (int) spinner5.getValue();

                Date dataservico = new Date((ano-1900),mes,dia,hora,min);

                Servico servico = new Servico(nchip,nomepre,dataservico, StatusServico.EFETUADA,Repositorio.getInstance().getIniUser().getUsername());//, Servico.Tratamento.valueOf(valueOf(comboBox3.getSelectedItem().toString())));

                try{
                    PrivilegiosCliente.adicionarservico(servico);
                    clientemarcaservico.setVisible(false);
                    new ClienteRegisto(frame);
                } catch (ServicoException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }
    public void returnback(JFrame frame){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientemarcaservico.setVisible(false);
                new ClienteRegisto(frame);
            }
        });
    }
}

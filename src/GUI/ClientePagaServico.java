package GUI;

import Entidades.Servico;
import Enumerados.StatusServico;
import PrivilegiosEntidades.PrivilegiosCliente;
import Repositorios.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientePagaServico {
    private JPanel clientepagaservico;
    private JTable table1;
    private JButton OKButton;
    private JButton returnButton;
    private JComboBox comboBox1;

    public ClientePagaServico(JFrame frame){
        frame.add(clientepagaservico);
        frame.pack();
        frame.setVisible(true);

        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        table1.setModel(model);

        model.addColumn("DataHora Servico");
        model.addColumn("Estado");
        model.addColumn("Tipo Consulta");
        model.addColumn("Nchip");

        for(Servico ser : Repositorio.getInstance().getServicos()){
            if(ser.getUsercliente().equals(Repositorio.getInstance().getIniUser().getUsername()) && ser.getStatusservico().equals(StatusServico.EFETUADA)){
                model.addRow(new Object[]{ser.getDataservico(),ser.getStatusservico(),ser.getTiposervico(),ser.getUsercliente()});
                comboBox1.addItem(ser.getNchip());

            }
        }
        returnback(frame);
        pagamento(frame);

    }
    public void returnback(JFrame frame){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientepagaservico.setVisible(false);
                new ClienteRegisto(frame);
            }
        });
    }

    public void pagamento( JFrame frame){
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nchip = (int) comboBox1.getSelectedItem();
                Servico s = PrivilegiosCliente.escolherconsultarpagamento(nchip);
                PrivilegiosCliente.pagamentoefetuado(s);
                JOptionPane.showMessageDialog(null,"Serviço Pago!!");
                clientepagaservico.setVisible(false);
                new ClienteRegisto(frame);
            }
        });
    }


}

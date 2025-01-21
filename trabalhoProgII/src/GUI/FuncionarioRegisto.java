package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuncionarioRegisto extends JFrame{
    private JPanel funcionarioregisto;
    private JButton listarServicosButton;


    public FuncionarioRegisto(JFrame frame){
       frame.add(funcionarioregisto);
       frame.pack();
       frame.setVisible(true);
       listarconsultas(frame);
   }


   public void listarconsultas (JFrame frame){
        listarServicosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcionarioregisto.setVisible(false);
                new FuncionarioListaServicos(frame);
            }
        });
   }

}

import Repositorios.Repositorio;
import Repositorios.RepositorioFicheiros;
import Entidades.Admin;
import GUI.Login;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {



        Repositorio r = Repositorio.getInstance();
        //RepositorioFicheiros.desserializar();
        RepositorioFicheiros.desserializar();
        if (r.getUsers().isEmpty()) {
            r.getUsers().add(new Admin("admin", "admin", "admin", 0, 0, 0, "viana", "estg"));
            RepositorioFicheiros.serializarUser();
        }

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("APP Desktop");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setPreferredSize(new Dimension(600, 600));
            frame.setResizable(true);
            UIManager.put("Button.background", Color.WHITE);
            UIManager.put("Button.foreground", Color.BLACK);
            UIManager.put("TextField.background", Color.WHITE);
            UIManager.put("TextField.foreground", Color.BLACK);

            new Login(frame);

        });
    }

}

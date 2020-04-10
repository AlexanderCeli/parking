package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class Oyente_Salir implements ActionListener {

    JFrame vista;

    public Oyente_Salir(JFrame vista) {
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        vista.dispose();
    }
}

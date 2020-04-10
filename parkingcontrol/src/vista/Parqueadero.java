package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class Parqueadero extends JFrame {

    JLabel lugaresDisponibles;
    JLabel resultado;
    JButton consultar;
    JButton regresar;
    JPanel ubicar;

    public Parqueadero() {
        setSize(1200, 750);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pantalla();
    }

    private void pantalla() {
        ubicar();
        etiquetas();
        boton();
    }

    private void ubicar() {
        ubicar = new JPanel();
        ubicar.setLayout(null);
        this.add(ubicar);
    }

    private void etiquetas() {
        //Agregamos lugaresDisponibles 
        lugaresDisponibles = new JLabel("Lugares Disponibles");
        lugaresDisponibles.setBounds(600, 50, 200, 30);
        ubicar.add(lugaresDisponibles);
        //Agregamos resultado
        resultado = new JLabel("kndlkasnksnf{añnf{aklnfak{sdnflkns{dkfnasl{fn{dknf{ksndflk{anlfnas{kldfn");
        resultado.setBounds(300, 200, 800, 30);
        ubicar.add(resultado);
        resultado.setVisible(false);

    }

    private void boton() {
        //Agregamos registrar
        consultar = new JButton("Consultar");
        consultar.setBounds(600, 100, 100, 30);
        ubicar.add(consultar);
        consultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                resultado.setVisible(true);
            }
        });

        //Agregamos boton salir
        regresar = new JButton("Regresar");
        regresar.setBounds(600, 600, 100, 30);
        ubicar.add(regresar);
        regresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                VentanaPrincipal v = new VentanaPrincipal();
                dispose();
            }
        });
    }

}

package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.WIDTH;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

// se creo un implementes Runnable para crear el  método public void run() y que se puede usar fácilmente para crear hilos en este caso para poder cargar 
// el reloj 
public class VentanaPrincipal extends JFrame implements Runnable {

    private String minutos, segundos, horas;
    private boolean estado; // para poder cuando el estado este en true inicie el reloj
    Thread hilo;

    Date fechaa = new Date();
    JLabel cajero;
    JLabel año;
    JLabel dia;
    JList lista_registar;
    JList lista_caja;
    JPanel ubicar;
    JPanel listas;
    JTextField nombre;
    JLabel añollenar;
    JLabel HORA;
    JButton registrar;
    JButton caja;
    JButton parqueadero;
    JButton salir;
    JMenu Resistrar = new JMenu();
    JMenu Caja = new JMenu();
    JMenu Parqueadero = new JMenu();
    JMenuItem Clientes, Usuario;
    JMenuItem Factura, Nota_de_Venta, Reporte_contable, Ingreso_Vehiculos;
    JMenuBar menubar;
    JMenuItem Alumnos, Lista, Salir;
    JPanel r = new JPanel();

    JMenuBar jmn = new JMenuBar();
    JMenu menu1;

    public JTextField getNombre() {
        return nombre;
    }

    public void setNombre(JTextField nombre) {
        this.nombre = nombre;
    }

    public VentanaPrincipal() {
        setSize(1200, 750);
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pantalla();
        iniciar();
    }

    private void pantalla() {
        ubicar();
        etiquetas();
//        lista();
        boton();
        Registar();
        caja();
//        icono
        fecha();

    }

    private void ubicar() {
        ubicar = new JPanel();
        ubicar.setLayout(null);
        this.add(ubicar);

    }

    private void etiquetas() {
        Font negrita1 = new Font("Dialog", Font.BOLD, 16);
        //Agregamos Cajero 
        cajero = new JLabel("Cajero:");
        cajero.setBounds(20, 20, 70, 30);
        cajero.setFont(negrita1);
        ubicar.add(cajero);
        //Agregamos año
        año = new JLabel("Fecha:");
        año.setBounds(375, 20, 70, 30);
        año.setFont(negrita1);
        ubicar.add(año);
        //Agregamos dia
        dia = new JLabel("Hora:");
        dia.setBounds(715, 20, 50, 30);
        dia.setFont(negrita1);
        ubicar.add(dia);
        //Agregamos nombre
        nombre = new JTextField();
        nombre.setBounds(80, 26, 250, 20);
        nombre.setFont(negrita1);
        ubicar.add(nombre);

        //Agregamos añollenar
        añollenar = new JLabel("");
        añollenar.setBounds(430, 26, 300, 20);
        añollenar.setFont(negrita1);
        ubicar.add(añollenar);
        //Agregamos fecha
        HORA = new JLabel("");
        HORA.setBounds(760, 26, 300, 20);
        HORA.setFont(negrita1);
        ubicar.add(HORA);

    }

    // se crea los menus
    private void Registar() {
        jmn.setBounds(70, 100, 100, 30);
        ubicar.add(jmn);
        Resistrar = new JMenu("Registrar");

        jmn.add(Resistrar);

        Clientes = new JMenuItem("Registro Clientes");
        Clientes.addActionListener(new OyenteventanaRegistro());
        Resistrar.add(Clientes);

        Usuario = new JMenuItem("Registro Cajero o Administrador");
        Usuario.addActionListener(new OyenteventanaRegistro());
        Resistrar.add(Usuario);
    }

    private class OyenteventanaRegistro implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == Clientes) {
                RegistroAdminUsuario q = new RegistroAdminUsuario();

            }
            if (e.getSource() == Usuario) {
                RegistroCliente p = new RegistroCliente();

            }

        }

    }

    public void caja() {
        JMenuBar jmn1 = new JMenuBar();
        jmn1.setBounds(425, 100, 100, 30);
        ubicar.add(jmn1);
        Caja = new JMenu("Caja");
        Caja.setBounds(425, 100, 300, 30);
        jmn1.add(Caja);

        Factura = new JMenuItem("Factura");
        Factura.addActionListener(new Oyenteventanap());
        Caja.add(Factura);

        Reporte_contable = new JMenuItem("Reporte Contable");
        Reporte_contable.addActionListener(new Oyenteventanap());
        Caja.add(Reporte_contable);

        Ingreso_Vehiculos = new JMenuItem("Ingreso Vehiculos");
        Ingreso_Vehiculos.addActionListener(new Oyenteventanap());
        Caja.add(Ingreso_Vehiculos);

    }

    private class Oyenteventanap implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == Factura) {
                Facturacion a = new Facturacion();

            }
            if (e.getSource() == Reporte_contable) {
                Reporte p = new Reporte();

            }
            if (e.getSource() == Ingreso_Vehiculos) {
                qr i = new qr();

            }

        }

    }

    private void boton() {

        //Agregamos boton parquadero
        parqueadero = new JButton("Parquadero");
        parqueadero.setBounds(775, 100, 150, 30);
        ubicar.add(parqueadero);
        parqueadero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Parqueadero b = new Parqueadero();
            }
        });
        //Agregamos boton salir
        salir = new JButton("Salir");
        salir.setBounds(875, 500, 100, 30);
        ubicar.add(salir);
        salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(WIDTH);
            }
        });

    }

    @Override
    public void run() {

        while (estado == true) {

            Calendar Fecha = new GregorianCalendar();
            int h = Fecha.get(Calendar.HOUR_OF_DAY);
            int m = Fecha.get(Calendar.MINUTE);
            int s = Fecha.get(Calendar.SECOND);

            horas = Integer.toString(h);
            minutos = Integer.toString(m);
            segundos = Integer.toString(s);

            HORA.setText(horas + ":" + minutos + ":" + segundos);

            try {
                Thread.sleep(1000);// se implementa el hilo para qe pueda funcionar ya que estamos poniendo 1000 milisengundos q es un segundo

            } catch (InterruptedException ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
    }
    // creamos un metodo para poder cuadno cargue la pantalla aparesca y comiense a funcionar el reloj

    public void iniciar() {
        hilo = new Thread(this);
        estado = true;
        hilo.start();
    }

    public void bloquear() {
        nombre.setEditable(false);
    }

    public void fecha() {
        Date date = new Date();

//Caso 2: obtener la fecha y salida por pantalla con formato:
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//System.out.println("Fecha: "+dateFormat.format(date));
        añollenar.setText(dateFormat.format(date));

    }

    public static void main(String[] args) {
        VentanaPrincipal q = new VentanaPrincipal();
    }

}

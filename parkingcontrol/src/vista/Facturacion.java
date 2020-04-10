package vista;

import Modelos.Bass;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Modelos.cliente;

public class Facturacion extends JFrame {

    JTextField tnumero;
    JTextField truc;
    JTextField tcliente;
    JTextField tdireccion;
    JTextField tfecha;
    JTextField temail;
    JTextField ttelefono;
    JTextField tcaja;
    JTextField tsubtotal;
    JTextField ttotal;
    JPanel ubicar;
    JButton guardar;
    JButton imprimir;
    JButton regresar;
    JButton buscar;
    Reporte r;
    Bass b = new Bass();
    cliente c = new cliente();

    Object ncolumnas[] = {"PLACA", "HORA DE ENTRADA", "HORA DE SALIDA", "TIEMPO TOTAL", "PRECIO"};
    Object celdas[][] = new Object[0][5];
    DefaultTableModel mtabla = new DefaultTableModel(celdas, ncolumnas);
    JTable tabla = new JTable();

    public JTextField getTnumero() {
        return tnumero;
    }

    public void setTnumero(JTextField tnumero) {
        this.tnumero = tnumero;
    }

    public JTextField getTruc() {
        return truc;
    }

    public void setTruc(JTextField truc) {
        this.truc = truc;
    }

    public JTextField getTcliente() {
        return tcliente;
    }

    public void setTcliente(JTextField tcliente) {
        this.tcliente = tcliente;
    }

    public JTextField getTdireccion() {
        return tdireccion;
    }

    public void setTdireccion(JTextField tdireccion) {
        this.tdireccion = tdireccion;
    }

    public JTextField getTfecha() {
        return tfecha;
    }

    public void setTfecha(JTextField tfecha) {
        this.tfecha = tfecha;
    }

    public JTextField getTemail() {
        return temail;
    }

    public void setTemail(JTextField temail) {
        this.temail = temail;
    }

    public JTextField getTtelefono() {
        return ttelefono;
    }

    public void setTtelefono(JTextField ttelefono) {
        this.ttelefono = ttelefono;
    }

    public JTextField getTcaja() {
        return tcaja;
    }

    public void setTcaja(JTextField tcaja) {
        this.tcaja = tcaja;
    }

    public JTextField getTsubtotal() {
        return tsubtotal;
    }

    public void setTsubtotal(JTextField tsubtotal) {
        this.tsubtotal = tsubtotal;
    }

    public JTextField getTtotal() {
        return ttotal;
    }

    public void setTtotal(JTextField ttotal) {
        this.ttotal = ttotal;
    }

    public JPanel getUbicar() {
        return ubicar;
    }

    public void setUbicar(JPanel ubicar) {
        this.ubicar = ubicar;
    }

    public JButton getGuardar() {
        return guardar;
    }

    public void setGuardar(JButton guardar) {
        this.guardar = guardar;
    }

    public JButton getImprimir() {
        return imprimir;
    }

    public void setImprimir(JButton imprimir) {
        this.imprimir = imprimir;
    }

    public JButton getRegresar() {
        return regresar;
    }

    public void setRegresar(JButton regresar) {
        this.regresar = regresar;
    }

    public JButton getBuscar() {
        return buscar;
    }

    public void setBuscar(JButton buscar) {
        this.buscar = buscar;
    }

    public Bass getB() {
        return b;
    }

    public void setB(Bass b) {
        this.b = b;
    }

    public cliente getC() {
        return c;
    }

    public void setC(cliente c) {
        this.c = c;
    }

    public Facturacion() {
        setSize(1200, 750);
        setVisible(true);
        setTitle("Facturación");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pantalla();
        fecha();
    }

    public void pantalla() {
        ubicar();
        etiquetas();
        campotexto();
        boton();
        tablaf();
    }

    public void ubicar() {
        ubicar = new JPanel();
        ubicar.setLayout(null);
        this.add(ubicar);

    }
// se creo la accesorios del inferzas

    private void etiquetas() {

        JLabel numero = new JLabel("Número de factura");
        numero.setBounds(5, 5, 200, 50);
        ubicar.add(numero);
        JLabel fecha = new JLabel("Fecha");
        fecha.setBounds(500, 5, 60, 50);
        ubicar.add(fecha);
        JLabel cliente = new JLabel("Cliente");
        cliente.setBounds(5, 85, 60, 50);
        ubicar.add(cliente);
        JLabel direccion = new JLabel("Direccion");
        direccion.setBounds(5, 130, 60, 50);
        ubicar.add(direccion);
        JLabel ruc = new JLabel("cedula/Ruc");
        ruc.setBounds(5, 50, 80, 50);
        ubicar.add(ruc);
        JLabel email = new JLabel("Email");
        email.setBounds(5, 175, 60, 50);
        ubicar.add(email);
        JLabel telefono = new JLabel("Teléfono");
        telefono.setBounds(5, 215, 60, 50);
        ubicar.add(telefono);
        JLabel cajero = new JLabel("Cajero");
        cajero.setBounds(500, 85, 60, 50);
        ubicar.add(cajero);
        JLabel subtotal = new JLabel("Subtotal");
        subtotal.setBounds(500, 585, 60, 50);
        ubicar.add(subtotal);
        JLabel iva = new JLabel("Iva");
        iva.setBounds(500, 615, 60, 50);
        ubicar.add(iva);
        JLabel total = new JLabel("Total");
        total.setBounds(500, 650, 60, 50);
        ubicar.add(total);

    }

    private void campotexto() {
        tnumero = new JTextField(30);
        tnumero.setBounds(125, 15, 200, 25);
        ubicar.add(tnumero);
        truc = new JTextField("");
        truc.setBounds(135, 60, 125, 25);
        ubicar.add(truc);
        tcliente = new JTextField();
        tcliente.setBounds(135, 100, 80, 25);
        ubicar.add(tcliente);
        tdireccion = new JTextField();
        tdireccion.setBounds(115, 140, 100, 25);
        ubicar.add(tdireccion);
        tfecha = new JTextField();
        tfecha.setBounds(600, 15, 60, 25);
        ubicar.add(tfecha);
        temail = new JTextField();
        temail.setBounds(125, 185, 100, 25);
        ubicar.add(temail);
        ttelefono = new JTextField();
        ttelefono.setBounds(125, 225, 100, 25);
        ubicar.add(ttelefono);
        JTextField tcaja = new JTextField();
        tcaja.setBounds(600, 98, 60, 25);
        ubicar.add(tcaja);
        JTextField tsubtotal = new JTextField();
        tsubtotal.setBounds(600, 600, 80, 25);
        ubicar.add(tsubtotal);
        JTextField tiva = new JTextField();
        tiva.setBounds(600, 630, 80, 25);
        ubicar.add(tiva);
        JTextField ttotal = new JTextField();
        ttotal.setBounds(600, 660, 80, 25);
        ubicar.add(ttotal);

    }

    private void tablaf() {
        tabla.setBounds(40, 300, 600, 150);
        ubicar.add(tabla);
        mtabla.addRow(ncolumnas);
        mtabla.setNumRows(3);

        tabla.setModel(mtabla);

    }

    private void boton() {
        //Agregamos guardar
        guardar = new JButton("Guardar");
        guardar.setBounds(800, 660, 80, 25);
        ubicar.add(guardar);
        guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

            }
        });

        //Agregamos ingresar
        imprimir = new JButton("Imprimir");
        imprimir.setBounds(900, 660, 90, 25);
        ubicar.add(imprimir);
        imprimir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

            }
        });
        //Agregamos Regresar
        regresar = new JButton("Regresar");
        regresar.setBounds(1000, 660, 100, 25);
        ubicar.add(regresar);
        regresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                VentanaPrincipal p = new VentanaPrincipal();
                dispose();
            }
        });
        buscar = new JButton("buscar");
        buscar.setBounds(225, 60, 125, 25);
        ubicar.add(buscar);
        buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                c = b.cargarcliente(verificaralumno());
                if (c.getCedula() == null) {
                    int resp = JOptionPane.showConfirmDialog(null, "El cliente no esta registrado,desea ingresarlo ");
                    if (resp == JOptionPane.YES_OPTION) {
//     r.toFront();
                        r = new Reporte();
                    }

                } else {

                    cargarcli(c);
                }

            }
        });
    }

    public String verificaralumno() {
        return truc.getText();
    }

    public void cargarcli(cliente c) {
        truc.setText(c.getCedula());
        tcliente.setText(c.getNombreapellido());
        tdireccion.setText(c.getDireccion());
        temail.setText(c.getCorreo());
        ttelefono.setText(c.getTelefono());

    }

    //metodo para obtener fecha actual
    public void fecha() {
        Calendar cal = new GregorianCalendar();
        int d = cal.get(Calendar.DATE);
        int m = cal.get(Calendar.MONTH) + 1;
        int y = cal.get(Calendar.YEAR);
        String dia = String.valueOf(d);
        String mes = String.valueOf(m);
        String año = String.valueOf(y);
        tfecha.setText(dia + "/" + mes + "/" + año);
    }

    public static void main(String[] args) {
        new Facturacion();
    }
}

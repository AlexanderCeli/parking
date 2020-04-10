package vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import controlador.oyenteReporDias;

public class Reporte extends JFrame {

    JPanel ubicar;
    JButton mes;
    JButton año;
    JButton dias;
    JButton consultar;
    JButton regresar;
    JComboBox meses;
    JComboBox dia;
    JComboBox años;
    JLabel vehiculos;
    JLabel horas;
    JLabel total;
    JLabel nvehiculos;
    JLabel ntotal;
    JLabel nhoras;
    JLabel jListas;
    JTable table;

    public Reporte() {
        setSize(1200, 750);
        setVisible(true);
        setTitle("Reportes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pantalla();
    }

    public void pantalla() {
        ubicar();
        boton();
        listas();
        etiquetas();
        tabla();

    }

    public void ubicar() {
        ubicar = new JPanel();
        ubicar.setLayout(null);
        this.add(ubicar);

    }

    private void boton() {
        mes = new JButton("Mes");
        mes.setBounds(300, 30, 60, 25);
        ubicar.add(mes);

        año = new JButton("Año");
        año.setBounds(500, 30, 70, 25);
        ubicar.add(año);

        dias = new JButton("Dias");
        dias.setBounds(100, 30, 70, 25);
        dias.addActionListener(new oyenteReporDias(this));
        ubicar.add(dias);

        consultar = new JButton("Consultar");
        consultar.setBounds(800, 30, 100, 40);
        ubicar.add(consultar);

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

    }

    private void listas() {
        meses = new JComboBox();
        meses.addItem("ENERO");
        meses.addItem("FEBRERO");
        meses.addItem("MARZO");
        meses.addItem("ABRIL");
        meses.addItem("MAYO");
        meses.addItem("JUNIO");
        meses.addItem("JULIO");
        meses.addItem("AGOSTO");
        meses.addItem("SEPTIEMBRE");
        meses.addItem("OCTUBRE");
        meses.addItem("NOVIEMBRE");
        meses.addItem("DICIEMBRE");
        ubicar.add(meses);
        meses.setBounds(250, 100, 100, 40);
        ubicar.add(meses);

        años = new JComboBox();
        años.addItem("2017");
        años.addItem("2018");
        años.addItem("2019");
        años.addItem("2020");

        ubicar.add(años);
        años.setBounds(450, 100, 100, 40);
        ubicar.add(años);

        dia = new JComboBox();
        dia.addItem("1");
        dia.addItem("2");
        dia.addItem("3");
        dia.addItem("4");
        dia.addItem("5");
        dia.addItem("6");
        dia.addItem("7");
        dia.addItem("8");
        dia.addItem("9");
        dia.addItem("10");
        dia.addItem("11");
        dia.addItem("12");
        dia.addItem("13");
        dia.addItem("14");
        dia.addItem("15");
        dia.addItem("16");
        dia.addItem("17");
        dia.addItem("18");
        dia.addItem("19");
        dia.addItem("20");
        dia.addItem("21");
        dia.addItem("22");
        dia.addItem("23");
        dia.addItem("24");
        dia.addItem("25");
        dia.addItem("26");
        dia.addItem("27");
        dia.addItem("28");
        dia.addItem("30");
        dia.addItem("31");

        ubicar.add(dia);
        dia.setBounds(70, 100, 100, 40);
        ubicar.add(dia);

    }

    private void etiquetas() {
        vehiculos = new JLabel("Número de vehiculos");
        vehiculos.setBounds(150, 250, 150, 100);
        ubicar.add(vehiculos);
        horas = new JLabel("Número de horas");
        horas.setBounds(400, 250, 100, 100);
        ubicar.add(horas);
        total = new JLabel("Total");
        total.setBounds(650, 250, 100, 100);
        ubicar.add(total);

        JLabel nvehiculos = new JLabel("gfrtytfi");
        nvehiculos.setBounds(150, 350, 100, 100);
        ubicar.add(nvehiculos);
        nhoras = new JLabel("yyyu");
        nhoras.setBounds(400, 350, 100, 100);
        ubicar.add(nhoras);
        ntotal = new JLabel("yg7t8yu8");
        ntotal.setBounds(650, 350, 100, 100);
        ubicar.add(ntotal);
    }

    private void tabla() {
        jListas = new JLabel();
        Box boxNorte = Box.createHorizontalBox();
        boxNorte.add(jListas);

        table = new JTable();
        add(boxNorte, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);

        table.setBounds(150, 350, 700, 90);
        ubicar.add(table);
    }

    public static void main(String[] args) {
        Reporte r = new Reporte();
    }

    public void bloqueo1() {
        año.setEnabled(false);
        mes.setEnabled(false);
    }

}

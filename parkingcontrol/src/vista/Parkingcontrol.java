/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Modelos.adminuser;
import controlador.Ingresar;

public class Parkingcontrol extends JFrame {

    // Declaracion de variable
    JPanel ubicar;
    JLabel texto, icono;
    JTextField txt;
    JButton enter;
    JPasswordField clave;

    public JPasswordField getClave() {
        return clave;
    }

    public void setClave(JPasswordField clave) {
        this.clave = clave;
    }

    public JTextField getTxt() {
        return txt;
    }

    public void setTxt(JTextField txt) {
        this.txt = txt;
    }

    public Parkingcontrol() {
        setTitle("Inicio");
        setSize(1250, 750);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(ubicar);
        escritorio();

    }

    private void escritorio() {
        ubicar();
        etiqueta();
        campotexto();
        enter();
        icono();
    }

    private void ubicar() {

        ubicar = new JPanel();
        ubicar.setLayout(null);
        this.add(ubicar);

    }

    private void etiqueta() {

        Font negrita = new Font("Dialog", Font.BOLD, 36);
        JLabel texto1 = new JLabel("BIENVENIDOS A PARKINGCONTROLL ");
        texto1.setBounds(310, 180, 700, 300);
        texto1.setFont(negrita);
        ubicar.add(texto1);

        texto = new JLabel("Ingrese su clave");
        Font negrita1 = new Font("Dialog", Font.BOLD, 20);
        texto.setBounds(520, 400, 200, 100);
        texto.setFont(negrita1);
        ubicar.add(texto);
    }

    private void campotexto() {
//            txt = new JTextField();  
//             Font negrita1 = new Font("Dialog", Font.BOLD, 16);
//            txt.setBounds(470,390, 250, 50);
//            txt.setFont(negrita1);
//            ubicar.add(txt);  
        clave = new JPasswordField(10);
        clave.setBounds(470, 390, 250, 50);
        ubicar.add(clave);

    }

    private void enter() {

        enter = new JButton("Entrar");
        Font negrita1 = new Font("Dialog", Font.BOLD, 16);
        enter.setBounds(750, 400, 100, 30);
        enter.setFont(negrita1);
        ubicar.add(enter);
        enter.addActionListener(new Ingresar(this));
    }

    private void icono() {

        icono = new JLabel();
        icono.setIcon(new ImageIcon(getClass().getResource("/Imagenes/parqueo.jpg")));
        icono.setBounds(320, 20, 700, 300);
        ubicar.add(icono);

        ubicar.setLayout(new BorderLayout());

    }

    public String BuscarAlumn() {

        return clave.getText();
    }

    public void cargar(adminuser adminuser) {
        VentanaPrincipal a = new VentanaPrincipal();
        a.nombre.setText(adminuser.getNomapead());
        a.bloquear();
    }

}

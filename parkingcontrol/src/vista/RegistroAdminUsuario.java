package vista;

import controlador.Oyente_Salir;
import controlador.Oyente_guardar_adminuser;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Modelos.adminuser;

public class RegistroAdminUsuario extends JFrame {

    JPanel ubicar;
    JLabel texto;
    JTextField txt;
    JButton boton;
    JTextField adcedula;
    JTextField nomapead;
    JTextField telefonoad;
    JTextField usuario;
    JTextField clave;
    JComboBox papel;
    adminuser adminuser;

    public JTextField getTelefonoad() {
        return telefonoad;
    }

    public void setTelefonoad(JTextField telefonoad) {
        this.telefonoad = telefonoad;
    }

    public JTextField getUsuario() {
        return usuario;
    }

    public void setUsuario(JTextField usuario) {
        this.usuario = usuario;
    }

    public JTextField getClave() {
        return clave;
    }

    public void setClave(JTextField clave) {
        this.clave = clave;
    }

    public JComboBox getPapel() {
        return papel;
    }

    public void setPapel(JComboBox papel) {
        this.papel = papel;
    }

    public RegistroAdminUsuario() {

        setTitle("Registro de Clientes");
        setSize(1000, 350);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(ubicar);
        this.setResizable(false);
        escritorio();

    }

    private void escritorio() {
        ubicar();
        etiqueta();
        campotexto();
        boton();
        combobox();

    }

    private void ubicar() {
        ubicar = new JPanel();
        ubicar.setLayout(null);
        this.add(ubicar);

    }

    private void etiqueta() {

        Font negrita = new Font("Dialog", Font.BOLD, 18);

        JLabel texto6 = new JLabel("Clave ");
        texto6.setBounds(750, 70, 280, 30);
        texto6.setFont(negrita);
        ubicar.add(texto6);

        JLabel texto3 = new JLabel("Nombre de Usuario ");

        texto3.setBounds(750, 20, 280, 30);
        texto3.setFont(negrita);
        ubicar.add(texto3);

        JLabel texto1 = new JLabel("Num. Cedula: ");

        texto1.setBounds(20, 70, 280, 30);
        texto1.setFont(negrita);
        ubicar.add(texto1);

        JLabel texto2 = new JLabel("Nombres y Apellidos:  ");

        texto2.setBounds(20, 120, 500, 30);
        texto2.setFont(negrita);
        ubicar.add(texto2);

        JLabel texto4 = new JLabel("Teléfono: ");
        texto4.setBounds(20, 170, 200, 30);
        texto4.setFont(negrita);
        ubicar.add(texto4);

        JLabel texto5 = new JLabel("Seleccione el roll ");
        texto5.setBounds(210, 20, 180, 30);
        texto5.setFont(negrita);
        ubicar.add(texto5);

    }

    private void campotexto() {
        Font negrita1 = new Font("Dialog", Font.ITALIC, 16);

        adcedula = new JTextField();
        adcedula.setBounds(150, 70, 125, 35);
        adcedula.setFont(negrita1);
        ubicar.add(adcedula);

        nomapead = new JTextField();
        nomapead.setBounds(230, 120, 300, 35);
        nomapead.setFont(negrita1);
        ubicar.add(nomapead);

        telefonoad = new JTextField();
        telefonoad.setBounds(115, 170, 200, 35);
        telefonoad.setFont(negrita1);
        ubicar.add(telefonoad);

        usuario = new JTextField();
        usuario.setBounds(750, 50, 230, 25);
        usuario.setFont(negrita1);
        ubicar.add(usuario);

        clave = new JTextField();
        clave.setBounds(750, 100, 230, 25);
        clave.setFont(negrita1);
        ubicar.add(clave);

    }

    private void boton() {
        boton = new JButton("Crear");
        boton.setBounds(300, 250, 150, 35);
        boton.addActionListener(new Oyente_guardar_adminuser(this));
        ubicar.add(boton);

        boton = new JButton("Salir");
        boton.setBounds(500, 250, 150, 35);
        boton.addActionListener(new Oyente_Salir(this));
        ubicar.add(boton);

    }

    private void combobox() {

        papel = new JComboBox();
        papel.addItem("Admin");
        papel.addItem("Usuario");
        papel.setBounds(20, 20, 150, 30);
        ubicar.add(papel);
    }

    public void Limpiar_Registros_admin() {

        adcedula.setText(null);
        nomapead.setText(null);
        telefonoad.setText(null);
        usuario.setText(null);
        clave.setText(null);
        papel.setSelectedItem("");

    }

    public adminuser guardaradminuser() {
        adminuser = new adminuser();
        adminuser.setAdcedula(adcedula.getText());
        adminuser.setNomapead(nomapead.getText());
        adminuser.setTelefonoad(telefonoad.getText());
        adminuser.setUsuario(usuario.getText());
        adminuser.setClave(clave.getText());
        adminuser.setPapel(papel.getName());
        adminuser.setPapel((String) papel.getSelectedItem());

        return adminuser;
    }

    public static void main(String[] args) {
        RegistroAdminUsuario a = new RegistroAdminUsuario();

    }
}

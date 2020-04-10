package vista;

import controlador.Oyente_Salir;
import controlador.oyente_guarda_cliente;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Modelos.cliente;

public class RegistroCliente extends JFrame {

    oyente_guarda_cliente oyente_guarda_cliente;
    JPanel ubicar;
    JLabel texto;

    public JPanel getUbicar() {
        return ubicar;
    }

    public void setUbicar(JPanel ubicar) {
        this.ubicar = ubicar;
    }

    public JLabel getTexto() {
        return texto;
    }

    public void setTexto(JLabel texto) {
        this.texto = texto;
    }

    public JTextField getId_cedula() {
        return Id_cedula;
    }

    public void setId_cedula(JTextField id_cedula) {
        this.Id_cedula = id_cedula;
    }

    public JTextField getNombreapellido() {
        return nombreapellido;
    }

    public void setNombreapellido(JTextField nombreapellido) {
        this.nombreapellido = nombreapellido;
    }

    public JTextField getDireccion() {
        return direccion;
    }

    public void setDireccion(JTextField direccion) {
        this.direccion = direccion;
    }

    public JTextField getTelefono() {
        return telefono;
    }

    public void setTelefono(JTextField telefono) {
        this.telefono = telefono;
    }

    public JTextField getCorreo() {
        return correo;
    }

    public void setCorreo(JTextField correo) {
        this.correo = correo;
    }

    public JButton getSalir() {
        return salir;
    }

    public void setSalir(JButton salir) {
        this.salir = salir;
    }

    public JButton getGuardar() {
        return guardar;
    }

    public void setGuardar(JButton guardar) {
        this.guardar = guardar;
    }
    JTextField Id_cedula;
    JTextField nombreapellido;
    JTextField direccion;
    JTextField telefono;
    JTextField correo;
    JButton salir, guardar;
    cliente Cliente;

    public RegistroCliente() {

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

    }

    private void ubicar() {
        ubicar = new JPanel();
        ubicar.setLayout(null);
        this.add(ubicar);

    }

    private void etiqueta() {

        Font negrita = new Font("Dialog", Font.BOLD, 18);

        JLabel texto1 = new JLabel("Num. Cedula: ");

        texto1.setBounds(20, 20, 280, 30);
        texto1.setFont(negrita);
        ubicar.add(texto1);

        JLabel texto2 = new JLabel("Nombres y Apellidos:  ");

        texto2.setBounds(20, 70, 500, 30);
        texto2.setFont(negrita);
        ubicar.add(texto2);

        JLabel texto3 = new JLabel("Dirección: ");

        texto3.setBounds(20, 120, 400, 30);
        texto3.setFont(negrita);
        ubicar.add(texto3);

        JLabel texto4 = new JLabel("Teléfono: ");

        texto4.setBounds(20, 170, 200, 30);
        texto4.setFont(negrita);
        ubicar.add(texto4);

        JLabel texto5 = new JLabel("Correo: ");

        texto5.setBounds(500, 170, 200, 30);
        texto5.setFont(negrita);
        ubicar.add(texto5);

    }

    private void campotexto() {
        Font negrita1 = new Font("Dialog", Font.ITALIC, 16);
        Id_cedula = new JTextField();
        Id_cedula.setBounds(150, 20, 125, 35);
        Id_cedula.setFont(negrita1);

        ubicar.add(Id_cedula);

        nombreapellido = new JTextField();
        nombreapellido.setBounds(230, 70, 500, 35);
        nombreapellido.setFont(negrita1);
        ubicar.add(nombreapellido);

        direccion = new JTextField();
        direccion.setBounds(130, 120, 400, 35);
        direccion.setFont(negrita1);
        ubicar.add(direccion);

        telefono = new JTextField();
        telefono.setBounds(115, 170, 200, 35);
        telefono.setFont(negrita1);
        ubicar.add(telefono);

        correo = new JTextField();
        correo.setBounds(570, 170, 200, 35);
        correo.setFont(negrita1);
        ubicar.add(correo);

    }

    private void boton() {
        guardar = new JButton("Guardar");
        guardar.setBounds(300, 250, 150, 35);
        guardar.addActionListener(new oyente_guarda_cliente(this));

        ubicar.add(guardar);

        salir = new JButton("Salir");
        salir.setBounds(500, 250, 150, 35);
        salir.addActionListener(new Oyente_Salir(this));

        ubicar.add(salir);

    }

    public void Limpiar_Registros_cliente() {

        Id_cedula.setText(null);
        nombreapellido.setText(null);
        direccion.setText(null);
        telefono.setText(null);
        correo.setText(null);

    }

    public cliente guardarcliente() {
        Cliente = new cliente();
        Cliente.setCedula(Id_cedula.getText());
        Cliente.setNombreapellido(nombreapellido.getText());
        Cliente.setDireccion(direccion.getText());
        Cliente.setTelefono(telefono.getText());
        Cliente.setCorreo(correo.getText());

        return Cliente;
    }

    public static void main(String[] args) {
        RegistroCliente a = new RegistroCliente();

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import vista.RegistroAdminUsuario;

/**
 *
 * @author Alexander
 */
public class Bass {

    adminuser adminuser;
    RegistroAdminUsuario v_registro;
    // se consulta para ingresar la claver

    public static adminuser buscar(String clave) {
        adminuser a = new adminuser();

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/parqueadero", "root", "root");
            System.out.println("Concexion establecida");
            Statement sentencia = conexion.createStatement();
            ResultSet buscar = sentencia.executeQuery("SELECT * FROM registradminuser WHERE clave = " + clave);

            while (buscar.next()) {
                String cla = buscar.getString("clave");
                String nom = buscar.getString("nombreapellido");

                a.setClave(cla);
                a.setNomapead(nom);

            }

            sentencia.close();
            conexion.close();
        } catch (Exception er) {
            System.out.print("Error en la conexion " + er);
        }

        return a;
    }

    // se consulta para la facturacion
    public static cliente cargarcliente(String cedula) {
        cliente c = new cliente();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingcontrol", "root", "root");
            System.out.println("Conexion establecida!");
            Statement sentencia = conexion.createStatement();
            ResultSet necesario = sentencia.executeQuery("select * from cliente where cedula =" + cedula);
            while (necesario.next()) {

                String ced = necesario.getString("cedula");
                String nom = necesario.getString("nombre");
                String dir = necesario.getString("direccion");
                String em = necesario.getString("email");
                String tel = necesario.getString("telefono");
                c.setCedula(ced);
                c.setNombreapellido(nom);
                c.setDireccion(dir);
                c.setTelefono(tel);
            }
            sentencia.close();
            conexion.close();

        } catch (Exception ex) {
            System.out.println("Error en la conexion" + ex);
        }
        return c;
    }

    // se guarda el cliente
    public void Guardar_cliente(cliente cliente) {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/parqueadero", "root", "root");
            System.out.println("Concexion  establecida");

            Statement sentencia = conexion.createStatement();
            int insert = sentencia.executeUpdate("insert into registroUsuario values ('" + cliente.getCedula() + "','" + cliente.getNombreapellido() + "','"
                    + cliente.getDireccion() + "','" + cliente.getTelefono() + "','" + cliente.getCorreo() + "')");
            sentencia.close();
            conexion.close();
        } catch (Exception ex) {
            System.out.println("Eroor de coneccion" + ex);
        }
    }

    // se guarda el administrador
    public void Guardar_adminuser(adminuser adminuser) {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/parqueadero", "root", "root");
            System.out.println("Concexion  establecida");

            Statement sentencia = conexion.createStatement();
            int insertad = sentencia.executeUpdate("insert into registrAdminuser values ('" + adminuser.getPapel() + "','" + adminuser.getAdcedula() + "','" + adminuser.getNomapead() + "','"
                    + adminuser.getTelefonoad() + "','" + adminuser.getUsuario() + "','" + adminuser.getClave() + "')");
            sentencia.close();
            conexion.close();
        } catch (Exception ex) {
            System.out.println("Eroor de coneccion" + ex);
        }
    }
}

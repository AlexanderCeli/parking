/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelos.adminuser;
import Modelos.Bass;
import vista.RegistroAdminUsuario;
import vista.RegistroCliente;

public class Oyente_guardar_adminuser implements ActionListener {

    Bass base;
    adminuser Adminuser;
    RegistroAdminUsuario v_Adminuser;

    public Oyente_guardar_adminuser(RegistroAdminUsuario v_Adminuser) {

        this.v_Adminuser = v_Adminuser;

    }

    @Override

    public void actionPerformed(ActionEvent ae) {
        base = new Bass();
        base.Guardar_adminuser(v_Adminuser.guardaradminuser());
        v_Adminuser.Limpiar_Registros_admin();

    }

}

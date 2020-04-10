/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelos.Bass;
import Modelos.cliente;
import vista.RegistroCliente;

/**
 *
 * @author satboy
 */
public class oyente_guarda_cliente implements ActionListener {

    Bass base;
    cliente Cliente;
    RegistroCliente v_cliente;

    public oyente_guarda_cliente(RegistroCliente v_cliente) {

        this.v_cliente = v_cliente;

    }

    @Override

    public void actionPerformed(ActionEvent ae) {
        base = new Bass();
        base.Guardar_cliente(v_cliente.guardarcliente());
        v_cliente.Limpiar_Registros_cliente();

    }

}

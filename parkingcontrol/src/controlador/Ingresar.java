/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelos.Bass;
import vista.Parkingcontrol;
import vista.VentanaPrincipal;
import Modelos.usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Modelos.adminuser;

public class Ingresar implements ActionListener {
  Parkingcontrol cp;
    Bass abd;
    adminuser a;
  VentanaPrincipal vp;
 public Ingresar (Parkingcontrol cp){
		this.cp = cp;
	}
    @Override
    public void actionPerformed(ActionEvent ae) {
       
        a=abd.buscar(cp.BuscarAlumn());
        if(a.getClave()==null){
        
             JOptionPane.showMessageDialog(null, "Clave Incorrecta");
        }else{
            
            JOptionPane.showMessageDialog(null, "La clave del usuario "+a.getNomapead()+" es correcta");
                  
          cp.cargar(a);
        }
    }
}

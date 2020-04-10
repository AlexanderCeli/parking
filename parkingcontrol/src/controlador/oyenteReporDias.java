/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.Parkingcontrol;
import vista.Reporte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class oyenteReporDias implements ActionListener {

    Reporte re;

    public oyenteReporDias(Reporte re) {
        this.re = re;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        re.bloqueo1();
    }

}

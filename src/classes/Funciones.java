/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import interfaces.HP;
import interfaces.Dashboard;
import interfaces.MSI;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adminccs
 */
public class Funciones extends Thread {

    boolean activo;

    public Funciones() {
        this.activo = true;
    }

    @Override
    public void run() {
        while (activo) {
            try {
                Thread.sleep(1002 * Dashboard.duracionDias); // Ajustado para usar "duracionDias" de Dashboard
//                HP.costosOperativosH.setText(Integer.toString((HPCompany.totalPayH) + Director.descontadoPmH)); 
                MSI.costosOperativosM.setText(Integer.toString((MSICompany.totalPayM) + Director.descontadoPmM)); // Actualización de costos operativos para MSI
//                HP.ganancia.setText(Integer.toString(Director.ingresoH - HPCompany.totalPayH + Math.abs(Director.descontadoPmH))); 
//                MSI.ganancia.setText(Integer.toString(Director.ingresoM - MSICompany.totalPayM + Math.abs(Director.descontadoPmM))); 
//                HP.ingresosBrutos.setText(Integer.toString(Director.ingresoH)); 
//                MSI.ingresosBrutos.setText(Integer.toString(Director.ingresoM)); 
            } catch (InterruptedException ex) {
                Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
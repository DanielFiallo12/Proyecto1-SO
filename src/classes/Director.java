/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author adminccs
 */

import interfaces.Dashboard;
import interfaces.MSI;
import interfaces.HP;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Director extends Thread {
    Semaphore daysRemaining;
    private float totalIncome;
    int rand1;
    int rand2;
    String company;
    int sueldoPorHora;
    static int ingresoH;
    static int ingresoM;
    String estado;
    int faltasCounterM;
    int faltasCounterH;
    static int descontadoPmH;
    static int descontadoPmM;

    public Director(Semaphore daysRemaining, String company) {
        this.company = company;
        this.daysRemaining = daysRemaining;
        this.totalIncome = 0;
        this.sueldoPorHora = 60;
        this.estado = "Labores administrativas";
        this.ingresoH = 0;
        this.ingresoM = 0;
        this.faltasCounterH = 0;
        this.faltasCounterM = 0;
        this.descontadoPmH = 0;
        this.descontadoPmM = 0;
    }

    public void payDayDirector() {
        int horasTrabajadas = 24;
        int salario = sueldoPorHora * horasTrabajadas;
        if ("H".equals(company)) {
            // Pago director de HP
             HPCompany.totalPayH += salario;
        } else {
            // Pago director de MSI
            MSICompany.totalPayM += salario;
        }

    }

    public void entregarPCs() {

        if ("H".equals(company)) {
            ingresoH += Ensamblador.countComputadorasListasH * 90000;
            ingresoH += Ensamblador.countComputadorasTarjetaListasH * 140000;
            Ensamblador.countComputadorasListasH = 0;
            HP.actualizarComputadorasListas(Ensamblador.countComputadorasListasH);
            Ensamblador.countComputadorasTarjetaListasH = 0;
            HP.actualizarComputadorasTarjetaListas(Ensamblador.countComputadorasTarjetaListasH);
            daysRemaining.release(HPCompany.diasRestantesH);  //Resetea días restantes
            HP.estadoDirector.setText("Labores administrativas");
        } else {
            ingresoM += Ensamblador.countComputadorasListasM * 180000;
            ingresoM += Ensamblador.countComputadorasTarjetaListasM * 250000;
            Ensamblador.countComputadorasListasM = 0;
            MSI.actualizarComputadorasListas(Ensamblador.countComputadorasListasM);
            Ensamblador.countComputadorasTarjetaListasM = 0;
            MSI.actualizarComputadorasTarjetaListas(Ensamblador.countComputadorasTarjetaListasM);
            daysRemaining.release(MSICompany.diasRestantesM);  //Resetea días restantes
            MSI.estadoDirector.setText("Labores administrativas");
        }

    }

    @Override
    public void run() {
        while (true) {

            try {
                if ("H".equals(company)) {
                    if (daysRemaining.availablePermits() == 0) {

                         HP.actualizarEstadoDirector("Entregando computadoras");
                        Thread.sleep(1000*Dashboard.duracionDias);  // Pasa un día
                        payDayDirector();
                        entregarPCs();
                    } else {

                        trabajoAdministrativo();
                    }
                } else {
                    if (daysRemaining.availablePermits() == 0) {

                        MSI.actualizarEstadoDirector("Entregando computadoras");
                        Thread.sleep(1000*Dashboard.duracionDias);  // Pasa un día
                        payDayDirector();
                        entregarPCs();
                    } else {

                        trabajoAdministrativo();
                    }
                }
            } catch (InterruptedException ex) {
                System.out.println("Prueba");

            }
        }

    }

    public void trabajoAdministrativo() {
        try {
            int randomN = new Random().nextInt(1000);
            Thread.sleep(randomN*Dashboard.duracionDias);
            checkPM();
            Thread.sleep((1000 - randomN)*Dashboard.duracionDias);
            payDayDirector();

        } catch (InterruptedException ex) {
            Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void checkPM() {

        if ("H".equals(company)) {

             HP.actualizarEstadoDirector("Vigilando P.M.");
        } else {
            MSI.actualizarEstadoDirector("Vigilando P.M.");
        }
         if (ProjectManager.isWatchingStreams == true) {

            if ("H".equals(company)) {
                faltasCounterH++;
                descontadoPmH -= 100;
                 HP.faltasPM.setText(Integer.toString(faltasCounterH));
                 HP.descontadoPM.setText(Integer.toString(descontadoPmH));
                 HP.actualizarEstadoDirector("Labores administrativas");
            } else {
                faltasCounterM++;
                descontadoPmM -= 100;
                MSI.faltasPM.setText(Integer.toString(faltasCounterM));
                MSI.descontadoPM.setText(Integer.toString(descontadoPmM));
                MSI.estadoDirector.setText("Labores administrativas");

             }

        }
    }

}

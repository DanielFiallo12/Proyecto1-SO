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
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Director {
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

    public Director(Semaphore daysRemaining,String company) {
        this.company = company;
        this.daysRemaining = daysRemaining;
        this.totalIncome = 0;
        this.sueldoPorHora = 30;
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
            /* HPCompany.totalPayH += salario; */
        } else {
            // Pago de nintendo
            MSICompany.totalPayM += salario;
        }

    }

}

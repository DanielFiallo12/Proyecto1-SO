/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import interfaces.Dashboard;
import interfaces.MSI;
import java.util.concurrent.Semaphore;

/**
 *
 * @author adminccs
 */
public class ProductorCPUs extends Thread {
    
    public static int CPUsListosH = 0;
    public static int CPUsListosM = 0;
    int sueldoPorHora;
    Semaphore almacenCPU;
    boolean activo;
    int diasParaGenerar;
    int totalPay;
    String company;
    
    public ProductorCPUs(Semaphore almacenCPU, int totalPay, int diasParaGenerar, String company, boolean activo) {

        this.sueldoPorHora = 26;
        this.almacenCPU = almacenCPU;
        this.totalPay = totalPay;
        this.activo = activo;
        this.diasParaGenerar = diasParaGenerar;
        this.company = company;
    }
    
    public void payDayProductorCPUs() {
        // Calcular el salario basado en las horas trabajadas y agregarlo al total de pago
        int horasTrabajadas = 24;
        int salario = sueldoPorHora * horasTrabajadas;
        if (company == "H") {
            // Pago de productor CPUs de HP
            // HPCompany.totalPayH += salario;
            
        } else {
            // Pago de productor CPUs de MSI
            MSICompany.totalPayM += salario;
        }
    }
    
    @Override
    public void run() {
        while (activo) {
            try {
                int count = 0;

                while (count <= diasParaGenerar) {
                    Thread.sleep(1000*Dashboard.duracionDias);
                    payDayProductorCPUs();
                    count++;
                }
                producirCPU();
            } catch (InterruptedException ex) {
                System.out.println("TESTTT2");
            }
        }
    }
    
    private void producirCPU() throws InterruptedException {
        // Agregar el CPU al almacén
        if ("H".equals(company)) {
            if (almacenCPU.availablePermits() > 0) {
                almacenCPU.acquire(1);
                CPUsListosH++; // Incrementa el contador 
               // HP.actualizarCPUsAlmacen(CPUsListosH);
            } else {
                System.out.println("Almacén de CPUs lleno. Esperando que libere espacio.");
            }
        } else {
            // Producción CPU MSI
            if (almacenCPU.availablePermits() > 0) {
                almacenCPU.acquire(1);
                CPUsListosM++; // Incrementa el contador 
                MSI.actualizarCPUsAlmacen(CPUsListosM);

            } else {
                System.out.println("Almacén de CPUs lleno. Esperando que libere espacio.");
            }
        }

    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public static int getCPUsListasAlmacenH() {
        return CPUsListosH;
    }

    public static void setCPUsListasAlmacenH(int CPUsListosH) {
        ProductorCPUs.CPUsListosH -= CPUsListosH;
    }

    public static int getCPUsListasAlmacenM() {
        return CPUsListosM;
    }

    public static void setCPUsListasAlmacenM(int CPUsListosM) {
        ProductorCPUs.CPUsListosM -= CPUsListosM;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.concurrent.Semaphore;
import interfaces.Dashboard;
import interfaces.MSI;
/**
 *
 * @author adminccs
 */
public class ProductorPlacas extends Thread{
    
    public static int placasListasH = 0;
    public static int placasListasM = 0;
    int sueldoPorHora;
    Semaphore almacenPlaca;
    boolean activo;
    int diasParaGenerar;
    int totalPay;
    String company;
    
    public ProductorPlacas(Semaphore almacenPlaca, int totalPay, int diasParaGenerar, String company, boolean activo) {

        this.sueldoPorHora = 20;
        this.almacenPlaca = almacenPlaca;
        this.totalPay = totalPay;
        this.activo = activo;
        this.diasParaGenerar = diasParaGenerar;
        this.company = company;

    }
    
    public void payDayProductorPlacas() {
        // Calcular el salario basado en las horas trabajadas y agregarlo al total de pago
        int horasTrabajadas = 24;
        int salario = sueldoPorHora * horasTrabajadas;
        if ("H".equals(company)) {
            // Pago de HP
             // HPCompany.totalPayH += salario;
        } else {
            // Pago de MSI
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
                    payDayProductorPlacas();
                    count++;
                }
                producirPlaca();
            } catch (InterruptedException ex) {
                System.out.println("TESTTT2");

            }
        }
    }
    
    private void producirPlaca() throws InterruptedException {
        // Agregar la placa al almacén
        if ("H".equals(company)) {
            if (almacenPlaca.availablePermits() > 0) {
                almacenPlaca.acquire(1);
                placasListasH++; // Incrementa el contador 
                // HP.actualizarPlacasAlmacen(placasListasH);
            } else {
                System.out.println("Almacén de placas lleno. Esperando que libere espacio.");
            }
        } else {
            // Producción placa MSI
            if (almacenPlaca.availablePermits() > 0) {
                almacenPlaca.acquire(1);
                placasListasM++;
                MSI.actualizarPlacasAlmacen(placasListasM);
            } else {
                System.out.println("Almacén de placas lleno. Esperando que libere espacio.");
            }
        }
    }
    
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public static int getPlacasListasAlmacenH() {
        return placasListasH;
    }
    
     public static void setPlacasListasAlmacenH(int placasListasH) {
        ProductorPlacas.placasListasH -= placasListasH;
    }

    public static int getPlacasListasAlmacenM() {
        return placasListasM;
    }

    public static void setGuionesSubidosDriveN(int placasListasM) {
        ProductorPlacas.placasListasM -= placasListasM;
    }
}

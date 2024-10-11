/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import interfaces.Dashboard;
import interfaces.MSI;
import interfaces.HP;
import java.util.concurrent.Semaphore;

/**
 *
 * @author adminccs
 */
public class ProductorMemorias extends Thread {
    
    public static int memoriasListasH = 0;
    public static int memoriasListasM = 0;
    int sueldoPorHora;
    Semaphore almacenMemoria;
    boolean activo;
    int diasParaGenerar;
    int totalPay;
    String company;
    
    public ProductorMemorias(Semaphore almacenMemoria, int totalPay, int diasParaGenerar, String company, boolean activo) {

        this.sueldoPorHora = 40;
        this.almacenMemoria = almacenMemoria;
        this.totalPay = totalPay;
        this.activo = activo;
        this.diasParaGenerar = diasParaGenerar;
        this.company = company;

    }
    
    public void payDayProductorMemorias() {
        // Calcular el salario basado en las horas trabajadas y agregarlo al total de pago
        int horasTrabajadas = 24;
        int salario = sueldoPorHora * horasTrabajadas;
        if ("H".equals(company)) {
            // Pago de HP
              HPCompany.totalPayH += salario;
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
                    payDayProductorMemorias();
                    count++;
                }
                producirMemoria();
            } catch (InterruptedException ex) {
                System.out.println("TESTTT2");

            }
        }
    }
    
     private void producirMemoria() throws InterruptedException {
        // Agregar la memoria al almacén
        if ("H".equals(company)) {
            if (almacenMemoria.availablePermits() > 0) {
                almacenMemoria.acquire(1);
                memoriasListasH++; // Incrementa el contador 
                HP.actualizarMemoriasAlmacen(memoriasListasH);
            } else {
                System.out.println("Almacén de memorias RAM lleno. Esperando que libere espacio.");
            }
        } else {
            // Producción memoria MSI
            if (almacenMemoria.availablePermits() > 0) {
                almacenMemoria.acquire(1);
                memoriasListasM++;
                MSI.actualizarMemoriasAlmacen(memoriasListasM);
            } else {
                System.out.println("Almacén de memorias RAM lleno. Esperando que libere espacio.");
            }
        }
    }
    
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public static int getMemoriasListasAlmacenH() {
        return memoriasListasH;
    }
    
     public static void setMemoriasListasAlmacenH(int memoriasListasH) {
        ProductorMemorias.memoriasListasH -= memoriasListasH;
    }

    public static int getMemoriasListasAlmacenM() {
        return memoriasListasM;
    }

    public static void setMemoriasListasAlmacenM(int memoriasListasM) {
        ProductorMemorias.memoriasListasM -= memoriasListasM;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import interfaces.Dashboard;
import interfaces.HP;
import interfaces.MSI;
import java.util.concurrent.Semaphore;

/**
 *
 * @author adminccs
 */
public class ProductorFuentes extends Thread {
    
    public static int fuentesListasH = 0;
    public static int fuentesListasM = 0;
    int sueldoPorHora;
    Semaphore almacenFuente;
    boolean activo;
    int diasParaGenerar;
    int totalPay;
    String company;
    
    public ProductorFuentes(Semaphore almacenFuente, int totalPay, int diasParaGenerar, String company, boolean activo) {

        this.sueldoPorHora = 16;
        this.almacenFuente = almacenFuente;
        this.totalPay = totalPay;
        this.activo = activo;
        this.diasParaGenerar = diasParaGenerar;
        this.company = company;

    }
    
    public void payDayProductorFuentes() {
        // Calcular el salario basado en las horas trabajadas y agregarlo al total de pago
        int horasTrabajadas = 24;
        int salario = sueldoPorHora * horasTrabajadas;
        if (company == "H") {
            // Pago de productor CPUs de HP
             HPCompany.totalPayH += salario;
            
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
                    payDayProductorFuentes();
                    count++;
                }
                producirFuente();
            } catch (InterruptedException ex) {
                System.out.println("TESTTT2");
            }
        }
    }
    
    private void producirFuente() throws InterruptedException {
        // Agregar el fuente al almacén
        if ("H".equals(company)) {
            if (almacenFuente.availablePermits() > 0) {
                almacenFuente.acquire(1);
                fuentesListasH++; // Incrementa el contador 
                HP.actualizarFuentesAlmacen(fuentesListasH);
            } else {
                System.out.println("Almacén de fuentes lleno. Esperando que libere espacio.");
            }
        } else {
            // Producción fuente MSI
            if (almacenFuente.availablePermits() > 0) {
                almacenFuente.acquire(1);
                fuentesListasM++; // Incrementa el contador 
                MSI.actualizarFuentesAlmacen(fuentesListasM);

            } else {
                System.out.println("Almacén de fuentes lleno. Esperando que libere espacio.");
            }
        }

    }

    public static int getFuentesListasAlmacenH() {
        return fuentesListasH;
    }

    public static void setFuentesListasAlmacenH(int fuentesListasH) {
        ProductorFuentes.fuentesListasH -= fuentesListasH;
    }

    public static int getFuentesListasAlmacenM() {
        return fuentesListasM;
    }

    public static void setFuentesListasAlmacenM(int fuentesListasM) {
        ProductorFuentes.fuentesListasM -= fuentesListasM;
    }
    
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
}

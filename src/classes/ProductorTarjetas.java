/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import interfaces.HP;
import interfaces.Dashboard;
import interfaces.MSI;
import java.util.concurrent.Semaphore;

/**
 *
 * @author adminccs
 */
public class ProductorTarjetas extends Thread {
    
    public static int tarjetasListasH = 0;
    public static int tarjetasListasM = 0;
    int sueldoPorHora;
    Semaphore almacenTarjeta;
    boolean activo;
    int diasParaGenerar;
    int totalPay;
    String company;
    
    public ProductorTarjetas(Semaphore almacenTarjeta, int totalPay, int diasParaGenerar, String company, boolean activo) {

        this.sueldoPorHora = 34;
        this.almacenTarjeta = almacenTarjeta;
        this.totalPay = totalPay;
        this.activo = activo;
        this.diasParaGenerar = diasParaGenerar;
        this.company = company;

    }
    
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public void payDayProductorTarjetas() {
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
                    payDayProductorTarjetas();
                    count++;
                }
                producirTarjeta();
            } catch (InterruptedException ex) {
                System.out.println("TESTTT2");

            }
        }
    }
    
    private void producirTarjeta() throws InterruptedException {
        // Agregar la tarjeta al almacén
        if ("H".equals(company)) {
            if (almacenTarjeta.availablePermits() > 0) {
                almacenTarjeta.acquire(1);
                tarjetasListasH++; // Incrementa el contador 
                HP.actualizarTarjetasAlmacen(tarjetasListasH);
            } else {
                System.out.println("Almacén de tarjetas lleno. Esperando que libere espacio.");
            }
        } else {
            // Producción tarjeta MSI
            if (almacenTarjeta.availablePermits() > 1) {
                almacenTarjeta.acquire(1);
                tarjetasListasM += 1;
                MSI.actualizarTarjetasAlmacen(tarjetasListasM);
            } else {
                System.out.println("Almacén de tarjetas lleno. Esperando que libere espacio.");
            }
        }
    }
    
    public static int getTarjetasListasAlmacenH() {
        return tarjetasListasH;
    }

    public static void setTarjetasListasAlmacenH(int tarjetasListasH) {
        ProductorTarjetas.tarjetasListasH -= tarjetasListasH;
    }

    public static int getTarjetasListasAlmacenM() {
        return tarjetasListasM;
    }
    public static void setTarjetasListasAlmacenM(int tarjetasListasM) {
        ProductorTarjetas.tarjetasListasM -= tarjetasListasM;
    }
    
}

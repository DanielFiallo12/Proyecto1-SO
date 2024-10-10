/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import interfaces.HP;
import interfaces.MSI;
import interfaces.Dashboard;
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
        this.sueldoPorHora = 40;  // Sueldo por hora fijo
        this.almacenMemoria = almacenMemoria;
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

    public static int getMemoriasListasH() {
        return memoriasListasH;
    }

    public static void setMemoriasListasH(int memoriasListasH) {
        ProductorMemorias.memoriasListasH -= memoriasListasH;
    }

    public static int getMemoriasListasM() {
        return memoriasListasM;
    }

    public static void setMemoriasListasM(int memoriasListasM) {
        ProductorMemorias.memoriasListasM -= memoriasListasM;
    }

    public void payDayProductorMemorias() {
        // Calcular el salario basado en horas trabajadas
        int horasTrabajadas = 24;
        int salario = sueldoPorHora * horasTrabajadas;
        if ("H".equals(company)) {
            HPCompany.totalPayH += salario;
        } else {
            MSICompany.totalPayM += salario;
        }
    }

    public void generarMemoria() throws InterruptedException {
        if ("H".equals(company)) {
            // HP Company
            if (almacenMemoria.availablePermits() > 1) {
                almacenMemoria.acquire(2);
                memoriasListasH += 2;
                HP.actualizarMemoriasAlmacen(memoriasListasH);
            } else if (almacenMemoria.availablePermits() == 1) {
                almacenMemoria.acquire(1);
                memoriasListasH += 1;
                HP.actualizarMemoriasAlmacen(memoriasListasH);
            } else {
                System.out.println("Almacén de memorias lleno");
            }
        } else {
            // MSI Company
            if (almacenMemoria.availablePermits() > 1) {
                almacenMemoria.acquire(1);
                memoriasListasM += 1;
                MSI.actualizarMemoriasAlmacen(memoriasListasM);
            } else {
                System.out.println("Almacén de memorias lleno");
            }
        }
    }

    @Override
    public void run() {
        while (activo) {
            try {
                Thread.sleep(1000 * Dashboard.duracionDias);
                payDayProductorMemorias();
                generarMemoria();
            } catch (InterruptedException ex) {
                System.out.println("Error en el hilo de ProductorMemorias");
            }
        }
    }
}
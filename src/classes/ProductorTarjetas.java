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
    
    public static int gettarjetasListasH() {
        return tarjetasListasH;
    }

    public static void settarjetasListasH(int tarjetasListasH) {
        ProductorTarjetas.tarjetasListasH -= tarjetasListasH;
    }

    public static int gettarjetasListasM() {
        return tarjetasListasM;
    }
    public static void settarjetasListasM(int tarjetasListasM) {
        ProductorTarjetas.tarjetasListasM -= tarjetasListasM;
    }
    
    public void payDayDesarrolladorSprites() {
        int horasTrabajadas = 24;
        int salario = sueldoPorHora * horasTrabajadas;
        if (company == "H") {
            HPCompany.totalPayH += salario;
        } else {
            // Pago de nintendo
            MSICompany.totalPayM += salario;
        }
    }

    public void generarSprite() throws InterruptedException {

        if (company == "H") {
            //HP
            if (almacenTarjeta.availablePermits() > 1) {
                almacenTarjeta.acquire(2);
                tarjetasListasH += 2;
                HP.actualizarTarjetasAlmacen(tarjetasListasH);
            } else if (almacenTarjeta.availablePermits() == 1) {
                almacenTarjeta.acquire(1);
                tarjetasListasH += 1;
                HP.actualizarTarjetasAlmacen(tarjetasListasH);
            } else {
                System.out.println("Drive lleno");
            }
        } else {
            //MSI
            if (almacenTarjeta.availablePermits() > 1) {
                almacenTarjeta.acquire(1);
                tarjetasListasM += 1;
                MSI.actualizarTarjetasAlmacen(tarjetasListasM);
            } else {
                System.out.println("Drive lleno");
            }
        }
    }

    @Override
    public void run() {
        while (activo) {
            try {

                Thread.sleep(1000*Dashboard.duracionDias);
                payDayDesarrolladorSprites();
                generarSprite();

            } catch (InterruptedException ex) {
                System.out.println("Metodo Run Desarrollador Sprites Catch");
            }
        }
    }
}

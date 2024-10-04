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

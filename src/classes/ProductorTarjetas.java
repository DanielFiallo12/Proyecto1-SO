/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

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
    
}

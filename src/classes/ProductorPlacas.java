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
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
}

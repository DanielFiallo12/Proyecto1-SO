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
    
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}

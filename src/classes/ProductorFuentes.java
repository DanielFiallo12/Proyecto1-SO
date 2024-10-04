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
    
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
}

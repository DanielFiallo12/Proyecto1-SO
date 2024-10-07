/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import interfaces.Dashboard;
import interfaces.MSI;
import java.util.concurrent.Semaphore;

/**
 *
 * @author adminccs
 */
public class Ensamblador extends Thread {
    
    public static int countComputadorasListasH = 0;
    public static int countComputadorasListasM = 0;

    public static int countComputadorasTarjetaListasH = 0;
    public static int countComputadorasTarjetaListasM = 0;

    // Companía para el cual trabaja
    String company;

    // Almacén de los productores
    Semaphore almacenPlacas;
    Semaphore almacenCPUs;
    Semaphore almacenMemorias;
    Semaphore almacenFuentes;
    Semaphore almacenTarjetas;

    // Parámetros propios del ensamblador
    int sueldoPorHora;
    int totalPay;
    int diasParaGenerar;
    boolean activo;
    Semaphore almacenComputadoras;
    public static int computadorasListasTotalesH = 0;
    public static int computadorasListasTotalesM = 0;
    int computadorasListas;
    int computadorasTarjetaListas;
    int countComputadoras;

    // Parámetros para computadoras estándar
    int placasNecesarias;
    int CPUsNecesarios;
    int memoriasNecesarias;
    int fuentesNecesarias;
    int tarjetasNecesarias;
    int gananciaXComputador;

    // Parámetros para una computadora con tarjeta gráfica
    // Las tarjetas es un semáforo, ya que cuando se crean 6 computadoras, se toman 5 tarjetas gráficas del almacén.
    public Ensamblador(Semaphore almacenComputadoras, Semaphore almacenPlacas, Semaphore almacenCPUs, Semaphore almacenMemorias, Semaphore almacenFuentes, Semaphore almacenTarjetas, int computadorasListas, int computadorasTarjetaListas, int diasParaGenerar, int placasNecesarias, int CPUsNecesarios, int memoriasNecesarias, int fuentesNecesarias, int tarjetasNecesarias, String company, boolean activo) {

        this.company = company;

        this.almacenPlacas = almacenPlacas;
        this.almacenCPUs = almacenCPUs;
        this.almacenMemorias = almacenMemorias;
        this.almacenFuentes = almacenFuentes;
        this.almacenTarjetas = almacenTarjetas;

        this.sueldoPorHora = 50;
        this.totalPay = 0;
        this.diasParaGenerar = diasParaGenerar;
        this.almacenComputadoras = almacenComputadoras;
        this.computadorasListas = computadorasListas;
        this.computadorasTarjetaListas = computadorasTarjetaListas;
        this.countComputadoras = 0;

        this.placasNecesarias = placasNecesarias;
        this.CPUsNecesarios = CPUsNecesarios;
        this.memoriasNecesarias = memoriasNecesarias;
        this.fuentesNecesarias = fuentesNecesarias;
        this.tarjetasNecesarias = tarjetasNecesarias;
    }
    
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public void payDayEnsamblador() {
        int horasTrabajadas = 24;
        int salario = sueldoPorHora * horasTrabajadas;
        if (company == "H") {
            /* Pago ensamblador de HP */
        } else {
            MSICompany.totalPayM += salario;
        }
    }
}

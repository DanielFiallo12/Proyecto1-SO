/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import interfaces.Dashboard;
import interfaces.MSI;
import interfaces.HP;
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
    public static int computadorasTarjetaListasTotalesH = 0;
    public static int computadorasTarjetaListasTotalesM = 0;
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
            HPCompany.totalPayH += salario;
        } else {
            MSICompany.totalPayM += salario;
        }
    }
    
    public void ensamblarComputador() {
        if ("H".equals(company)) {
            if (countComputadoras == 2) {
                if (ProductorPlacas.getPlacasListasAlmacenH() >= placasNecesarias && 
                        ProductorCPUs.getCPUsListasAlmacenH() >= CPUsNecesarios && 
                        ProductorMemorias.getMemoriasListasAlmacenH() >= memoriasNecesarias && 
                        ProductorFuentes.getFuentesListasAlmacenH() >= fuentesNecesarias &&
                        ProductorTarjetas.getTarjetasListasAlmacenH() >= tarjetasNecesarias) {
                    try {
                        // Tiempo de ensamblaje (2 días)
                        Thread.sleep(2000 * Dashboard.duracionDias);

                        // LIBERAR Y ACTUALIZAR VALORES EN LA INTERFAZ
                        // Placas base
                        almacenPlacas.release(placasNecesarias);
                        ProductorPlacas.setPlacasListasAlmacenH(placasNecesarias);

                        // CPUs
                        almacenCPUs.release(CPUsNecesarios);
                        ProductorCPUs.setCPUsListasAlmacenH(CPUsNecesarios);

                        // Memorias RAM
                        almacenMemorias.release(memoriasNecesarias);
                        ProductorMemorias.setMemoriasListasAlmacenH(memoriasNecesarias);

                        // Fuentes de poder
                        almacenFuentes.release(fuentesNecesarias);
                        ProductorFuentes.setFuentesListasAlmacenH(fuentesNecesarias);

                        // Tarjetas gráficas
                        almacenTarjetas.release(tarjetasNecesarias);
                        ProductorTarjetas.setTarjetasListasAlmacenH(tarjetasNecesarias);

                        countComputadorasTarjetaListasH++;
                        computadorasTarjetaListasTotalesH++;
                        HP.actualizarComputadorasTarjetaListas(countComputadorasTarjetaListasH);
                        countComputadoras = 0; // Se reinicia el contador de computadoras para poder contar otra vez la cantidad de computadoras necesarias para ensamblar una con tarjetas gráficas.
                        HP.actualizarComputadorasTarjetaListasTotalesH(computadorasTarjetaListasTotalesH);
                    } catch (InterruptedException ex) {
                        System.out.println("testttt");
                    }
                } else {
                    System.out.println("No hay recursos suficientes para ensamblar el computador");
                }
            } else {
                if (ProductorPlacas.getPlacasListasAlmacenH() >= placasNecesarias && 
                        ProductorCPUs.getCPUsListasAlmacenH() >= CPUsNecesarios && 
                        ProductorMemorias.getMemoriasListasAlmacenH() >= memoriasNecesarias && 
                        ProductorFuentes.getFuentesListasAlmacenH() >= fuentesNecesarias) {
                    try {
                        // Tiempo de ensamblaje (2 días)
                        Thread.sleep(2000 * Dashboard.duracionDias);

                        // LIBERAR Y ACTUALIZAR VALORES EN LA INTERFAZ
                        // Placas base
                        almacenPlacas.release(placasNecesarias);
                        ProductorPlacas.setPlacasListasAlmacenH(placasNecesarias);

                        // CPUs
                        almacenCPUs.release(CPUsNecesarios);
                        ProductorCPUs.setCPUsListasAlmacenH(CPUsNecesarios);

                        // Memorias RAM
                        almacenMemorias.release(memoriasNecesarias);
                        ProductorMemorias.setMemoriasListasAlmacenH(memoriasNecesarias);

                        // Fuentes de poder
                        almacenFuentes.release(fuentesNecesarias);
                        ProductorFuentes.setFuentesListasAlmacenH(fuentesNecesarias);

                        countComputadorasListasH++;
                        computadorasListasTotalesH++;
                        HP.actualizarComputadorasListas(countComputadorasListasH);
                        countComputadoras++;
                        HP.actualizarComputadorasListasTotalesH(computadorasListasTotalesH);
                    } catch (InterruptedException ex) {
                        System.out.println("testttt");
                    }
                } else {
                    System.out.println("No hay recursos suficientes para ensamblar el computador.");
                }
            }
        } else {
            // MSI
            if (countComputadoras == 6) {
                if (ProductorPlacas.getPlacasListasAlmacenM() >= placasNecesarias && 
                        ProductorCPUs.getCPUsListasAlmacenM() >= CPUsNecesarios && 
                        ProductorMemorias.getMemoriasListasAlmacenM() >= memoriasNecesarias && 
                        ProductorFuentes.getFuentesListasAlmacenM() >= fuentesNecesarias &&
                        ProductorTarjetas.getTarjetasListasAlmacenM() >= tarjetasNecesarias) {
                    try {
                        // Tiempo de ensamblaje (2 días)
                        Thread.sleep(2000 * Dashboard.duracionDias);

                        // LIBERAR Y ACTUALIZAR VALORES EN LA INTERFAZ
                        // Placas base
                        almacenPlacas.release(placasNecesarias);
                        ProductorPlacas.setPlacasListasAlmacenM(placasNecesarias);
                        
                        // CPUs
                        almacenCPUs.release(CPUsNecesarios);
                        ProductorCPUs.setCPUsListasAlmacenM(CPUsNecesarios);

                        // Memorias RAM
                        almacenMemorias.release(memoriasNecesarias);
                        ProductorMemorias.setMemoriasListasAlmacenM(memoriasNecesarias);

                        // Fuentes de poder
                        almacenFuentes.release(fuentesNecesarias);
                        ProductorFuentes.setFuentesListasAlmacenM(fuentesNecesarias);

                        // Tarjetas gráficas
                        almacenTarjetas.release(tarjetasNecesarias);
                        ProductorTarjetas.setTarjetasListasAlmacenM(tarjetasNecesarias);

                        countComputadorasTarjetaListasM++;
                        computadorasTarjetaListasTotalesM++;
                        MSI.actualizarComputadorasTarjetaListas(countComputadorasTarjetaListasM);
                        countComputadoras = 0; // Se reinicia el contador de computadoras para poder contar otra vez la cantidad de computadoras necesarias para ensamblar una con tarjetas gráficas.
                        MSI.actualizarComputadorasTarjetaListasTotalesM(computadorasTarjetaListasTotalesM);
                    } catch (InterruptedException ex) {
                        System.out.println("testttt");
                    }
                } else {
                    System.out.println("No hay recursos suficientes para ensamblar la computadora.");
                }
            } else {
                if (ProductorPlacas.getPlacasListasAlmacenM() >= placasNecesarias && 
                        ProductorCPUs.getCPUsListasAlmacenM() >= CPUsNecesarios && 
                        ProductorMemorias.getMemoriasListasAlmacenM() >= memoriasNecesarias && 
                        ProductorFuentes.getFuentesListasAlmacenM() >= fuentesNecesarias) {
                    try {
                        // Tiempo de ensamblaje (2 días)
                        Thread.sleep(2000 * Dashboard.duracionDias);

                        // LIBERAR Y ACTUALIZAR VALORES EN LA INTERFAZ
                        // Placas base
                        almacenPlacas.release(placasNecesarias);
                        ProductorPlacas.setPlacasListasAlmacenM(placasNecesarias);
                        
                        // CPUs
                        almacenCPUs.release(CPUsNecesarios);
                        ProductorCPUs.setCPUsListasAlmacenM(CPUsNecesarios);

                        // Memorias RAM
                        almacenMemorias.release(memoriasNecesarias);
                        ProductorMemorias.setMemoriasListasAlmacenM(memoriasNecesarias);

                        // Fuentes de poder
                        almacenFuentes.release(fuentesNecesarias);
                        ProductorFuentes.setFuentesListasAlmacenM(fuentesNecesarias);

                        countComputadorasListasM++;
                        computadorasListasTotalesM++;
                        MSI.actualizarComputadorasListas(countComputadorasListasM);
                        countComputadoras++;
                        MSI.actualizarComputadorasListasTotalesM(computadorasListasTotalesM);
                    } catch (InterruptedException ex) {
                        System.out.println("testttt");
                    }
                } else {
                    System.out.println("No hay recursos suficientes para ensamblar la computadora.");
                }
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000 * Dashboard.duracionDias);
                payDayEnsamblador();
                ensamblarComputador();
            } catch (InterruptedException ex) {
                System.out.println("TESTTTT Ensamblador catch");
            }
        }
    }
}



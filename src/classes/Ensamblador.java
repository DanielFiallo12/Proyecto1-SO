/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaces.HP;
import interfaces.Dashboard;
import interfaces.MSI;
import java.util.concurrent.Semaphore;


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

    public void generarVideoJuego() {
        if ("H".equals(company)) {
            if (countComputadoras == 7) {
                if (ProductorPlacas.getPlacasListasAlmacenH() >= placasNecesarias && ProductorCPUs.getCPUsListasAlmacenH() >= CPUsNecesarios && ProductorMemorias.getMemoriasListasAlmacenH() >= memoriasNecesarias && ProductorFuentes.getFuentesListasAlmacenH() >= fuentesNecesarias) {
                    try {
                        // Tiempo de armado (2 dias)
                        Thread.sleep(2000 * Dashboard.duracionDias);

                        // LIBERAR Y ACTUALIZAR VALORES EN LA INTERFAZ
                        // Placas
                        almacenPlacas.release(placasNecesarias);
                        ProductorPlacas.setPlacasListasAlmacenH(placasNecesarias);

                        // CPUs
                        almacenCPUs.release(CPUsNecesarios);
                        ProductorCPUs.setCPUsListasAlmacenH(CPUsNecesarios);

                        // DLC
                        almacenMemorias.release(memoriasNecesarias);
                        ProductorMemorias.setMemoriasListasAlmacenH(memoriasNecesarias);

                        // Sistemas
                        almacenFuentes.release(fuentesNecesarias);
                        ProductorFuentes.setFuentesListasAlmacenH(fuentesNecesarias);

                        // Sprites
                        almacenTarjetas.release(tarjetasNecesarias);
                        ProductorTarjetas.setTarjetasListasAlmacenH(tarjetasNecesarias);

                        countComputadorasTarjetaListasH++;
                        computadorasListasTotalesH++;
                        HP.actualizarMemoriasAlmacen(countComputadorasTarjetaListasH);
                        countComputadoras = 0; // Se reinicia el contador de juegos para poder contar otra vez la cantidad de juegos necesarios para desarrollar uno con DLC.
                    } catch (InterruptedException ex) {
                        System.out.println("testttt");
                    }
                } else {
                    System.out.println("No hay recursos suficientes para generar el juego");
                }
            } else {
                if (ProductorPlacas.getPlacasListasAlmacenH() >= placasNecesarias && ProductorCPUs.getCPUsListasAlmacenH() >= CPUsNecesarios && ProductorFuentes.getFuentesListasAlmacenH() >= fuentesNecesarias && ProductorTarjetas.getTarjetasListasAlmacenH() >= tarjetasNecesarias) {
                    try {
                        // Tiempo de armado (2 dias)
                        Thread.sleep(2000 * Dashboard.duracionDias);

                        // LIBERAR Y ACTUALIZAR VALORES EN LA INTERFAZ
                        // Guiones
                        almacenPlacas.release(placasNecesarias);
                        ProductorPlacas.setPlacasListasAlmacenH(placasNecesarias);

                        // Niveles
                        almacenCPUs.release(CPUsNecesarios);
                        ProductorCPUs.setCPUsListasAlmacenH(CPUsNecesarios);

                        // Sistemas
                        almacenFuentes.release(fuentesNecesarias);
                        ProductorFuentes.setFuentesListasAlmacenH(fuentesNecesarias);

                        // Sprites
                        almacenTarjetas.release(tarjetasNecesarias);
                        ProductorTarjetas.setTarjetasListasAlmacenH(tarjetasNecesarias);

                        countComputadorasTarjetaListasH++;
                        computadorasListasTotalesH++;
                        HP.actualizarMemoriasAlmacen(countComputadorasTarjetaListasH);
                        countComputadoras++;
                    } catch (InterruptedException ex) {
                        System.out.println("testttt");
                    }
                } else {
                    System.out.println("No hay recursos suficientes para generar el juego");
                }
            }
            HP.actualizarComputadorasListas(computadorasListasTotalesH);
        } else {
            // MSI
            if (countComputadoras == 5) {
                if (ProductorPlacas.getPlacasListasAlmacenM() >= placasNecesarias && ProductorCPUs.getCPUsListasAlmacenM() >= CPUsNecesarios && ProductorMemorias.getMemoriasListasAlmacenM() >= memoriasNecesarias && ProductorFuentes.getFuentesListasAlmacenM() >= fuentesNecesarias) {
                    try {
                        // Tiempo de armado (2 dias)
                        Thread.sleep(2000 * Dashboard.duracionDias);


                        almacenPlacas.release(placasNecesarias);
                        ProductorPlacas.setPlacasListasAlmacenM(placasNecesarias);

                        
                        almacenCPUs.release(CPUsNecesarios);
                        ProductorCPUs.setCPUsListasAlmacenM(CPUsNecesarios);

                        almacenMemorias.release(memoriasNecesarias);
                        ProductorMemorias.setMemoriasListasAlmacenM(memoriasNecesarias);

                       
                        almacenFuentes.release(fuentesNecesarias);
                        ProductorFuentes.setFuentesListasAlmacenM(fuentesNecesarias);

                        almacenTarjetas.release(tarjetasNecesarias);
                        ProductorTarjetas.setTarjetasListasAlmacenM(tarjetasNecesarias);

                        countComputadorasTarjetaListasM++;
                        computadorasListasTotalesM++;
                        MSI.actualizarMemoriasAlmacen(countComputadorasTarjetaListasM);
                        countComputadoras = 0; // Se reinicia el contador de juegos para poder contar otra vez la cantidad de juegos necesarios para desarrollar uno con DLC.
                    } catch (InterruptedException ex) {
                        System.out.println("testttt");
                    }
                } else {
                    System.out.println("No hay recursos suficientes para generar el juego");
                }
            } else {

                if (ProductorPlacas.getPlacasListasAlmacenM() >= placasNecesarias && ProductorCPUs.getCPUsListasAlmacenM() >= CPUsNecesarios && ProductorFuentes.getFuentesListasAlmacenM() >= fuentesNecesarias && ProductorTarjetas.getTarjetasListasAlmacenM() >= tarjetasNecesarias) {
                    try {
                        // Tiempo de armado (2 dias)
                        Thread.sleep(2000 * Dashboard.duracionDias);

                        // LIBERAR Y ACTUALIZAR VALORES EN LA INTERFAZ
                        // Guiones
                        almacenPlacas.release(placasNecesarias);
                        ProductorPlacas.setPlacasListasAlmacenM(placasNecesarias);

                        // Niveles
                        almacenCPUs.release(CPUsNecesarios);
                        ProductorCPUs.setCPUsListasAlmacenM(CPUsNecesarios);

                        // Sistemas
                        almacenFuentes.release(fuentesNecesarias);
                        ProductorFuentes.setFuentesListasAlmacenM(fuentesNecesarias);

                        // Sprites
                        almacenTarjetas.release(tarjetasNecesarias);
                        ProductorTarjetas.setTarjetasListasAlmacenM(tarjetasNecesarias);

                        countComputadorasTarjetaListasM++;
                        computadorasListasTotalesM++;
                        MSI.actualizarMemoriasAlmacen(countComputadorasTarjetaListasM);
                        countComputadoras++;
                    } catch (InterruptedException ex) {
                        System.out.println("testttt");
                    }
                } else {
                    System.out.println("No hay recursos suficientes para generar el juego");
                }
            }
            MSI.actualizarComputadorasListas(computadorasListasTotalesM);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000 * Dashboard.duracionDias);
                payDayEnsamblador();
                generarVideoJuego();
            } catch (InterruptedException ex) {
                System.out.println("TESTTTT Ensamblador catch");
            }
        }
    }
}

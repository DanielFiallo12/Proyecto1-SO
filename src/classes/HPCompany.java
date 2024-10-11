/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import interfaces.Dashboard;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author adminccs
 */
public class HPCompany {
    
    public static int diasRestantesH = Dashboard.diasParaEntrega;
    public static int totalPayH = 0;
    public static int ingresoH = 0;
    public static int utilidadH = ingresoH - totalPayH;
    public static int pcsGeneradosH = 0;
    public static int pcsTGGeneradosH = 0;
    
    // Capacidad de los almacenes de los productores
    static int capacidadAlmacenPlacasH = 25;
    static int capacidadAlmacenCPUsH = 20;
    static int capacidadAlmacenMemoriasH = 55;
    static int capacidadAlmacenFuentesH = 35;
    static int capacidadAlmacenTarjetasH = 10;
    
    // Semáforos de los almacenes de los productores
    public static Semaphore almacenPlacasH = new Semaphore(capacidadAlmacenPlacasH);
    public static Semaphore almacenCPUsH = new Semaphore(capacidadAlmacenCPUsH);
    public static Semaphore almacenMemoriasH = new Semaphore(capacidadAlmacenMemoriasH);
    public static Semaphore almacenFuentesH = new Semaphore(capacidadAlmacenFuentesH);
    public static Semaphore almacenTarjetasH = new Semaphore(capacidadAlmacenTarjetasH);
    public static Semaphore almacenPCsH = new Semaphore(Integer.MAX_VALUE);
    
    // Semáforo de los días restantes
    public static Semaphore diasRestantesSem = new Semaphore(diasRestantesH);

    final private boolean active = true;
    private int pcsContador;
    private int dayDuration;
    private final Semaphore counterMutex = new Semaphore(1);

    int totalDayCounter = 0;
    
    //Productores
    private static int productorPlacasCountH = 0;
    private static int productorCPUsCountH = 0;
    private static int productorMemoriasCountH = 0;
    private static int productorFuentesCountH = 0;
    private static int productorTarjetasCountH = 0;
    private static int ensambladoresCount = 0;
    
    public HPCompany(int dayDuration, int daysUntilLaunch) {
        this.dayDuration = dayDuration;
    }
    
    // Lista de productores
    private static ProductorPlacas[] productoresPlacas = new ProductorPlacas[14];
    private static ProductorCPUs[] productoresCPUs = new ProductorCPUs[14];
    private static ProductorMemorias[] productoresMemorias = new ProductorMemorias[14];
    private static ProductorFuentes[] productoresFuentes = new ProductorFuentes[14];
    private static ProductorTarjetas[] productoresTarjetas = new ProductorTarjetas[14];
    private static Ensamblador[] ensambladores = new Ensamblador[14];
    
    public static void crearProductorPlaca(Semaphore almacenPlacasH, int totalPay, int diasParaGenerar, String company, boolean activo) {
        ProductorPlacas productorPlacas = new ProductorPlacas(almacenPlacasH, totalPay, diasParaGenerar, company, activo);
        // Encuentra la primera posición libre en el arreglo
        for (int i = 0; i < 14; i++) {
            if (productoresPlacas[i] == null) {
                productoresPlacas[i] = productorPlacas;
                productorPlacasCountH++; // Incrementar el contador
                productorPlacas.start(); // Iniciar el hilo del productor de placas
                break;
            }
        }
    }
    
    public static void stopProductorPlacaAleatorio() {
        if (productorPlacasCountH == 0) {
            return; // No hay hilos para detener
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(14); // Obtener un índice aleatorio
        } while (productoresPlacas[indiceAleatorio] == null);

        ProductorPlacas hilo = productoresPlacas[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos antes de eliminar: " + productorPlacasCountH);
            hilo.setActivo(false); // Establecer el estado del hilo como inactivo
            productoresPlacas[indiceAleatorio] = null; // Eliminar el hilo de la lista
            productorPlacasCountH--; // Decrementar el contador
        }
    }
    
    public static void crearProductorCPU(Semaphore almacenCPUsH, int totalPay, int diasParaGenerar, String company, boolean activo) {
        ProductorCPUs productorCPUs = new ProductorCPUs(almacenCPUsH, totalPay, diasParaGenerar, company, activo);
        // Encuentra la primera posición libre en el arreglo
        for (int i = 0; i < 14; i++) {
            if (productoresCPUs[i] == null) {
                productoresCPUs[i] = productorCPUs;
                productorCPUsCountH++; // Incrementar el contador
                productorCPUs.start(); // Iniciar el hilo del productor de CPUs
                break;
            }
        }
    }

    public static void stopProductorCPUAleatorio() {
        if (productorCPUsCountH == 0) {
            return; // No hay hilos para detener
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(14); // Obtener un índice aleatorio
        } while (productoresCPUs[indiceAleatorio] == null);

        ProductorCPUs hilo = productoresCPUs[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos de CPUs antes de eliminar: " + productorCPUsCountH);
            hilo.setActivo(false); // Establecer el estado del hilo como inactivo
            productoresCPUs[indiceAleatorio] = null; // Eliminar el hilo de la lista
            productorCPUsCountH--; // Decrementar el contador
        }
    }
    
    public static void crearProductorMemoria(Semaphore almacenMemoriasH, int totalPay, int diasParaGenerar, String company, boolean activo) {
        ProductorMemorias productorMemorias = new ProductorMemorias(almacenMemoriasH, totalPay, diasParaGenerar, company, activo);
        // Encuentra la primera posición libre en el arreglo
        for (int i = 0; i < 14; i++) {
            if (productoresMemorias[i] == null) {
                productoresMemorias[i] = productorMemorias;
                productorMemoriasCountH++; // Incrementar el contador
                productorMemorias.start(); // Iniciar el hilo del productor de memorias
                break;
            }
        }
    }

    public static void stopProductorMemoriaAleatorio() {
        if (productorMemoriasCountH == 0) {
            return; // No hay hilos para detener
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(14); // Obtener un índice aleatorio
        } while (productoresMemorias[indiceAleatorio] == null);

        ProductorMemorias hilo = productoresMemorias[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos de memorias RAM antes de eliminar: " + productorMemoriasCountH);
            hilo.setActivo(false); // Establecer el estado del hilo como inactivo
            productoresMemorias[indiceAleatorio] = null; // Eliminar el hilo de la lista
            productorMemoriasCountH--; // Decrementar el contador
        }
    }

    public static void crearProductorFuente(Semaphore almacenFuentesH, int diasParaGenerar, int totalPay, String company, boolean activo) {
        ProductorFuentes productorFuentes = new ProductorFuentes(almacenFuentesH, diasParaGenerar, totalPay, company, activo);
        // Encuentra la primera posicion libre en el arreglo
        for (int i = 0; i < 14; i++) {
            if (productoresFuentes[i] == null) {
                productoresFuentes[i] = productorFuentes;
                productorFuentesCountH++;
                productorFuentes.start();
                break;
            }
        }
    }

    public static void stopProductorFuenteAleatorio() {
        if (productorFuentesCountH == 0) {
            return;
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(14);
        } while (productoresFuentes[indiceAleatorio] == null);

        ProductorFuentes hilo = productoresFuentes[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos de fuentes de poder antes de eliminar: " + productorFuentesCountH);
            hilo.setActivo(false);
            productoresFuentes[indiceAleatorio] = null;
            productorFuentesCountH--;
        }
    }
    
    public static void crearProductorTarjeta(Semaphore almacenTarjetasH, int diasParaGenerar, int totalPay, String company, boolean activo) {
        ProductorTarjetas productorTarjetas = new ProductorTarjetas(almacenTarjetasH, diasParaGenerar, totalPay, company, activo);

        for (int i = 0; i < 14; i++) {
            if (productoresTarjetas[i] == null) {
                productoresTarjetas[i] = productorTarjetas;
                productorTarjetasCountH++;
                productorTarjetas.start();
                break;
            }
        }
    }

    public static void stopProductorTarjetaAleatorio() {

        if (productorTarjetasCountH == 0) {
            return;
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(14);
        } while (productoresTarjetas[indiceAleatorio] == null);

        ProductorTarjetas hilo = productoresTarjetas[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos de tarjetas gráficas antes de eliminar: " + productorTarjetasCountH);
            hilo.setActivo(false);
            productoresTarjetas[indiceAleatorio] = null;
            productorTarjetasCountH--;
        }
    }
    
    public static void crearEnsamblador(Semaphore almacenPCsH, Semaphore almacenPlacasH, Semaphore almacenCPUsH, Semaphore almacenMemoriasH, Semaphore almacenFuentesH, Semaphore almacenTarjetasH, int pcsGeneradosH, int pcsTGGeneradosH, int diasParaGenerar, int placasNecesarias, int CPUsNecesarios, int memoriasNecesarias, int fuentesNecesarias, int tarjetasNecesarias, String company, boolean activo) {
        Ensamblador ensamblador = new Ensamblador(almacenPCsH, almacenPlacasH, almacenCPUsH, almacenMemoriasH, almacenFuentesH, almacenTarjetasH, pcsGeneradosH, pcsTGGeneradosH, diasParaGenerar, placasNecesarias, CPUsNecesarios, memoriasNecesarias, fuentesNecesarias, tarjetasNecesarias, company, activo);

        for (int i = 0; i < 14; i++) {
            if (ensambladores[i] == null) {
                ensambladores[i] = ensamblador;
                ensambladoresCount++;
                ensamblador.start();
                break;
            }
        }
    }

    public static void stopEnsambladorAleatorio() {

        if (ensambladoresCount == 0) {
            return;
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(14);
        } while (ensambladores[indiceAleatorio] == null);

        Ensamblador hilo = ensambladores[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos de ensambladores antes de eliminar: " + ensambladoresCount);
            hilo.setActivo(false);
            ensambladores[indiceAleatorio] = null;
            ensambladoresCount--;
        }
    }
}

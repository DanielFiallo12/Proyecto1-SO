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
public class MSICompany {
    
    public static int diasRestantesM = Dashboard.diasParaEntrega;
    public static int totalPayM = 0;
    public static int ingresoM = 0;
    public static int utilidadM = ingresoM - totalPayM;
    public static int pcsGeneradosM = 0;
    public static int pcsTGGeneradosM = 0;
    
    // Capacidad de los almacénes de los productores
    static int capacidadAlmacenPlacasM = 25;
    static int capacidadAlmacenCPUsM = 20;
    static int capacidadAlmacenMemoriasM = 55;
    static int capacidadAlmacenFuentesM = 35;
    static int capacidadAlmacenTarjetasM = 10;
    
    // Semáforos de los almacénes de los productores
    public static Semaphore almacenPlacasM = new Semaphore(capacidadAlmacenPlacasM);
    public static Semaphore almacenCPUsM = new Semaphore(capacidadAlmacenCPUsM);
    public static Semaphore almacenMemoriasM = new Semaphore(capacidadAlmacenMemoriasM);
    public static Semaphore almacenFuentesM = new Semaphore(capacidadAlmacenFuentesM);
    public static Semaphore almacenTarjetasM = new Semaphore(capacidadAlmacenTarjetasM);
    public static Semaphore almacenPCsM = new Semaphore(Integer.MAX_VALUE);
    
    // Semáforo de los días restantes
    public static Semaphore diasRestantesSem = new Semaphore(diasRestantesM);

    final private boolean active = true;
    private int pcsContador;
    private int dayDuration;
    private final Semaphore counterMutex = new Semaphore(1);

    int totalDayCounter = 0;
    
    //Productores
    private static int productorPlacasCountM = 0;
    private static int productorCPUsCountM = 0;
    private static int productorMemoriasCountM = 0;
    private static int productorFuentesCountM = 0;
    private static int productorTarjetasCountM = 0;
    private static int ensambladoresCount = 0;
    
    public MSICompany(int dayDuration, int daysUntilLaunch) {
        this.dayDuration = dayDuration;
    }
    
    // Lista de productores
    private static ProductorPlacas[] productoresPlacas = new ProductorPlacas[14];
    private static ProductorCPUs[] productoresCPUs = new ProductorCPUs[14];
    private static ProductorMemorias[] productoresMemorias = new ProductorMemorias[14];
    private static ProductorFuentes[] productoresFuentes = new ProductorFuentes[14];
    private static ProductorTarjetas[] productoresTarjetas = new ProductorTarjetas[14];
    private static Ensamblador[] ensambladores = new Ensamblador[14];
    
    public static void crearProductorPlaca(Semaphore almacenPlacasM, int totalPay, int diasParaGenerar, String company, boolean activo) {
        ProductorPlacas productorPlacas = new ProductorPlacas(almacenPlacasM, totalPay, diasParaGenerar, company, activo);
        // Encuentra la primera posición libre en el arreglo
        for (int i = 0; i < 14; i++) {
            if (productoresPlacas[i] == null) {
                productoresPlacas[i] = productorPlacas;
                productorPlacasCountM++; // Incrementar el contador
                productorPlacas.start(); // Iniciar el hilo del productor de placas
                System.out.println(": " + productorPlacasCountM);
                break;
            }
        }
    }
    
    public static void stopProductorPlacaAleatorio() {
        if (productorPlacasCountM == 0) {
            return; // No hay hilos para detener
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(14); // Obtener un índice aleatorio
        } while (productoresPlacas[indiceAleatorio] == null);

        ProductorPlacas hilo = productoresPlacas[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos antes de eliminar: " + productorPlacasCountM);
            hilo.setActivo(false); // Establecer el estado del hilo como inactivo
            productoresPlacas[indiceAleatorio] = null; // Eliminar el hilo de la lista
            productorPlacasCountM--; // Decrementar el contador
        }
    }
    
    public static void crearProductorCPU(Semaphore almacenCPUsM, int totalPay, int diasParaGenerar, String company, boolean activo) {
        ProductorCPUs productorCPUs = new ProductorCPUs(almacenCPUsM, totalPay, diasParaGenerar, company, activo);
        // Encuentra la primera posición libre en el arreglo
        for (int i = 0; i < 14; i++) {
            if (productoresCPUs[i] == null) {
                productoresCPUs[i] = productorCPUs;
                productorCPUsCountM++; // Incrementar el contador
                productorCPUs.start(); // Iniciar el hilo del productor de CPUs
                break;
            }
        }
    }

    public static void stopProductorCPUAleatorio() {
        if (productorCPUsCountM == 0) {
            return; // No hay hilos para detener
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(14); // Obtener un índice aleatorio
        } while (productoresCPUs[indiceAleatorio] == null);

        ProductorCPUs hilo = productoresCPUs[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos de CPUs antes de eliminar: " + productorCPUsCountM);
            hilo.setActivo(false); // Establecer el estado del hilo como inactivo
            productoresCPUs[indiceAleatorio] = null; // Eliminar el hilo de la lista
            productorCPUsCountM--; // Decrementar el contador
        }
    }
    
    public static void crearProductorMemoria(Semaphore almacenMemoriasM, int totalPay, int diasParaGenerar, String company, boolean activo) {
        ProductorMemorias productorMemorias = new ProductorMemorias(almacenMemoriasM, totalPay, diasParaGenerar, company, activo);
        // Encuentra la primera posición libre en el arreglo
        for (int i = 0; i < 14; i++) {
            if (productoresMemorias[i] == null) {
                productoresMemorias[i] = productorMemorias;
                productorMemoriasCountM++; // Incrementar el contador
                productorMemorias.start(); // Iniciar el hilo del productor de memorias
                break;
            }
        }
    }

    public static void stopProductorMemoriaAleatorio() {
        if (productorMemoriasCountM == 0) {
            return; // No hay hilos para detener
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(14); // Obtener un índice aleatorio
        } while (productoresMemorias[indiceAleatorio] == null);

        ProductorMemorias hilo = productoresMemorias[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos de memorias RAM antes de eliminar: " + productorMemoriasCountM);
            hilo.setActivo(false); // Establecer el estado del hilo como inactivo
            productoresMemorias[indiceAleatorio] = null; // Eliminar el hilo de la lista
            productorMemoriasCountM--; // Decrementar el contador
        }
    }

    public static void crearProductorFuente(Semaphore almacenFuentesM, int diasParaGenerar, int totalPay, String company, boolean activo) {
        ProductorFuentes productorFuentes = new ProductorFuentes(almacenFuentesM, diasParaGenerar, totalPay, company, activo);
        // Encuentra la primera posicion libre en el arreglo
        for (int i = 0; i < 14; i++) {
            if (productoresFuentes[i] == null) {
                productoresFuentes[i] = productorFuentes;
                productorFuentesCountM++;
                productorFuentes.start();
                break;
            }
        }
    }

    public static void stopProductorFuenteAleatorio() {
        if (productorFuentesCountM == 0) {
            return;
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(14);
        } while (productoresFuentes[indiceAleatorio] == null);

        ProductorFuentes hilo = productoresFuentes[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos de fuentes de poder antes de eliminar: " + productorFuentesCountM);
            hilo.setActivo(false);
            productoresFuentes[indiceAleatorio] = null;
            productorFuentesCountM--;
        }
    }
    
    public static void crearProductorTarjeta(Semaphore almacenTarjetasM, int diasParaGenerar, int totalPay, String company, boolean activo) {
        ProductorTarjetas productorTarjetas = new ProductorTarjetas(almacenTarjetasM, diasParaGenerar, totalPay, company, activo);

        for (int i = 0; i < 14; i++) {
            if (productoresTarjetas[i] == null) {
                productoresTarjetas[i] = productorTarjetas;
                productorTarjetasCountM++;
                productorTarjetas.start();
                break;
            }
        }
    }

    public static void stopProductorTarjetaAleatorio() {

        if (productorTarjetasCountM == 0) {
            return;
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(14);
        } while (productoresTarjetas[indiceAleatorio] == null);

        ProductorTarjetas hilo = productoresTarjetas[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos de tarjetas gráficas antes de eliminar: " + productorTarjetasCountM);
            hilo.setActivo(false);
            productoresTarjetas[indiceAleatorio] = null;
            productorTarjetasCountM--;
        }
    }
    
    public static void crearEnsamblador(Semaphore almacenPCsM, Semaphore almacenPlacasM, Semaphore almacenCPUsM, Semaphore almacenMemoriasM, Semaphore almacenFuentesM, Semaphore almacenTarjetasM, int pcsGeneradosM, int pcsTGGeneradosM, int diasParaGenerar, int placasNecesarias, int CPUsNecesarios, int memoriasNecesarias, int fuentesNecesarias, int tarjetasNecesarias, String company, boolean activo) {
        Ensamblador ensamblador = new Ensamblador(almacenPCsM, almacenPlacasM, almacenCPUsM, almacenMemoriasM, almacenFuentesM, almacenTarjetasM, pcsGeneradosM, pcsTGGeneradosM, diasParaGenerar, placasNecesarias, CPUsNecesarios, memoriasNecesarias, fuentesNecesarias, tarjetasNecesarias, company, activo);

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

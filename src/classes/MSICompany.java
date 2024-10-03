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
    
    public static int diasRestantesM = 0;
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
    private static ProductorPlacas[] productoresPlacas = new ProductorPlacas[11];
    
    public static void crearProductorPlaca(Semaphore almacenPlacasM, int totalPay, int diasParaGenerar, String company, boolean activo) {
        ProductorPlacas productorPlacas = new ProductorPlacas(almacenPlacasM, totalPay, diasParaGenerar, company, activo);
        // Encuentra la primera posición libre en el arreglo
        for (int i = 0; i < 11; i++) {
            if (productoresPlacas[i] == null) {
                productoresPlacas[i] = productorPlacas;
                productorPlacasCountM++; // Incrementar el contador
                productorPlacas.start(); // Iniciar el hilo del productor de placas
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
            indiceAleatorio = random.nextInt(11); // Obtener un índice aleatorio
        } while (productoresPlacas[indiceAleatorio] == null);

        ProductorPlacas hilo = productoresPlacas[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos antes de eliminar: " + productorPlacasCountM);
            hilo.setActivo(false); // Establecer el estado del hilo como inactivo
            productoresPlacas[indiceAleatorio] = null; // Eliminar el hilo de la lista
            productorPlacasCountM--; // Decrementar el contador
        }
    }
} 
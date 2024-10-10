package classes;

import interfaces.HP;
import interfaces.Dashboard;
import interfaces.MSI;
import java.util.concurrent.Semaphore;

public class ProjectManager extends Thread {

    Semaphore diasRestantesEntregaPCs;
    int totalPay;
    public static boolean isWatchingStreams;
    int sueldoPorHora;
    String studio;

    // Tiempos basados en que 1 dia de trabajo (24 horas) son 1000 milisegundos.
    int currentTime = 0;
    int streamInterval = 21*Dashboard.duracionDias; // 30 minutos en milisegundos
    int workInterval = 21*Dashboard.duracionDias;   // 30 minutos en milisegundos
    int totalWorkTime = 666*Dashboard.duracionDias; // 16 horas en milisegundos 
    int totalDayTime = 1000*Dashboard.duracionDias;  // 24 horas en milisegundos

    // Estados PM
    String estadoWork = "Trabajando";
    String estadoStreams = "Viendo streams";

    public ProjectManager(Semaphore diasRestantesEntregaJuegos, String studio) {
        this.diasRestantesEntregaPCs = diasRestantesEntregaJuegos;
        this.totalPay = 0;
        this.isWatchingStreams = false;
        this.sueldoPorHora = 40;
        this.studio = studio;
    }

    @Override
    public void run() {

        while (true) {
            try {
                while (currentTime < totalWorkTime) {
                    trabaja();
                    veStreams();
                    currentTime += (workInterval + streamInterval);
                }

                // Simula el paso del tiempo restante 
                int tiempoRestanteDia = totalDayTime - totalWorkTime;
                Thread.sleep(tiempoRestanteDia);

                changeDaysRemaining();
                payDayPM();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void trabaja() {
        if ("H".equals(studio)) {
            try {
                isWatchingStreams = false;
                HP.actualizarEstadoPM(estadoWork);
                Thread.sleep(workInterval); // 30 minutos en milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                isWatchingStreams = false;
                MSI.actualizarEstadoPM(estadoWork);
                Thread.sleep(workInterval); // 30 minutos en milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void veStreams() {
        if ("H".equals(studio)) {
            try {
                isWatchingStreams = true;
                HP.actualizarEstadoPM(estadoStreams);
                Thread.sleep(streamInterval); // 30 minutos en milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                isWatchingStreams = true;
                MSI.actualizarEstadoPM(estadoStreams);
                Thread.sleep(streamInterval); // 30 minutos en milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void changeDaysRemaining() {
        try {
            if ("H".equals(studio)) {
                // Cambia el contador de días restantes
                diasRestantesEntregaPCs.acquire(1);
            diasRestantesEntregaPCs.release(HPCompany.diasRestantesH);
                currentTime = 0;
            } else {
                // Cambia el contador de días restantes
                diasRestantesEntregaPCs.acquire(1);
            diasRestantesEntregaPCs.release(MSICompany.diasRestantesM);
                currentTime = 0;
            }
            // Simula el tiempo que lleva cambiar el contador
            Thread.sleep(100); // Tiempo despreciable
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void payDayPM() {
        // Calcular el salario basado en las horas trabajadas y agregarlo al total de pago
        int horasTrabajadas = 24;
        int salario = sueldoPorHora * horasTrabajadas;
        if ("H".equals(studio)) {
            HPCompany.totalPayH += salario;
        } else {
            // Pago de nintendo
            MSICompany.totalPayM += salario;
        }
    }
}
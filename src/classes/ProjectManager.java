package classes;

import interfaces.Dashboard;
import interfaces.MSI;
import interfaces.HP;
import java.util.concurrent.Semaphore;

public class ProjectManager extends Thread {

    Semaphore diasRestantesEntregaPCs;
    int totalPay;
    public static boolean isWatchingStreams;
    int sueldoPorHora;
    String company;

    // Tiempos basados en que 1 dia de trabajo (24 horas) son 1000 milisegundos.
    int currentTime = 0;
    int streamInterval = 21*Dashboard.duracionDias; // 30 minutos en milisegundos
    int workInterval = 21*Dashboard.duracionDias;   // 30 minutos en milisegundos
    int totalWorkTime = 666*Dashboard.duracionDias; // 16 horas en milisegundos 
    int totalDayTime = 1000*Dashboard.duracionDias;  // 24 horas en milisegundos

    // Estados PM
    String estadoWork = "Trabajando";
    String estadoStreams = "Viendo streams";

    public ProjectManager(Semaphore diasRestantesEntregaPCs, String company) {
        this.diasRestantesEntregaPCs = diasRestantesEntregaPCs;
        this.totalPay = 0;
        this.isWatchingStreams = false;
        this.sueldoPorHora = 40;  // Cambié el sueldo acorde al patrón del nuevo proyecto
        this.company = company;
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
                payDayPM(); // Pago correspondiente al PM
            } catch (InterruptedException ex) {
                System.out.println("Interrupción en ProjectManager");
            }
        }
    }

    public void trabaja() {
        try {
            if ("H".equals(company)) {
                 HP.actualizarEstadoPM(estadoWork);
                Thread.sleep(workInterval); // Trabajando en HP
            } else {
                MSI.actualizarEstadoPM(estadoWork);
                Thread.sleep(workInterval); // Trabajando en MSI
            }
        } catch (InterruptedException ex) {
            System.out.println("Interrupción durante el trabajo en ProjectManager");
        }
    }

    public void veStreams() {
        try {
            isWatchingStreams = true; // Indica que está viendo streams
            if ("H".equals(company)) {
                 HP.actualizarEstadoPM(estadoStreams);
                Thread.sleep(streamInterval); // Viendo streams en HP
            } else {
                MSI.actualizarEstadoPM(estadoStreams);
                Thread.sleep(streamInterval); // Viendo streams en MSI
            }
            isWatchingStreams = false; // Termina de ver streams
        } catch (InterruptedException ex) {
            System.out.println("Interrupción durante los streams en ProjectManager");
        }
    }

    public void changeDaysRemaining() {
        if ("H".equals(company)) {
            // Resetear días restantes en HP
            diasRestantesEntregaPCs.release(HPCompany.diasRestantesH);
        } else {
            // Resetear días restantes en MSI
            diasRestantesEntregaPCs.release(MSICompany.diasRestantesM);
        }
    }

    public void payDayPM() {
        int horasTrabajadas = 24; // Asumimos que trabaja 24 horas en el día
        int salario = sueldoPorHora * horasTrabajadas;
        if ("H".equals(company)) {
            // Pago correspondiente en HP
             HPCompany.totalPayH += salario;
        } else {
            // Pago correspondiente en MSI
            MSICompany.totalPayM += salario;
        }
    }
}
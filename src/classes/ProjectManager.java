package classes;

import interfaces.Dashboard;
import interfaces.MSI;
import interfaces.HP;
import java.util.concurrent.Semaphore;

public class ProjectManager extends Thread {

    Semaphore diasRestantesEntregaPCs;
    int totalPay;
    public static boolean isWatchingAnime;
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
    String estadoAnime = "Viendo ánime";

    public ProjectManager(Semaphore diasRestantesEntregaPCs, String company) {
        this.diasRestantesEntregaPCs = diasRestantesEntregaPCs;
        this.totalPay = 0;
        this.isWatchingAnime = false;
        this.sueldoPorHora = 40; 
        this.company = company;
    }

    @Override
    public void run() {

        while (true) {
            try {
                while (currentTime < totalWorkTime) {
                    trabaja();
                    veAnime();
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

   
    private void trabaja() {
        if ("H".equals(company)) {
            try {
                isWatchingAnime = false;
                HP.actualizarEstadoPM(estadoWork);
                Thread.sleep(workInterval); // 30 minutos en milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                isWatchingAnime = false;
                MSI.actualizarEstadoPM(estadoWork);
                Thread.sleep(workInterval); // 30 minutos en milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void veAnime() {
        if ("H".equals(company)) {
            try {
                isWatchingAnime = true;
                MSI.actualizarEstadoPM(estadoAnime);
                Thread.sleep(streamInterval); // 30 minutos en milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                isWatchingAnime = true;
                MSI.actualizarEstadoPM(estadoAnime);
                Thread.sleep(streamInterval); // 30 minutos en milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void changeDaysRemaining() {
        try {
            if ("H".equals(company)) {
                // Cambia el contador de días restantes
                diasRestantesEntregaPCs.acquire(1);
                HP.actualizarDiasParaEntrega(diasRestantesEntregaPCs.availablePermits());
                currentTime = 0;
            } else {
                // Cambia el contador de días restantes
                diasRestantesEntregaPCs.acquire(1);
                MSI.actualizarDiasParaEntrega(diasRestantesEntregaPCs.availablePermits());
                currentTime = 0;
            }
            // Simula el tiempo que lleva cambiar el contador
            Thread.sleep(100); // Tiempo despreciable
        } catch (InterruptedException e) {
            e.printStackTrace();
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
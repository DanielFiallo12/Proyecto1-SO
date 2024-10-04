/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interfaces;
import javax.swing.JFrame;
/**
 *
 * @author adminccs
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Prueba");

        // Crear un JFrame
        JFrame frame = new JFrame("MSI Panel");

        // Establecer las configuraciones del JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600); // Establece el tamaño de la ventana

        // Crear una instancia del JPanel MSI
        MSI msiPanel = new MSI();

        // Agregar el JPanel al JFrame
        frame.add(msiPanel);

        // Hacer visible el JFrame
        frame.setVisible(true);
    }
    
}

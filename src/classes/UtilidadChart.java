package classes;
import interfaces.HP;
import interfaces.MSI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UtilidadChart extends JPanel {


    public static void main(String[] args) {
        JFrame frame = new JFrame("Gráfico Utilidad");
        JTabbedPane tabbedPane = new JTabbedPane();

        UtilidadChart chart = new UtilidadChart();
        tabbedPane.addTab("Gráfico Utilidad", chart);

        frame.add(tabbedPane);
        frame.setSize(430, 380);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
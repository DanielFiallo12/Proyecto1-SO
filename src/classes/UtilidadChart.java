package classes;

import interfaces.HP;
import interfaces.MSI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class UtilidadChart extends JPanel {
    
    private XYSeries seriesHP;
    private XYSeries seriesMSI;
    private int tiempo = 0;

    public UtilidadChart() {
        seriesHP = new XYSeries("HP");
        seriesHP.add(1.0, 0); // Inicializa con un valor de 0
        // Agrega más puntos de datos según tus necesidades

        seriesMSI = new XYSeries("MSI");
        seriesMSI.add(1.0, 0); // Inicializa con un valor de 0
        // Agrega más puntos de datos según tus necesidades

        final XYSeriesCollection dataset = new XYSeriesCollection(seriesHP);
        dataset.addSeries(seriesMSI);

        final JFreeChart chart = ChartFactory.createXYLineChart(
                "Utilidad con respecto al tiempo", // Título del gráfico
                "Tiempo", // Etiqueta del eje X
                "Utilidad", // Etiqueta del eje Y
                dataset, // Datos
                PlotOrientation.VERTICAL,
                true, // Incluye leyenda
                true, // Utiliza tooltips
                false // URLs no son utilizados
        );

        final Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tiempo++; // Incrementa el tiempo
                int gananciaHP = Integer.parseInt(HP.gananciaH.getText());
                int gananciaMSI = Integer.parseInt(MSI.gananciaM.getText());
                seriesHP.add(tiempo, gananciaHP); // Utiliza el valor de ganancia de HP
                seriesMSI.add(tiempo, gananciaMSI); // Utiliza el valor de ganancia de MSI
            }
        });
        timer.start(); // Inicia el temporizador

        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(430, 380));
        this.add(chartPanel);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gráfico utilidad");
        JTabbedPane tabbedPane = new JTabbedPane();

        UtilidadChart chart = new UtilidadChart();
        tabbedPane.addTab("Gráfico utilidad", chart);

        frame.add(tabbedPane);
        frame.setSize(430, 380);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
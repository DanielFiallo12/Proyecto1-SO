/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaces;

import classes.Director;
import classes.HPCompany;
import classes.ProjectManager;
import classes.Funciones;
import interfaces.HP;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;
import javax.swing.JFormattedTextField;

/**
 *
 * @author adminccs
 */
public class HP extends javax.swing.JPanel {

    private int valorSpinnerPlacasH;
    private int valorSpinnerCPUsH;
    private int valorSpinnerMemoriasH;
    private int valorSpinnerFuentesH;
    private int valorSpinnerTarjetasH;
    private int valorSpinnerEnsambladoresH;
    
    public final int totalProductores = 17;
    
    /**
     * Creates new form MSI
     */
    public HP() {
        
        initComponents();
        actualizarSpinnersDesdeDashboard();
        
        HP.diasParaEntrega.setText(Integer.toString(HPCompany.diasRestantesSem.availablePermits()));

        Director director = new Director(HPCompany.diasRestantesSem, "H");
        director.start();

        ProjectManager pm = new ProjectManager(HPCompany.diasRestantesSem, "H");
        pm.start();

        Funciones dia = new Funciones();
        dia.start();
        
        setSpinnerEditable(spinnerPlacasH, 1); // Mínimo 1
        setSpinnerEditable(spinnerCPUsH, 1);   // Mínimo 1
        setSpinnerEditable(spinnerMemoriasH, 1); // Mínimo 1
        setSpinnerEditable(spinnerFuentesH, 1); // Mínimo 1
        setSpinnerEditable(spinnerTarjetasH, 1); // Mínimo 1
        setSpinnerEditable(spinnerEnsambladoresH, 1); // Mínimo 1
        
        // Código para el spinner de las placas base
        valorSpinnerPlacasH = (int) spinnerPlacasH.getValue();
        for (int i = 0; i < valorSpinnerPlacasH; i++) {
            // Llama a la función para crear un productor de placa
            HPCompany.crearProductorPlaca(HPCompany.almacenPlacasH, 0, 3, "H", true);  //MODIFICAR VALORES (LISTOOOO)
        }

        spinnerPlacasH.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // Obtenemos el nuevo valor del JSpinner
                int nuevoValorSpinnerPlacas = (int) spinnerPlacasH.getValue();
                if (validarProductoresRestantes(nuevoValorSpinnerPlacas, valorSpinnerPlacasH)) {
                    // Compara el nuevo valor del JSpinner con valorSpinnerPlacasH
                    if (nuevoValorSpinnerPlacas > valorSpinnerPlacasH) {
                        // función: Crear productor de placa
                        // Se llama a la función para crear un productor de placa
                        HPCompany.crearProductorPlaca(HPCompany.almacenPlacasH, 0, 3, "H", true);
                    } else if (nuevoValorSpinnerPlacas < valorSpinnerPlacasH){
                        // función: Detener productor de placa
                        HPCompany.stopProductorPlacaAleatorio();
                    }
                    valorSpinnerPlacasH = nuevoValorSpinnerPlacas;
                } else {
                    spinnerPlacasH.setValue(valorSpinnerPlacasH);
                }
                actualizarProductoresRestantes();
                bloquearSpinnersSiNoHayProductoresRestantes();
            }
                // Actualiza valorSpinner con el nuevo valor del JSpinner
        });
                
        // Código para el spinner de los CPUs       
        // Obtenemos el valor inicial del JSpinner
        valorSpinnerCPUsH = (int) spinnerCPUsH.getValue();
        for (int i = 0; i < valorSpinnerCPUsH; i++) {
        // Llama a la función para crear un productor de CPU
            HPCompany.crearProductorCPU(HPCompany.almacenCPUsH, 0, 3, "H", true); // (LISTOOOO Los valores)
        }

        // Agrega un ChangeListener al JSpinner
        spinnerCPUsH.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // Obtenemos el nuevo valor del JSpinner
                int nuevoValorSpinnerCPUs = (int) spinnerCPUsH.getValue();
                if (validarProductoresRestantes(nuevoValorSpinnerCPUs, valorSpinnerCPUsH)) {
                    // Compara el nuevo valor del JSpinner con valorSpinnerCPUsH
                    if (nuevoValorSpinnerCPUs > valorSpinnerCPUsH) {
                        // función: Crear productor de CPU
                        // Se llama a la función para crear un productor de CPU
                        HPCompany.crearProductorCPU(HPCompany.almacenCPUsH, 0, 3, "H", true);
                    } else if (nuevoValorSpinnerCPUs < valorSpinnerCPUsH){
                        // función: Detener productor de CPU
                        HPCompany.stopProductorCPUAleatorio();
                    }
                    valorSpinnerCPUsH = nuevoValorSpinnerCPUs;
                } else {
                    spinnerCPUsH.setValue(valorSpinnerCPUsH);
                }
                actualizarProductoresRestantes();
                bloquearSpinnersSiNoHayProductoresRestantes();
            }
                // Actualiza valorSpinner con el nuevo valor del JSpinner
        });
        
        // Código para el spinner de las memorias       
        // Obtenemos el valor inicial del JSpinner
        valorSpinnerMemoriasH = (int) spinnerMemoriasH.getValue();
        for (int i = 0; i < valorSpinnerMemoriasH; i++) {
            // Se llama a la función para crear un productor de memoria
            HPCompany.crearProductorMemoria(HPCompany.almacenMemoriasH, 0, 1, "H", true); // (LISTOOOO Los valores)
        }     

        // Agrega un ChangeListener al JSpinner
        spinnerMemoriasH.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // Obtén el nuevo valor del JSpinner
                int nuevoValorSpinnerMemorias = (int) spinnerMemoriasH.getValue();
                if (validarProductoresRestantes(nuevoValorSpinnerMemorias, valorSpinnerMemoriasH)) {
                    // Compara el nuevo valor del JSpinner con valorSpinnerMemoriasH
                    if (nuevoValorSpinnerMemorias > valorSpinnerMemoriasH) {
                        // función: Crear productor de memoria
                        // Se llama a la función para crear un productor de memoria
                        HPCompany.crearProductorMemoria(HPCompany.almacenMemoriasH, 0, 1, "H", true);
                    } else if (nuevoValorSpinnerMemorias < valorSpinnerMemoriasH){
                        // función: Detener productor de memoria
                        HPCompany.stopProductorMemoriaAleatorio();
                    }
                    valorSpinnerMemoriasH = nuevoValorSpinnerMemorias;
                } else {
                    spinnerMemoriasH.setValue(valorSpinnerMemoriasH);
                }
                actualizarProductoresRestantes();
                bloquearSpinnersSiNoHayProductoresRestantes();
            }
                // Actualiza valorSpinner con el nuevo valor del JSpinner
        });
        
        // Código para el spinner de las fuentes       
        // Obtenemos el valor inicial del JSpinner
        valorSpinnerFuentesH = (int) spinnerFuentesH.getValue();        
        for (int i = 0; i < valorSpinnerFuentesH; i++) {
            // Se llama a la función para crear un productor de fuente
            HPCompany.crearProductorFuente(HPCompany.almacenFuentesH, 1, 0, "H", true); // (LISTOOOO Los valores)
        }

        spinnerFuentesH.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                int nuevoValorSpinnerFuentes = (int) spinnerFuentesH.getValue();
                if (validarProductoresRestantes(nuevoValorSpinnerFuentes, valorSpinnerFuentesH)) {
                    // Compara el nuevo valor del JSpinner con valorSpinnerFuentesH
                    if (nuevoValorSpinnerFuentes > valorSpinnerFuentesH) {
                        // función: Crear productor de fuente
                        // Se llama a la función para crear un productor de fuente
                        HPCompany.crearProductorFuente(HPCompany.almacenFuentesH, 1, 0, "H", true);
                    } else if (nuevoValorSpinnerFuentes < valorSpinnerFuentesH){
                        // función: Detener productor de fuente
                        HPCompany.stopProductorFuenteAleatorio();
                    }
                    valorSpinnerFuentesH = nuevoValorSpinnerFuentes;
                } else {
                    spinnerFuentesH.setValue(valorSpinnerFuentesH);
                }
                actualizarProductoresRestantes();
                bloquearSpinnersSiNoHayProductoresRestantes();
            }
                // Actualiza valorSpinner con el nuevo valor del JSpinner
        });
        
        // Código para el spinner de las tarjetas       
        // Obtenemos el valor inicial del JSpinner
        valorSpinnerTarjetasH = (int) spinnerTarjetasH.getValue();   
        for (int i = 0; i < valorSpinnerTarjetasH; i++) {
            // Se llama a la función para crear un productor de tarjeta
            HPCompany.crearProductorTarjeta(HPCompany.almacenTarjetasH, 2, 0, "H", true); // (LISTOOOO Los valores)
        }

        spinnerTarjetasH.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                int nuevoValorSpinnerTarjetas = (int) spinnerTarjetasH.getValue();
                if (validarProductoresRestantes(nuevoValorSpinnerTarjetas, valorSpinnerTarjetasH)) {
                    // Compara el nuevo valor del JSpinner con valorSpinnerTarjetasH
                    if (nuevoValorSpinnerTarjetas > valorSpinnerTarjetasH) {
                        // función: Crear productor de tarjeta
                        // Se llama a la función para crear un productor de tarjeta
                        HPCompany.crearProductorTarjeta(HPCompany.almacenTarjetasH, 2, 0, "H", true);
                    } else if (nuevoValorSpinnerTarjetas < valorSpinnerTarjetasH){
                        // función: Detener productor de tarjeta
                        HPCompany.stopProductorTarjetaAleatorio();
                    }
                    valorSpinnerTarjetasH = nuevoValorSpinnerTarjetas;
                } else {
                    spinnerTarjetasH.setValue(valorSpinnerTarjetasH);
                }
                actualizarProductoresRestantes();
                bloquearSpinnersSiNoHayProductoresRestantes();
            }
                // Actualiza valorSpinner con el nuevo valor del JSpinner
        });
        
        // Código para el spinner de los ensambladores       
        // Obtenemos el valor inicial del JSpinner
        valorSpinnerEnsambladoresH = (int) spinnerEnsambladoresH.getValue();
        for (int i = 0; i < valorSpinnerEnsambladoresH; i++) {
            // Se llama a la función para crear un ensamblador
            HPCompany.crearEnsamblador(HPCompany.almacenPCsH, HPCompany.almacenPlacasH, HPCompany.almacenCPUsH, HPCompany.almacenMemoriasH, HPCompany.almacenFuentesH, HPCompany.almacenTarjetasH, HPCompany.pcsGeneradosH, HPCompany.pcsTGGeneradosH, 2, 1, 1, 2, 4, 3, "H", true);
        }

        spinnerEnsambladoresH.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                int nuevoValorspinnerEnsambladores = (int) spinnerEnsambladoresH.getValue();
                if (validarProductoresRestantes(nuevoValorspinnerEnsambladores, valorSpinnerEnsambladoresH)) {
                    if (nuevoValorspinnerEnsambladores > valorSpinnerEnsambladoresH) {
                        // función: Crear ensamblador
                        // Se llama a la función para crear un ensamblador
                        HPCompany.crearEnsamblador(HPCompany.almacenPCsH, HPCompany.almacenPlacasH, HPCompany.almacenCPUsH, HPCompany.almacenMemoriasH, HPCompany.almacenFuentesH, HPCompany.almacenTarjetasH, HPCompany.pcsGeneradosH, HPCompany.pcsTGGeneradosH, 2, 2, 3, 4, 6, 5, "H", true);
                        } else if (nuevoValorspinnerEnsambladores < valorSpinnerEnsambladoresH) { 
                        // función: Detener ensamblador
                        HPCompany.stopEnsambladorAleatorio();
                    }
                    valorSpinnerEnsambladoresH = nuevoValorspinnerEnsambladores;
                } else {
                    spinnerEnsambladoresH.setValue(valorSpinnerEnsambladoresH);
                }
                actualizarProductoresRestantes();
                bloquearSpinnersSiNoHayProductoresRestantes();
            }
            });
            /*Dashboard.generarGrafico (); //Genera el gráfico de utilidad*/
    }
    
    public void actualizarSpinnersDesdeDashboard() {
        spinnerPlacasH.setValue(Dashboard.placasH);
        spinnerCPUsH.setValue(Dashboard.CPUsH);
        spinnerMemoriasH.setValue(Dashboard.memoriasH);
        spinnerFuentesH.setValue(Dashboard.fuentesH);
        spinnerTarjetasH.setValue(Dashboard.tarjetasH);
        spinnerEnsambladoresH.setValue(Dashboard.ensambladoresH);  
        
        int productoresAsignadosH = (int) spinnerPlacasH.getValue() + (int) spinnerCPUsH.getValue() + (int) spinnerMemoriasH.getValue() + (int) spinnerFuentesH.getValue() + (int) spinnerTarjetasH.getValue() + (int) spinnerEnsambladoresH.getValue();
        int productoresRestantes = totalProductores - productoresAsignadosH;
        productoresRestantesH.setText(Integer.toString(productoresRestantes));
    }
    
    private void setSpinnerEditable(JSpinner spinner, int minValue) {
    // Crea un modelo de número con el valor actual del spinner y el mínimo deseado
    SpinnerNumberModel model = new SpinnerNumberModel((int) spinner.getValue(), minValue, null, 1);
    spinner.setModel(model);
    
    // Agrega un ChangeListener para manejar cambios en el valor
    spinner.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            int currentValue = (int) spinner.getValue();
            if (currentValue < minValue) {
                // Si el valor es menor que el mínimo, restablecer al mínimo
                spinner.setValue(minValue);
            }
        }
    });
}
    
    private void actualizarProductoresRestantes() {
        int productoresAsignadosH = valorSpinnerPlacasH + valorSpinnerCPUsH + valorSpinnerMemoriasH + valorSpinnerFuentesH + valorSpinnerTarjetasH + valorSpinnerEnsambladoresH;
        int productoresRestantes = totalProductores - productoresAsignadosH;
        productoresRestantesH.setText(Integer.toString(productoresRestantes));
    }

    private boolean validarProductoresRestantes(int nuevoValor, int valorActual) {
        int productoresAsignadosH = valorSpinnerPlacasH + valorSpinnerCPUsH + valorSpinnerMemoriasH + valorSpinnerFuentesH + valorSpinnerTarjetasH + valorSpinnerEnsambladoresH;
        int productoresRestantes = totalProductores - productoresAsignadosH;
        return productoresRestantes >= (nuevoValor - valorActual);
    }
         
    public void bloquearSpinnersSiNoHayProductoresRestantes() {
        int productoresRestantes = Integer.parseInt(productoresRestantesH.getText());

        Color colorHabilitado = Color.WHITE; // Color normal cuando hay productores restantes
        Color colorDeshabilitado = Color.LIGHT_GRAY; // Color simulado para bloqueo

        if (productoresRestantes <= 0) {
            // Cambia el color de fondo a gris si no hay productores restantes
            spinnerPlacasH.getEditor().getComponent(0).setBackground(colorDeshabilitado);
            spinnerCPUsH.getEditor().getComponent(0).setBackground(colorDeshabilitado);
            spinnerMemoriasH.getEditor().getComponent(0).setBackground(colorDeshabilitado);
            spinnerFuentesH.getEditor().getComponent(0).setBackground(colorDeshabilitado);
            spinnerTarjetasH.getEditor().getComponent(0).setBackground(colorDeshabilitado);
            spinnerEnsambladoresH.getEditor().getComponent(0).setBackground(colorDeshabilitado);
        } else {
            // Cambia el color de fondo a blanco si hay productores restantes
            spinnerPlacasH.getEditor().getComponent(0).setBackground(colorHabilitado);
            spinnerCPUsH.getEditor().getComponent(0).setBackground(colorHabilitado);
            spinnerMemoriasH.getEditor().getComponent(0).setBackground(colorHabilitado);
            spinnerFuentesH.getEditor().getComponent(0).setBackground(colorHabilitado);
            spinnerTarjetasH.getEditor().getComponent(0).setBackground(colorHabilitado);
            spinnerEnsambladoresH.getEditor().getComponent(0).setBackground(colorHabilitado);
        }}
    
    public static void actualizarPlacasAlmacen(int nuevoValor) {
        placasAlmacenH.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarCPUsAlmacen(int nuevoValor) {
        CPUsAlmacenH.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarMemoriasAlmacen(int nuevoValor) {
        memoriasAlmacenH.setText(Integer.toString(nuevoValor));
    }

    // Desarrollador Logica
    public static void actualizarFuentesAlmacen(int nuevoValor) {
        fuentesAlmacenH.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarTarjetasAlmacen(int nuevoValor) {
        tarjetasAlmacenH.setText(Integer.toString(nuevoValor));
    }
    
    private void SetImageLabel (JLabel labelName, String root){
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(
                image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel22 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        computadorasTotalesH = new javax.swing.JLabel();
        computadorasTarjetaTotalesH = new javax.swing.JLabel();
        ganaciasTotalesH = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        computadorasTarjetaListasH = new javax.swing.JLabel();
        computadorasListasH = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        spinnerPlacasH = new javax.swing.JSpinner();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        spinnerCPUsH = new javax.swing.JSpinner();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        spinnerMemoriasH = new javax.swing.JSpinner();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        spinnerFuentesH = new javax.swing.JSpinner();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        spinnerTarjetasH = new javax.swing.JSpinner();
        jPanel9 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        spinnerEnsambladoresH = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        productoresRestantesH = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        costosOperativosH = new javax.swing.JLabel();
        ingresosBrutosH = new javax.swing.JLabel();
        gananciaH = new javax.swing.JLabel();
        estadoPM = new javax.swing.JLabel();
        estadoDirector = new javax.swing.JLabel();
        descontadoPM = new javax.swing.JLabel();
        faltasPM = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        diasParaEntrega = new javax.swing.JLabel();
        dias = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        placasAlmacenH = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        CPUsAlmacenH = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        memoriasAlmacenH = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        fuentesAlmacenH = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        tarjetasAlmacenH = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel22.setBackground(new java.awt.Color(34, 46, 60));
        jPanel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Computadoras estándar totales:");

        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Computadoras c / tarjetas gráficas totales:");

        jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("Ganancias");

        computadorasTotalesH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        computadorasTotalesH.setForeground(new java.awt.Color(255, 255, 255));
        computadorasTotalesH.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        computadorasTotalesH.setText("0");

        computadorasTarjetaTotalesH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        computadorasTarjetaTotalesH.setForeground(new java.awt.Color(255, 255, 255));
        computadorasTarjetaTotalesH.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        computadorasTarjetaTotalesH.setText("0");

        ganaciasTotalesH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ganaciasTotalesH.setForeground(new java.awt.Color(255, 255, 255));
        ganaciasTotalesH.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        ganaciasTotalesH.setText("0");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel59)
                    .addComponent(jLabel60)
                    .addComponent(jLabel61))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ganaciasTotalesH, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(computadorasTotalesH, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(computadorasTarjetaTotalesH, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(computadorasTotalesH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(computadorasTarjetaTotalesH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(ganaciasTotalesH))
                .addContainerGap())
        );

        add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 440, 380, -1));

        jPanel17.setBackground(new java.awt.Color(34, 46, 60));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Computadoras estándar:");

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Computadoras c / tarjetas gráficas:");

        computadorasTarjetaListasH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        computadorasTarjetaListasH.setForeground(new java.awt.Color(255, 255, 255));
        computadorasTarjetaListasH.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        computadorasTarjetaListasH.setText("0");

        computadorasListasH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        computadorasListasH.setForeground(new java.awt.Color(255, 255, 255));
        computadorasListasH.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        computadorasListasH.setText("0");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addGap(85, 85, 85)
                        .addComponent(computadorasListasH, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addGap(18, 18, 18)
                        .addComponent(computadorasTarjetaListasH, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)))
                .addGap(23, 23, 23))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(computadorasListasH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(computadorasTarjetaListasH))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, 381, -1));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 5, true));
        jPanel2.setMaximumSize(new java.awt.Dimension(308, 376));
        jPanel2.setMinimumSize(new java.awt.Dimension(308, 376));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONFIGURACIÓN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TRABAJADORES");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Productores de placas base:");

        spinnerPlacasH.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        spinnerPlacasH.setValue(1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spinnerPlacasH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerPlacasH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Productores de CPUs:");

        spinnerCPUsH.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));
        spinnerCPUsH.setValue(1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spinnerCPUsH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(spinnerCPUsH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Productores de memorias RAM:");

        spinnerMemoriasH.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spinnerMemoriasH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(spinnerMemoriasH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Productores de fuentes de poder:");

        spinnerFuentesH.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(spinnerFuentesH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(spinnerFuentesH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Productores de tarjetas gráficas:");

        spinnerTarjetasH.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spinnerTarjetasH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(spinnerTarjetasH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel9.setMaximumSize(new java.awt.Dimension(176, 39));
        jPanel9.setMinimumSize(new java.awt.Dimension(176, 39));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Ensambladores");

        spinnerEnsambladoresH.setModel(new javax.swing.SpinnerNumberModel(1, 1, 11, 1));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spinnerEnsambladoresH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spinnerEnsambladoresH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("TRABAJADORES RESTANTES:");

        productoresRestantesH.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        productoresRestantesH.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productoresRestantesH, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productoresRestantesH, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap())
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, 400));

        jPanel16.setBackground(new java.awt.Color(34, 46, 60));
        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("COSTOS / GANANCIAS");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Costos operativos:");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Ingresos brutos:");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Ganancia:");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("DIRECTOR");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Estado:");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("PROJECT MANAGER");

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Estado:");

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Faltas:");

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Descontado ($):");

        costosOperativosH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        costosOperativosH.setForeground(new java.awt.Color(255, 255, 255));
        costosOperativosH.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        costosOperativosH.setText("0");

        ingresosBrutosH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ingresosBrutosH.setForeground(new java.awt.Color(255, 255, 255));
        ingresosBrutosH.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        ingresosBrutosH.setText("0");

        gananciaH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        gananciaH.setForeground(new java.awt.Color(255, 255, 255));
        gananciaH.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        gananciaH.setText("0");

        estadoPM.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        estadoPM.setForeground(new java.awt.Color(255, 255, 255));
        estadoPM.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        estadoPM.setText("Por comenzar");

        estadoDirector.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        estadoDirector.setForeground(new java.awt.Color(255, 255, 255));
        estadoDirector.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        estadoDirector.setText("Por comenzar");

        descontadoPM.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        descontadoPM.setForeground(new java.awt.Color(255, 255, 255));
        descontadoPM.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        descontadoPM.setText("0");

        faltasPM.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        faltasPM.setForeground(new java.awt.Color(255, 255, 255));
        faltasPM.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        faltasPM.setText("0");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37)
                            .addComponent(jLabel41)
                            .addComponent(jLabel39)
                            .addComponent(jLabel38)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44)
                            .addComponent(jLabel45))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(costosOperativosH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ingresosBrutosH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(gananciaH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(estadoPM, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(estadoDirector, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(descontadoPM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(faltasPM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(23, 23, 23))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(costosOperativosH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(ingresosBrutosH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(gananciaH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(estadoDirector))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(estadoPM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(faltasPM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(descontadoPM))
                .addContainerGap())
        );

        add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 381, -1));

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255), 5));

        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel50.setText("Días transcurridos:");

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel51.setText("Días para entrega:");

        diasParaEntrega.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        diasParaEntrega.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        diasParaEntrega.setText("0");

        dias.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dias.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        dias.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51)
                    .addComponent(jLabel50))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dias, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diasParaEntrega, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dias))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diasParaEntrega)
                    .addComponent(jLabel51))
                .addGap(21, 21, 21))
        );

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 470, 230, 64));

        jLabel49.setBackground(new java.awt.Color(153, 51, 255));
        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("PRODUCCIÓN ACTUAL");
        add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 310, 380, 22));

        jLabel46.setBackground(new java.awt.Color(153, 51, 255));
        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("LOTE DE PRODUCCIÓN");
        add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 412, 380, 20));

        jPanel10.setBackground(new java.awt.Color(153, 204, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255), 5));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("CAPACIDAD");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("ALMACÉN");
        jLabel20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setText("Placas base:");

        placasAlmacenH.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        placasAlmacenH.setText("0");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel32.setText("/ 25");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addGap(55, 55, 55)
                .addComponent(placasAlmacenH)
                .addGap(18, 18, 18)
                .addComponent(jLabel32)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(placasAlmacenH)
                    .addComponent(jLabel32))
                .addContainerGap())
        );

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setText("CPUs:");

        CPUsAlmacenH.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        CPUsAlmacenH.setText("0");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel33.setText("/ 20");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(CPUsAlmacenH)
                .addGap(18, 18, 18)
                .addComponent(jLabel33)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(CPUsAlmacenH)
                    .addComponent(jLabel33))
                .addContainerGap())
        );

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setText("Memorias RAM:");

        memoriasAlmacenH.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        memoriasAlmacenH.setText("0");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel34.setText("/ 55");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addGap(34, 34, 34)
                .addComponent(memoriasAlmacenH)
                .addGap(18, 18, 18)
                .addComponent(jLabel34)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(memoriasAlmacenH)
                    .addComponent(jLabel34))
                .addContainerGap())
        );

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setText("Fuentes de poder:");

        fuentesAlmacenH.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        fuentesAlmacenH.setText("0");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel35.setText("/ 35");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addGap(22, 22, 22)
                .addComponent(fuentesAlmacenH)
                .addGap(18, 18, 18)
                .addComponent(jLabel35)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(fuentesAlmacenH)
                    .addComponent(jLabel35))
                .addContainerGap())
        );

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel29.setText("Tarjetas gráficas:");

        tarjetasAlmacenH.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tarjetasAlmacenH.setText("0");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel36.setText("/ 10");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addGap(26, 26, 26)
                .addComponent(tarjetasAlmacenH)
                .addGap(18, 18, 18)
                .addComponent(jLabel36)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(tarjetasAlmacenH)
                    .addComponent(jLabel36))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 229, 280));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/hp-logo-png-photo.png"))); // NOI18N
        jLabel8.setMaximumSize(new java.awt.Dimension(413, 409));
        jLabel8.setMinimumSize(new java.awt.Dimension(413, 409));
        jLabel8.setPreferredSize(new java.awt.Dimension(413, 409));
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1020, 940));
    }// </editor-fold>//GEN-END:initComponents

    public static JLabel getComputadorasTarjetaListasH() {
        return computadorasTarjetaListasH;
    }

    public static void setComputadorasTarjetaListasH(JLabel computadorasTarjetaGeneradasH) {
        HP.computadorasTarjetaListasH = computadorasTarjetaGeneradasH;
    }

    public static JLabel getComputadorasListasH() {
        return computadorasListasH;
    }

    public static void getComputadorasListasH(JLabel computadorasGeneradasH) {
        HP.computadorasListasH = computadorasGeneradasH;
    }

    public static void actualizarComputadorasListas(int nuevoValor) {
        computadorasListasH.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarComputadorasTarjetaListas(int nuevoValor) {
        computadorasTarjetaListasH.setText(Integer.toString(nuevoValor));
    }

    public static JLabel getComputadorasTotalesH() {
        return computadorasTotalesH;
    }

    public static void setComputadorasTotalesH(JLabel computadorasTotalesH) {
        HP.computadorasTotalesH = computadorasTotalesH;
    }
    
    public static JLabel getComputadorasTarjetaTotalesH() {
        return computadorasTarjetaTotalesH;
    }

    public static void setComputadorasTarjetaTotalesH(JLabel computadorasTarjetaTotalesH) {
        HP.computadorasTarjetaTotalesH = computadorasTarjetaTotalesH;
    }

    public static void actualizarComputadorasListasTotalesH(int nuevoValor) {
        computadorasTotalesH.setText(Integer.toString(nuevoValor));
    }
    
    public static void actualizarComputadorasTarjetaListasTotalesH(int nuevoValor) {
        computadorasTarjetaTotalesH.setText(Integer.toString(nuevoValor));
    }

    public static JLabel getPlacasAlmacenM() {
        return placasAlmacenH;
    }

    public static void setPlacasAlmacenM(JLabel placasAlmacenM) {
        HP.placasAlmacenH = placasAlmacenM;
    }

    public static JLabel getCPUsAlmacenM() {
        return CPUsAlmacenH;
    }

    public static void setCPUsAlmacenM(JLabel CPUsAlmacenM) {
        HP.CPUsAlmacenH = CPUsAlmacenM;
    }

    public static JLabel getMemoriasAlmacenM() {
        return memoriasAlmacenH;
    }

    public static void setMemoriasAlmacenM(JLabel memoriasAlmacenM) {
        HP.memoriasAlmacenH = memoriasAlmacenM;
    }

    public static JLabel getFuentesAlmacenM() {
        return fuentesAlmacenH;
    }

    public static void setFuentesAlmacenM(JLabel fuentesAlmacenM) {
        HP.fuentesAlmacenH = fuentesAlmacenM;
    }

    public static JLabel getTarjetasAlmacenM() {
        return tarjetasAlmacenH;
    }

    public static void setTarjetasAlmacenM(JLabel tarjetasAlmacenM) {
        HP.tarjetasAlmacenH = tarjetasAlmacenM;
    }

    public static JLabel getCostosOperativosH() {
        return costosOperativosH;
    }

    public static void setCostosOperativosH(JLabel costosOperativosH) {
        HP.costosOperativosH = costosOperativosH;
    }

    public static JLabel getEstadoPM() {
        return estadoPM;
    }

    public static void setEstadoPM(JLabel estadoPM) {
        HP.estadoPM = estadoPM;
    }

    public static void actualizarEstadoPM(String estado) {
        estadoPM.setText(estado);
    }
    
    public static JLabel getEstadoDirector() {
        return estadoDirector;
    }
     
    public static void setEstadoDirector(JLabel estadoDirector) {
        HP.estadoDirector = estadoDirector;
    }

    public static void actualizarEstadoDirector(String estado) {
        estadoDirector.setText(estado);
    }
    
    public static JLabel getDiasParaEntrega() {
        return diasParaEntrega;
    }

    public static void setDiasParaEntrega(JLabel diasParaEntrega) {
        HP.diasParaEntrega = diasParaEntrega;
    }

    public static void actualizarDiasParaEntrega(int nuevoValor) {
        diasParaEntrega.setText(Integer.toString(nuevoValor));
    }

    public static JLabel getDescontadoPM() {
        return descontadoPM;
    }

    public static void setDescontadoPM(JLabel descontadoPM) {
        HP.descontadoPM = descontadoPM;
    }

    public static JLabel getFaltasPM() {
        return faltasPM;
    }

    public static void setFaltasPM(JLabel faltasPM) {
        HP.faltasPM = faltasPM;
    }

    public static JLabel getGanancia() {
        return gananciaH;
    }
    
    public static void setGanancia(JLabel gananciaH) {
        HP.gananciaH = gananciaH;
    }
    
    public static JLabel getGananciasTotales() {
        return ganaciasTotalesH;
    }
    
    public static void setGananciasTotales(JLabel ganaciasTotalesH) {
        HP.ganaciasTotalesH = ganaciasTotalesH;
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel CPUsAlmacenH;
    public static javax.swing.JLabel computadorasListasH;
    public static javax.swing.JLabel computadorasTarjetaListasH;
    public static javax.swing.JLabel computadorasTarjetaTotalesH;
    public static javax.swing.JLabel computadorasTotalesH;
    public static javax.swing.JLabel costosOperativosH;
    public static javax.swing.JLabel descontadoPM;
    public static javax.swing.JLabel dias;
    public static javax.swing.JLabel diasParaEntrega;
    public static javax.swing.JLabel estadoDirector;
    public static javax.swing.JLabel estadoPM;
    public static javax.swing.JLabel faltasPM;
    public static javax.swing.JLabel fuentesAlmacenH;
    public static javax.swing.JLabel ganaciasTotalesH;
    public static javax.swing.JLabel gananciaH;
    public static javax.swing.JLabel ingresosBrutosH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public static javax.swing.JLabel memoriasAlmacenH;
    public static javax.swing.JLabel placasAlmacenH;
    public static javax.swing.JLabel productoresRestantesH;
    public static javax.swing.JSpinner spinnerCPUsH;
    public static javax.swing.JSpinner spinnerEnsambladoresH;
    public static javax.swing.JSpinner spinnerFuentesH;
    public static javax.swing.JSpinner spinnerMemoriasH;
    public static javax.swing.JSpinner spinnerPlacasH;
    public static javax.swing.JSpinner spinnerTarjetasH;
    public static javax.swing.JLabel tarjetasAlmacenH;
    // End of variables declaration//GEN-END:variables
}

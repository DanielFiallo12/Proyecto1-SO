/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaces;

import classes.Director;
import classes.MSICompany;
import interfaces.MSI;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author adminccs
 */
public class MSI extends javax.swing.JPanel {

    private int valorSpinnerPlacasM;
    private int valorSpinnerCPUsM;
    private int valorSpinnerMemoriasM;
    private int valorSpinnerFuentesM;
    private int valorSpinnerTarjetasM;
    private int valorSpinnerEnsambladoresM;
    
    /**
     * Creates new form MSI
     */
    public MSI() {
        
        initComponents();
        
        MSI.diasParaEntrega.setText(Integer.toString(MSICompany.diasRestantesSem.availablePermits()));

        Director director = new Director(MSICompany.diasRestantesSem, "M");
        director.start();

        // Código para el spinner de las placas base
        valorSpinnerPlacasM = (int) spinnerPlacasM.getValue();
        if (valorSpinnerPlacasM == 1) {
            // Llama a la función para crear un productor de placa
            MSICompany.crearProductorPlaca(MSICompany.almacenPlacasM, 0, 4, "M", true);  //MODIFICAR VALORES (LISTOOOO)
        }

        spinnerPlacasM.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int nuevoValorSpinnerPlacas = (int) spinnerPlacasM.getValue();
                int productoresRestantes = Integer.parseInt(productoresRestantesM.getText());
                if (nuevoValorSpinnerPlacas > valorSpinnerPlacasM) {
                    if (productoresRestantes > 0) {
                        // función: Crear productor de placa base
                        // Se llama a la función para crear un productor de placa base
                        MSICompany.crearProductorPlaca(MSICompany.almacenPlacasM, 0, 4, "M", true);   //MODIFICAR VALORES (LISTOOOO)
                        // Restamos 1 a productoresRestantesM si el nuevo valor es mayor
                        int valorActual = Integer.parseInt(productoresRestantesM.getText());
                        valorActual--;
                        productoresRestantesM.setText(Integer.toString(valorActual));
                        valorSpinnerPlacasM = nuevoValorSpinnerPlacas;
                    } else {
                        spinnerPlacasM.setValue(valorSpinnerPlacasM);
                    }
                } else if (nuevoValorSpinnerPlacas < valorSpinnerPlacasM) {
                    // función: Detener productor de placa base
                    MSICompany.stopProductorPlacaAleatorio();
                    // Sumamos 1 a productoresRestantesM si el nuevo valor es menor
                    int valorActual = Integer.parseInt(productoresRestantesM.getText());
                    valorActual++;
                    productoresRestantesM.setText(Integer.toString(valorActual));
                    valorSpinnerPlacasM = nuevoValorSpinnerPlacas;
                }

                // Actualiza valorSpinner con el nuevo valor del JSpinner
            }
        });
        
        // Código para el spinner de los CPUs       
        // Obtenemos el valor inicial del JSpinner
        valorSpinnerCPUsM = (int) spinnerCPUsM.getValue();
        if (valorSpinnerCPUsM == 1) {
            // Llama a la función para crear un productor de CPU
            MSICompany.crearProductorCPU(MSICompany.almacenCPUsM, 0, 4, "M", true); // (LISTOOOO Los valores)
        }

        // Agrega un ChangeListener al JSpinner
        spinnerCPUsM.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // Obtenemos el nuevo valor del JSpinner
                int nuevoValorSpinnerCPUs = (int) spinnerCPUsM.getValue();
                int productoresRestantes = Integer.parseInt(productoresRestantesM.getText());
                // Compara el nuevo valor del JSpinner con valorSpinnerCPUsM
                if (nuevoValorSpinnerCPUs > valorSpinnerCPUsM) {
                    if (productoresRestantes > 0) {
                        // función: Crear productor de CPU
                        // Se llama a la función para crear un productor de CPU
                        MSICompany.crearProductorCPU(MSICompany.almacenCPUsM, 0, 4, "M", true); // (LISTOOOO Los valores)
                        // Restamos 1 a productoresRestantesM si el nuevo valor es mayor
                        int valorActual = Integer.parseInt(productoresRestantesM.getText());
                        valorActual--;
                        productoresRestantesM.setText(Integer.toString(valorActual));
                        valorSpinnerCPUsM = nuevoValorSpinnerCPUs;
                    } else {
                        spinnerCPUsM.setValue(valorSpinnerCPUsM);
                    }
                } else if (nuevoValorSpinnerCPUs < valorSpinnerCPUsM) {

                    // función: Detener productor de CPU
                    MSICompany.stopProductorCPUAleatorio();
                    // Sumamos 1 a productoresRestantesM si el nuevo valor es menor
                    int valorActual = Integer.parseInt(productoresRestantesM.getText());
                    valorActual++;
                    productoresRestantesM.setText(Integer.toString(valorActual));
                    valorSpinnerCPUsM = nuevoValorSpinnerCPUs;
                }

                // Actualiza valorSpinner con el nuevo valor del JSpinner
            }
        });
        

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
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        spinnerPlacasM = new javax.swing.JSpinner();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        spinnerCPUsM = new javax.swing.JSpinner();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        spinnerMemoriasM = new javax.swing.JSpinner();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        spinnerFuentesM = new javax.swing.JSpinner();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        spinnerTarjetasM = new javax.swing.JSpinner();
        jPanel9 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        spinnerEnsambladoresM = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        productoresRestantesM = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
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
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
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
        jLabel22 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();

        jPanel22.setBackground(new java.awt.Color(34, 46, 60));
        jPanel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Computadoras estándar:");

        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Computadoras c / tarjetas gráficas:");

        jTextField18.setBackground(new java.awt.Color(34, 46, 60));
        jTextField18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField18.setForeground(new java.awt.Color(255, 255, 255));
        jTextField18.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField18.setText("0");
        jTextField18.setBorder(null);
        jTextField18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField18ActionPerformed(evt);
            }
        });

        jTextField19.setBackground(new java.awt.Color(34, 46, 60));
        jTextField19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField19.setForeground(new java.awt.Color(255, 255, 255));
        jTextField19.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField19.setText("0");
        jTextField19.setBorder(null);
        jTextField19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField19ActionPerformed(evt);
            }
        });

        jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("Ganancias");

        jTextField20.setBackground(new java.awt.Color(34, 46, 60));
        jTextField20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField20.setForeground(new java.awt.Color(255, 255, 255));
        jTextField20.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField20.setText("0");
        jTextField20.setBorder(null);
        jTextField20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel61)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel59)
                            .addComponent(jLabel60))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61))
                .addContainerGap())
        );

        jPanel17.setBackground(new java.awt.Color(34, 46, 60));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Computadoras estándar:");

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Computadoras c / tarjetas gráficas:");

        jTextField8.setBackground(new java.awt.Color(34, 46, 60));
        jTextField8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(255, 255, 255));
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField8.setText("0");
        jTextField8.setBorder(null);
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jTextField9.setBackground(new java.awt.Color(34, 46, 60));
        jTextField9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(255, 255, 255));
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField9.setText("0");
        jTextField9.setBorder(null);
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 51, 51), 5, true));
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spinnerPlacasM, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spinnerPlacasM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Productores de CPUs:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spinnerCPUsM, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(spinnerCPUsM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Productores de memorias RAM:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spinnerMemoriasM, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(spinnerMemoriasM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Productores de fuentes de poder:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spinnerFuentesM, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(spinnerFuentesM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Productores de tarjetas gráficas:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spinnerTarjetasM)
                .addGap(14, 14, 14))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(spinnerTarjetasM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel9.setMaximumSize(new java.awt.Dimension(176, 39));
        jPanel9.setMinimumSize(new java.awt.Dimension(176, 39));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Ensambladores");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spinnerEnsambladoresM, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spinnerEnsambladoresM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("TRABAJADORES RESTANTES:");

        productoresRestantesM.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        productoresRestantesM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        productoresRestantesM.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(productoresRestantesM)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(productoresRestantesM))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/msi-logo.png"))); // NOI18N
        jLabel8.setText("jLabel8");
        jLabel8.setMaximumSize(new java.awt.Dimension(413, 409));
        jLabel8.setMinimumSize(new java.awt.Dimension(413, 409));
        jLabel8.setPreferredSize(new java.awt.Dimension(413, 409));

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

        jTextField1.setBackground(new java.awt.Color(34, 46, 60));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField1.setText("0");
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setBackground(new java.awt.Color(34, 46, 60));
        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField2.setText("0");
        jTextField2.setBorder(null);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setBackground(new java.awt.Color(34, 46, 60));
        jTextField3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField3.setText("0");
        jTextField3.setBorder(null);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.setBackground(new java.awt.Color(34, 46, 60));
        jTextField4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField4.setText("Por comenzar");
        jTextField4.setBorder(null);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.setBackground(new java.awt.Color(34, 46, 60));
        jTextField5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField5.setText("Por comenzar");
        jTextField5.setBorder(null);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTextField6.setBackground(new java.awt.Color(34, 46, 60));
        jTextField6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField6.setText("0");
        jTextField6.setBorder(null);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jTextField7.setBackground(new java.awt.Color(34, 46, 60));
        jTextField7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(255, 255, 255));
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField7.setText("0");
        jTextField7.setBorder(null);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 102, 102));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 5));

        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel50.setText("Días:");

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
                    .addComponent(jLabel50)
                    .addComponent(jLabel51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jLabel49.setBackground(new java.awt.Color(153, 51, 255));
        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("PRODUCCIÓN ACTUAL");

        jLabel46.setBackground(new java.awt.Color(153, 51, 255));
        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("PRODUCCIONES PASADAS");

        jPanel10.setBackground(new java.awt.Color(255, 102, 102));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 5));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("CAPACIDAD");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("ALMACÉN");
        jLabel20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setText("Placas base:");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel22.setText("0");

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
                .addComponent(jLabel22)
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
                    .addComponent(jLabel22)
                    .addComponent(jLabel32))
                .addContainerGap())
        );

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setText("CPUs:");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel24.setText("0");

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
                .addComponent(jLabel24)
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
                    .addComponent(jLabel24)
                    .addComponent(jLabel33))
                .addContainerGap())
        );

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setText("Memorias RAM:");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel26.setText("0");

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
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(jLabel34)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel34))
                .addContainerGap())
        );

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setText("Fuentes de poder:");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setText("0");

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
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addComponent(jLabel35)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(jLabel35))
                .addContainerGap())
        );

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel29.setText("Tarjetas gráficas:");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel30.setText("0");

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
                .addComponent(jLabel30)
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
                    .addComponent(jLabel30)
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
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18ActionPerformed

    private void jTextField19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField19ActionPerformed

    private void jTextField20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    public static JLabel getDiasParaEntrega() {
        return diasParaEntrega;
    }

    public static void setDiasParaEntrega(JLabel diasParaEntrega) {
        MSI.diasParaEntrega = diasParaEntrega;
    }

    public static void actualizarDiasParaEntrega(int nuevoValor) {
        diasParaEntrega.setText(Integer.toString(nuevoValor));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dias;
    public static javax.swing.JLabel diasParaEntrega;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
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
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel productoresRestantesM;
    private javax.swing.JSpinner spinnerCPUsM;
    private javax.swing.JSpinner spinnerEnsambladoresM;
    private javax.swing.JSpinner spinnerFuentesM;
    private javax.swing.JSpinner spinnerMemoriasM;
    private javax.swing.JSpinner spinnerPlacasM;
    private javax.swing.JSpinner spinnerTarjetasM;
    // End of variables declaration//GEN-END:variables
}

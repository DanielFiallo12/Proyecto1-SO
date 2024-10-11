
package interfaces;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class MainInterface extends javax.swing.JFrame {

    
     public MainInterface() {
        inittComponents();
        
        setLocationRelativeTo(null);
    }

         private void inittComponents() {
             
           tabbedPane = new javax.swing.JTabbedPane();

        // Panel para Dashboard con tamaño personalizado
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setPreferredSize(new Dimension(700, 800)); // Tamaño para dashboard
        dashboard1 = new interfaces.Dashboard();
        dashboardPanel.add(dashboard1);

        // Panel para HP con tamaño personalizado
        JPanel hpPanel = new JPanel();
        hpPanel.setPreferredSize(new Dimension(1000, 1000)); // Tamaño para HP
        hp1 = new interfaces.HP();
        hpPanel.add(hp1);

        // Panel para MSI con tamaño personalizado
        JPanel msiPanel = new JPanel();
        msiPanel.setPreferredSize(new Dimension(1000, 1000)); // Tamaño para MSI
        msi2 = new interfaces.MSI();
        msiPanel.add(msi2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.BorderLayout());

        // Añadir las pestañas con los paneles personalizados
        tabbedPane.addTab("Dasboard Principal", dashboardPanel);
        tabbedPane.addTab("HP", hpPanel);
        tabbedPane.addTab("MSI", msiPanel);

        getContentPane().add(tabbedPane, java.awt.BorderLayout.CENTER);
        pack();
    }// </editor-fold>                        
     
    /**
     * Creates new form MainInterface
     */

@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        
        
        try {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
            }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainInterface().setVisible(true);

            }
        });
    }


    // Variables declaration - do not modify                     
    private interfaces.HP hp1;
    private interfaces.Dashboard dashboard1;
    private interfaces.MSI msi2;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration                   
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


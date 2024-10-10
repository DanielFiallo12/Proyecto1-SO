
package interfaces;

public class MainInterface extends javax.swing.JFrame {

    
     public MainInterface() {
        inittComponents();
    }

         private void inittComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        dashboard1 = new interfaces.Dashboard();
        hp1 = new interfaces.HP();
        msi2 = new interfaces.MSI();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabbedPane.setName("tabbedPane"); // NOI18N
        tabbedPane.addTab("Dasboard Principal", dashboard1);
        tabbedPane.addTab("HP", hp1);
        tabbedPane.addTab("MSI", msi2);

getContentPane().setLayout(new java.awt.BorderLayout());
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

        /* Create and display the form */
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


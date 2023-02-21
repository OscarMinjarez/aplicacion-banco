/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import implementaciones.ClientesDAO;
import implementaciones.DireccionesDAO;
import implementaciones.NombresCompletosDAO;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
import interfaces.INombresCompletosDAO;

/**
 *
 * @author Oscar
 */
public class PantallaInicio extends javax.swing.JFrame {

    private final IConexionBD manejadorConexiones;
    private IClientesDAO clientesDAO;
    private INombresCompletosDAO nombresCompletosDAO;
    
    /**
     * Creates new form PantallaInicio
     * @param manejadorConexiones
     * @param nombresCompletosDAO
     */
    public PantallaInicio(IConexionBD manejadorConexiones) {
        this.manejadorConexiones = manejadorConexiones;
        this.clientesDAO = new ClientesDAO(manejadorConexiones);
        this.nombresCompletosDAO = new NombresCompletosDAO(manejadorConexiones);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        parrafo = new javax.swing.JLabel();
        btnSoyCliente = new javax.swing.JButton();
        btnNoSoyCliente = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnRetiroSinCuenta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        titulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titulo.setText("Bienvenido");

        parrafo.setText("Selecciona una opción para continuar");

        btnSoyCliente.setText("Soy cliente");
        btnSoyCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoyClienteActionPerformed(evt);
            }
        });

        btnNoSoyCliente.setText("No soy cliente");
        btnNoSoyCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoSoyClienteActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnRetiroSinCuenta.setText("Retiro sin cuenta");
        btnRetiroSinCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetiroSinCuentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSalir)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(btnRetiroSinCuenta)
                            .addComponent(titulo)
                            .addComponent(parrafo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSoyCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNoSoyCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(66, 66, 66))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(titulo)
                .addGap(18, 18, 18)
                .addComponent(parrafo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSoyCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNoSoyCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRetiroSinCuenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSoyClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoyClienteActionPerformed
        IniciarSesion iniciarSesion = new IniciarSesion(clientesDAO, nombresCompletosDAO);
        iniciarSesion.setVisible(true);
    }//GEN-LAST:event_btnSoyClienteActionPerformed

    private void btnNoSoyClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoSoyClienteActionPerformed
        RegistrarCliente registro = new RegistrarCliente(
                new ClientesDAO(this.manejadorConexiones),
                new NombresCompletosDAO(this.manejadorConexiones),
                new DireccionesDAO(this.manejadorConexiones)
        );
        registro.setVisible(true);
    }//GEN-LAST:event_btnNoSoyClienteActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRetiroSinCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetiroSinCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRetiroSinCuentaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNoSoyCliente;
    private javax.swing.JButton btnRetiroSinCuenta;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSoyCliente;
    private javax.swing.JLabel parrafo;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}

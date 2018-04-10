/*
 * Titulo: Panatalla 3 Módulo paciente.
 * Este programa se realizó para la organización "La sagrada familia A.C".
 * Esta panatalla consiste en el reingresos,egresos  de pacientes.
 * Fecha: 28/02/2017
 */
package pantallas;

import clases.ComboItem;
import clases.DAOPacientes;
import clases.DAORegistroMovimientos;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose Luis Tinajero Carvajal.
 */
public class FrmHistorial_Ingresos_Egresos extends javax.swing.JFrame {

    Font fntTitulo = new Font("Tahoma", Font.BOLD, 24);
    Font fntComponente = new Font("Tahoma", Font.BOLD, 14);
    Dimension dmsBoton = new Dimension(250, 40);

    /**
     * Creates new form FrmHistorial_Ingresos_Egresos
     */
    public FrmHistorial_Ingresos_Egresos() {
        initComponents();
        cargaCmbAutorizacion();
        cargaCmbMotivos();
        mn1.setVisible(false);
        skin();
    }

    private void skin() {
        lblIngreso.setText(lblIngreso.getText().toUpperCase());
        lblAutorizado.setText(lblAutorizado.getText().toUpperCase());
        lblComentarios.setText(lblComentarios.getText().toUpperCase());
        lblMotivos.setText(lblMotivos.getText().toUpperCase());
        lblNoExp.setText(lblNoExp.getText().toUpperCase());
        btnEgresar.setText(btnEgresar.getText().toUpperCase());
        btnReingresar.setText(btnReingresar.getText().toUpperCase());
        btnListarEgresos.setText(btnListarEgresos.getText().toUpperCase());
        btnListarIngresos.setText(btnListarIngresos.getText().toUpperCase());
        btnListasMovimientos.setText(btnListasMovimientos.getText().toUpperCase());
//        txtComponente  
    }

    private void cargaCmbAutorizacion() {
        cmbAutorizado.removeAllItems();
        cmbAutorizado.addItem("Medico");
        cmbAutorizado.addItem("Madre Teresa");
        cmbAutorizado.addItem("Madre Lupe");
        cmbAutorizado.addItem("Medico2");

    }

    private void cargaCmbMotivos() {
        cmbMotivos.removeAllItems();
        cmbMotivos.addItem("ALTA MEDICA");
        cmbMotivos.addItem("POR DEFUNCIÓN");
        cmbMotivos.addItem("POR VOLUNTAD PROPIA");
    }

    public void LimpiarCampos() {
        txaComentarios.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHistorial = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistorial = new javax.swing.JTable();
        pnlDatos2 = new javax.swing.JPanel();
        lblIngreso = new javax.swing.JLabel();
        lblMotivos = new javax.swing.JLabel();
        cmbMotivos = new javax.swing.JComboBox();
        lblAutorizado = new javax.swing.JLabel();
        cmbAutorizado = new javax.swing.JComboBox<>();
        btnEgresar = new javax.swing.JButton();
        btnListarEgresos = new javax.swing.JButton();
        btnListarIngresos = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaComentarios = new javax.swing.JTextArea();
        lblComentarios = new javax.swing.JLabel();
        btnListasMovimientos = new javax.swing.JButton();
        lblNoExp = new javax.swing.JLabel();
        txtNoExpediente = new javax.swing.JTextField();
        btnReingresar = new javax.swing.JButton();
        mbrPrincipal = new javax.swing.JMenuBar();
        mn1 = new javax.swing.JMenu();
        mitHistorial1 = new javax.swing.JMenuItem();
        mitResponsables = new javax.swing.JMenuItem();
        mitPacientes = new javax.swing.JMenuItem();
        sep5 = new javax.swing.JPopupMenu.Separator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlHistorial.setBackground(new java.awt.Color(198, 253, 188));

        tblHistorial.setFont(fntComponente);
        tblHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblHistorial);

        pnlDatos2.setBackground(new java.awt.Color(198, 253, 188));

        lblIngreso.setFont(fntTitulo);
        lblIngreso.setText("Ingresos y Egresos  de Paciente");

        lblMotivos.setFont(fntComponente);
        lblMotivos.setText("Motivos de egreso:");

        cmbMotivos.setFont(fntComponente);
        cmbMotivos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblAutorizado.setFont(fntComponente);
        lblAutorizado.setText("Autorizado por:");

        cmbAutorizado.setFont(fntComponente);
        cmbAutorizado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnEgresar.setFont(fntComponente);
        btnEgresar.setText("Egresar Paciente");
        btnEgresar.setMaximumSize(dmsBoton);
        btnEgresar.setPreferredSize(dmsBoton);
        btnEgresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEgresarActionPerformed(evt);
            }
        });

        btnListarEgresos.setFont(fntComponente);
        btnListarEgresos.setText("Listar Egresos");
        btnListarEgresos.setMaximumSize(dmsBoton);
        btnListarEgresos.setPreferredSize(dmsBoton);
        btnListarEgresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarEgresosActionPerformed(evt);
            }
        });

        btnListarIngresos.setFont(fntComponente);
        btnListarIngresos.setText("Listar ingresos");
        btnListarIngresos.setMaximumSize(dmsBoton);
        btnListarIngresos.setPreferredSize(dmsBoton);
        btnListarIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarIngresosActionPerformed(evt);
            }
        });

        txaComentarios.setColumns(20);
        txaComentarios.setFont(fntComponente);
        txaComentarios.setRows(5);
        txaComentarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaComentariosKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txaComentarios);

        lblComentarios.setFont(fntComponente);
        lblComentarios.setText("Comentarios:");

        btnListasMovimientos.setFont(fntComponente);
        btnListasMovimientos.setText("Listar todos los movimientos");
        btnListasMovimientos.setMaximumSize(dmsBoton);
        btnListasMovimientos.setPreferredSize(dmsBoton);
        btnListasMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListasMovimientosActionPerformed(evt);
            }
        });

        lblNoExp.setFont(fntComponente);
        lblNoExp.setText("No. Expediente:");

        txtNoExpediente.setFont(fntComponente);

        btnReingresar.setFont(fntComponente);
        btnReingresar.setText("Reingresar Paciente");
        btnReingresar.setMaximumSize(dmsBoton);
        btnReingresar.setPreferredSize(dmsBoton);
        btnReingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReingresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDatos2Layout = new javax.swing.GroupLayout(pnlDatos2);
        pnlDatos2.setLayout(pnlDatos2Layout);
        pnlDatos2Layout.setHorizontalGroup(
            pnlDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatos2Layout.createSequentialGroup()
                .addGroup(pnlDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatos2Layout.createSequentialGroup()
                        .addComponent(lblNoExp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNoExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDatos2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(lblIngreso))
                    .addGroup(pnlDatos2Layout.createSequentialGroup()
                        .addGroup(pnlDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMotivos)
                            .addComponent(lblAutorizado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbAutorizado, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbMotivos, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlDatos2Layout.createSequentialGroup()
                        .addComponent(lblComentarios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDatos2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(pnlDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEgresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnListarEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatos2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnReingresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlDatos2Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(btnListarIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnListasMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        pnlDatos2Layout.setVerticalGroup(
            pnlDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatos2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIngreso)
                .addGap(18, 18, 18)
                .addGroup(pnlDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNoExp)
                    .addComponent(txtNoExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAutorizado)
                    .addComponent(cmbAutorizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMotivos)
                    .addComponent(cmbMotivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatos2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(lblComentarios))
                    .addGroup(pnlDatos2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(pnlDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEgresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReingresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(btnListasMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(pnlDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListarEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListarIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91))
        );

        javax.swing.GroupLayout pnlHistorialLayout = new javax.swing.GroupLayout(pnlHistorial);
        pnlHistorial.setLayout(pnlHistorialLayout);
        pnlHistorialLayout.setHorizontalGroup(
            pnlHistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHistorialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDatos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlHistorialLayout.setVerticalGroup(
            pnlHistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHistorialLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(pnlHistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDatos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlHistorialLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        mn1.setText("Menú Historial");

        mitHistorial1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.SHIFT_MASK));
        mitHistorial1.setText("Historial de salidas y entradas");
        mitHistorial1.setActionCommand("Historial Medico");
        mitHistorial1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitHistorial1ActionPerformed(evt);
            }
        });
        mn1.add(mitHistorial1);

        mitResponsables.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        mitResponsables.setText("Responsables de Pacientes");
        mitResponsables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitResponsablesActionPerformed(evt);
            }
        });
        mn1.add(mitResponsables);

        mitPacientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        mitPacientes.setText("Pacientes");
        mitPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitPacientesActionPerformed(evt);
            }
        });
        mn1.add(mitPacientes);
        mn1.add(sep5);

        mbrPrincipal.add(mn1);

        setJMenuBar(mbrPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mitHistorial1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitHistorial1ActionPerformed
        dispose();
        FrmHistorial_Ingresos_Egresos frmhie = new FrmHistorial_Ingresos_Egresos();
        frmhie.setVisible(true);
    }//GEN-LAST:event_mitHistorial1ActionPerformed

    private void mitResponsablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitResponsablesActionPerformed
        dispose();
        FrmPacientes2 frm2 = new FrmPacientes2();
        frm2.setVisible(true);
    }//GEN-LAST:event_mitResponsablesActionPerformed

    private void mitPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitPacientesActionPerformed
        dispose();
        FrmPacientes frm = new FrmPacientes();
        frm.setVisible(true);
    }//GEN-LAST:event_mitPacientesActionPerformed

    private void btnListarEgresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarEgresosActionPerformed
        DAORegistroMovimientos dre = new DAORegistroMovimientos();
        dre.setNoExpediente(Integer.parseInt(txtNoExpediente.getText()));
        tblHistorial.setModel(dre.listarEgresos());
    }//GEN-LAST:event_btnListarEgresosActionPerformed

    private void btnReingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReingresarActionPerformed
        // TODO add your handling code here:
        DAORegistroMovimientos drm = new DAORegistroMovimientos();
        drm.setNoExpediente(Integer.parseInt(txtNoExpediente.getText()));
        drm.setDescripcion("Reingresar");
        drm.setAutorizado((String) cmbAutorizado.getSelectedItem());
        drm.setComentarios(txaComentarios.getText());
        drm.setMotivos((String) cmbMotivos.getSelectedItem());
        if (drm.agregar()) {
            DAOPacientes dp = new DAOPacientes();
            dp.setNoExpediente(Integer.parseInt(txtNoExpediente.getText()));
            dp.activar();
            JOptionPane.showMessageDialog(rootPane, "Reingreso de paciente con exito");
            LimpiarCampos();
            btnListarIngresos.doClick();
        } else {
            JOptionPane.showMessageDialog(rootPane, "No se reingreso paciente");
        }
    }//GEN-LAST:event_btnReingresarActionPerformed

    private void btnListasMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListasMovimientosActionPerformed
        DAORegistroMovimientos dre = new DAORegistroMovimientos();
        dre.setNoExpediente(Integer.parseInt(txtNoExpediente.getText()));
        tblHistorial.setModel(dre.listarMovimientos());
    }//GEN-LAST:event_btnListasMovimientosActionPerformed

    private void btnListarIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarIngresosActionPerformed
        DAORegistroMovimientos dre = new DAORegistroMovimientos();
        dre.setNoExpediente(Integer.parseInt(txtNoExpediente.getText()));
        tblHistorial.setModel(dre.listarReingresos());
    }//GEN-LAST:event_btnListarIngresosActionPerformed

    private void btnEgresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEgresarActionPerformed
        if (!txtNoExpediente.getText().isEmpty()) {
            DAORegistroMovimientos drm = new DAORegistroMovimientos();
            drm.setNoExpediente(Integer.parseInt(txtNoExpediente.getText()));
            drm.setDescripcion("Egresar");
            drm.setAutorizado((String) cmbAutorizado.getSelectedItem());
            drm.setComentarios(txaComentarios.getText());
            drm.setMotivos((String) cmbMotivos.getSelectedItem());
            if (drm.agregar()) {
                DAOPacientes dp = new DAOPacientes();
                dp.setNoExpediente(Integer.parseInt(txtNoExpediente.getText()));
                dp.Desactivar();
                JOptionPane.showMessageDialog(rootPane, "Egreso de paciente exitoso.");
                LimpiarCampos();
                btnListarEgresos.doClick();
            } else {
                JOptionPane.showMessageDialog(rootPane, "No se egresó el paciente.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "ERROR: Faltó el No. de expediente.");
        }
    }//GEN-LAST:event_btnEgresarActionPerformed

    private void txaComentariosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaComentariosKeyReleased
        // TODO add your handling code here:
        txaComentarios.setText(txaComentarios.getText().toUpperCase());
    }//GEN-LAST:event_txaComentariosKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmHistorial_Ingresos_Egresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmHistorial_Ingresos_Egresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmHistorial_Ingresos_Egresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmHistorial_Ingresos_Egresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmHistorial_Ingresos_Egresos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEgresar;
    private javax.swing.JButton btnListarEgresos;
    private javax.swing.JButton btnListarIngresos;
    private javax.swing.JButton btnListasMovimientos;
    private javax.swing.JButton btnReingresar;
    private javax.swing.JComboBox<String> cmbAutorizado;
    private javax.swing.JComboBox cmbMotivos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAutorizado;
    private javax.swing.JLabel lblComentarios;
    private javax.swing.JLabel lblIngreso;
    private javax.swing.JLabel lblMotivos;
    private javax.swing.JLabel lblNoExp;
    private javax.swing.JMenuBar mbrPrincipal;
    private javax.swing.JMenuItem mitHistorial1;
    private javax.swing.JMenuItem mitPacientes;
    private javax.swing.JMenuItem mitResponsables;
    private javax.swing.JMenu mn1;
    private javax.swing.JPanel pnlDatos2;
    private javax.swing.JPanel pnlHistorial;
    private javax.swing.JPopupMenu.Separator sep5;
    private javax.swing.JTable tblHistorial;
    private javax.swing.JTextArea txaComentarios;
    private javax.swing.JTextField txtNoExpediente;
    // End of variables declaration//GEN-END:variables
}

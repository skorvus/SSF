/*
 * Nombre del autor: Iván Ruiz Ramírez
 * Fecha de creación: 2017/01/31
 * Nombre del proyecto: casaDescanso
 * Nombre del módulo: centralDeEnfermería
 * Breve descripción del contenido: pantalla que contiene la lista de pedidos de medicamentos que se deben de autorizar.
 */
package pantallas;

import clases.DAOPedMed;
import static pantallas.frmPedMed.pedMed;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;

/**
 *
 * @author IvanR
 */
public class frmListPedMed extends javax.swing.JFrame {

    /**
     * Creates new form frmListPedMed
     */
    public frmListPedMed() {
        initComponents();
        skin1();
    }
    DAOPedMed daoPed = new DAOPedMed();
    Font textoTitulos = new Font("Tahoma", Font.BOLD,24);
    Font textoComponentes = new Font("Tahoma", Font.BOLD,14);
    
    public void skin1(){
        Dimension dmnBtn = new Dimension(130, 50); //130, 50
        btnRegresar.setSize(dmnBtn);
        lblListPedMed.setText(lblListPedMed.getText().toUpperCase());
        lblFiltro.setText(lblFiltro.getText().toUpperCase());
        lblNombre.setText(lblNombre.getText().toUpperCase());
        btnRegresar.setText(btnRegresar.getText().toUpperCase());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pumPedMed = new javax.swing.JPopupMenu();
        muiAutorizar = new javax.swing.JMenuItem();
        btnRegresar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPedMed = new javax.swing.JTable();
        txtNombre = new javax.swing.JTextField();
        lblListPedMed = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblFiltro = new javax.swing.JLabel();
        lblFondoVerde = new javax.swing.JLabel();

        muiAutorizar.setText("jMenuItem1");
        muiAutorizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                muiAutorizarActionPerformed(evt);
            }
        });
        pumPedMed.add(muiAutorizar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegresar.setFont(textoComponentes);
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(925, 528, 159, 40));

        tblPedMed.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPedMed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPedMedMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPedMed);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 127, 1074, 383));

        txtNombre.setFont(textoComponentes);
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 93, 212, -1));

        lblListPedMed.setFont(textoTitulos);
        lblListPedMed.setText("Lista de pedidos de medicamentos (Individuales)");
        getContentPane().add(lblListPedMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 36, 747, -1));

        lblNombre.setFont(textoComponentes);
        lblNombre.setText("Nombre de paciente:");
        getContentPane().add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 96, 185, -1));

        lblFiltro.setFont(textoComponentes);
        lblFiltro.setText("Filtro:");
        getContentPane().add(lblFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 61, 100, -1));

        lblFondoVerde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoVerde.jpg"))); // NOI18N
        getContentPane().add(lblFondoVerde, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        dispose();
        //pedMed.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void tblPedMedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPedMedMouseClicked
        if (SwingUtilities.isRightMouseButton(evt)) {
            Point p = evt.getPoint(); //Para obtener las coordenadas del click derecho
            int rowNumber = tblPedMed.rowAtPoint(p); // index que tiene la coordenada
            ListSelectionModel model = tblPedMed.getSelectionModel();
            model.setSelectionInterval(rowNumber, rowNumber);
            muiAutorizar.setText("Autorizar Pedido");
            pumPedMed.show(evt.getComponent(), evt.getX(), evt.getY());
        } else {
            int index = tblPedMed.getSelectedRow();
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            TableModel model = tblPedMed.getModel();
            String horarioEsp = "";
            pedMed.txtCmbFiltMed.setText("");
            pedMed.txtCmbFiltPac.setText("");
            daoPed.setNomPac("%");
            daoPed.setNombreProductoGen("%");
            String idPedMed = model.getValueAt(index, 0).toString();
            String fechaIn = model.getValueAt(index, 1).toString();
            String depart = model.getValueAt(index, 2).toString();
            String paciente = model.getValueAt(index, 3).toString() + " " + model.getValueAt(index, 4).toString() + " " + model.getValueAt(index, 5).toString();
            String diagnost = model.getValueAt(index, 6).toString();
            String medPat = model.getValueAt(index, 7).toString();
            String medGen = model.getValueAt(index, 8).toString();
            String dosis = model.getValueAt(index, 9).toString();
            String enfermera = model.getValueAt(index, 11).toString() + " " + model.getValueAt(index, 12).toString() + " " + model.getValueAt(index, 13).toString();
            String fechaPedMed = model.getValueAt(index, 14).toString();
            if(model.getValueAt(index, 15) != null){
                horarioEsp = model.getValueAt(index, 15).toString();
            }
            String horarioMan = model.getValueAt(index, 16).toString();
            String horarioTarde = model.getValueAt(index, 17).toString();
            String horarioNoche = model.getValueAt(index, 18).toString();
            String descrPedMed = model.getValueAt(index, 19).toString();
            dispose();
            pedMed.setVisible(true);
            pedMed.txtIdPedidoMed.setText(idPedMed);
            try {
                pedMed.dchFechaPedMed.setDate(fmt.parse(fechaPedMed));
                pedMed.dchFechaIngreso.setDate(fmt.parse(fechaIn));
            } catch (ParseException ex) {
                Logger.getLogger(frmListPedMed.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            pedMed.txtDiagnost.setText(diagnost);
            pedMed.cmbDepart.setSelectedItem(depart);
            pedMed.cmbEnfermera.setSelectedItem(enfermera);
            pedMed.cmbPaciente.setSelectedItem(paciente);
            pedMed.cmbMedGen.setSelectedItem(medGen);
            pedMed.cmbMedPat.setSelectedItem(medPat);
            pedMed.txtDosis.setText(dosis);
            if(horarioEsp != null){
                pedMed.txtHorarioEsp.setText(horarioEsp);
            }
            pedMed.txtHorarioMan.setText(horarioMan);
            pedMed.txtHorarioTarde.setText(horarioTarde);
            pedMed.txtHorarioNoche.setText(horarioNoche);
            pedMed.txaDescrPedMed.setText(descrPedMed);
            pedMed.btnModificarPed.setEnabled(true);
            pedMed.btnEliminarPed.setEnabled(true);
            pedMed.btnAgregarPed.setEnabled(false);
        }

    }//GEN-LAST:event_tblPedMedMouseClicked

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        daoPed.setNomPac(txtNombre.getText() + "%");
        daoPed.getTmodel().setColumnCount(0);
        daoPed.getTmodel().setRowCount(0);
        daoPed.filtrar();
        tblPedMed.setModel(daoPed.getTmodel());
    }//GEN-LAST:event_txtNombreKeyReleased

    private void muiAutorizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_muiAutorizarActionPerformed
        int index = tblPedMed.getSelectedRow();
        TableModel model = tblPedMed.getModel();
        daoPed.setIdPedidoMed(Integer.parseInt(model.getValueAt(index, 0).toString()));
        daoPed.autorizar();
        daoPed.getTmodel().setColumnCount(0);
        daoPed.getTmodel().setRowCount(0);
        daoPed.listar();
        tblPedMed.setModel(daoPed.getTmodel());
        JOptionPane.showMessageDialog(null, "Pedido autorizado.");
    }//GEN-LAST:event_muiAutorizarActionPerformed

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
            java.util.logging.Logger.getLogger(frmListPedMed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmListPedMed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmListPedMed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmListPedMed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmListPedMed().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblFondoVerde;
    private javax.swing.JLabel lblListPedMed;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JMenuItem muiAutorizar;
    private javax.swing.JPopupMenu pumPedMed;
    public javax.swing.JTable tblPedMed;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
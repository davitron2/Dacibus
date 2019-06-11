/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.CuentaSQL;
import modelo.OrdenSQL;
import modelo.ProductoSQL;

/**
 *
 * @author JOCELYNE
 */
public class Atender extends javax.swing.JFrame {
MenuAtender menu;
DefaultTableModel model;
OrdenSQL ord= new OrdenSQL();

    /**
     * Creates new form Atender
     */int idord;
    public Atender() {
        initComponents();
        this.setLocationRelativeTo(null);
       cargartabla();
       idord=ord.asignarID();
        txtNOrden.setText(String.valueOf(idord));
    }
    ProductoSQL Prosql= new ProductoSQL();
    Cuenta cuen;
public void cargartabla(){
    try {
        Prosql.SoloTabla(tblProducto);
        
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(Atender.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        Logger.getLogger(Atender.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        Logger.getLogger(Atender.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(Atender.class.getName()).log(Level.SEVERE, null, ex);
    }



}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnPagar = new javax.swing.JButton();
        lblMinimizar = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnCancelaOrden = new javax.swing.JButton();
        btnVolverMenu = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAtender = new javax.swing.JTable();
        txtNOrden = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        spnCantidad = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        lblAtender = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1390, 800));
        setMinimumSize(new java.awt.Dimension(1390, 800));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1390, 800));
        setResizable(false);
        setSize(new java.awt.Dimension(1390, 800));
        getContentPane().setLayout(null);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/crearorden.png"))); // NOI18N
        btnPagar.setBorder(null);
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });
        jPanel1.add(btnPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 620, -1, -1));

        lblMinimizar.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lblMinimizar.setForeground(new java.awt.Color(255, 255, 255));
        lblMinimizar.setText("-");
        lblMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizarMouseClicked(evt);
            }
        });
        jPanel1.add(lblMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 10, 20, 30));

        lblCerrar.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 36)); // NOI18N
        lblCerrar.setForeground(new java.awt.Color(255, 255, 255));
        lblCerrar.setText("X");
        lblCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });
        jPanel1.add(lblCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 10, 20, 30));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btnAgregar.png"))); // NOI18N
        btnAgregar.setBorder(null);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 350, -1, -1));

        btnCancelaOrden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cancelaorden.png"))); // NOI18N
        btnCancelaOrden.setBorder(null);
        btnCancelaOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelaOrdenActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelaOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 620, -1, -1));

        btnVolverMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btnVolverMenu.png"))); // NOI18N
        btnVolverMenu.setBorder(null);
        btnVolverMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverMenuActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolverMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 680, -1, -1));

        jButton1.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 20)); // NOI18N
        jButton1.setText("Ver todos los productos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 65, -1, -1));

        txtBuscar.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 18)); // NOI18N
        txtBuscar.setBorder(null);
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 130, 18));

        tblAtender.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdProducto", "Nombre", "Precio"
            }
        ));
        jScrollPane1.setViewportView(tblAtender);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, 800, 150));

        txtNOrden.setEditable(false);
        txtNOrden.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 24)); // NOI18N
        txtNOrden.setBorder(null);
        jPanel1.add(txtNOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 80, 40));

        jButton2.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 24)); // NOI18N
        jButton2.setText("Retirar de la orden");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 590, 210, 30));

        spnCantidad.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 24)); // NOI18N
        spnCantidad.setBorder(null);
        jPanel1.add(spnCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 90, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/buscar3.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 210, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/deAtender_1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 400, 240));

        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "IDPRODUCTO", "NOMBRE PRODUCTO", "CATEGORIA", "PRECIO"
            }
        ));
        jScrollPane2.setViewportView(tblProducto);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 810, 240));

        lblAtender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Atender.png"))); // NOI18N
        lblAtender.setText("jLabel1");
        lblAtender.setPreferredSize(new java.awt.Dimension(1390, 800));
        jPanel1.add(lblAtender, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 800));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1390, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizarMouseClicked
        this.setState(JFrame.ICONIFIED); //minimizar la ventana
    }//GEN-LAST:event_lblMinimizarMouseClicked

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        if (menu == null) {
            menu = new MenuAtender();
            menu.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void btnVolverMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverMenuActionPerformed
          if (menu == null) {
            menu = new MenuAtender();
            menu.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnVolverMenuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
cargartabla();      
txtBuscar.setText("");// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
       
    try {
        Prosql.BuscarTabla(tblProducto,txtBuscar.getText());
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(Atender.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        Logger.getLogger(Atender.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        Logger.getLogger(Atender.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(Atender.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
      int cantidad= Integer.parseInt(spnCantidad.getValue().toString());
        int col =tblProducto.getSelectedRow();
        for (int i = 0; i < cantidad; i++) {
            
        
 String  []datos= new String[3];
datos[0]= String.valueOf(tblProducto.getValueAt(col, 0));

datos[1]= String.valueOf(tblProducto.getValueAt(col, 1));

datos[2]= String.valueOf(tblProducto.getValueAt(col, 3));
  model = (DefaultTableModel) tblAtender.getModel();
        model.insertRow(model.getRowCount(),datos);
        tblAtender.setModel(model);
        }
        spnCantidad.setValue(0);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        if (tblAtender.getRowCount()<1) {
            JOptionPane.showMessageDialog(null, "Agregue productos a la orden");
        }else{

int op=JOptionPane.showConfirmDialog(null, "Confirme la creacion de la orden", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
       
if (op==0) {
             int [] IdsProductos = new int[model.getRowCount()];
        double[] Precios = new double[model.getRowCount()];
        for (int i = 0; i <model.getRowCount(); i++) {
            IdsProductos[i]= Integer.parseInt(tblAtender.getValueAt(i,0).toString());
            Precios[i]=Double.parseDouble(tblAtender.getValueAt(i,2).toString());
        }
      
        
        ord.RegistrarOrden(idord,IdsProductos, Precios);
           if ( cuen == null) {
            cuen = new Cuenta(txtNOrden.getText());
            cuen.setVisible(true);
            this.dispose();
        }
        
        }else{
        
        
        
        
        }
        
        }
       
        
       /*if (cuen == null) {
      
      
      
      
      
      
      
            cuen = new Cuenta();
            cuen.setVisible(true);
            this.dispose();
        }*/
    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnCancelaOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelaOrdenActionPerformed
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
        }
     tblAtender.setModel(model);
        if (menu == null) {
            menu = new MenuAtender();
            menu.setVisible(true);
            this.dispose();
        }

// TODO add your handling code here:
    }//GEN-LAST:event_btnCancelaOrdenActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (tblAtender.getSelectedRow()!=-1) {
               model.removeRow(tblAtender.getSelectedRow());
 tblAtender.setModel(model);
        }else{
            JOptionPane.showMessageDialog(null,"Seleccione lo que desea retirar");
        }
     
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Atender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Atender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Atender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Atender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Atender().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelaOrden;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnVolverMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAtender;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblMinimizar;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JTable tblAtender;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtNOrden;
    // End of variables declaration//GEN-END:variables
}

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
import modelo.CuentaSQL;
import modelo.Usuario;
import modelo.VentaSQL;

/**
 *
 * @author JOCELYNE
 */
public class Ventas extends javax.swing.JFrame {
CuentaSQL cuesql = new CuentaSQL();
    modelo.VentaSQL obj = new VentaSQL();
    Menu menu;

    /**
     * Creates new form Ventas
     */
    Usuario user;
    public Ventas(Usuario us) {
        user=us;
        initComponents();
        this.setLocationRelativeTo(null);
        Tabla();
    }
    public Ventas() {
        initComponents();
        this.setLocationRelativeTo(null);
        Tabla();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        btnVolverMenu = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        txtNVenta = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblorden = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblMinimizar = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        lblVentas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1390, 800));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1390, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "IdCuenta", "CostoTotal", "IdMesa", "IdOrden", "IdUsuario", "Fecha"
            }
        ));
        tblVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVentas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 580, 310));

        btnVolverMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btnVolverMenu.png"))); // NOI18N
        btnVolverMenu.setBorder(null);
        btnVolverMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverMenuActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolverMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 710, -1, -1));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btnBuscar.png"))); // NOI18N
        btnBuscar.setBorder(null);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 200, 50));

        jDateChooser1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDateChooser1KeyPressed(evt);
            }
        });
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 200, 50));

        txtNVenta.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 24)); // NOI18N
        txtNVenta.setBorder(null);
        txtNVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNVentaActionPerformed(evt);
            }
        });
        txtNVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNVentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNVentaKeyTyped(evt);
            }
        });
        jPanel1.add(txtNVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 80, 50));

        tblorden.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "IdOrden", "IdProducto", "Nombre", "Cant", "Precio"
            }
        ));
        tblorden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblordenMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblorden);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 370, -1, 310));

        jButton1.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 24)); // NOI18N
        jButton1.setText("Ver todas las ventas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 680, 210, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/deVentas.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 300, -1));

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

        lblVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Ventas.png"))); // NOI18N
        lblVentas.setText("jLabel1");
        jPanel1.add(lblVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public final void Tabla() {
        try {
            obj.SoloTabla(tblVentas);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void lblMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizarMouseClicked
        this.setState(JFrame.ICONIFIED); //minimizar la ventana
    }//GEN-LAST:event_lblMinimizarMouseClicked

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        if (menu == null) {
            menu = new Menu(user);
            menu.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void txtNVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNVentaKeyPressed
        //keypressed
    }//GEN-LAST:event_txtNVentaKeyPressed

    private void txtNVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNVentaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String[] opcion = {"N°Venta", "Fecha"};

        int x = JOptionPane.showOptionDialog(this, "Selecciona con que deseas realizar la busqueda", "Elige", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcion, opcion[0]);
        if (x == 0) {
            if (!"".equals(txtNVenta.getText())) {
                try {
                    obj.BuscarTabla(tblVentas, txtNVenta.getText());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por Favor introduzca el numero de orden");
            }
        }
        if (x == 1) {
             if (jDateChooser1.getDate() != null) {
               

                 try {
                      String fecha = jDateChooser1.getDate().toLocaleString();
                String[] partes = fecha.split(" ");
                     ///////////busca reserva por fecha/
                     /////ReSql.BuscarTablaFecha(tblReservas,partes[0]);
                     System.out.println(""+partes[0]);
                     obj.BuscarTablaFecha(tblVentas, partes[0]);
                 } catch (ClassNotFoundException ex) {
                     Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (InstantiationException ex) {
                     Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (IllegalAccessException ex) {
                     Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (SQLException ex) {
                     Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                 }
            } else{
                JOptionPane.showMessageDialog(this,"Por Favor selecciona una fecha");
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jDateChooser1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooser1KeyPressed


    }//GEN-LAST:event_jDateChooser1KeyPressed

    private void btnVolverMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverMenuActionPerformed
      if (menu == null) {
            menu = new Menu(user);
            menu.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnVolverMenuActionPerformed

    private void txtNVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNVentaKeyTyped
        char c=evt.getKeyChar();
        if((c<'0'||c>'9')) evt.consume();
    }//GEN-LAST:event_txtNVentaKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            obj.SoloTabla(tblVentas)  ;      // TODO add your handling code here:
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblordenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblordenMouseClicked
  
    }//GEN-LAST:event_tblordenMouseClicked

    private void tblVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVentasMouseClicked
      
    try {
        int IdOrden = Integer.parseInt(tblVentas.getValueAt(tblVentas.getSelectedRow(), 3).toString());
        
        
        cuesql.TablaOrdenId(tblorden, IdOrden);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
    }
       
    }//GEN-LAST:event_tblVentasMouseClicked

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
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnVolverMenu;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblMinimizar;
    private javax.swing.JLabel lblVentas;
    private javax.swing.JTable tblVentas;
    private javax.swing.JTable tblorden;
    private javax.swing.JTextField txtNVenta;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.CuentaSQL;
import modelo.MesaSQL;
import modelo.OrdenSQL;
import modelo.ReservaSQL;
import modelo.Usuario;

/**
 *
 * @author JOCELYNE
 */
public class Cuenta extends javax.swing.JFrame {
CuentaSQL cuesql = new CuentaSQL();
    modelo.Cuenta Cue = new modelo.Cuenta();
    ReservaSQL resql = new ReservaSQL();
    MesaSQL mesql= new MesaSQL();
    OrdenSQL ordsql= new OrdenSQL();
    MenuAtender menu;
    /**
     * Creates new form Cuenta
     */
   // Usuario usr;
     public Cuenta(String idcuenta) {
         
        initComponents();
       // usr=us;
        this.setLocationRelativeTo(null);
        txtNCuenta.setText(idcuenta);
         txtNOrden.setText(idcuenta);
    try {
        cuesql.TablaOrdenId(tblOrden,Integer.parseInt(idcuenta));
       txtTotal.setText(String.valueOf(ordsql.TotalOrdenId(Integer.parseInt(idcuenta)))); 
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
    }
                 cargartabla();
    }
    public Cuenta() {
        initComponents();
        this.setLocationRelativeTo(null);
         cargartabla();
    }
    public void cargartabla(){
        try {
          
               LocalDate fecha1 = LocalDate.now();
                String fecha;
                
               if(fecha1.getMonthValue()<10){
               
                fecha=fecha1.getDayOfMonth()+"/0"+fecha1.getMonthValue()+"/"+fecha1.getYear();
               }else{
                fecha= fecha1.getDayOfMonth()+"/"+fecha1.getMonthValue()+"/"+fecha1.getYear();
               }
               
               
               
       
                
         
                resql.TablaMesasDisponibles(tblMesas,fecha);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
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
        lblMinimizar = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        txtNCuenta = new javax.swing.JTextField();
        txtNMesa = new javax.swing.JTextField();
        txtNOrden = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnCalcularTotal = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMesas = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrden = new javax.swing.JTable();
        txtTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblPagarCuenta = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1390, 800));
        setMinimumSize(new java.awt.Dimension(1390, 800));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1390, 800));
        setSize(new java.awt.Dimension(1390, 800));
        getContentPane().setLayout(null);

        jPanel1.setMaximumSize(new java.awt.Dimension(1390, 800));
        jPanel1.setMinimumSize(new java.awt.Dimension(1390, 800));
        jPanel1.setPreferredSize(new java.awt.Dimension(1390, 800));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        txtNCuenta.setEditable(false);
        txtNCuenta.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 24)); // NOI18N
        txtNCuenta.setBorder(null);
        jPanel1.add(txtNCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 80, 30));

        txtNMesa.setEditable(false);
        txtNMesa.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 24)); // NOI18N
        txtNMesa.setBorder(null);
        jPanel1.add(txtNMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 80, 50));

        txtNOrden.setEditable(false);
        txtNOrden.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 24)); // NOI18N
        txtNOrden.setBorder(null);
        jPanel1.add(txtNOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 80, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/dePagarCuenta.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, -1, -1));

        btnCalcularTotal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/crearcuenta.png"))); // NOI18N
        btnCalcularTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularTotalActionPerformed(evt);
            }
        });
        jPanel1.add(btnCalcularTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 630, 200, 50));

        jComboBox1.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Libres", "Reservadas" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 100, 30));

        tblMesas.setModel(new javax.swing.table.DefaultTableModel(
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
        tblMesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMesasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblMesas);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, -1, 430));

        tblOrden.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "PRODUCTO", "CANTIDAD", "PRECIO", "IMPORTE"
            }
        ));
        jScrollPane1.setViewportView(tblOrden);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 110, 400, 240));

        txtTotal.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 24)); // NOI18N
        txtTotal.setBorder(null);
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 440, 130, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/deTotal.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 390, -1, 150));

        lblPagarCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Cuenta.png"))); // NOI18N
        jPanel1.add(lblPagarCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 800));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btnRegresar.png"))); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 630, 200, 50));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1390, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizarMouseClicked
        this.setState(JFrame.ICONIFIED); //minimizar la ventana
    }//GEN-LAST:event_lblMinimizarMouseClicked

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked





        //cerrar la ventana
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        
              
                LocalDate fecha1 = LocalDate.now();
                String fecha;
        if(jComboBox1.getSelectedItem().equals("Reservadas")){
        
                    try {
                        if(fecha1.getMonthValue()<10){
                            
                            fecha=fecha1.getDayOfMonth()+"/0"+fecha1.getMonthValue()+"/"+fecha1.getYear();
                        }else{
                            fecha= fecha1.getDayOfMonth()+"/"+fecha1.getMonthValue()+"/"+fecha1.getYear();
                        }
                        System.out.println("reservadas"+fecha);
                        
                        resql.BuscarTablaFecha(tblMesas, fecha);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                
                
                
                
                
        
        
        }
        if (jComboBox1.getSelectedItem().equals("Libres")) {
            try {
                
                
               if(fecha1.getMonthValue()<10){
               
                fecha=fecha1.getDayOfMonth()+"/0"+fecha1.getMonthValue()+"/"+fecha1.getYear();
               }else{
                fecha= fecha1.getDayOfMonth()+"/"+fecha1.getMonthValue()+"/"+fecha1.getYear();
               }
               
               
                System.out.println("libres"+fecha);
                
                
                
                
                
                
                resql.TablaMesasDisponibles(tblMesas,fecha);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
     
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void tblMesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMesasMouseClicked
if(jComboBox1.getSelectedItem().equals("Libres")){
        
        
        if(tblMesas.getSelectedRow()!=-1){
txtNMesa.setText(tblMesas.getValueAt(tblMesas.getSelectedRow(), 1).toString());


}else{


}
    }

if(jComboBox1.getSelectedItem().equals("Reservadas")){
        
        
        if(tblMesas.getSelectedRow()!=-1){
txtNMesa.setText(tblMesas.getValueAt(tblMesas.getSelectedRow(), 3).toString());


}else{


}
    }

        // TODO add your handling code here:
    }//GEN-LAST:event_tblMesasMouseClicked

    private void btnCalcularTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularTotalActionPerformed
int op=JOptionPane.showConfirmDialog(null, "Confirme la creacion de la cuenta", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
     if(op==0){



if(!txtNCuenta.getText().equals("") && !txtNMesa.getText().equals("")){
    Cue.setIdCuenta(Integer.parseInt(txtNCuenta.getText()));
    Cue.setCostoTotal(Double.parseDouble(txtTotal.getText()));
     Cue.setIdMesa(Integer.parseInt(txtNMesa.getText()));
     Cue.setIdOrden(Integer.parseInt(txtNOrden.getText()));
     //Cue.setIdUsuario(usr.getIdUsuario());
             
     
     LocalDate fecha1 = LocalDate.now();
                String fecha;
                  if(fecha1.getMonthValue()<10){
               
                fecha=fecha1.getDayOfMonth()+"/0"+fecha1.getMonthValue()+"/"+fecha1.getYear();
               }else{
                fecha= fecha1.getDayOfMonth()+"/"+fecha1.getMonthValue()+"/"+fecha1.getYear();
               }
               System.out.println("registro "+fecha);
     Cue.setFecha(fecha);
     Cue.setEstado("Activa");
    
     
     
cuesql.RegistrarCuenta(Cue);
 if ( menu == null) {
            menu = new MenuAtender();
            menu.setVisible(true);
            this.dispose();
 }

}else{

JOptionPane.showMessageDialog(null, "seleccione una mesa");

}

     }
     else{
     
     
     }


        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalcularTotalActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswinlblPagarCuentandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cuenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcularTotal;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblMinimizar;
    private javax.swing.JLabel lblPagarCuenta;
    private javax.swing.JTable tblMesas;
    private javax.swing.JTable tblOrden;
    private javax.swing.JTextField txtNCuenta;
    private javax.swing.JTextField txtNMesa;
    private javax.swing.JTextField txtNOrden;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}

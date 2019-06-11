/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class CuentaSQL  extends Conexion{
    
    public JTable TablaOrdenId(JTable tabla,int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
            PreparedStatement ps=null;
            Connection con = getConexion();
            Statement s=con.createStatement();
                                            //Nombre de la tabla
            ResultSet rs=s.executeQuery("SELECT  orden.IdOrden, orden.IdProducto,producto.Nombre, orden.Cant, orden.Precio from orden,producto where orden.IdProducto=producto.IdProducto AND orden.IdOrden="+id+"");
            
            DefaultTableModel modelo=new DefaultTableModel();
            JTable tab=new JTable(modelo);
            
           
            ResultSetMetaData metaDatos=rs.getMetaData();
            int NumeroColumnas=metaDatos.getColumnCount();
            
            Object[] etiquetas=new Object[NumeroColumnas];
            
            for (int i = 0; i < NumeroColumnas; i++) {
                etiquetas[i]=metaDatos.getColumnLabel(i+1);    
            }
            modelo.setColumnIdentifiers(etiquetas);            
            
            
                while(rs.next()){
                Object[] fila=new Object[modelo.getColumnCount()];
                
                for (int i = 0; i < modelo.getColumnCount(); i++) {
                    fila[i]=rs.getObject(i+1);
                }
                modelo.addRow(fila);
            }
               rs.close();
               tabla.setModel(modelo);
                
        return tabla;    
        
        }
    
     public JTable SoloTablaActivas(JTable tabla) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        PreparedStatement ps = null;
        Connection con = getConexion();
        Statement s = con.createStatement();
        //Nombre de la tabla
        ResultSet rs = s.executeQuery("SELECT * from cuenta where Estado='Activa'");

        DefaultTableModel modelo = new DefaultTableModel();
        JTable tab = new JTable(modelo);

        ResultSetMetaData metaDatos = rs.getMetaData();
        int NumeroColumnas = metaDatos.getColumnCount();

        Object[] etiquetas = new Object[NumeroColumnas];

        for (int i = 0; i < NumeroColumnas; i++) {
            etiquetas[i] = metaDatos.getColumnLabel(i + 1);
        }
        modelo.setColumnIdentifiers(etiquetas);

        while (rs.next()) {
            Object[] fila = new Object[modelo.getColumnCount()];

            for (int i = 0; i < modelo.getColumnCount(); i++) {
                fila[i] = rs.getObject(i + 1);
            }
            modelo.addRow(fila);
        }
        rs.close();
        tabla.setModel(modelo);

        return tabla;

    }
       public int RegistrarCuenta(Cuenta Cue) {

        try {
            PreparedStatement ps = null;
            Connection con = getConexion();
            ResultSet rs = null;

            String sql;
          
                    
               sql = "call RegistrarCuenta(?,?,?,?,?,?,?)";
             
               
                ps = con.prepareCall(sql);
                ps.setInt(1, Cue.getIdCuenta());
                ps.setDouble(2, Cue.getCostoTotal());
                ps.setInt(3, Cue.getIdMesa());
                ps.setInt(4, Cue.getIdOrden());
                ps.setInt(5, Cue.getIdUsuario());
                ps.setString(6,Cue.getFecha());
                ps.setString(7,Cue.getEstado());
              
                  
                 ps.executeQuery();
                JOptionPane.showMessageDialog(null, "Cuenta Registrada");
                return 1;

            

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioSQL.class.getName()).log(Level.SEVERE, null, ex);
            return 33;
        }

    }
}

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
public class OrdenSQL extends Conexion{
    
    
     public JTable SoloTabla(JTable tabla) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
            PreparedStatement ps=null;
            Connection con = getConexion();
            Statement s=con.createStatement();
                                            //Nombre de la tabla
            ResultSet rs=s.executeQuery("SELECT * FROM producto");
            
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
      public int RegistrarOrden(int id,int[] ids, double[] precios) {

        try {
            PreparedStatement ps = null;
            Connection con = getConexion();
            ResultSet rs = null;

            String sql;
           
            for (int i = 0; i < ids.length; i++) {
                
            
                sql = "call RegistrarOrden(?,?,?,?)";
                
                ps = con.prepareCall(sql);
                ps.setInt(1,id);
                ps.setInt(2,ids[i] );
                ps.setInt(3, 1);
                ps.setDouble(4, precios[i]);
         
                rs = ps.executeQuery();
                
              ///  JOptionPane.showMessageDialog(null, "Reserva Registrada");
                

            }
            return 1;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioSQL.class.getName()).log(Level.SEVERE, null, ex);
            return 33;
        }

    }
    
    
    
   public int asignarID(){
   int id=0;
     PreparedStatement ps = null;
            Connection con;
       try {
           con = getConexion();
             ResultSet rs = null;

            
            Statement stm = con.createStatement();
            //id,usuario,nombre,edad,genero,tipo
            
         
            rs = stm.executeQuery("SELECT COUNT(DISTINCT(IdOrden)) FROM orden");
         // primer fila. (El cursor inicia antes de la primer fila)
     if(rs.next()) {
       //Si hay resultados obtengo el valor. 
        id= rs.getInt(1);
        id++;
          
             return id;
     }
            
       } catch (SQLException ex) {
           Logger.getLogger(OrdenSQL.class.getName()).log(Level.SEVERE, null, ex);
       }
          
       
       
    return id;
   
   
  
   }
    
    
    
    
    
    
       public double TotalOrdenId(int id){
           double total=0;
     PreparedStatement ps = null;
            Connection con;
       try {
           con = getConexion();
             ResultSet rs = null;

            
            Statement stm = con.createStatement();
            //id,usuario,nombre,edad,genero,tipo
            
         
            rs = stm.executeQuery("SELECT SUM(Precio) from orden where IdOrden ="+id+"");
         // primer fila. (El cursor inicia antes de la primer fila)
     if(rs.next()) {
       //Si hay resultados obtengo el valor. 
       total= rs.getDouble(1);
       
          
             return total;
     }
            
       } catch (SQLException ex) {
           Logger.getLogger(OrdenSQL.class.getName()).log(Level.SEVERE, null, ex);
       }
          
       
       
    return total;
   
   
  
   }
    
    
    
    
    
    
    
    
}

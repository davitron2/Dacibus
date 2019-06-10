/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class OrdenSQL extends Conexion{
    
    
    
      public int RegistrarOrden(int[] ids, double[] precios) {

        try {
            PreparedStatement ps = null;
            Connection con = getConexion();
            ResultSet rs = null;

            String sql;
           int id= asignarID();
            for (int i = 0; i < ids.length; i++) {
                
            
                sql = "call RegistrarOrden(?,?,?,?)";
                //usuario,pass,nombre,edad,genero,tipo
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
   int id=1;
     PreparedStatement ps = null;
            Connection con;
       try {
           con = getConexion();
             ResultSet rs = null;

            String sql = "SELECT DISTINCT COUNT(IdOrden) from orden";
            //id,usuario,nombre,edad,genero,tipo
            ps = con.prepareStatement(sql);
         
            rs = ps.executeQuery();
            
           System.out.println(""+rs.toString());
            id++;
            System.out.println(""+id);
             return id;
       } catch (SQLException ex) {
           Logger.getLogger(OrdenSQL.class.getName()).log(Level.SEVERE, null, ex);
       }
          
       
       
    return id;
   
   
  
   }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

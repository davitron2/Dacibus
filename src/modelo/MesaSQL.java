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
 * @author Cesar
 */
public class MesaSQL extends Conexion{
    
    
    public int RegistrarMesa(Mesa mesa){
       try {
            PreparedStatement ps = null;
            Connection con;
            con = getConexion();
            ResultSet rs = null;

            String sql = "call ExisteMesa(?)";
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, mesa.getIdMesa());
            rs = ps.executeQuery();
            if (rs.next()) {

                JOptionPane.showMessageDialog(null, "Ya existe alguna mesa con ese Id Mesa");
                return 3;

            } else {

                sql = "call RegistrarMesa(?,?)";
                //usuario,pass,nombre,edad,genero,tipo
                ps = con.prepareCall(sql);
                ps.setInt(1, mesa.getIdMesa());
                ps.setString(2, mesa.getEdoMesa());
               
                rs = ps.executeQuery();
                 JOptionPane.showMessageDialog(null, "Registro exitoso");
                return 10;

            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioSQL.class.getName()).log(Level.SEVERE, null, ex);
            return 33;
        }
    
    
    }

    
    
}

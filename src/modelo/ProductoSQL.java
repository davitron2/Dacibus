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
public class ProductoSQL extends Conexion{
    
    public int RegistrarProducto(Producto produc){
       try {
            PreparedStatement ps = null;
            Connection con;
            con = getConexion();
            ResultSet rs = null;

            String sql = "call ExisteProducto(?)";
            
            ps = con.prepareStatement(sql);
            ps.setString(1, produc.getNombreProducto());
            rs = ps.executeQuery();
            if (rs.next()) {

                JOptionPane.showMessageDialog(null, "Ya existe un producto con ese nombre");
                return 3;

            } else {

                sql = "call RegistrarProducto(?,?,?)";
                //usuario,pass,nombre,edad,genero,tipo
                ps = con.prepareCall(sql);
                ps.setString(1, produc.getNombreProducto());
                ps.setString(2,produc.getCategoriaProducto() );
                ps.setInt(3, produc.getPrecioProducto());
               
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

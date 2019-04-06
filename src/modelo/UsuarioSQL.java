/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.ParseConversionEvent;

/**
 *
 * @author HP
 */
public class UsuarioSQL  extends Conexion {
    
    public boolean Registrar(user usr){
        try {
            PreparedStatement ps=null;
            Connection con = getConexion();
            
            String sql="call AgregarUsuario(?,?,?,?)";
            //String sql=" INSERT INTO usuario (IdUsuario,Nombre,Contraseña,Edad) VALUES ("+usr.getIdUser()+",'"+usr.getName()+"','"+usr.getPass()+"',"+usr.getEdad()+")";
            //nombre,password,edad,genero,tipo
            
            ps=con.prepareCall(sql);
            ps.setInt(1, usr.getIdUser());//id
            ps.setString(2, usr.getName());//nombre
            ps.setString(3, usr.getPass());//contrase;a
            ps.setInt(4, usr.getEdad());//edad
            ps.execute();
            return true;
     
           
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
     
      
     
    }
    
    /*public boolean Eliminar(Usuario usr){
     try {
            PreparedStatement ps=null;
            Connection con = getConexion();
            
            
            ///procedure que eliminar usuario con id recivido
            String sql="call EliminarUsuario(?,?,?,?,?)";
            //id,nombre,edad,genero,tipo
            ps=con.prepareCall(sql);
            ps.setInt(1, usr.getIdUsuario());
            ps.setString(2, usr.getNombreUsu());
            ps.setInt(3,usr.getEdad() );
            ps.setString(4, usr.getGenero());
            ps.setString(5,usr.getTipoUsuario());
            ps.execute();
            return true;
     
           
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
     
    
    }*/
    
    
    
    
}

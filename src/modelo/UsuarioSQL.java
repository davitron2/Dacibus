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
public class UsuarioSQL extends Conexion {

    public int Registrar(Usuario usr) {
        try {
            PreparedStatement ps = null;
            Connection con = getConexion();
            ResultSet rs = null;

            String sql = "call ExisteUsuario(?)";
            //id,usuario,nombre,edad,genero,tipo
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            rs = ps.executeQuery();
            if (rs.next()) {

                JOptionPane.showMessageDialog(null, "Ya existe alguien con ese nombre usuario");
                return 3;

            } else {

                sql = "call RegistrarUsuario(?,?,?,?,?,?)";
                //usuario,pass,nombre,edad,genero,tipo
                ps = con.prepareCall(sql);
                ps.setString(1, usr.getUsuario());
                ps.setString(2, usr.getPass());
                ps.setString(3, usr.getNombre());
                ps.setInt(4, usr.getEdad());
                ps.setString(5, usr.getGenero());
                ps.setString(6, usr.getTipoUsuario());
                rs = ps.executeQuery();
                 JOptionPane.showMessageDialog(null, "Registro exitoso");
                return 10;

            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioSQL.class.getName()).log(Level.SEVERE, null, ex);
            return 33;
        }

    }

    public boolean Eliminar(Usuario usr) {
                        
        try {
            PreparedStatement ps = null;
            Connection con = getConexion();

            ///procedure que eliminar usuario con id recivido
            String sql = "call EliminarUsuario(?)";
            //id,usuario,nombre,edad,genero,tipo
            ps = con.prepareCall(sql);
            //La eliminacion del usuario se hace con IDUSER pero es un dato autonumerico podemos cambiar a eliminar por nombre de usuario
            
            ps.setInt(1, usr.getIdUsuario());
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean ExisteUsuario(Usuario usr) {
        try {
            PreparedStatement ps = null;
            Connection con = getConexion();
            ResultSet rs = null;

            ///procedure que eliminar usuario con id recivido
            String sql = "call ExisteUsuario(?)";
            //id,usuario,nombre,edad,genero,tipo
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            rs = ps.executeQuery();
            if (rs.next()) {

                return true;
            } else {

                return false;

            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public int Login(Usuario usr) {
        try {
            PreparedStatement ps = null;
            Connection con = getConexion();
            ResultSet rs = null;

            ///procedure que eliminar usuario con id recivido
            String sql = "call ExisteUsuario(?)";
            //id,usuario,nombre,edad,genero,tipo
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            rs = ps.executeQuery();

            if (rs.next()) {
                rs = null;
                ps = null;
                // String sql2 = "select Pass from usuario where Usuario=? and Pass=?";

                String sql2 = "call VerificaPass(?,?)";

                ps = con.prepareStatement(sql2);
                ps.setString(1, usr.getUsuario());
                ps.setString(2, usr.getPass());
                rs = ps.executeQuery();

                if (rs.next()) {
                    System.out.println("valida");
                    return 1;

                } else {

                    System.out.println("contraseña invalida");
                    return 9;
                }

            } else {

                System.out.println("usuario no existe");
                return 10;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioSQL.class.getName()).log(Level.SEVERE, null, ex);
            return 10;
        }
    }
    

}

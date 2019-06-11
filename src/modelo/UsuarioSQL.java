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
                return 10;

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
                return 1;

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
     public Usuario IdTipo(String Usuario){
           Usuario us= new Usuario();
     PreparedStatement ps = null;
            Connection con;
       try {
           con = getConexion();
             ResultSet rs = null;

            
            Statement stm = con.createStatement();
            //id,usuario,nombre,edad,genero,tipo
            
         
            rs = stm.executeQuery("SELECT usuario.IdUsuario, usuario.TipoUsuario from usuario WHERE usuario.Usuario='"+Usuario+"'");
         // primer fila. (El cursor inicia antes de la primer fila)
     if(rs.next()) {
       //Si hay resultados obtengo el valor. 
       us.setIdUsuario(rs.getInt(1));
       us.setTipoUsuario(rs.getString(2));
       
          
             return us;
     }
            
       } catch (SQLException ex) {
           Logger.getLogger(OrdenSQL.class.getName()).log(Level.SEVERE, null, ex);
       }
          
       
       
    return us;
   
   
  
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

    public JTable BuscarTabla(JTable tabla, String dato) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        PreparedStatement ps = null;
        Connection con = getConexion();
        Statement s = con.createStatement();
        //Nombre de la tabla

        String sql = "call ExisteUsuario(?)";
        ResultSet rs = s.executeQuery("SELECT * FROM usuario WHERE Nombre LIKE '%" + dato + "%'");

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

    public JTable SoloTabla(JTable tabla) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        PreparedStatement ps = null;
        Connection con = getConexion();
        Statement s = con.createStatement();
        //Nombre de la tabla
        ResultSet rs = s.executeQuery("SELECT * FROM usuario");

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

    public int ActualizarProducto(Usuario user, int IdUser) {
        try {
            PreparedStatement ps = null;
            Connection con;
            con = getConexion();
            ResultSet rs = null;

            String sql = "call ExisteUsuario(?)";

            ps = con.prepareStatement(sql);
            ps.setInt(1, IdUser);
            rs = ps.executeQuery();
            if (rs.next()) {

                sql = "call ActualizarUsuario(?,?,?,?,?,?,?)";

                ps = con.prepareCall(sql);
                ps.setInt(1, IdUser);
                ps.setString(2, user.getUsuario());
                ps.setString(3, user.getPass());
                ps.setString(4, user.getNombre());
                ps.setInt(5, user.getEdad());
                ps.setString(6, user.getGenero());
                ps.setString(7, user.getTipoUsuario());

                rs = ps.executeQuery();
                JOptionPane.showMessageDialog(null, "Actalizacion exitosa");
                return 10;

            } else {
                JOptionPane.showMessageDialog(null, "No existe ese usuario");
                return 3;

            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioSQL.class.getName()).log(Level.SEVERE, null, ex);
            return 33;
        }
    }

}

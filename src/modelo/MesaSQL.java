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
 * @author Cesar
 */
public class MesaSQL extends Conexion {

    public int RegistrarMesa(Mesa mesa) {
        try {
            PreparedStatement ps = null;
            Connection con;
            con = getConexion();
            ResultSet rs = null;

            String sql = "call ExisteMesa(?)";

            ps = con.prepareStatement(sql);
            ps.setInt(1, mesa.getNumeroMesa());
            rs = ps.executeQuery();
            if (rs.next()) {

                JOptionPane.showMessageDialog(null, "Ya existe alguna mesa con ese numero de Mesa");
                return 3;

            } else {

                sql = "call RegistrarMesa(?,?,?)";
                ps = con.prepareCall(sql);
                ps.setInt(1, mesa.getNumeroMesa());
                ps.setInt(2, mesa.getCapacidadMesa());
                ps.setString(3, mesa.getEstadoMesa());

                rs = ps.executeQuery();
                JOptionPane.showMessageDialog(null, "Registro exitoso");
                return 10;

            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioSQL.class.getName()).log(Level.SEVERE, null, ex);
            return 33;
        }
    }

    public JTable SoloMesa(JTable tabla, int op) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        PreparedStatement ps = null;
        Connection con = getConexion();
        Statement s = con.createStatement();
        //Nombre de la tabla
        ResultSet rs;
      
                                            //Nombre de la tabla
                                            if(op==1){
             rs=s.executeQuery("SELECT * FROM mesa");
                                            }else{
                             rs=s.executeQuery("SELECT IdMesa,NumeroMesa,Capacidad FROM mesa");
                                            
                                            
                                            }
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

    public JTable BuscarTabla(JTable tabla, int dato) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        PreparedStatement ps = null;
        Connection con = getConexion();
        Statement s = con.createStatement();
        //Nombre de la tabla
        ResultSet rs = s.executeQuery("SELECT * FROM mesa WHERE NumeroMesa LIKE '%" + dato + "%'");

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

    public int ActualizarProducto(Mesa mesa, int idMesa) {
        try {
            PreparedStatement ps = null;
            Connection con;
            con = getConexion();
            ResultSet rs = null;

            String sql = "call ExisteMesa(?)";

            ps = con.prepareStatement(sql);
            ps.setInt(1, idMesa);
            rs = ps.executeQuery();
            if (rs.next()) {

                sql = "call ActualizarMesa(?,?,?,?)";

                ps = con.prepareCall(sql);
                ps.setInt(1, idMesa);
                ps.setInt(2, mesa.getNumeroMesa());
                ps.setInt(3, mesa.getCapacidadMesa());
                ps.setString(4, mesa.getEstadoMesa());

                rs = ps.executeQuery();
                JOptionPane.showMessageDialog(null, "Actalizacion exitosa");
                return 10;

            } else {
                JOptionPane.showMessageDialog(null, "No existe esa Mesa");
                return 3;

            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioSQL.class.getName()).log(Level.SEVERE, null, ex);
            return 33;
        }
    }

    public boolean Eliminar(int id) {

        try {
            PreparedStatement ps = null;
            Connection con = getConexion();

            ///procedure que eliminar usuario con id recivido
            String sql = "call EliminarMesa(?)";
            //id,usuario,nombre,edad,genero,tipo
            ps = con.prepareCall(sql);
            //La eliminacion del usuario se hace con IDUSER pero es un dato autonumerico podemos cambiar a eliminar por nombre de usuario

            ps.setInt(1, id);
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}

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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cesar
 */
public class VentaSQL extends Conexion {

    public JTable SoloTabla(JTable tabla) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        PreparedStatement ps = null;
        Connection con = getConexion();
        Statement s = con.createStatement();
        //Nombre de la tabla
        ResultSet rs = s.executeQuery("SELECT * FROM cuenta");

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

    public JTable BuscarTabla(JTable tabla, String dato) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        PreparedStatement ps = null;
        Connection con = getConexion();
        Statement s = con.createStatement();
        //Nombre de la tabla
        ResultSet rs = s.executeQuery("SELECT * FROM cuenta WHERE IdCuenta LIKE '%" + dato + "%'");

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
    
   
     public JTable BuscarTablaFecha(JTable tabla, String dato) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        PreparedStatement ps = null;
        Connection con = getConexion();
        Statement s = con.createStatement();
        //Nombre de la tabla
        ResultSet rs = s.executeQuery("SELECT * FROM cuenta WHERE Fecha LIKE '" + dato + "'");

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

}

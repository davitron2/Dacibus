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
    
    
    public boolean ConsultaProducto(Producto produc) {
        try {
            PreparedStatement ps = null;
            Connection con = getConexion();
            ResultSet rs = null;

            ///procedure que eliminar usuario con id recivido
            String sql = "call BuscarProducto(?)";
            //id,usuario,nombre,edad,genero,tipo
            ps = con.prepareStatement(sql);
            ps.setString(1,produc.getNombreProducto());
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
    
    
    public JTable BuscarTabla(JTable tabla,String dato) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
            PreparedStatement ps=null;
            Connection con = getConexion();
            Statement s=con.createStatement();
                                            //Nombre de la tabla
            ResultSet rs=s.executeQuery("SELECT * FROM producto WHERE NombrePro LIKE '%"+dato+"%'");
            
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
    
    
    
    
    
}

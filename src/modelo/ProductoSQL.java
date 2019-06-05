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
                ps.setDouble(3, produc.getPrecio());
               
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
            ResultSet rs=s.executeQuery("SELECT * FROM producto WHERE Nombre LIKE '%"+dato+"%'");
            
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
        
         
         public boolean Eliminar(Producto produc) {
                        
        try {
            PreparedStatement ps = null;
            Connection con = getConexion();

            ///procedure que eliminar usuario con id recivido
            String sql = "call EliminarProducto(?)";
            //id,usuario,nombre,edad,genero,tipo
            ps = con.prepareCall(sql);
            //La eliminacion del usuario se hace con IDUSER pero es un dato autonumerico podemos cambiar a eliminar por nombre de usuario
            
            ps.setString(1, produc.getNombreProducto());
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
         
         
         
         public int ActualizarProducto(Producto produc,int idProducto){
       try {
            PreparedStatement ps = null;
            Connection con;
            con = getConexion();
            ResultSet rs = null;

            String sql = "call ExisteProducto(?)";
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, idProducto);
            rs = ps.executeQuery();
            if (rs.next()) {
                
                sql = "call ActualizarProducto(?,?,?,?)";
                
                ps = con.prepareCall(sql);
                ps.setInt(1, idProducto);
                ps.setString(2, produc.getNombreProducto());
                ps.setString(3,produc.getCategoriaProducto() );
                ps.setDouble(4, produc.getPrecio());
                
                rs = ps.executeQuery();
                 JOptionPane.showMessageDialog(null,"Actalizacion exitosa");
                return 10;
                
                
                
                
            } else {
                JOptionPane.showMessageDialog(null, "No existe ese producto");
                return 3;


            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioSQL.class.getName()).log(Level.SEVERE, null, ex);
            return 33;
        }
    }
         
         
         
         
    
}

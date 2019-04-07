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
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
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
    
    
    

          
        
        
    


    
    
    
    
    public JTable MostrarTabla(JTable tabla) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
            PreparedStatement ps=null;
            Connection con = getConexion();
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery("SELECT * FROM mesas");
            
            DefaultTableModel modelo=new DefaultTableModel();
            JTable tab=new JTable(modelo);
            
           
            ResultSetMetaData metaDatos=rs.getMetaData();
            int NumeroColumnas=metaDatos.getColumnCount();
            
            Object[] etiquetas=new Object[NumeroColumnas];
            
            for (int i = 0; i < NumeroColumnas; i++) {
                etiquetas[i]=metaDatos.getColumnLabel(i+1);    
            }
            modelo.setColumnIdentifiers(etiquetas);            
            //Creamos las columnas
            //modelo.addColumn("IdMesa");
            //modelo.addColumn("EstadoMesa");

            //Recuperar cada resultado
            
                while(rs.next()){
                Object[] fila=new Object[modelo.getColumnCount()];
                
                for (int i = 0; i < modelo.getColumnCount(); i++) {
                    fila[i]=rs.getObject(i+1);
                }
                modelo.addRow(fila);
            }
                
               /* while(rs.next()){
                String fila[]=new String[modelo.getColumnCount()];
                for(int j=0;j<modelo.getColumnCount();j++){
                    fila[j]=rs.getString(j+1);
                }
                modelo.addRow(fila);
            }*/
               rs.close();
               tabla.setModel(modelo);
                
        return tabla;    
        
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

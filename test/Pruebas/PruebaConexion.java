/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import java.sql.Connection;
import java.sql.SQLException;
import modelo.Conexion;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cesar
 */
public class PruebaConexion {
    
    public PruebaConexion() {
    }
    
    
    //Fallas para comparar los objetos conexion 
    //ESPERADO no se puede definir
    @Test
    public void PruebaConexion() throws SQLException{
        modelo.Conexion ob=new Conexion();
        
        Connection result=ob.getConexion();
        
        
        
        
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

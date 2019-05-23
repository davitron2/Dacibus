/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import modelo.Mesa;
import modelo.MesaSQL;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cesar
 */
public class PruebaRegistroMesa {
    
    @Test
    public void RegistroMesa(){
        modelo.Mesa mesa=new Mesa();
        modelo.MesaSQL ob=new MesaSQL();
        mesa.setNumMe(1);
        mesa.setCapacidad(4);
        mesa.setEdoMesa("Libre");
        
        mesa.setEdoMesa("Libre");
        
        int result=ob.RegistrarMesa(mesa);
        int esperado=10;
        
        assertEquals(result, esperado);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import modelo.Usuario;
import modelo.UsuarioSQL;
import modelo.hash;
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
public class PruebaRegistroUser {
    
    public PruebaRegistroUser() {
    
    }
    
    @Test
    public void testRegistro(){
        modelo.UsuarioSQL ob=new UsuarioSQL();
        
        modelo.Usuario usr=new Usuario();
        usr.setNombre("Cesar01");
        usr.setEdad(21);
        usr.setGenero("H");
        usr.setTipoUsuario("Administrdor");
        usr.setUsuario("CesarDxD");
        String contra = new String("123");
        String npass = hash.sha1(contra);
        usr.setPass(npass);
        
        
        
        
        int result=ob.Registrar(usr);
        
        int esperado=10;
        
        assertEquals(result,esperado);
        
    }
   
    
   
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

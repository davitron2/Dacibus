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
public class PruebaLogin {
    
    @Test
    public void Login(){
        modelo.UsuarioSQL user=new UsuarioSQL();
        modelo.Usuario usr=new Usuario();
        usr.setUsuario("CesarDxD");
        String contra = new String("123");
        String npass = hash.sha1(contra);
        usr.setPass(npass);
        
        int experado=1;
        int result=user.Login(usr);
        
        assertEquals(experado, result);
        
        
        
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

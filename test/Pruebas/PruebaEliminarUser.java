/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import modelo.Usuario;
import modelo.UsuarioSQL;
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
public class PruebaEliminarUser {
    
    @Test
    public void ElimnaU(){
        modelo.UsuarioSQL obj=new UsuarioSQL();
        modelo.Usuario usr=new Usuario();
        usr.setIdUsuario(8);
        
        obj.Eliminar(usr);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.sql.SQLException;
import java.util.HashSet;
import java.util.Scanner;
import modelo.hash;


public class PruebaDeConsultas {

    
    public static void main(String[] args) throws SQLException {
            Usuario usuario= new Usuario();
    UsuarioSQL SqlU= new UsuarioSQL();
    
        int op=0;
        Scanner datos= new Scanner(System.in);
        System.out.println("1-registrar");
        System.out.println("2-eliminar");
        System.out.println("3- login");
        op=datos.nextInt();
        switch(op){
            case 1:
        System.out.println("usuario");
        
        usuario.setUsuario("davitron2");
       
                System.out.println("contraseña");
                String contra= "hola";
                 String npass = hash.sha1(contra);
                 
                 System.out.println("nomrbe");
                 usuario.setNombre("david alberto");
                 
                 usuario.setPass(npass);
                 System.out.println("edad");
                usuario.setEdad(34);
                
                System.out.println("genero");
                usuario.setGenero("h");
                
                System.out.println("tipo usuario");
                usuario.setTipoUsuario("admin");
            
                
                if(SqlU.Registrar(usuario)){
                    System.out.println("registro exitoso");
                
                
                }else{
                
                
                    System.out.println("error");
                
                }
                
                   break;
            case 2:
                System.out.println("id a borrar");
                usuario.setIdUsuario(5);
              
                SqlU.Eliminar(usuario);
               
                
                
                
                break;
            case 3:
               
               usuario.setUsuario("davitron2");
               
               
               contra= "hola";
                 npass = hash.sha1(contra);
               usuario.setPass(npass);
               SqlU.Login(usuario);
                
                
                
                break;
        
        }
    }
    
}

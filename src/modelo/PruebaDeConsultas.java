/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.util.HashSet;
import java.util.Scanner;
import modelo.hash;


public class PruebaDeConsultas {

    
    public static void main(String[] args) {
            Usuario usuario= new Usuario();
    UsuarioSQL SqlU= new UsuarioSQL();
    
        int op=0;
        Scanner datos= new Scanner(System.in);
        System.out.println("1-registrar");
        System.out.println("2-eliminar");
        op=datos.nextInt();
        switch(op){
            case 1:
        System.out.println("nombre usuario");
        
        usuario.setNombreUsu("yo");
       
                System.out.println("contraseña");
                String contra= "queso123";
                 String npass = hash.sha1(contra);
                 
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
                usuario.setIdUsuario(3);
              
                SqlU.Eliminar(usuario);
               
                
                
                
                break;
        
        }
    }
    
}

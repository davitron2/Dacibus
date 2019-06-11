
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    
   
    private final String usuario ="sql9295141";
    private final String password ="VXAiK1fT34";                    //basededatosis
    private final String url ="jdbc:mysql://sql9.freesqldatabase.com:3306/sql9295141?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    ///private final String url ="jdbc:mysql://localhost:3306/da2?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    // private final String usuario ="root";
    //private final String password ="";       
    private Connection con = null;
    public Connection getConexion() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(url,usuario,password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return con;
    }
    
    
}


package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    
   
    private final String usuario ="root";
    private final String password ="";                    //basededatosis
    private final String url ="jdbc:mysql://localhost:3306/da2?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
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

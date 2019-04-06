
package modelo;

import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    
   
    private final String usuario ="root";
    private final String password ="";
    private final String url ="jdbc:mysql://localhost:3306/pruebas?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
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


package tienda;
import java.sql.*;

public class Conexion {
    
    private static String url = "jdbc:sqlite:Tienda.db";
    Connection con;
    
    public Conexion() {
        
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println(e);
        }
       
    }
    
    public Connection getConexion(){
        return con;
    }
    
}

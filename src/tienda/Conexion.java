
package tienda;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Conexion {
    
    private static String url = "jdbc:sqlite:Tienda.db";
    Connection con;
    
    public Conexion() {
        
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e, "Error al conectar con la Base de datos", 0, new ImageIcon(getClass().getResource("/imagenes/errorBD.png")));
        }
       
    }
    
    public Connection getConexion(){
        return con;
    }
    
}

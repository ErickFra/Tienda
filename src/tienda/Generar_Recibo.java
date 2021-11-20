
package tienda;
import javax.swing.JTable;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class Generar_Recibo {
    
    private FileWriter escribir;
    private File archivo;
    private Connection c;
    private Statement st;
    private ResultSet rs;
    private String sql;
    private Conexion con;
    public Generar_Recibo(JTable tabla, int id, float total) {
        
        try {
            archivo = new File("documento"+id+".txt");
            escribir = new FileWriter(archivo);
            con = new Conexion();
            c = con.getConexion();
            st = c.createStatement();
            
            escribir.write("\t\t\t\t ------------ Productos ------------".toUpperCase() + "\n\n");
            escribir.write("\t ****************************************************\n\n");
            for (int i = 0; i < tabla.getRowCount(); i++){
                sql = "SELECT PP.nombre, P.nombre FROM productos as P INNER JOIN proveedor as PP ON P.id_proveedor = PP.id WHERE P.id = "+tabla.getValueAt(i, 0)+" ";
                rs = st.executeQuery(sql);
                escribir.write("\t" + rs.getString(1) + " ---> " + "\t " + tabla.getValueAt(i, 1).toString() + "(");
                escribir.write(tabla.getValueAt(i, 2).toString() + ") * ");
                escribir.write(tabla.getValueAt(i, 3).toString() + " ---> ");
                escribir.write(tabla.getValueAt(i, 4).toString());
                escribir.write("\n\n");
            }
            escribir.write("\t\t Total: $" + total + "\n\n");
            escribir.write("\t ****************************************************\n\n");
            escribir.write("\t ****************************************************\n\n");
            escribir.write("\t\t Gracias por su compra".toUpperCase()+"\n\n");
            escribir.write("\t ****************************************************\n");
                        
            escribir.close();
            c.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error al generar el archivo...", 0, new ImageIcon(getClass().getResource("/imagenes/error.png")));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error SQL", 0, new ImageIcon(getClass().getResource("/imagenes/errorSQL.png")));
        }
        
    }
    
    public void eliminarArchivo(){
        archivo.delete();
    }
    
    
}

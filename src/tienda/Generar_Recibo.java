
package tienda;
import javax.swing.JTable;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class Generar_Recibo {
    
    private FileWriter escribir;
    private File archivo;
    public Generar_Recibo(JTable tabla, int id, float total) {
        
        try {
            archivo = new File("documento"+id+".txt");
            escribir = new FileWriter(archivo);
            
            escribir.write("\t ------------ Productos ------------".toUpperCase() + "\n\n");
            escribir.write("****************************************************\n\n");
            for (int i = 0; i < tabla.getRowCount(); i++){
                escribir.write(tabla.getValueAt(i, 1).toString() + "(");
                escribir.write(tabla.getValueAt(i, 2).toString() + ") * ");
                escribir.write(tabla.getValueAt(i, 3).toString() + " ---> ");
                escribir.write(tabla.getValueAt(i, 4).toString());
                escribir.write("\n\n");
            }
            escribir.write("\t\t Total: $" + total + "\n\n");
            escribir.write("****************************************************\n\n");
            escribir.write("****************************************************\n\n");
            escribir.write("\t\t Gracias por su compra".toUpperCase()+"\n\n");
            escribir.write("****************************************************\n");
                        
            escribir.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error al generar el archivo...", 0, new ImageIcon(getClass().getResource("/imagenes/error.png")));
            //System.out.println("Error al generar el archiovo...\n" + ex);
        }
        
    }
    
    public void eliminarArchivo(){
        archivo.delete();
    }
    
    
}


package tienda;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class Productos extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    Conexion con;
    public static String seleccion = "";
    public static float suma = 0;
    
    public Productos() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/productos.png")).getImage());
        seleccionar.setVisible(false);
        
        modelo.addColumn("ID");
        modelo.addColumn("Proveedor");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("PRESIO");
        
        productos.setModel(modelo);
        
        informacion();
        
        productos.setSelectionBackground(Color.green);
        
    }

    public void informacion(){
        Connection c;
        ResultSet rs;
        Statement st;
        String sql = "SELECT * FROM productos";  
        String filas [] = new String [5];
        
        try {
            con = new Conexion();
            c = con.getConexion();
            st = c.createStatement();
            rs = st.executeQuery(sql);
            
            while (rs.next()){
                filas[0] = String.valueOf(rs.getInt(1));
                filas[1] = String.valueOf(rs.getInt(2));
                filas[2] = rs.getString(3);
                filas[3] = String.valueOf(rs.getInt(4));
                filas[4] = String.valueOf(rs.getString(5));
                modelo.addRow(filas);
            }
            for (int i = 0; i < productos.getRowCount(); i++){
                if (Integer.parseInt(productos.getValueAt(i, 3).toString()) == 0){
                    modelo.removeRow(i);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error en instruccion SQL", 0, new ImageIcon(getClass().getResource("/imagenes/errorSQL.png")));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = /*new javax.swing.JPanel()*/ new gradientPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        seleccionar = new javax.swing.JButton();
        busqueda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PRODUCTOS");

        productos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        productos.setFocusable(false);
        productos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(productos);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Productos Registrados.");

        seleccionar.setFont(new java.awt.Font("Trebuchet MS", 3, 18)); // NOI18N
        seleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/paloma.png"))); // NOI18N
        seleccionar.setText("SELECCIONAR");
        seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarActionPerformed(evt);
            }
        });

        busqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                busquedaKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Buscar producto: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(seleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(27, 27, 27)
                        .addComponent(busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 82, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(busqueda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(seleccionar)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void seleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarActionPerformed
        
        int fila = productos.getSelectedRow();
        if (fila >= 0){
            
            seleccion = productos.getValueAt(fila, 0).toString();
            Conexion con;
            Connection c;
            Statement st;
            ResultSet rs;
            String sql = "SELECT id, nombre, precio FROM productos WHERE id = " + Integer.parseInt(Productos.seleccion) + "";
            try {
                con = new Conexion();
                c = con.getConexion();
                st = c.createStatement();
                rs = st.executeQuery(sql);

                int cantidad;
                String cantidadS = (String) JOptionPane.showInputDialog(null, "Cuantos le gustaria ordenar:", "Cantidad de productos", JOptionPane.QUESTION_MESSAGE, new ImageIcon(getClass().getResource("/imagenes/pensando.png")), null, "Productos");
                
                
                try {
                    cantidad = Integer.parseInt(cantidadS);
                    if (cantidad > 0 && cantidad < Integer.parseInt(productos.getValueAt(productos.getSelectedRow(), 3).toString())){
                        
                        while (rs.next()){
                            
                            Compra_Venta.modelo.addRow(new Object []
                            {
                                rs.getInt(1), 
                                rs.getString(2), 
                                rs.getFloat(3), 
                                cantidad, 
                                rs.getFloat(3) * cantidad
                            });

                        }
                        c.close();
                        if (Compra_Venta.compras.getRowCount() == 0) Compra_Venta.irCompra.setEnabled(false); else Compra_Venta.irCompra.setEnabled(true);
                    }else JOptionPane.showMessageDialog(null, "La cantidad no es valida", "Error de cantidad", 0, new ImageIcon(getClass().getResource("/imagenes/errorNumero.png")));
                } catch (Exception e) {
                    
                    if (!"null".equals(e.getMessage())) JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(),  "Por favor, numeros (enteros)", 0, new ImageIcon(getClass().getResource("/imagenes/numeros.png")));
                }
                

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Error en instruccion SQL", 0, new ImageIcon(getClass().getResource("/imagenes/errorSQL.png")));
            }
            
            
        }else{
            
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila.", "Sin selecccion", 0, new ImageIcon(getClass().getResource("/imagenes/advertencia.png")));
            
        }
        suma = 0;
        for (int i = 0; i < Compra_Venta.compras.getRowCount(); i++){ 
            suma += Float.parseFloat(Compra_Venta.compras.getValueAt(i, 4).toString());
        }
        
        Compra_Venta.total.setText("Total : " + suma);
        
        
    }//GEN-LAST:event_seleccionarActionPerformed

    private void busquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_busquedaKeyReleased
        
        int to = productos.getRowCount();
        for (int i = 0; i < to; i++){
            modelo.removeRow(0);
        }
        Conexion con;
        Connection c;
        Statement st;
        ResultSet rs;
        String sql = "SELECT * FROM productos WHERE nombre LIKE '%"+busqueda.getText()+"%'";
        String filas [] = new String[5];
        
        try {
            con = new Conexion();
            c = con.getConexion();
            st = c.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                filas[0] = String.valueOf(rs.getInt(1));
                filas[1] = String.valueOf(rs.getInt(2));
                filas[2] = rs.getString(3);
                filas[3] = String.valueOf(rs.getInt(4));
                filas[4] = String.valueOf(rs.getString(5));
                modelo.addRow(filas);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en instruccion SQL", 0, new ImageIcon(getClass().getResource("/imagenes/errorSQL.png")));
        }
        
    }//GEN-LAST:event_busquedaKeyReleased

    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Productos().setVisible(true);
            }
        });
    }
    
    class gradientPanel extends JPanel {
        protected void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D) g;
            int ancho = getWidth();
            int alto = getHeight();
            
            Color color1 = new Color(52, 143, 80);
            Color color2 = new Color(86, 180, 211);
            GradientPaint gp = new GradientPaint(0, 0, color1, 180, ancho-alto, color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, ancho, alto);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField busqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable productos;
    public static javax.swing.JButton seleccionar;
    // End of variables declaration//GEN-END:variables
}

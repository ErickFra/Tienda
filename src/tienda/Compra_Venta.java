
package tienda;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Compra_Venta extends javax.swing.JFrame {

    public static DefaultTableModel modelo;
    public Compra_Venta() {
        initComponents();
        this.setTitle("Cliente: " + Inicio_Secion.Dnombre + " " +Inicio_Secion.Dapellido);
        this.setLocationRelativeTo(null);
        
        modelo = new DefaultTableModel();
        modelo.addColumn("ID_PRODUCTOS");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("PRECIO");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("CARGO");
        jTable1.setModel(modelo);
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        irProductos = new javax.swing.JButton();
        total = new javax.swing.JLabel();
        irCompra = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        irProductos.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        irProductos.setText("Productos");
        irProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irProductosActionPerformed(evt);
            }
        });

        total.setFont(new java.awt.Font("Trebuchet MS", 3, 18)); // NOI18N

        irCompra.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        irCompra.setText("Comprar");
        irCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(total)
                .addGap(160, 160, 160))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(irProductos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(irCompra)
                .addGap(109, 109, 109))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(197, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(irProductos)
                    .addComponent(irCompra))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(total)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void irProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irProductosActionPerformed

        Productos productos = new Productos();
        Productos.seleccionar.setVisible(true);
        productos.setVisible(true);
    }//GEN-LAST:event_irProductosActionPerformed

    private void irCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irCompraActionPerformed

        int comprobacion = JOptionPane.showConfirmDialog(null, "¿Realiazar compra?", "Confirmacion", JOptionPane.YES_NO_OPTION, 3);
        
        if (comprobacion == 0){
            
            Conexion con;
            Connection c;
            
            Correo correo;
            Statement st;
            ResultSet rs;
            
            PreparedStatement ppt;
            
            String sql = "SELECT * FROM registro WHERE id = " + Inicio_Secion.id +"";
            String sql2 = "INSERT INTO compra_venta (id_registro, total, fecha) VALUES (?, ?, DATETIME('now', 'localtime'))";
            //String sql3 = "UPDATE productos set cantidad = cantidad - (?) WHERE id = ?";
            
            try {
                
                con = new Conexion();
                c = con.getConexion();
                ppt = c.prepareStatement(sql2);
                
                ppt.setInt(1, Inicio_Secion.id);
                ppt.setFloat(2, (float) Productos.suma);
                
                ppt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Compra exitosa", "Procesando...", JOptionPane.INFORMATION_MESSAGE);
                c.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Error al registrar", JOptionPane.ERROR_MESSAGE);
            }
            // ENVIO DEL CORREO. 
            
            try {
                con = new Conexion();
                c = con.getConexion();
            
                st = c.createStatement();
                rs = st.executeQuery(sql);

                String mail = rs.getString(4);

                correo = new Correo(mail, "Tus productos estan listo.\nPor favor, pase a la caja.\nSerian: $" + Productos.suma);
                correo.enviar();
                
                rs.close();
                st.close();
                c.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Error al enviar el correo", JOptionPane.ERROR_MESSAGE);
            }
            
            // ACTUALIZACION DE LOS DATOS.
            try {
                con = new Conexion();
                c = con.getConexion();
                
                for (int i = 0; i < jTable1.getRowCount(); i++){
                    ppt = c.prepareStatement("UPDATE productos SET cantidad = cantidad - " + jTable1.getValueAt(i, 3) + " WHERE id = "+jTable1.getValueAt(i, 0)+" ");
                    ppt.executeUpdate();
                }
                c.close();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Error al actulizar productos", JOptionPane.ERROR_MESSAGE);
        }
            //Inicio inicio = new Inicio();
            //inicio.setVisible(true);
            //this.setVisible(false);
        
        }else{
            total.setText(null);
        }
        
        
        
    }//GEN-LAST:event_irCompraActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compra_Venta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton irCompra;
    private javax.swing.JButton irProductos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    public static javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}

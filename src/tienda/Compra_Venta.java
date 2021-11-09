
package tienda;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Compra_Venta extends javax.swing.JFrame {

    public static DefaultTableModel modelo;
    public Compra_Venta() {
        initComponents();
        this.setTitle("Cliente: " + Inicio_Secion.Dnombre + " " +Inicio_Secion.Dapellido);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/perfil.png")).getImage());
        
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
        irProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/productos.png"))); // NOI18N
        irProductos.setText("Productos");
        irProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irProductosActionPerformed(evt);
            }
        });

        total.setFont(new java.awt.Font("Trebuchet MS", 3, 18)); // NOI18N

        irCompra.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        irCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/comprar.png"))); // NOI18N
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
                .addGap(39, 39, 39)
                .addComponent(irProductos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(irCompra)
                .addGap(107, 107, 107))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(187, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(irCompra)
                    .addComponent(irProductos))
                .addGap(28, 28, 28)
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
            
            Generar_Recibo recibo = new Generar_Recibo(jTable1, Inicio_Secion.id, Productos.suma);
            try {
                
                con = new Conexion();
                c = con.getConexion();
                ppt = c.prepareStatement(sql2);
                
                ppt.setInt(1, Inicio_Secion.id);
                ppt.setFloat(2, (float) Productos.suma);
                
                ppt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Compra exitosa", "Procesando...", 1, new ImageIcon(getClass().getResource("/imagenes/ok.png")));
                c.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Error en instruccion SQL", 0, new ImageIcon(getClass().getResource("/imagenes/errorSQL.png")));
                //JOptionPane.showMessageDialog(null, e, "Error al registrar", 0, new ImageIcon(getClass().getResource("/imagenes/error.png")));
            }
            // ENVIO DEL CORREO. 
            
            try {
                con = new Conexion();
                c = con.getConexion();
            
                st = c.createStatement();
                rs = st.executeQuery(sql);

                String mail = rs.getString(4);

                correo = new Correo(mail, "Tus productos estan listo.\nPor favor, pase a la caja.\nSerian: $" + Productos.suma, "Compra de productos");
                //correo.enviar();
                correo.enviar("documento"+Inicio_Secion.id+".txt");
                
                rs.close();
                st.close();
                c.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Error al enviar el correo", 0, new ImageIcon(getClass().getResource("/imagenes/error.png")));
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
                JOptionPane.showMessageDialog(null, e, "Error al actulizar productos", 0, new ImageIcon(getClass().getResource("/imagenes/error.png")));
        }
            //Inicio inicio = new Inicio();
            //inicio.setVisible(true);
            //this.setVisible(false);
            recibo.eliminarArchivo();
        
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

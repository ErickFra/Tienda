
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
public class Compra_Venta extends javax.swing.JFrame {

    public static DefaultTableModel modelo;
    public Compra_Venta() {
        initComponents();
        this.setTitle("Cliente: " + Inicio_Secion.Dnombre + " " +Inicio_Secion.Dapellido);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/perfil.png")).getImage());
        
        modelo = new DefaultTableModel();
        modelo.addColumn("ID_PRODUCTOS");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("PRECIO");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("CARGO");
        compras.setModel(modelo);
        compras.setSelectionBackground(Color.green);
        
        irCompra.setEnabled(false); 
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = /*new javax.swing.JPanel()*/new gradientPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        compras = new javax.swing.JTable();
        irProductos = new javax.swing.JButton();
        total = new javax.swing.JLabel();
        irCompra = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        compras = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        compras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        compras.setFocusable(false);
        compras.getTableHeader().setResizingAllowed(false);
        compras.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(compras);

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

        salir.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        eliminar.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(total)
                .addGap(160, 160, 160))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(irProductos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(irCompra)
                        .addGap(43, 43, 43)
                        .addComponent(eliminar)
                        .addGap(42, 42, 42)
                        .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(185, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(irCompra)
                    .addComponent(irProductos)
                    .addComponent(salir)
                    .addComponent(eliminar))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(total)
                .addGap(30, 30, 30))
        );

        jMenu1.setText("Cuenta");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Compras");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Actualizar Datos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        int comprobacion = JOptionPane.showConfirmDialog(null, "¿Realiazar compra?", "Confirmacion", JOptionPane.YES_NO_OPTION, 3, new ImageIcon(getClass().getResource("/imagenes/pensando.png")));
        
        if (comprobacion == 0){
            
            Conexion con;
            Connection c;
            
            Correo correo;
            Statement st;
            ResultSet rs;
            
            PreparedStatement ppt;
            
            String sql = "SELECT * FROM registro WHERE id = " + Inicio_Secion.id +"";
            String sql2 = "INSERT INTO compra_venta (id_registro, total, fecha) VALUES (?, ?, DATETIME('now', 'localtime'))";
            
            Generar_Recibo recibo = new Generar_Recibo(compras, Inicio_Secion.id, Productos.suma);
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
                
                for (int i = 0; i < compras.getRowCount(); i++){
                    ppt = c.prepareStatement("UPDATE productos SET cantidad = cantidad - " + compras.getValueAt(i, 3) + " WHERE id = "+compras.getValueAt(i, 0)+" ");
                    ppt.executeUpdate();
                }
                c.close();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Error al actulizar productos", 0, new ImageIcon(getClass().getResource("/imagenes/error.png")));
        }

             
            int t = compras.getRowCount();
            for (int k = 0; k < t; k++){
                this.modelo.removeRow(0);
            }
            total.setText("");
            recibo.eliminarArchivo();
        
        }
        
        
    }//GEN-LAST:event_irCompraActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed

        int opc = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres salir?", "Salir", JOptionPane.YES_NO_OPTION, 0, new ImageIcon(getClass().getResource("/imagenes/pensando.png")));
        if (opc == 0){
            Inicio inicio = new Inicio();
            inicio.setVisible(true);
            this.setVisible(false);
        }
        
    }//GEN-LAST:event_salirActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed

        int fila = compras.getSelectedRow();
        
        if (fila >=0 ){
            int opc = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere eliminar el producto?", "Eliminar producto", JOptionPane.YES_NO_OPTION, 0, new ImageIcon(getClass().getResource("/imagenes/pensando.png")));
            if (opc == 0){
                modelo.removeRow(fila);
                Productos.suma = 0;
                for (int i = 0; i < compras.getRowCount(); i++){ 
                    Productos.suma += Float.parseFloat(compras.getValueAt(i, 4).toString());
                }
                total.setText("Total: " + Productos.suma);
                if (compras.getRowCount() == 0) irCompra.setEnabled(false); //else irCompra.setEnabled(true);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila.", "Sin selecccion", 0, new ImageIcon(getClass().getResource("/imagenes/advertencia.png")));
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
        Compras compras = new Compras();
        compras.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        Registro registro = new Registro();
        Registro.actualizar.setVisible(true);
        Registro.registrar.setVisible(false);
        Registro.login.setVisible(false);
        Registro.regresar.setVisible(false);
        
        Conexion con;
        Encriptar en;
        Connection c;
        ResultSet rs;
        Statement st;
        String sql = "SELECT * FROM registro WHERE id = "+Inicio_Secion.id+" ";
        
        try {
            en = new Encriptar();
            con = new Conexion();
            c = con.getConexion();
            st = c.createStatement();
            rs = st.executeQuery(sql);
            Registro.nombre.setText(rs.getString(2));
            Registro.apellido.setText(rs.getString(3));
            Registro.mail.setText(rs.getString(4));
            Registro.telefono.setText(rs.getString(5));
            Registro.contra1.setText(en.desencriptar(rs.getString(6)));
            Registro.contra2.setText(en.desencriptar(rs.getString(6)));
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        registro.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compra_Venta().setVisible(true);
            }
        });
    }
    
    class gradientPanel extends JPanel {
        protected void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D) g;
            int ancho = getWidth();
            int alto = getHeight();
            
            Color color1 = new Color(234,153,153);
            Color color2 = new Color(242,200,70);
            GradientPaint gp = new GradientPaint(0, 0, color1, 180, alto+400, color2);
            //GradientPaint gp = new GradientPaint(0, 0, color1, 180, alto, color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, ancho, alto);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable compras;
    private javax.swing.JButton eliminar;
    public static javax.swing.JButton irCompra;
    private javax.swing.JButton irProductos;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton salir;
    public static javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}

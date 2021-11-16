
package tienda;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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
        //modelo.addColumn("Proveedor");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("PRESIO");
        
        productos.setModel(modelo);
        
        informacion();
        
    }

    public void informacion(){
        Connection c;
        ResultSet rs;
        Statement st;
        String sql = "SELECT * FROM productos";  
        String filas [] = new String [4];
        
        try {
            con = new Conexion();
            c = con.getConexion();
            st = c.createStatement();
            rs = st.executeQuery(sql);
            
            while (rs.next()){
                filas[0] = String.valueOf(rs.getInt(1));
                //filas[1] = String.valueOf(rs.getInt(2));
                filas[1] = rs.getString(3);
                filas[2] = String.valueOf(rs.getInt(4));
                filas[3] = String.valueOf(rs.getString(5));
                modelo.addRow(filas);
            }
            for (int i = 0; i < productos.getRowCount(); i++){
                if (Integer.parseInt(productos.getValueAt(i, 2).toString()) == 0){
                    modelo.removeRow(i);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error en instruccion SQL", 0, new ImageIcon(getClass().getResource("/imagenes/errorSQL.png")));
            System.out.println(e);
            //JOptionPane.showMessageDialog(null, e, "Error", 2, new ImageIcon(getClass().getResource("/imagenes/error.png")));
            
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        seleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PRODUCTOS");

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

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

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
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
                        .addGap(0, 23, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(seleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(208, 208, 208))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(seleccionar)
                .addGap(41, 41, 41))
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
            //System.out.println(seleccion);
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
                int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Cuando productos quieres: ", "Cantidad", 1));
                // Continuamos aqui.
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
            
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Error en instruccion SQL", 0, new ImageIcon(getClass().getResource("/imagenes/errorSQL.png")));
            }
            
            
        }else{
            
            JOptionPane.showMessageDialog(null, "Por favor, seleccionar un producto", "Error", 2);
            
        }
        suma = 0;
        for (int i = 0; i < Compra_Venta.compras.getRowCount(); i++){ 
            suma += Float.parseFloat(Compra_Venta.compras.getValueAt(i, 4).toString());
        }
        
        Compra_Venta.total.setText("Total : " + suma);
        
        
    }//GEN-LAST:event_seleccionarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable productos;
    public static javax.swing.JButton seleccionar;
    // End of variables declaration//GEN-END:variables
}

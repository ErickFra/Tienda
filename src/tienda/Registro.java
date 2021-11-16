
package tienda;
import com.sun.glass.events.KeyEvent;
import java.awt.Image;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Registro extends javax.swing.JFrame {

    Conexion con;
    Encriptar enc;
    private char signo;
    
    public Registro() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        login.setEnabled(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/registro.png")).getImage());
        signo = contra1.getEchoChar();
        actualizar.setVisible(false);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        apellido = new javax.swing.JTextField();
        mail = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        registrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        contra1 = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        contra2 = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        regresar = new javax.swing.JButton();
        mostrar = new javax.swing.JCheckBox();
        actualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de clientes");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro");

        jLabel2.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        jLabel2.setText("Nombre: ");
        jLabel2.setMaximumSize(new java.awt.Dimension(93, 30));
        jLabel2.setMinimumSize(new java.awt.Dimension(93, 30));

        jLabel3.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        jLabel3.setText("Apellido: ");
        jLabel3.setMaximumSize(new java.awt.Dimension(95, 30));
        jLabel3.setMinimumSize(new java.awt.Dimension(95, 30));

        jLabel4.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        jLabel4.setText("Correo: ");
        jLabel4.setMaximumSize(new java.awt.Dimension(80, 30));
        jLabel4.setMinimumSize(new java.awt.Dimension(80, 30));

        jLabel5.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        jLabel5.setText("Telefono: ");

        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
            }
        });

        apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellidoKeyTyped(evt);
            }
        });

        telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefonoKeyTyped(evt);
            }
        });

        registrar.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ok.png"))); // NOI18N
        registrar.setText("Registrar");
        registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        jLabel6.setText("Contraseña: ");

        jLabel7.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        jLabel7.setText("Cofirmar: ");

        login.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iniciar_sesion.png"))); // NOI18N
        login.setText("Iniciar Secion");
        login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        regresar.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresar.png"))); // NOI18N
        regresar.setText("Regresar");
        regresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        mostrar.setText("Mostrar Contraseñas");
        mostrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarActionPerformed(evt);
            }
        });

        actualizar.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar.png"))); // NOI18N
        actualizar.setText("Actualizar");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(mostrar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(apellido)
                                    .addComponent(mail)
                                    .addComponent(telefono)
                                    .addComponent(contra1)
                                    .addComponent(contra2))
                                .addGap(73, 73, 73)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(regresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(registrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(34, 34, 34)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(registrar)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(login)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contra1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contra2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(regresar)
                        .addGap(35, 35, 35)
                        .addComponent(actualizar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(mostrar)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        // TODO add your handling code here:
        
        if (nombre.getText().length() != 0 && apellido.getText().length() != 0 && mail.getText().length() != 0 && telefono.getText().length() != 0 && contra1.getText().length() != 0 && contra2.getText().length() != 0){
            
            if (contra1.getText().equals(contra2.getText())){
                
                con = new Conexion();
                enc = new Encriptar();
                int res = JOptionPane.showConfirmDialog(null, "¿Los datos son correctos?");
            
                if (res == 0){

                    String sql = "INSERT INTO registro (nombre, apellido, correo, telefono, password) VALUES (?, ?, ?, ?, ?)";
                        
                    Connection c;
                    PreparedStatement ppt;

                    try {
                        c = con.getConexion();

                        ppt = c.prepareStatement(sql);

                        ppt.setString(1, nombre.getText());
                        ppt.setString(2, apellido.getText());
                        ppt.setString(3, mail.getText());
                        ppt.setString(4, telefono.getText());
                        ppt.setString(5, enc.encriptar(contra1.getText()));

                        ppt.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Datos guardados correctamente", "Guardado...", 1, new ImageIcon(getClass().getResource("/imagenes/ok.png")));
                            
                        login.setEnabled(true);

                        nombre.setText(null);
                        apellido.setText(null);
                        mail.setText(null);
                        telefono.setText(null);
                        contra1.setText(null);
                        contra2.setText(null);

                    } catch (Exception e) {

                            JOptionPane.showMessageDialog(null, e, "Error en instruccion SQL", 0, new ImageIcon(getClass().getResource("/imagenes/errorSQL.png")));
                        }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Las contraseñas no son iguales", "Error", 0, new ImageIcon(getClass().getResource("/imagenes/error.png")));
                /*nombre.setText(null);
                apellido.setText(null);
                mail.setText(null);
                telefono.setText(null);*/
                contra1.setText(null);
                contra2.setText(null);
            }
            
        }else{
            //JOptionPane.showMessageDialog(null, "Te falta llenar algun campo", "Error", 2);
            JOptionPane.showMessageDialog(null, "Por favor, llena todo los campos.", "Incompleto", 0, new ImageIcon(getClass().getResource("/imagenes/incompleto.png")));
        }
    }//GEN-LAST:event_registrarActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        
        this.setVisible(false);
        Inicio_Secion secion = new Inicio_Secion();
        secion.setVisible(true);
    }//GEN-LAST:event_loginActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed

        Inicio inicio = new Inicio();
        inicio.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_regresarActionPerformed

    private void mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarActionPerformed

        if (mostrar.isSelected()){
            contra1.setEchoChar((char)0);
            contra2.setEchoChar((char)0);
        }else{
            contra1.setEchoChar(signo);
            contra2.setEchoChar(signo);
        }
    }//GEN-LAST:event_mostrarActionPerformed

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped

        if (!Character.isLetter(evt.getKeyChar()) && !(evt.getKeyChar() == KeyEvent.VK_SPACE) && !(evt.getKeyChar() == KeyEvent.VK_BACKSPACE) && !(evt.getKeyChar() == KeyEvent.VK_ENTER)){
            JOptionPane.showMessageDialog(null, "Por favor, solo letras", "Error...", 0, new ImageIcon(getClass().getResource("/imagenes/letras.png")));
            System.out.println(KeyEvent.VK_DELETE);
            evt.consume();
        }
    }//GEN-LAST:event_nombreKeyTyped

    private void apellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidoKeyTyped

        if (!Character.isLetter(evt.getKeyChar()) && !(evt.getKeyChar() == KeyEvent.VK_SPACE) && !(evt.getKeyChar() == KeyEvent.VK_BACKSPACE) && !(evt.getKeyChar() == KeyEvent.VK_ENTER)){
            JOptionPane.showMessageDialog(null, "Por favor, solo letras", "Error...", 0, new ImageIcon(getClass().getResource("/imagenes/letras.png")));
            evt.consume();
        }
    }//GEN-LAST:event_apellidoKeyTyped

    private void telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoKeyTyped
        
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9' || (evt.getKeyChar() == KeyEvent.VK_BACKSPACE || evt.getKeyChar() == KeyEvent.VK_ENTER)){
        }else{
            JOptionPane.showMessageDialog(null, "Por favor, solo numeros", "Error...", 0, new ImageIcon(getClass().getResource("/imagenes/numeros.png")));
            evt.consume();
        }
        
    }//GEN-LAST:event_telefonoKeyTyped

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed

        
        if (nombre.getText().length() != 0 && apellido.getText().length() != 0 && mail.getText().length() != 0 && telefono.getText().length() != 0 && contra1.getText().length() != 0 && contra2.getText().length() != 0){
            
            Conexion con;
            Encriptar enc;
            if (contra1.getText().equals(contra2.getText())){
                
                con = new Conexion();
                enc = new Encriptar();
                int res = JOptionPane.showConfirmDialog(null, "¿Los datos son correctos?");
            
                if (res == 0){
                    String sql = "UPDATE registro SET nombre = '"+nombre.getText()+"', apellido = '"+apellido.getText()+"', correo = '"+mail.getText()+"', telefono = '"+telefono.getText()+"', password = '"+enc.encriptar(contra1.getText())+"' WHERE id = "+Inicio_Secion.id+" ";
                    
                    Connection c;
                    PreparedStatement pps;

                    try {
                        c = con.getConexion();
                        pps = c.prepareStatement(sql);
                        pps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Datos Actualizados", "Actualizacion", 0, new ImageIcon(getClass().getResource("/imagenes/ok.png")));
                        login.setVisible(true);
                        login.setEnabled(true);
                            
                        login.setEnabled(true);

                        nombre.setText(null);
                        apellido.setText(null);
                        mail.setText(null);
                        telefono.setText(null);
                        contra1.setText(null);
                        contra2.setText(null);

                    } catch (Exception e) {
                        
                        JOptionPane.showMessageDialog(null, e, "Error en instruccion SQL", 0, new ImageIcon(getClass().getResource("/imagenes/errorSQL.png")));
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Las contraseñas no son iguales", "Error", 0, new ImageIcon(getClass().getResource("/imagenes/error.png")));
                /*nombre.setText(null);
                apellido.setText(null);
                mail.setText(null);
                telefono.setText(null);*/
                contra1.setText(null);
                contra2.setText(null);
            }
            
        }else{
            //JOptionPane.showMessageDialog(null, "Te falta llenar algun campo", "Error", 2);
            JOptionPane.showMessageDialog(null, "Por favor, llena todo los campos.", "Incompleto", 0, new ImageIcon(getClass().getResource("/imagenes/incompleto.png")));
        }
    
    }//GEN-LAST:event_actualizarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton actualizar;
    public static javax.swing.JTextField apellido;
    public static javax.swing.JPasswordField contra1;
    public static javax.swing.JPasswordField contra2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JButton login;
    public static javax.swing.JTextField mail;
    private javax.swing.JCheckBox mostrar;
    public static javax.swing.JTextField nombre;
    public static javax.swing.JButton registrar;
    public static javax.swing.JButton regresar;
    public static javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}

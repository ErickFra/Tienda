
package tienda;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class Correo {
    
    private String correo;
    private String mensaje;
    
    public Correo(String correo, String msg){
        this.correo = correo;
        this.mensaje = msg;
    }
    
    public void enviar(){
        try {
            
            
            Properties propiedad = new Properties();
            
            propiedad.put("mail.smtp.host", "smtp.gmail.com");
            propiedad.put("mail.smtp.starttls.enable", true);
            propiedad.put("mail.smtp.ssl.trust", true);
            propiedad.put("mail.smtp.auth", true);
            propiedad.put("mail.smtp.port", 587);
            propiedad.put("mail.smtp.ssl.protocols", "TLSv1.2");

            Session sesion = Session.getDefaultInstance(propiedad);
            
            String miCorreo = "pruebass.mails@gmail.com";
            String pass = "pruebaserick";
            String asunto = "Compra de productos";
            String mensje = this.mensaje;

            MimeMessage mail = new MimeMessage(sesion);
            
            mail.setFrom(new InternetAddress(miCorreo));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(this.correo));
            mail.setSubject(asunto);
            mail.setText(mensje);

            Transport tranporte = sesion.getTransport("smtp"); 
            tranporte.connect("smtp.gmail.com", miCorreo, pass);            
            tranporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            
            tranporte.close();
            
            JOptionPane.showMessageDialog(null, "Correo enviado", "Confirmado", 1);
            
        } catch (AddressException ex) {
            System.out.println("Error 1".toUpperCase());
            JOptionPane.showMessageDialog(null, ex, "1", 1);
            Logger.getLogger(Correo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            System.out.println("Error 2".toUpperCase());
            JOptionPane.showMessageDialog(null, ex, "2", 1);
            Logger.getLogger(Correo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}

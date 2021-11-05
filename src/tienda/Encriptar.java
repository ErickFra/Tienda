
package tienda;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public class Encriptar {
    
    public SecretKeySpec CrearClave(String contr){
        try {
            byte [] cadena = contr.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            cadena = md.digest(cadena);
            cadena = Arrays.copyOf(cadena, 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(cadena, "AES");
            return secretKeySpec;
            
        } catch (Exception e) {
            return null;
        }
    }
    
    public String encriptar(String encrip){
        try {
            
            SecretKeySpec secretKeySpec = CrearClave("");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            
            byte [] cadena = encrip.getBytes("UTF-8");
            byte [] encriptada = cipher.doFinal(cadena);
            String cad_encrip = Base64.encode(encriptada);
            return cad_encrip;
            
        } catch (Exception e) {
            return "";
        }
    }
    
    public String desencriptar(String desencrip){
        try {
            
            SecretKeySpec secretKeySpec = CrearClave("");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            
            byte [] cadena = Base64.decode(desencrip);
            byte [] desencriptada = cipher.doFinal(cadena);
            String cad_desencrip = new String (desencriptada);
            return cad_desencrip;
            
        } catch (Exception e) {
            System.out.println(e);
            return "";
        }
    }
    
    
}

package practicecrypto;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;
import java.util.*;


/**
 *
 * @author Sean
 */
public class PracticeCrypto {

    //Practice encrypting a String using AES and CBC mode
    
    public static void main(String[] args) {
        
        
        System.out.print("Give me a string to encrypt and decrypt: ");
        Scanner scan = new Scanner(System.in);
        String myStr = scan.nextLine();
        
        try{
        String secret = "1234567812345678";
        String initVector = "RandomInitVector"; 
        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
        SecretKeySpec key = new SecretKeySpec(secret.getBytes("UTF-8"), "AES");
       
        // Encrypt
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        
        byte[] encryptedData = cipher.doFinal(myStr.getBytes());
        System.out.println("The encrypted message looks like this: " + new String(encryptedData));

        // Decrypt
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] decryptedData = cipher.doFinal(encryptedData);
        System.out.println("And decrypted you get back your original message: " + new String(decryptedData));
        
        }catch(Exception e){e.printStackTrace();}
    
    }
}

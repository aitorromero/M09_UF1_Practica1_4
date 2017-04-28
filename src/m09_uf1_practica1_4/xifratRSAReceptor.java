package m09_uf1_practica1_4;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class xifratRSAReceptor {
    private static KeyPair kP;
    private byte [] decryptedData;
    
    xifratRSAEmissor xRSAe= new xifratRSAEmissor();

    /**
     * Metodo que genera un par de claves de 2048 bytes, de estas claves podemos
     * obtener la calve Publica y la Privada.
     */
    public void generaClaus() {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            kP = keyGen.genKeyPair();
        } catch (Exception e) {
            System.err.println("Generador no disponible.");
        }
    }

    /**
     * Recibimos por parametro el mensaje convertido en array de bytes. Y gracias
     * a Cipher.DECRYPT_MODE y la clave privada desciframos el mensaje y lo 
     * almacenamos en un array de bytes.
     * @param data 
     */
    public void desxifraDadesReceptor(byte[] data) {
        Cipher ciph;
        try {
            ciph = Cipher.getInstance("RSA/ECB/PKCS1Padding","SunJCE");
            ciph.init(Cipher.DECRYPT_MODE, kP.getPrivate());
            decryptedData = ciph.doFinal(data);
        } catch (NoSuchAlgorithmException | NoSuchProviderException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(xifratRSAReceptor.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    /**
     * Metodo para obtener la clavePublica
     * @return 
     */
    public PublicKey getClauPublica() {
        return kP.getPublic();
    }

    /**
     * Meotod para obtener el mensaje descifrado.
     * @return 
     */
    public byte[] getTextDesxifrat() {
        return decryptedData;
    }

}

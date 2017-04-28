package m09_uf1_practica1_4;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class xifratRSAEmissor {
    private byte [] encryptedData;

    /**
     * Metodo que recibe por parametro un mensaje y obtiene la clave publica 
     * del par de claves que genera generarClau(). Mediante esta clave y
     * cipher.ENCRYPT_MODE codificamos el mensaje y lo almacenamos en ecnryptedData.
     * 
     * @param missatge_text
     * @param pub 
     */
    public void xifraDadesEmissor(String missatge_text, PublicKey pub) {
        byte[] msg;
        try {
            msg = missatge_text.getBytes("UTF-8");
            
            Cipher ciph = Cipher.getInstance("RSA/ECB/PKCS1Padding","SunJCE");
            ciph.init(Cipher.ENCRYPT_MODE, pub);
            encryptedData = ciph.doFinal(msg);
        } catch (NoSuchAlgorithmException | NoSuchProviderException | NoSuchPaddingException | InvalidKeyException | UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(xifratRSAEmissor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo para obtener el mensaje cifrado (encryptedData)
     * @return 
     */
    public byte[] getMissatgeXifrat() {
        return encryptedData;
    }

}

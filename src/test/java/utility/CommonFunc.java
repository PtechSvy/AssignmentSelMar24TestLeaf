package utility;



import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;


public class CommonFunc {

    private final String algorithm = "AES";

    private final byte[] arrayWithBytes = new byte[]{
        'c','r','m','s','f','a','3','b','z','=','2','w','u','g','m','/','e','2','v','r','m'
    };

    public String encryptValue(String valueToEnc) throws NoSuchPaddingException, NoSuchAlgorithmException {
        String encryptedValue = " ";

        if(valueToEnc!=null)
        {
            try {
                Cipher cipher = Cipher.getInstance(algorithm);
                cipher.init(Cipher.ENCRYPT_MODE, generateKey());
                byte[] encValue = cipher.doFinal(valueToEnc.getBytes(StandardCharsets.UTF_8));
                encryptedValue = Base64.getEncoder().encodeToString(encValue);
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return encryptedValue;
    }

    private Key generateKey() {

        Key key = new SecretKeySpec(arrayWithBytes,algorithm);
        return key;
    }

    public String decryptValue(String encryptedValue)
    {
        try
        {
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.DECRYPT_MODE,generateKey());
            byte[] decordedValue = Base64.getDecoder().decode(encryptedValue);
            byte[] decValue = cipher.doFinal(decordedValue);
            String decryptedValue = new String(decValue);
            return  decryptedValue;
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public String decryptVal(String value)
    {
        String algorithm = "AES";
        String transformation = "AES/ECB/PKCS5Padding";
        try {
            // Step 2: Create a key for the chosen encryption algorithm
            KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
            SecretKey secretKey = keyGenerator.generateKey();
            // Step 3: Initialize a cipher object with the key and encryption mode
            Cipher cipher = Cipher.getInstance(transformation);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(value.getBytes(StandardCharsets.UTF_8));
            String encryptedBase64 = Base64.getEncoder().encodeToString(encryptedBytes);
            return encryptedBase64;
        }catch(Exception e)
        {
            e.printStackTrace();
        }
       return null;
    }
}

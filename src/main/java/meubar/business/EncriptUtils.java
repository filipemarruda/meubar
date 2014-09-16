package meubar.business;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class EncriptUtils {

    private static byte[] key = {
 0x21, 0x22, 0x21, 0x25, 0x29, 0x22, 0x30,
			0x33, 0x24, 0x44, 0x41, 0x39, 0x37, 0x40, 0x35, 0x49
    };//"thisIsASecretKey";

	public static String encrypt(String strToEncrypt)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException
    {
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptedVal = cipher.doFinal(strToEncrypt.getBytes());
		byte[] encodedVal = new Base64().encode(encryptedVal);
		return new String(encodedVal).replace("\r\n", "");

    }

	public static String decrypt(String strToDecrypt)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException
    {

		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] decodedValue = new Base64().decode(strToDecrypt.getBytes());
		byte[] decryptedVal = cipher.doFinal(decodedValue);
		return new String(decryptedVal);
    }
}

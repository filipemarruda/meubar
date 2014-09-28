package meubar.business.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import org.apache.commons.codec.binary.Base64;

public class EncriptUtils {

	private static SecretKey key;

	private static String algorithm = "DES";
	private static String encryptMode = "DES/ECB/PKCS7Padding";
	private static Cipher encryptCipher;
	private static Cipher decryptCipher;

	public static String encrypt(String strToEncrypt)
			throws UnsupportedEncodingException, NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException,
			InvalidKeySpecException {

		byte[] input = strToEncrypt.getBytes("UTF8");
		byte[] enc = getEncryptCipher().doFinal(input);
		enc = Base64.encodeBase64(enc);
		String token = new String(enc);
		System.out.println("Token gerado: " + token);
		return ConversionUtils.encodeBase64ToCookie(token);

    }

	public static String decrypt(String tokenCookie)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException,
			BadPaddingException, IOException, InvalidKeySpecException,
			InvalidAlgorithmParameterException {

		String token = ConversionUtils.decodeCookieToBase64(tokenCookie);
		System.out.println("Token recebido: " + token);
		byte[] dec = Base64.decodeBase64(token.getBytes());
		byte[] utf8 = getDecryptCipher().doFinal(dec);
		return new String(utf8, "UTF8");

    }

	public static Cipher getEncryptCipher() throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException,
			InvalidKeySpecException {

		if (encryptCipher == null) {
			encryptCipher = Cipher.getInstance(encryptMode);
			encryptCipher.init(Cipher.ENCRYPT_MODE, getSecretKey());
		}
		return encryptCipher;
	}

	public static Cipher getDecryptCipher() throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException,
			InvalidKeySpecException, InvalidAlgorithmParameterException {
		if (decryptCipher == null) {
			decryptCipher = Cipher.getInstance(encryptMode);
			decryptCipher.init(Cipher.DECRYPT_MODE, getSecretKey());
		}
		return decryptCipher;
	}

	private static SecretKey getSecretKey() throws NoSuchAlgorithmException,
			InvalidKeyException, InvalidKeySpecException {
		if (key == null) {
			key = KeyGenerator.getInstance(algorithm).generateKey();
		}
		return key;
	}
}

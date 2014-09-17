package meubar.business;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import meubar.api.autenticacao.LoginException;

public class TokenUtils {

	private static int EXPIRES_INTERVAL = 3;
	public static String AUTH_TOKEN = "auth_token";
	private TokenUtils() {
	}

	public static String generateToken(String login) throws IOException,
			NoSuchAlgorithmException, InvalidKeyException,
			NoSuchPaddingException, IllegalBlockSizeException,
			BadPaddingException {
		
		Map<String, String> tokenMap = new HashMap<String, String>();
		tokenMap.put("login", login);
		Calendar dataDeExpiracao = Calendar.getInstance();
		dataDeExpiracao.add(Calendar.MINUTE, + EXPIRES_INTERVAL);
		tokenMap.put("expires",
		ConversionUtils.formatDate(dataDeExpiracao.getTime()));
		byte[] byteArray = ConversionUtils.serialize(tokenMap);
		return EncriptUtils.encrypt(new String(byteArray));
		
	}

	public static void isValidToken(String token) throws LoginException {

		try {
			byte[] byteArray = EncriptUtils.decrypt(token).getBytes();

			Map<String, String> tokenMap = (Map<String, String>) ConversionUtils
					.deserialize(byteArray);

			Date dataExpiracao = ConversionUtils.extractDate(tokenMap
					.get("expires"));

			if (dataExpiracao.before(new Date())) {
				throw new LoginException();
			}

		} catch (Exception e) {
			throw new LoginException();
		}
	}
}

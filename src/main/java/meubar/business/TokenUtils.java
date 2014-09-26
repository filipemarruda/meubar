package meubar.business;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import meubar.api.autenticacao.LoginException;

public class TokenUtils {

	private static int EXPIRES_INTERVAL = 3;
	public static String AUTH_TOKEN = "auth_token";
	private TokenUtils() {
	}

	public static String generateToken(String login, String grupo) {
		String token;
		try {
			Map<String, String> tokenMap = new HashMap<String, String>();
			tokenMap.put("login", login);
			tokenMap.put("grupo", grupo);
			Calendar dataDeExpiracao = Calendar.getInstance();
			dataDeExpiracao.add(Calendar.MINUTE, +EXPIRES_INTERVAL);
			tokenMap.put("expires",
					ConversionUtils.formatDate(dataDeExpiracao.getTime()));
			byte[] byteArray = ConversionUtils.serialize(tokenMap);
			token = EncriptUtils.encrypt(new String(byteArray));
		} catch (Exception e) {
			token = null;
		}
		return token;
		
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

	public static String extractUser(String token) {
		String user;

		try {

			byte[] byteArray = EncriptUtils.decrypt(token).getBytes();
			Map<String, String> tokenMap = (Map<String, String>) ConversionUtils
					.deserialize(byteArray);
			user = tokenMap.get("login");

		} catch (Exception e) {
			user = null;
		}

		return user;
	}

	public static String extractGrupo(String token) {
		String user;

		try {

			byte[] byteArray = EncriptUtils.decrypt(token).getBytes();
			Map<String, String> tokenMap = (Map<String, String>) ConversionUtils
					.deserialize(byteArray);
			user = tokenMap.get("grupo");

		} catch (Exception e) {
			user = null;
		}

		return user;
	}
}

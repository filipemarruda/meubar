package meubar.business.util;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import meubar.acesso.exceptions.LoginException;

public class TokenUtils {

	private static int EXPIRES_INTERVAL = 10;// 'Session Time'
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

	private static Map<String, String> getTokenMap(String token) throws LoginException {
		Map<String, String> tokenMap = null;
		try {

			byte[] byteArray = EncriptUtils.decrypt(token).getBytes();
			tokenMap = (Map<String, String>) ConversionUtils.deserialize(byteArray);

		} catch (Exception e) {
			System.out.println("Erro : " + e.getMessage());
			throw new LoginException();
		}

		return tokenMap;
	}

	public static void isValidToken(String token) throws LoginException {

		Map<String, String> tokenMap = getTokenMap(token);
		Date dataExpiracao = ConversionUtils.extractDate(tokenMap.get("expires"));

		if (dataExpiracao.before(new Date())) {
			throw new LoginException();
		}
	}

	public static String extractUser(String token) {
		String user;

		try {

			Map<String, String> tokenMap = getTokenMap(token);
			user = tokenMap.get("login");

		} catch (Exception e) {
			user = null;
		}

		return user;
	}

	public static String extractGrupo(String token) {
		String user;

		try {

			Map<String, String> tokenMap = getTokenMap(token);
			user = tokenMap.get("grupo");

		} catch (Exception e) {
			user = null;
		}

		return user;
	}
}

package meubar.business.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConversionUtils {

	private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssz";

	private ConversionUtils() {
	}

	public static byte[] serialize(Object obj) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream os = new ObjectOutputStream(out);
		os.writeObject(obj);
		return out.toByteArray();
	}

	public static Object deserialize(byte[] data) throws IOException,
			ClassNotFoundException {
		ByteArrayInputStream in = new ByteArrayInputStream(data);
		ObjectInputStream is = new ObjectInputStream(in);
		return is.readObject();
	}

	public static String formatDate(Date d) {

		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		return sdf.format(d);

	}

	public static Date extractDate(String dateString) {

		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		Date data = null;

		try {

			data = sdf.parse(dateString);

		} catch (ParseException e) {
			System.out.println("Erro : data(" + dateString + ")" + e.getMessage());
		}

		return data;

	}

	public static String encodeBase64ToCookie(String b64String) {
		return b64String.replaceAll("\\+", "-").replaceAll("/", "_");
	}

	public static String decodeCookieToBase64(String cookieString){
		return cookieString.replaceAll("-", "+").replaceAll("_", "/")
				.replaceAll("%3D", "=");
	}

}

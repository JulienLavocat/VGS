package gameserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Random;

public class Utils {

	public static Random random = new Random();
	public static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	public static String randomString(int length) {
		char[] msg = new char[length];
		for(int i = 0; i < length; i++)
			msg[i] = CHARS.charAt(random.nextInt(61));
		return new String(msg);
	}

	public static String getPublicIP() {
		URL whatismyip;
		try {
			whatismyip = new URL("http://checkip.amazonaws.com");
			BufferedReader in = new BufferedReader(new InputStreamReader(
					whatismyip.openStream()));
			String ip = in.readLine();
			in.close();
			return ip;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}

package gameserver;

import redis.clients.jedis.Jedis;

public class Redis {

	public static String CHANNEL = "gs-" + Server.SERVER_ID;
	
	private static Jedis jedis;
	
	public static boolean init() {
			
		//Initialize redis connection
		jedis = new Jedis("thebad.xyz");
		
		//Pub/Sub initialization
		//jedis.subscribe(new PubSub(), CHANNEL);
		
		return true;
	}
	
	public synchronized static void pub(String... data) {
		String msg = "";	
		for(String s : data)
			msg += s + "-";
		jedis.publish("MASTER", msg);
	}
	
	public static void close() {
		jedis.close();
	}
	
}

package gameserver;

public class Main {
	
	public static void main(String[] args) {
		
		Server.SERVER_ID = Utils.randomString(10);
		
		Redis.init();
		
		Server.start();
		
	}
	
}

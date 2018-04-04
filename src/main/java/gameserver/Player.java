package gameserver;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.UUID;

public class Player {

	public static ArrayList<Player> players = new ArrayList<Player>();
	
	private InetAddress address;
	private int port;
	private UUID id;
	
	public Player(InetAddress address, int port, UUID id) {
		this.address = address;
		this.port = port;
		this.id = id;
	}
	
	public InetAddress getAddress() {
		return address;
	}
	
	public int getPort() {
		return port;
	}
	
}

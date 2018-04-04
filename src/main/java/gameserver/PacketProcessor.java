package gameserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class PacketProcessor implements Runnable {
	
	DatagramPacket packet;
	DatagramSocket socket;
	
	public PacketProcessor(DatagramPacket packet, DatagramSocket socket) {
		this.packet = packet;
		this.socket = socket;
	}

	@Override
	public void run() {
		
		String[] msg = new String(packet.getData()).split("§");
		
		if(msg[0] != Server.PROTOCOL_KEY)
			return;
		
		if(msg[1].equals("handshake")) {
			
			
			
		}
			
		
	}

	/*
	 * Send to all client except sender
	 */
	public void broadcast(String msg, int id) {
		
		DatagramPacket p = new DatagramPacket(msg.getBytes(), msg.getBytes().length);
		for(int i = 0; i < Player.players.size(); i++) {
			if(id == i)
				return;
			Player pl = Player.players.get(i);
			p.setPort(pl.getPort());
			p.setAddress(pl.getAddress());
			try {
				socket.send(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/*
	 * Send to all clients
	 */
	public void emit(String msg) {
		DatagramPacket p = new DatagramPacket(msg.getBytes(), msg.getBytes().length);
		for(Player pl : Player.players) {
			p.setPort(pl.getPort());
			p.setAddress(pl.getAddress());
			try {
				socket.send(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * Send to a specific client
	 */
	public void send(String msg, InetAddress address) {
		try {
			socket.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

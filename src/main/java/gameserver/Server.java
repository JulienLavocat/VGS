package gameserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

	public static final String PROTOCOL_KEY = "1234";
	public static final int BUFFER_SIZE = 8192;
	
	public static String SERVER_ID = "";
	
	private static boolean isClosed;
	private static DatagramSocket socket;
	private static ExecutorService pool;
	
	public static void start() {
		
		pool = Executors.newFixedThreadPool(30);
		
		try {
			socket = new DatagramSocket(2000);
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
		Redis.pub("READY", SERVER_ID, Utils.getPublicIP());
		
		while(!isClosed) {
			
			//Receive packet and broadcast
			
			byte[] buffer = new byte[BUFFER_SIZE];
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			try {
				socket.receive(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
			pool.execute(new PacketProcessor(packet, socket));
		}
		
	}
	
}

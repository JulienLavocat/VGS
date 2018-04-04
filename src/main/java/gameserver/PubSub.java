package gameserver;

import redis.clients.jedis.JedisPubSub;

public class PubSub extends JedisPubSub {
	
	@Override
	public void onMessage(String channel, String message) {
		
		System.out.println("[MS] " + message);
		
		String[] data = message.split("§");
		
		super.onMessage(channel, message);
	}
	
	@Override
	public void onSubscribe(String channel, int subscribedChannels) {
		
		System.out.println("[SERVER] - Redis : Subbed to channel " + Redis.CHANNEL);
		
		super.onSubscribe(channel, subscribedChannels);
	}
	
	@Override
	public void onUnsubscribe(String channel, int subscribedChannels) {
		super.onUnsubscribe(channel, subscribedChannels);
	}
	
	@Override
	public void onPMessage(String pattern, String channel, String message) {
		
		System.out.println("[MSP] " + message);
		
		super.onPMessage(pattern, channel, message);
	}
	
	@Override
	public void onPSubscribe(String pattern, int subscribedChannels) {
		super.onPSubscribe(pattern, subscribedChannels);
	}
	
	@Override
	public void onPUnsubscribe(String pattern, int subscribedChannels) {
		super.onPUnsubscribe(pattern, subscribedChannels);
	}
	
}

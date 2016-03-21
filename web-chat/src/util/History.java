package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public enum History {
	INSTANCE;
	
	private final Queue<Message> publicMessages = new CircularQueue<Message>(new LinkedList<Message>(), 10);
	private final List<Message> privateMessages = new LinkedList<Message>();
	
	public synchronized void addMessage(Message message) {
		if ("".equals(message.getWho())) {
			publicMessages.offer(message);
		} else {
			privateMessages.add(message);
		}
	}
	
	public synchronized List<Message> getHistory() {
		List<Message> allMessages = new ArrayList<Message>(publicMessages);
		allMessages.addAll(privateMessages);
		Collections.sort(allMessages, new Comparator<Message>() {
			 public int compare(Message mes1, Message mes2) {
	                return mes1.compareTo(mes2);
			 }
		});
		return allMessages;
	}
}

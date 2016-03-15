package util;

import java.util.LinkedList;
import java.util.Queue;

public enum History {
	INSTANCE;
	private final Queue<String> messagesHistory = new CircularQueue<String>(new LinkedList<String>(), 10);
	
	public synchronized void addMessage(String message) {
		messagesHistory.offer(message);
	}
	
	public synchronized Queue<String> getHistory() {
		return messagesHistory;
	}
}

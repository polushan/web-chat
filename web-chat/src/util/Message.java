package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message implements Comparable<Message>{
	private String message;
	private Date date;
	private String who;
	private String from;
	
	public Message(String message, String from, String who) {
		this.message = message;
		this.date = new Date();
		this.from = from;
		this.who = who.trim();
	}
	
	public Message(String message, String from) {
		this(message, from, "");
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getWho() {
		return who;
	}

	public void setWho(String who) {
		this.who = who;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	private String getTime() {
		DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		String time = formatter.format(this.date);
		return time;
	}
	
	@Override
	public int compareTo(Message mes) {
		return this.date.compareTo(mes.getDate());
	}
	
	@Override
	public String toString() {
		StringBuilder mes = new StringBuilder(getTime() + " " + from + "<br>" + message);
		if (!"".equals(who)) {
			mes.insert(0, "<font color=\"red\">");
			mes.append("</font>");
		}
		mes.insert(0, "<p>");
		mes.append("</p>");
		return mes.toString();
	}
	
}

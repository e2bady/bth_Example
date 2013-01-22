package dba;

import java.util.Arrays;

public class Mail {
	private String subject;
	private String text;
	private String[] receivers;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String[] getReceivers() {
		return receivers;
	}
	public void setReceivers(String[] receivers) {
		this.receivers = receivers;
	}
	
	@Override
	public String toString() {
		return String.format("Mail [subject=%s, text=%s, receivers=%s]",
				subject, text, Arrays.toString(receivers));
	}
}

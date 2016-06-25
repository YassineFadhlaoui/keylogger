package com.sassouki.mail;

import java.net.URL;
import java.net.URLConnection;

public class Connection {

	public boolean isConnected(){
		try {
		    final URLConnection connection = new URL("https://www.google.com").openConnection();
		    connection.connect();
		    return true;
		} catch (Exception  e) {
		    return false;
		}
	}
}

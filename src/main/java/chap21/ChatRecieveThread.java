package chap21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ChatRecieveThread extends Thread{
	Socket socket = null;
	InputStream is = null;
	OutputStream os = null;
	
	BufferedReader br = null;
	BufferedWriter bw = null;
	
	String inMessage = null;
	
	public ChatRecieveThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			is = socket.getInputStream();			
			br = new BufferedReader(new InputStreamReader(is));

			while(true) {
				inMessage = br.readLine();
				
				System.out.println(inMessage);
			}
			
		} catch (Exception e) {}
		
	}
	
	
}

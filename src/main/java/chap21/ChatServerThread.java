package chap21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatServerThread extends Thread{
	private ServerSocket serverSocket = null;
	
	private static List<ChatServerThread> threads = new ArrayList<ChatServerThread>(); //스태틱이 중요함
	private Socket socket = null;
	
	InputStream is = null;
	OutputStream os = null;
	
	BufferedReader br = null;
	BufferedWriter bw = null;
	
	PrintWriter writer = null;
	String message = null; 
	String nickName = null;
	
	public ChatServerThread(Socket socket, String nikName) {
		this.socket = socket;
		this.nickName = nickName;
		
		threads.add(this);  // 이거 굉장히 중요 
	}
	
	
	@Override
	public void run() {
		
		try {
			is = socket.getInputStream();
			os = socket.getOutputStream();
			
			bw =  new BufferedWriter(new OutputStreamWriter(os));
			writer = new PrintWriter(bw,true);
			writer.print(nickName+" 이(가) 서버에 접속되었습니다. ");
			
			while(true) {
				br = new BufferedReader(new InputStreamReader(is));
				message = br.readLine();
				if(message == null) {
					throw new Exception();
				}
				
				//현재 클라이언트 접속자의 메시지를 인자로 전달
				sendMessageAll(message);
			}
			
		} catch (Exception e) {}
		
		
	}
	
	public void sendMessageAll(String message) throws Exception {
		ChatServerThread thread1 = null;
		for (int i=0; i< threads.size(); i++) {
			thread1 = threads.get(i);
			if(thread1.isAlive()) { // 해당 스레드의 run메서드가 종료됐는지 확인
				thread1.sendMessage(message);
			}
		}
		
	}
	public void sendMessage(String message) throws Exception {
		writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
		writer.println(message);
	}
	
}

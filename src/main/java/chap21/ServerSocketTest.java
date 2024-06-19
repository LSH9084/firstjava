package chap21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  Socket 클래스 : 원격지에 접속 요청 후, 원격지와 데이터 통신 기능을 제공하는 클래스 (컨트롤러라고 간단하게 생각)
 *  
 *  
 * 
 */


public class ServerSocketTest {
	
	
	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		InputStream is = null;
		OutputStream os = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		PrintWriter writer = null;
		
		
		InetAddress clientIP = null;
		String message = null;
		
		try {
			serverSocket = new ServerSocket(8888);
			System.out.println("서버 실행중 ...");
			
			while(true) {// 서버에서 클라이언트의 접속을 항상 대기중 (24시간)
				//1. 클라이언트에서 요청시 accept()메서드가 호출되 연결 후 socket객체를 생성하여 클라이언트와 통신
				socket = serverSocket.accept();
				clientIP = socket.getInetAddress();
				System.out.println("접속 IP: " + clientIP);
				
				//클라이언트와 접속할 수 있는 소켓으로 통해 정보 입출력
				is = socket.getInputStream(); //읽기=가져오기
				os = socket.getOutputStream(); //쓰기=보내기
				
				//클라이언트에게 전송할 데이터 보내기
				bw = new BufferedWriter(new OutputStreamWriter(os));
				writer = new PrintWriter(bw,true);
				writer.println("서버: 접속을 환영합니다.");
				
				//클라이언트로 전송 받은 데이터 가져오기
				br = new BufferedReader(new InputStreamReader(is));
				message = br.readLine();
				System.out.println(message);
				
				writer.close(); socket.close();
				
			}
			
		} catch (Exception e) {}
		
		
	}
}







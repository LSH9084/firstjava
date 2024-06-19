package chap21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientTest {
	
	public static void main(String[] args) {
		
		Socket socket = null;
		
		InputStream is = null;
		OutputStream os = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		PrintWriter writer = null;
		
		String inMessage = null; // 클라이언트로부터 문자 받기
		String outMessage = null;// 클라이언트에게 문자 보내기
		String nickName = null;
		
		
//		192.168.0.21
		
		try {
			Scanner sc = new java.util.Scanner(System.in);
			System.out.println("대화명을 입력하세요. :");
			nickName = sc.nextLine();
			socket = new Socket("192.168.0.12",8888);
			System.out.println("클라이언트 접속 요청");
			is = socket.getInputStream();
			os = socket.getOutputStream();
			
			ChatRecieveThread rThread = new ChatRecieveThread(socket);
			rThread.start();
			
			br = new BufferedReader(new InputStreamReader(is));
			bw = new BufferedWriter(new OutputStreamWriter(os));
			writer = new PrintWriter(bw,true);
			
			while(true) {
				//서버로부터 전송받은 문자 확인
//				inMessage = br.readLine();
//				System.out.println(inMessage);
				
				System.out.print("내용:");
				outMessage = sc.nextLine();
				
				if(outMessage == "exit") {
					break;
				} else {
//					System.out.println("서버 : "+outMessage);
					writer.println(nickName +" : " + outMessage);
				}
			}
			
//			sc.close(); writer.close(); socket.close();
			
		} catch (Exception e) {}
		
	}
	
}

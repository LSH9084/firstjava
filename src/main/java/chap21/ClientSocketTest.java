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

import chap09.Interface.Scanner;

/**
 * 
 * 
 * 
 */

public class ClientSocketTest {
	
	
	public static void main(String[] args) {
		
//		ServerSocket serverSocket = null;
		Socket socket = null;
		
		InputStream is = null;
		OutputStream os = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		PrintWriter writer = null;
		String message = null;
		String sendMsg = "";
		
		try {
			socket = new Socket("192.168.0.12",8888); // "127.0.0.1" 의 도메인 주소는 "localhost" 
			System.out.println("서버 접속중...");
			
			is = socket.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			message = br.readLine();
			System.out.println(message);
			
			
			os = socket.getOutputStream();
			bw = new BufferedWriter(new OutputStreamWriter(os));
			writer = new PrintWriter(bw,true);
			
			java.util.Scanner sc = new java.util.Scanner(System.in);
			System.out.print("문자 보내기: ");
			sendMsg = sc.nextLine();
			writer.println("홍길동 : "+sendMsg);
			
			
			
		} catch (Exception e) {	}
		finally {
			try {
				writer.close(); socket.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
		
	}
}

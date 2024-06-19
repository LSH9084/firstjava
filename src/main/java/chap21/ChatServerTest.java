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
import java.util.Scanner;

/**
 *  채팅 서버 프로그램
 * 
 */


public class ChatServerTest {

    public static void main(String[] args) {
        ChatServerThread thread;
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // 서버 소켓을 한 번만 생성
            serverSocket = new ServerSocket(8888);
            System.out.println("서버 실행 중....");

            while (true) {
                    // 클라이언트의 연결을 기다림
                    socket = serverSocket.accept();

                    // 클라이언트로부터 넘어온 값을 읽기
                    InputStream is = socket.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String str = br.readLine();

                    System.out.println("접속IP: " + socket.getInetAddress());
                    System.out.println("접속자: " + str);

                    // 새로운 스레드 생성 및 시작
                    thread = new ChatServerThread(socket, str);
                    thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

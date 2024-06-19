package chap21;

import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.stream.Stream;

public class NetworkTest01 {
	
	
	public static void main(String[] args) throws Exception {
		// 네트워크 : 원격지에있는 장치간에 서로 연결
		// 클라이언트(Client), 서버(Server)
		// IP주소 : 숫자로 구성된 주소, 도메인네임 : 문자로 구성된 주소
		// 프로토콜 : 통신규약 -  정보전달하는 규약
		//									상호간의 접속 방식, 데이터형식,오류검출방식등을 규정
		//									HTTP, HTTPS, FTP, TCP/IP, UDP,...
		// 포트번호 : 0~65535(0~1023까지 사용)
		
		
			InetAddress addr1 = InetAddress.getByName("www.oracle.com");
			InetAddress addr2 = InetAddress.getByAddress(new byte[] {(byte)104,(byte)74,(byte)162,(byte)89});
			
			System.out.println(addr1);
			System.out.println(addr2);
			
			InetAddress[] addr3 = InetAddress.getAllByName("www.naver.com");
			System.out.println(Arrays.toString(addr3));
			
			Arrays.stream(addr3).forEach(System.out::println);
			
			// url(uniform resource location)
			// 프로토콜://호스트명:포트번호/경로면/파일명?쿼리스트링
			URL url = new URL("https://www.egovframe.go.kr/home/sub.do?menuNo=9");
			System.out.println("프로토콜: "+url.getProtocol());
			System.out.println("호스트명: "+url.getHost());
			System.out.println("포트번호: "+url.getPort());
			System.out.println("경로명: "+url.getPath());
			System.out.println("파일명: "+url.getFile());
			System.out.println("쿼리스트링: "+url.getQuery());
			System.out.println(url.getAuthority());
			System.out.println(url.getContent());
		
			
			
			
			
			
			

	}
}

package chap21;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class publicDataTest {
	
	
	
	
	public static void main(String[] args) throws Exception {
		//서울시 문화재 정보(영문) 공공데이터 open api구현하기
		//인증키 : 41677546716b696f34394255566376
		
		
			URL url = new URL("http://openapi.seoul.go.kr:8088/41677546716b696f34394255566376/xml/SebcHeritageInfoEng/1/5/");
			InputStream stm1 = url.openStream();
		
		
		
		
	}
}

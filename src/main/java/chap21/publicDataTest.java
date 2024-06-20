package chap21;

import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class publicDataTest {
	
	
	
	
	public static void main(String[] args) throws Exception {
		//서울시 문화재 정보(영문) 공공데이터 open api구현하기
		//인증키 : 41677546716b696f34394255566376
		
		
			URL url = new URL("http://openapi.seoul.go.kr:8088/41677546716b696f34394255566376/xml/SebcHeritageInfoEng/1/5/");
			InputStream stm1 = url.openStream();
			
			char ch = 0;  // 이건 어디다가 씀?
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(stm1);
			doc.getDocumentElement().normalize();
			
			NodeList nList = doc.getElementsByTagName("row");
			System.out.println("===================================================================");
			for(int i=0; i< nList.getLength(); i++) {
				org.w3c.dom.Node nNode = nList.item(i);
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element nElement = (Element)nNode; 
					System.out.println(i+1);
					System.out.println("문화재 키값: "+ getTageValue("MAIN_KEY",nElement));
					System.out.println("문화재 일련 번호: "+ getTageValue("MNG_NO",nElement));
					System.out.println("문화재 이름: "+ getTageValue("NAME_ENG",nElement));
					System.out.println("문화재 수량 규모: "+ getTageValue("QUANTITY_SCALE",nElement));
					System.out.println("===================================================================");
				}
			}
	
	}
	
	private static String getTageValue (String str, Element nElement) {
		NodeList nList = nElement.getElementsByTagName(str).item(0).getChildNodes();
		Node nValue = (Node) nList.item(0);
		
		if(nValue == null) return "1"; // 문화재 수량이 없는 경우 "1"로 설정하여 반환
		return nValue.getNodeValue();
	}
}

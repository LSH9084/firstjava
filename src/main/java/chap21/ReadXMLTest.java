package chap21;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXMLTest {

	
	
	public static void main(String[] args) throws Exception {
		File fXmlFile = new File("./src/main/java/chap21/company.xml");
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		
		System.out.println("Root element : "+doc.getDocumentElement().getNodeName());
		
		NodeList nList = doc.getElementsByTagName("emp");
		System.out.println("==========================================================");
		
		for(int i=0; i<nList.getLength();i++) {
			Node nNode = nList.item(i);
			if(nNode.getNodeType()==Node.ELEMENT_NODE) {
			Element nElement = (Element) nNode;
			System.out.println("firstname : "+getTagValue("firstname",nElement));
			System.out.println("lastname : "+getTagValue("lastname",nElement));
			System.out.println("nickname : "+getTagValue("nickname",nElement));
			System.out.println("salary : "+getTagValue("salary",nElement));
			System.out.println("==========================================================");
			}
		}
		
		
		
		
	}
	

	private static String getTagValue (String str, Element nElement) {
		NodeList nList = nElement.getElementsByTagName(str).item(0).getChildNodes();
		Node nValue = (Node) nList.item(0);
		
//		if(nValue == null) return "1"; // 문화재 수량이 없는 경우 "1"로 설정하여 반환
		return nValue.getNodeValue();
	}
}


/**
 * XML(eXtensible Makeup Language): 확장성 있는 마크업 언어
 * 프로그램 간에 정보를 교환하기 위한 데이터 형식
 * 
 * 구성 요소
 * 태그(tag) : 데이터의 구성
 * 속성(attribute) : 데이터를 상세하게 설명하는 용도
 * 
 * 태그 규칙
 * -모든 태그는 시작태그와 종료 태그를 가져야한다.
 * 태그는 또 다른 하위 태그를 가질 수 있다.(계층 구조)
 * 
 * 형식) <사용자가 정의 태그이름> 담겨질 내용 </사용자가 정의 태그이름>
 * 		<?xml version = "1.0" encoding="UTF-8"?>  //xml문자라고 알려주고 utf-8로 쓰겠다고 선언함
 * 		<info>
 * 			<name>홍길동< /name>
 * 			<address>부산<address />
 * 			<other> a*b+&<other /> 이스케이프문자가 들어가면 이렇게 쓸수가 없음 대시
 * 			<other>
 * 				요소안에 이스케이프 문자가 있을경우에는
 * 				<![CDATA[
 * 					select *
 * 					from dual
 * 					where a < b
 * 					and b>c
 * 				]]>                                 // <![CDATA[ 여기에 이스케이프 문자를 쓰면 됨 ]]>
 * 			<other />
 * 		<info />
 */

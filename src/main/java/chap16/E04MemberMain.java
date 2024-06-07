package chap16;

import java.util.List;

import chap16.dao.E02MemberDAO;
import chap16.vo.E03MemberVO;

public class E04MemberMain {
	public static void main(String[] args) {
		E02MemberDAO dao = new E02MemberDAO(); //db 입력 수정 삭제 조회 목록 처리하는 객체의 생성자(서비스)
		
		E03MemberVO vo = new E03MemberVO();
		vo.setMemberno(2);
		vo.setId("hong2123213");
		vo.setName("홍길순123");
		
		System.out.println(vo);
		
		int rs = dao.insert(vo);
		
		if(rs>0) {
			System.out.println("회원 정보 정상적으로 등록 되었습니다.");
		}
		System.out.println("result code : "+rs);
		
		E03MemberVO vo2 = new E03MemberVO();
		vo2.setMemberno(3);
		vo2.setId("hong3132");
		vo2.setName("홍길이2323");
		
		int rs2 = dao.insert(vo2);
		if(rs2>0) {
			System.out.println("회원 정보 정상적으로 등록 되었습니다.");
		}
		System.out.println(rs2);
		List<E03MemberVO> list = dao.list();
		list.stream().forEach(System.out::println);
		
		int r3 = dao.delete(3);
		if(r3>0) {
			System.out.println("회원 삭제 성공");
		}
		
		dao.close();
	}
	
}

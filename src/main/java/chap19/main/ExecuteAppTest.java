package chap19.main;

import java.util.ArrayList;
import java.util.List;

import chap09.Interface.Scanner;
import chap19.member.controller.MemberController;
import chap19.member.controller.MemberControllerImpl;
import chap19.member.vo.MemberVo;

public class ExecuteAppTest {
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		
		MemberController controller = new MemberControllerImpl();
		
		List<MemberVo> list1 = new ArrayList<MemberVo>();
//		System.out.print("이름: ");
//		String name2 = sc.next().trim();
		
//		MemberVo vo = MemberVo.builder()
//				.name(name2)								
//				.build();
		MemberVo vo = MemberVo.builder()
				.Id("hont")
				.ps("1414")
				.name("홍길순")
				.address("부산")
				.p_number("010-444")
				.build();
		controller.regMember(vo);
		
		MemberVo vo1 = MemberVo.builder()
				.ps("15135")
				.name("홍4길순2")
				.address("제주3도")
				.p_number("0102-55-4444")
				.Id("hontt")
				.build();
		
		controller.modMember(vo1);
		
		MemberVo vo2 = MemberVo.builder()
				.Id("hontt2")
				.build();
		controller.removeMember(vo2);
		
		System.out.println("==회원정보 조회==");
		list1 = controller.listMember(null);
		list1.stream().forEach(System.out::println);
		
		controller.close2();
		
	}
}

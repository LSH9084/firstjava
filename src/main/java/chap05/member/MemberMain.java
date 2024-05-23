package chap05.member;

public class MemberMain {
	public static void main(String[] args) {
		
		Member i = new MemberImpl("kk", "1234","king", "010-1202-5064");
		MemberVo i2 = new MemberVo("kkg94", "1515", "이상훈", "010-5706-0084");
//		i.delMember(i2);
//		System.out.println(i);
//		i.modMember(i2);
//		System.out.println(i);
//		System.out.println(i.viewMember(i2));
		
		MemberVo i3 = MemberVo.builder()
				.id("김밥")
				.password("1234")
				.name("김밥천국")
				.phoneNum("010-55")
				.build();
		
		i3 = MemberVo.builder()
				.id("wwkk")
				.password("12232434")
				.name("김dkjlsf")
				.phoneNum("010-55-4648")
				.build();
		
		
		
//		System.out.println(i.viewMember(i3));
//		i.delMember(i3);
//		System.out.println(i);
//		i.modMember(i3);
//		System.out.println(i);
//		i.regMember(i3);
//		System.out.println(i);
//		i.viewMember(i3);
//		System.out.println(i);
		i.regMember(i3);
		System.out.println(i.listMember());
		i.listMember().forEach((m)->{
			System.out.println("-----");
			System.out.println(m.getId());
			System.out.println(m.getPassword());
			System.out.println(m.getName());
			System.out.println(m.getPhoneNum());
			System.out.println("-----");
		});
		
	}
}

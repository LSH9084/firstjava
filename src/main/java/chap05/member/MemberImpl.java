package chap05.member;

import java.util.ArrayList;
import java.util.Arrays;

import lombok.ToString;

@ToString
public class MemberImpl implements Member {
	String memberData;
	
	ArrayList<MemberVo> members = new ArrayList<MemberVo>();
	
	public MemberImpl(String id, String password, String name, String phoneNum) {
		// TODO Auto-generated constructor stub
		
		
		this.memberData = id + password + name + phoneNum;
		System.out.println(memberData);
	}
	
	
	@Override
	public MemberVo viewMember(MemberVo vo) {
		// TODO Auto-generated method stub
		memberData = vo.getId()+","+vo.getPassword()+","+vo.getName()+","+vo.getPhoneNum();
		System.out.println(members.indexOf(vo));
		int idx = members.indexOf(vo);
//		System.out.println(members.get(idx));
		members.forEach((members)->{
			System.out.println("-----");
			System.out.println(members.getId());
			System.out.println(members.getPassword());
			System.out.println(members.getName());
			System.out.println(members.getPhoneNum());
			System.out.println("-----");
			
		});
		return members.get(idx);
	}

	@Override
	public void regMember(MemberVo vo) {
		// TODO Auto-generated method stub
		memberData = vo.getId()+","+vo.getPassword()+","+vo.getName()+","+vo.getPhoneNum();
		
		members.add(vo);
		System.out.println(members);
		
		
//		memberList[memberList.length] = vo;
//		System.out.println(Arrays.toString(memberList));
		
		
		
		System.out.println("회원가입 되었습니다.");
		
	}
	
	

	@Override
	public void modMember(MemberVo vo) {
		memberData = vo.getId()+","+vo.getPassword()+","+vo.getName()+","+vo.getPhoneNum();
		System.out.println("회원정보가 수정되었습니다.");
		
	}

	@Override
	public void delMember(MemberVo vo) {
		// TODO Auto-generated method stub
		memberData = "";
		System.out.println("회원정보가 삭제되었습니다.");
		
	}


	@Override
	public ArrayList<MemberVo> listMember() {
		
		
		return members;
	}
	
}

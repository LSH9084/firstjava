package chap05.member;

import java.util.ArrayList;

public interface Member {
	public MemberVo viewMember(MemberVo vo);
	public void regMember(MemberVo vo);
	public void modMember(MemberVo vo);
	public void delMember(MemberVo vo);
	
	public ArrayList<MemberVo> listMember();
}

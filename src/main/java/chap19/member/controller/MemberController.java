package chap19.member.controller;

import java.util.List;

import chap19.common.base.AbstractBaseDao;
import chap19.member.vo.MemberVo;

public interface MemberController {
	// 회원 조회
	public List<MemberVo> listMember(MemberVo vo);	
	// 회원 등록
	public int regMember(MemberVo vo);
	// 회원 수정
	public void modMember(MemberVo vo);
	// 회원 삭제
	public void removeMember(MemberVo vo);
	
	public void close2();
	
	public MemberVo checkId(String memId);
	
}

package chap19.member.controller;

import java.util.ArrayList;
import java.util.List;

import chap19.member.dao.MemberDao;
import chap19.member.dao.MemberDaoImpl;
import chap19.member.vo.MemberVo;

public class MemberControllerImpl implements MemberController{
	public MemberDao memberDao;
	
	public MemberControllerImpl() {
		memberDao = new MemberDaoImpl();
	}
	@Override
	public List<MemberVo> listMember(MemberVo vo) {
		// 회원 정보 조회하는 dao를 호출
		List<MemberVo> list1 = new ArrayList<MemberVo>();
		try {
			list1 = memberDao.selectMember(vo);
			
		} catch (Exception e) {	System.out.println(e.getMessage());}
		
		return list1;
	}

	@Override
	public int regMember(MemberVo vo) {
		int result = 0;
		try {
			result = memberDao.inserMember(vo);
		} catch (Exception e) {}
		return result;
		
	}

	@Override
	public void modMember(MemberVo vo) {
		try {
			memberDao.updateMember(vo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void removeMember(MemberVo vo) {
		try {
			memberDao.deleteMember(vo);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Override
	public void close2() {
		try {
			memberDao.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	@Override
	public MemberVo checkId(String memId) {
		MemberVo vo = new MemberVo();
		
		try {
			vo = memberDao.checkId(memId);
		} catch (Exception e) {
		}
		return vo;
	}
	
	
}

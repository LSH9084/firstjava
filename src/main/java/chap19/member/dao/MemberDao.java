package chap19.member.dao;

import java.util.List;

import chap19.member.vo.MemberVo;

public interface MemberDao {
	public List<MemberVo> selectMember(MemberVo vo)  throws Exception;
	
	public int inserMember(MemberVo vo)throws Exception;
	
	public void updateMember(MemberVo vo)throws Exception;
	
	public void deleteMember(MemberVo vo)throws Exception;
	
	public void close() throws Exception;
	
	public MemberVo checkId(String id) throws Exception;
	
}

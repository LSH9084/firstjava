package chap19.res.dao;

import java.util.List;

import chap19.res.vo.ResVo;

public interface ResDao{
	public List<ResVo> searchRes2(ResVo vo) throws Exception;
	
	public int regRes2(ResVo vo) throws Exception;
	
	public void modRes2(ResVo vo) throws Exception;
	
	public void remRes2(ResVo vo) throws Exception;
	
	public ResVo checkId3(String rentNum) throws Exception;
}

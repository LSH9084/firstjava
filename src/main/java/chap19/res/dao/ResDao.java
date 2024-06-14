package chap19.res.dao;

import java.util.List;

import chap19.res.vo.ResVo;

public interface ResDao{
	public List<ResVo> searchRes2() throws Exception;
	
	public void regRes2() throws Exception;
	
	public void modRes2() throws Exception;
	
	public void remRes2() throws Exception;
}

package chap19.res.controller;

import java.util.List;

import chap19.res.vo.ResVo;

public interface ResController {
	public List<ResVo> searchRes(ResVo vo);
	
	public int regRes(ResVo vo);
	
	public void modRes(ResVo vo);
	
	public void remRes(ResVo vo);
	
	public ResVo checkId3(String rentNum);
}

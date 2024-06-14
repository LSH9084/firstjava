package chap19.res.controller;

import java.util.List;

import chap19.res.vo.ResVo;

public interface ResController {
	public List<ResVo> searchRes();
	
	public void regRes();
	
	public void modRes();
	
	public void remRes();
}

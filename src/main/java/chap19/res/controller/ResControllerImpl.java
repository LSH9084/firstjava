package chap19.res.controller;

import java.util.ArrayList;
import java.util.List;

import chap19.res.dao.ResDao;
import chap19.res.dao.ResDaoImpl;
import chap19.res.vo.ResVo;

public class ResControllerImpl implements ResController{
	ResDao resdao = new ResDaoImpl();
	@Override
	public List<ResVo> searchRes() {
		List<ResVo> resList = new ArrayList<ResVo>();
		try {
			resList = resdao.searchRes2();
		} catch (Exception e) {
			e.getMessage();
		}
		return resList;
	}

	@Override
	public void regRes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modRes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remRes() {
		// TODO Auto-generated method stub
		
	}
	
}

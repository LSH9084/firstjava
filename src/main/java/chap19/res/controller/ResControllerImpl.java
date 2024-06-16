package chap19.res.controller;

import java.util.ArrayList;
import java.util.List;

import chap19.res.dao.ResDao;
import chap19.res.dao.ResDaoImpl;
import chap19.res.vo.ResVo;

public class ResControllerImpl implements ResController{
	ResDao resdao = new ResDaoImpl();
	@Override
	public List<ResVo> searchRes(ResVo vo) {
		List<ResVo> resList = new ArrayList<ResVo>();
		try {
			resList = resdao.searchRes2(vo);
		} catch (Exception e) {
			e.getMessage();
		}
		return resList;
	}

	@Override
	public int regRes(ResVo vo) {
		int result = 0;
		try {
			result = resdao.regRes2(vo);
		} catch (Exception e) {
			e.getMessage();
		}
		return result;
		
	}

	@Override
	public void modRes(ResVo vo) {
		try {
			resdao.modRes2(vo);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void remRes(ResVo vo) {
		try {
			resdao.remRes2(vo);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public ResVo checkId3(String rentNum) {
		ResVo vo = new ResVo();
		
		try {
			vo = resdao.checkId3(rentNum);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return vo;
	}
	
	
	
}

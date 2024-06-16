package chap19.rentCar.controller;

import java.util.ArrayList;
import java.util.List;

import chap19.member.vo.MemberVo;
import chap19.rentCar.dao.CarDao;
import chap19.rentCar.dao.CarDaoImpl;
import chap19.rentCar.vo.CarVo;

public class CarControllerImpl implements CarController {
	CarDao daocar = new CarDaoImpl();
	
	@Override
	public List<CarVo> listCar(CarVo vo) {
		List<CarVo> list1 = new ArrayList<CarVo>();
		
		try {
			list1 = daocar.listCar2(vo);
		} catch (Exception e) {e.getMessage()	;}
		
		return list1;
	}
	
	public List<CarVo> listCarNum(CarVo vo) {
		List<CarVo> list1 = new ArrayList<CarVo>();
		
		try {
			list1 = daocar.listCarNum2(vo);
		} catch (Exception e) {e.getMessage()	;}
		
		return list1;
	}
	
	public List<CarVo> listCarMade(CarVo vo) {
		List<CarVo> list1 = new ArrayList<CarVo>();
		
		try {
			list1 = daocar.listCarMade2(vo);
		} catch (Exception e) {e.getMessage()	;}
		
		return list1;
	}
	
	public List<CarVo> listCarColor(CarVo vo) {
		List<CarVo> list1 = new ArrayList<CarVo>();
		
		try {
			list1 = daocar.listCarColor2(vo);
		} catch (Exception e) {e.getMessage()	;}
		
		return list1;
	}
	
	

	@Override
	public int regCar(CarVo vo) throws Exception {
		int result = 0;
		result = daocar.regCar2(vo);
		return result;
	}

	@Override
	public void modCar(CarVo vo) throws Exception  {
		daocar.modCar2(vo);
	}

	@Override
	public void removeCar(CarVo vo) throws Exception  {
		daocar.removeCar2(vo);
	}

	@Override
	public void close() {
		
	}
	
	
	public CarVo checkId2(String carnum) {
		CarVo vo = new CarVo();
		
		try {
			vo = daocar.checkId2(carnum);
		} catch (Exception e) {
		}
		return vo;
	}
	
}

package chap19.rentCar.controller;

import java.util.List;

import chap19.member.vo.MemberVo;
import chap19.rentCar.vo.CarVo;

public interface CarController {
	public List<CarVo> listCar(CarVo vo);
	
	public int regCar(CarVo vo) throws Exception ;
	
	public void modCar(CarVo vo) throws Exception ;
	
	public void removeCar(CarVo vo) throws Exception ;
	
	public void close();
	
	public List<CarVo> listCarColor(CarVo vo) throws Exception;
	
	public List<CarVo> listCarMade(CarVo vo) throws Exception;
	
	public List<CarVo> listCarNum(CarVo vo) throws Exception;
	
	public CarVo checkId2(String carnum);
}

package chap19.rentCar.controller;

import java.util.List;

import chap19.rentCar.vo.CarVo;

public interface CarController {
	public List<CarVo> listCar(CarVo vo);
	
	public int regCar(CarVo vo) throws Exception ;
	
	public void modCar(CarVo vo) throws Exception ;
	
	public void removeCar(CarVo vo) throws Exception ;
	
	public void close();
	
}

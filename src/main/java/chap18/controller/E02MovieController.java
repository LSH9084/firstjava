package chap18.controller;

import chap18.model.E03MovieModel;

public class E02MovieController {

	E03MovieModel movieModel;
	
	public E02MovieController() {
		movieModel = new E03MovieModel();
	}
	
	//추가 기능 요청시
	public void addTitle() {
		movieModel.addTitle();
	}
	//저장 기능 요청시
	public void saveTitle() {
		movieModel.saveTitle();
	}
	//삭제 기능 요청시
	public void delTitle() {
		movieModel.delTitle();
	}
	
}

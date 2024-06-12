package chap18.controller;
import java.awt.List;
import chap18.model.E03MovieModel;

public class E02MovieController {

	E03MovieModel movieModel;
	
	public E02MovieController() {
		movieModel = new E03MovieModel();
	}
	
	//추가 기능 요청시
	public void addTitle(String title, List movieList) {
		movieModel.addTitle(title, movieList);
	}
	//저장 기능 요청시
	public void saveTitle(List movieList) {
		movieModel.saveTitle(movieList);
	}
	//삭제 기능 요청시
	public void delTitle(String title, List movieList) {
		movieModel.delTitle(title, movieList);
	}
	
}

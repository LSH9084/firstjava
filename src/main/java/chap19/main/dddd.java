package chap19.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import chap19.res.controller.ResController;
import chap19.res.controller.ResControllerImpl;
import chap19.res.vo.ResVo;
import chap19.res.window.ResRemoveDialog;
import chap19.res.window.ResSearchiDialog;

public class dddd {
	public static void main(String[] args) {
		
		List<ResVo> list1 = new ArrayList<>();
		
		ResVo vo = new ResVo();
		vo.setRent_start(LocalDate.of(2222, 5, 5));
		vo.setRent_end(LocalDate.of(2222, 5, 7));
		ResController rs = new ResControllerImpl();
		rs.searchRes(vo);
		
		
		
	}
}

package notice.comments.controller;

import java.util.ArrayList;
import java.util.List;

import notice.comments.dao.CommentsDao;
import notice.comments.dao.CommentsDaoImpl;
import notice.comments.vo.CommentsVo;

public class CommentsControllerImpl implements CommentsController{
	CommentsDao comDao = new CommentsDaoImpl();
	@Override
	public List<CommentsVo> CommentsList(CommentsVo vo) {
		System.out.println("===dkssud");
		List<CommentsVo> list1 = new ArrayList<CommentsVo>();
		try {
			list1 = comDao.CommentsList2(vo);
		} catch (Exception e) {}
//		list1.forEach(System.out::println);
		return list1;
	}
	
	public void registComments(CommentsVo vo) {
		try {
			comDao.registComments2(vo);
		} catch (Exception e) {}
	}
	
	public void deleteComments(CommentsVo vo) {
		try {
			comDao.deleteComments2(vo);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public List<CommentsVo> clickComments(CommentsVo vo) {
		System.out.println("=====");
		List<CommentsVo> list1 = new ArrayList<CommentsVo>();
		try {
			list1 = comDao.clickComments2(vo);
		} catch (Exception e) {}
		return list1;
	}

}

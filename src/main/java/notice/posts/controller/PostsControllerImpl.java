package notice.posts.controller;

import java.util.ArrayList;
import java.util.List;

import notice.posts.dao.PostsDao;
import notice.posts.dao.PostsDaoImpl;
import notice.posts.vo.PostsVo;

public class PostsControllerImpl implements PostsController{
	PostsDao postsController = new PostsDaoImpl();
	@Override
	public void DeletePosts(PostsVo vo) {
		try {
			postsController.DeletePosts2(vo);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	public void ModifyPosts(PostsVo vo) {
		try {
			postsController.ModifyPosts2(vo);
		}  catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	public void RegisterPosts(PostsVo vo) {
		try {
			postsController.RegisterPosts2(vo);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	public List<PostsVo> postsList(PostsVo vo) {
		List<PostsVo> list1 = new ArrayList<PostsVo>();
		
		try {
			list1 = postsController.postsList2(vo);
		} catch (Exception e) {
			e.getMessage();
		}
		return list1;
	}
	
	public List<PostsVo> ClickPosts(PostsVo vo) {
		List<PostsVo> list1 = new ArrayList<PostsVo>();
		try {
		list1 =postsController.ClickPosts2(vo);
		} catch (Exception e) {}
		return list1;
	}

	@Override
	public List<PostsVo> searchList(PostsVo vo, String str, String inner) {
		List<PostsVo> list1 = new ArrayList<PostsVo>();
		try {
		list1 =postsController.searchList2(vo,str,inner);
		} catch (Exception e) {}
		return list1;
	}

}

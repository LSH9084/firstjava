package notice.posts.controller;

import java.util.List;

import notice.posts.vo.PostsVo;

public interface PostsController {
	
	public void DeletePosts (PostsVo vo);
	
	public void ModifyPosts(PostsVo vo);
	
	public void RegisterPosts(PostsVo vo);
	
	public List<PostsVo> postsList(PostsVo vo);
	
	public List<PostsVo> ClickPosts(PostsVo vo);
	
	public List<PostsVo> searchList(PostsVo vo, String str, String inner);
}

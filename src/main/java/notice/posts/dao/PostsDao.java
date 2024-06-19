package notice.posts.dao;

import java.util.List;

import notice.posts.vo.PostsVo;

public interface PostsDao {
	public void DeletePosts2(PostsVo vo) throws Exception;
	
	public void ModifyPosts2(PostsVo vo) throws Exception;
	
	public void RegisterPosts2(PostsVo vo) throws Exception;
	
	public List<PostsVo> postsList2(PostsVo vo) throws Exception;
	
	public List<PostsVo> ClickPosts2(PostsVo vo) throws Exception;
	
	public List<PostsVo> searchList2(PostsVo vo, String str, String inner) throws Exception;
	
}

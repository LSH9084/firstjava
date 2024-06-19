package notice.comments.controller;

import java.util.List;

import notice.comments.vo.CommentsVo;

public interface CommentsController {
	public List<CommentsVo> CommentsList(CommentsVo vo);
	
	public void registComments(CommentsVo vo);
	
	public void deleteComments(CommentsVo vo);
	
	public List<CommentsVo> clickComments(CommentsVo vo);
}

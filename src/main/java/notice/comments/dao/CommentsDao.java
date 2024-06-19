package notice.comments.dao;

import java.util.List;

import notice.comments.vo.CommentsVo;
import notice.common.base.AbstractBaseDao;

public interface CommentsDao {
	public List<CommentsVo> CommentsList2(CommentsVo vo) throws Exception;

	public void registComments2(CommentsVo vo) throws Exception;
	
	public void deleteComments2(CommentsVo vo) throws Exception;
	
	public List<CommentsVo> clickComments2(CommentsVo vo) throws Exception;
}

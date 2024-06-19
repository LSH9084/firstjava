package notice.comments.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import notice.comments.vo.CommentsVo;
import notice.common.base.AbstractBaseDao;

public class CommentsDaoImpl extends AbstractBaseDao implements CommentsDao {

	@Override
	public List<CommentsVo> CommentsList2(CommentsVo vo) throws Exception{
//		System.out.println(vo.getPost_id());
		System.out.println("=====dsfsdfsd");
		String sql = "select * from comments where post_id = ?";
		List<CommentsVo> list1 = new ArrayList<CommentsVo>();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1	, vo.getPost_id());
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			int comment_id = rs.getInt("comment_id");
			int post_id = rs.getInt("post_id");
			String content_comments = rs.getString("content_comments");
			String author_comments = rs.getString("author_comments");
			LocalDate created_comments = rs.getDate("created_comments").toLocalDate();
			
			CommentsVo vo2 = CommentsVo.builder()
					.comment_id(comment_id)
					.post_id(post_id)
					.content_comments(content_comments)
					.author_comments(author_comments)
					.created_comments(created_comments)
					.build();
			
			list1.add(vo2);
		}
		list1.forEach(System.out::println);
		return list1;
	}

	@Override
	public void registComments2(CommentsVo vo) throws Exception {
		String sql = """
					insert into comments(content_comments,author_comments,post_id )
					values(?,?,?)
				""";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(3, vo.getPost_id());
		pstmt.setString(1, vo.getContent_comments());
		pstmt.setString(2, vo.getAuthor_comments());
		
		pstmt.executeUpdate();
		
	}

	@Override
	public void deleteComments2(CommentsVo vo) throws Exception {
		
		
		String sql = "delete from comments where comment_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, vo.getComment_id());
//		System.out.println(a);
		
		pstmt.executeUpdate();
		
	}
	
	public List<CommentsVo> clickComments2(CommentsVo vo) throws Exception{
//		System.out.println(vo.getPost_id());
		System.out.println("=====");
		String sql = "select * from comments where comment_id = ?";
		List<CommentsVo> list1 = new ArrayList<CommentsVo>();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1	, vo.getComment_id());
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			int comment_id = rs.getInt("comment_id");
			int post_id = rs.getInt("post_id");
			String content_comments = rs.getString("content_comments");
			String author_comments = rs.getString("author_comments");
			LocalDate created_comments = rs.getDate("created_comments").toLocalDate();
			
			CommentsVo vo2 = CommentsVo.builder()
					.comment_id(comment_id)
					.post_id(post_id)
					.content_comments(content_comments)
					.author_comments(author_comments)
					.created_comments(created_comments)
					.build();
			
			list1.add(vo2);
		}
		list1.forEach(System.out::println);
		return list1;
	}


	

	
}

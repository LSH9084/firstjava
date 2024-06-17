package notice.posts.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import notice.common.base.AbstractBaseDao;
import notice.posts.vo.PostsVo;

public class PostsDaoImpl extends AbstractBaseDao implements PostsDao {

	@Override
	public void DeletePosts2(PostsVo vo) throws Exception {
		String sql = "delete from posts where post_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, vo.getPost_id());
		
		pstmt.executeUpdate();
	}

	@Override
	public void ModifyPosts2(PostsVo vo) throws Exception {
		String sql = "update posts set title = ?, content = ?, author = ?, created_posts =?, updated_posts =? where post_id = ? ";
		pstmt = conn.prepareStatement(sql);
		LocalDate created_posts1 = vo.getCreated_posts();
		LocalDate updated_posts1 = vo.getUpdated_posts();
		java.sql.Date created_posts2 = java.sql.Date.valueOf(created_posts1);
		java.sql.Date updated_posts2 = java.sql.Date.valueOf(updated_posts1);
		
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		pstmt.setString(3, vo.getAuthor());
		pstmt.setDate(4, created_posts2);
		pstmt.setDate(5, updated_posts2);
		pstmt.setInt(6, vo.getPost_id());
		
		pstmt.executeUpdate();
	}

	@Override
	public void RegisterPosts2(PostsVo vo) throws Exception {
		String sql = """
					insert into posts (post_id, title, content, author, created_posts, updated_posts)
					values (?,?,?,?,?,?)
				""";
		pstmt = conn.prepareStatement(sql);
		LocalDate created_posts1 = vo.getCreated_posts();
		LocalDate updated_posts1 = vo.getUpdated_posts();
		java.sql.Date created_posts2 = java.sql.Date.valueOf(created_posts1);
		java.sql.Date updated_posts2 = java.sql.Date.valueOf(updated_posts1);
		
		pstmt.setInt(1, vo.getPost_id());
		pstmt.setString(2, vo.getTitle());
		pstmt.setString(3, vo.getContent());
		pstmt.setString(4, vo.getAuthor());
		pstmt.setDate(5, created_posts2);
		pstmt.setDate(6, updated_posts2);
		
		pstmt.executeUpdate();
	}

	@Override
//	public List<PostsVo> postsList2(PostsVo vo) throws Exception {
//		
////		LocalDate created_posts1 = vo.getCreated_posts();
////		LocalDate updated_posts1 = vo.getUpdated_posts();
////		java.sql.Date created_posts2 = java.sql.Date.valueOf(created_posts1);
////		java.sql.Date updated_posts2 = java.sql.Date.valueOf(updated_posts1);
//		String sql = "select * from posts";
//		List<PostsVo> list1 = new ArrayList<PostsVo>();
//		pstmt = conn.prepareStatement(sql);
//		rs = pstmt.executeQuery();
//		
//		while(rs.next()) {
//			int post_id = rs.getInt("post_id");
//			String title = rs.getString("title");
//			String content = rs.getString("content");
//			String author = rs.getString("author");
//			LocalDate created_posts = rs.getDate("created_posts").toLocalDate();
//			LocalDate updated_posts = rs.getDate("updated_posts").toLocalDate();
//			
//			PostsVo vo2 = PostsVo.builder()
//					.post_id(post_id)
//					.title(title)
//					.content(content)
//					.author(author)
//					.created_posts(created_posts)
//					.updated_posts(updated_posts)
//					.build();
//			
//			list1.add(vo2);
//			
//			
//		}
//		rs.close();
//		
//		
//		return list1;
//	}
	public List<PostsVo> postsList2(PostsVo vo) throws Exception {
	    String sql = "select * from posts";
	    List<PostsVo> list1 = new ArrayList<PostsVo>();
	    pstmt = conn.prepareStatement(sql);
	    rs = pstmt.executeQuery();
	    
	    while(rs.next()) {
	        int post_id = rs.getInt("post_id"); // 수정된 변수 이름
	        String title = rs.getString("title");
	        String content = rs.getString("content");
	        String author = rs.getString("author");
	        LocalDate created_posts = rs.getDate("created_posts").toLocalDate();
	        LocalDate updated_posts = rs.getDate("updated_posts").toLocalDate();
	        
	        PostsVo vo2 = PostsVo.builder()
	                .post_id(post_id) // 수정된 필드 이름
	                .title(title)
	                .content(content)
	                .author(author)
	                .created_posts(created_posts)
	                .updated_posts(updated_posts)
	                .build();
	        
	        list1.add(vo2);
	    }
	    rs.close();
	    
	    return list1;
	}
}

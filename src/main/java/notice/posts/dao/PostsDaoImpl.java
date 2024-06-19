package notice.posts.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import notice.common.base.AbstractBaseDao;
import notice.posts.controller.PostsController;
import notice.posts.controller.PostsControllerImpl;
import notice.posts.vo.PostsVo;
import notice.posts.window.PostsClickDialog;

public class PostsDaoImpl extends AbstractBaseDao implements PostsDao {
//	PostsController postsController = new PostsControllerImpl();
	@Override
	public void DeletePosts2(PostsVo vo) throws Exception {
		String sql = "delete from posts where post_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, vo.getPost_id());
		
		pstmt.executeUpdate();
	}

	@Override
	public void ModifyPosts2(PostsVo vo) throws Exception {
		String sql ="UPDATE posts SET title = ?, content = ?, author = ?, updated_posts = CURRENT_TIMESTAMP WHERE post_id = ?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		pstmt.setString(3, vo.getAuthor());
		pstmt.setInt(4, vo.getPost_id());
		
		pstmt.executeUpdate();
	}

	@Override
	public void RegisterPosts2(PostsVo vo) throws Exception {

		
		String sql = """
				insert into posts (title, content, author)
				values (?,?,?)
			""";
		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getAuthor());
		pstmt.setString(3, vo.getContent());

		
		pstmt.executeUpdate();
	}


	public List<PostsVo> postsList2(PostsVo vo) throws Exception {
	    String sql = "select * from posts  order by created_posts desc";
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
	
	@Override
	public List<PostsVo> ClickPosts2(PostsVo vo) throws Exception {
		List<PostsVo> list1 = new ArrayList<>();
//		int result =0;
		String sql = "select * from posts where post_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, vo.getPost_id());
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
		
		list1.forEach(System.out::println);
		
		return list1;
		
		
		
	}

	@Override
	public List<PostsVo> searchList2(PostsVo vo, String str, String inner) throws Exception {
		List<PostsVo> list1 = new ArrayList<PostsVo>();
		String sql;
		if(str.equals("제목")) {
			sql = "select * from posts where title like ? order by created_posts desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + inner + "%");
			rs = pstmt.executeQuery();
		} else if (str.equals("작성자")) {
			sql = "select * from posts where author like ? order by created_posts desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + inner + "%");
			rs = pstmt.executeQuery();
		}

		
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
		list1.forEach(v->{
			System.out.println(v);
		});
		
		return list1;
	}

}

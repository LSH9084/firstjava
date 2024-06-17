package notice.posts.vo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PostsVo {
	private int post_id;
	private String title;
	private String content;
	private String author;
	private LocalDate created_posts;
	private LocalDate updated_posts;
	
}

package notice.comments.vo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class CommentsVo {
	private int comment_id;
	private int post_id;
	String content_comments;
	String author_comments;
	LocalDate created_comments;
	
}

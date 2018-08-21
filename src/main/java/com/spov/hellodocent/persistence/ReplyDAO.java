package com.spov.hellodocent.persistence;

import java.util.List;

import com.spov.hellodocent.domain.BlogReplyDTO;
import com.spov.hellodocent.domain.CommentaryReplyDTO;

public interface ReplyDAO {
	
	/*해설 댓글 CRUD*/
	
	public void insertCommentaryReply(CommentaryReplyDTO reply);
	public List<CommentaryReplyDTO> selectCommentaryReply(String id);
	public void removeCommentaryReply (String id);
	public void updateCommentaryReply (CommentaryReplyDTO reply);

	/*블로그 댓글 CRUD*/
	
	public void insertBlogReply(BlogReplyDTO reply);
	public List<BlogReplyDTO> selectBlogReply(String id);
	public void removeBlogReply (String id);
	public void updateBlogReply (BlogReplyDTO reply);

}

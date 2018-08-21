package com.spov.hellodocent.services;

import java.util.List;
import java.util.Map;

import com.spov.hellodocent.domain.BlogReplyDTO;
import com.spov.hellodocent.domain.CommentaryReplyDTO;

public interface ReplyService {
	
	/*해설 댓글 CRUD*/
	public void insertCommentaryReply(CommentaryReplyDTO reply);
	public Map<String, List<CommentaryReplyDTO>> selectCommentaryReply(String id);
	public void removeCommentaryReply (String id);
	public void updateCommentaryReply (CommentaryReplyDTO reply);

	
	/*블로그 댓글 CRUD*/
	public void insertBlogReply(BlogReplyDTO reply);
	public Map<String, List<BlogReplyDTO>> selectBlogReply(String id);
	public void removeBlogReply (String id);
	public void updateBlogReply (BlogReplyDTO reply);
}

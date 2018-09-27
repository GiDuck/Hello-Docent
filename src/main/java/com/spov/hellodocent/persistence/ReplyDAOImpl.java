package com.spov.hellodocent.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spov.hellodocent.domain.BlogReplyDTO;
import com.spov.hellodocent.domain.CommentaryReplyDTO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.spov.hellodocent.mappers.replyMapper";

	
	/*해설 댓글 CRUD*/
	
	
	@Override
	public void insertCommentaryReply(CommentaryReplyDTO reply) {
	
		sqlSession.insert(namespace+".insertCommentaryReply", reply);
		
	}

	@Override
	public List<CommentaryReplyDTO> selectCommentaryReply(String id) {
	
		return sqlSession.selectList(namespace+".selectCommentaryReply", id);
	}

	@Override
	public void removeCommentaryReply(String id) {
		
		
		sqlSession.delete(namespace+".removeCommentaryReply", id);
	}

	@Override
	public void updateCommentaryReply(CommentaryReplyDTO reply) {
		
		sqlSession.update(namespace+".updateCommentaryReply", reply);
		
	}

	/*블로그 댓글 CRUD*/
	
	@Override
	public void insertBlogReply(BlogReplyDTO reply) {
		sqlSession.insert(namespace+".insertBlogReply", reply);		
	}

	@Override
	public List<BlogReplyDTO> selectBlogReply(String id) {
 		return sqlSession.selectList(namespace+".selectBlogReply", id);
	}

	@Override
	public void removeBlogReply(String id) {
		sqlSession.delete(namespace+".removeBlogReply", id);
		
	}

	@Override
	public void updateBlogReply(BlogReplyDTO reply) {
		sqlSession.update(namespace+".updateBlogReply", reply);
		
	}
	
	
	
	
	
	
	
	
	
}

package com.spov.hellodocent.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spov.hellodocent.domain.BlogDTO;
import com.spov.hellodocent.domain.ResourceDTO;

@Repository
public class BlogDAOImpl implements BlogDAO {

	
	@Inject
	private SqlSession sqlSession;
	
	final private String namespace = "com.spov.hellodocent.mappers.blogMapper";

	/*블로그 포스팅 삽입*/
	@Override
	public void insertBlog(BlogDTO blog) {
		sqlSession.insert(namespace+".insertBlog", blog);
		
	}

	/*블로그 태그 삽입*/
	@Override
	public void insertTags(Map<String, String> param) {
		if(param!=null && param.size()!=0) {
		sqlSession.insert(namespace+".insertBlogTags", param);
		}
	}



	/*블로그 이미지 삽입*/
	@Override
	public void insertBlogResource(List<ResourceDTO> param) {
		
		if(param!=null && param.size()!=0) {
		sqlSession.insert(namespace+".insertBlogResource", param);
		}
	}

	
	/*블로그 정보 가져오기*/
	@Override
	public BlogDTO selectBlog(String id) {
		return sqlSession.selectOne(namespace + ".getBlog", id);
	}

	

	public List<Map<String, String>> getBlogList (Map<String, String> param){		
		
		return sqlSession.selectList(namespace + ".getBlogList", param);
	}
	
	
	
	/*블로그 포스팅 태그 가져오기*/

	@Override
	public List<String> getBlogTags(String id) {
		
		return sqlSession.selectList(namespace+".getBlogTags", id);
	}

	
	/*블로그 포스팅 수정*/
	
	@Override
	public void updateBlog(BlogDTO  blog) {
		
		sqlSession.update(namespace+".updateBlog", blog);

		
	}

	/*블로그 태그 삭제*/
	
	@Override
	public void removeBlogTags(String id) {
		
		sqlSession.update(namespace+".removeBlogTags", id);
		
	}

	@Override
	public void removeBlog(String id) {
	
		sqlSession.delete(namespace+".removeBlog", id);
		
	}

	@Override
	public void removeBlogResource(String id) {
	
		sqlSession.delete(namespace + ".removeBlogResource", id);
		
	}
	
	/*블로그 포스팅 이미지 들고오기*/

	
	@Override
	public String selectBlogImageResource(String id) {
	
		
		
		return sqlSession.selectOne(namespace+".selectBlogImageResource", id);
	}

	@Override
	public String getBlogLength(String keyword) {
		
		Map<String, String> param = new HashMap<>();
		param.put("keyword", keyword);
	
		return sqlSession.selectOne(namespace+".getBlogLength", param);
	
	}

	@Override
	public List<Map<String, String>> getMyBlog(Map<String, String> param) {	
		return sqlSession.selectList(namespace+".getMyBlog", param);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

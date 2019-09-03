package cn.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.blog.mapper.BlogCommentMapper;
import cn.blog.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private BlogCommentMapper blogCommentMapper;
	
	public int getTotalBlogComments(long blogId) {
		return blogCommentMapper.getTotalBlogComments(blogId);
	}

	@Override
	public int getTotalComments() {
		return blogCommentMapper.getTotalComments();
	}

}

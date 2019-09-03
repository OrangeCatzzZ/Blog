package cn.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.blog.entity.Blog;
import cn.blog.entity.BlogDetailVO;
import cn.blog.entity.SimpleBlogListVO;
import cn.blog.mapper.BlogCommentMapper;
import cn.blog.mapper.BlogMapper;
import cn.blog.mapper.BlogTagMapper;
import cn.blog.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogMapper blogMapper;
	@Autowired
	private BlogCommentMapper blogCommentMapper;
	@Autowired
	private BlogTagMapper blogTagMapper;
	
	public List<Blog> findAllBlog() {
		return blogMapper.findAllBlog();
	}

	@Override
	public List<SimpleBlogListVO> getBlogListForType(int type) {
		return blogMapper.findBlogListByType(type);
	}

	public BlogDetailVO getBlogDetailById(long blogId) {
		BlogDetailVO blogDetailVO = blogMapper.findBlogDetailById(blogId);
		blogDetailVO.setBlogId(blogId);
		int commentCount = blogCommentMapper.getTotalBlogComments(blogId);
		blogDetailVO.setCommentCount(commentCount);
		List<String> blogTags = blogTagMapper.findTagById(blogId);
		blogDetailVO.setBlogTags(blogTags);
		return blogDetailVO;
	}

	public List<Blog> getBlogsByTagId(Integer tagId) {
		return blogMapper.getBlogsByTagId(tagId);
	}

	public List<Blog> searchBlogByKeyword(String keyword) {
		return blogMapper.searchBlogBykeyword(keyword);
	}

	@Override
	public int getTotalBlogs() {
		return blogMapper.getTotalBlogs();
	}

	@Override
	public void save(Blog blog) {
		blogMapper.insert(blog);
	}

}

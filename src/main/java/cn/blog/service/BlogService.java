package cn.blog.service;

import java.util.List;

import cn.blog.entity.Blog;
import cn.blog.entity.BlogDetailVO;
import cn.blog.entity.SimpleBlogListVO;

public interface BlogService {
	
	List<Blog> findAllBlog();
	
	int getTotalBlogs();
	
	void save(Blog blog);
	
	/**
	 * 获得首页侧边栏数据列表
	 * type 0-点击最多  1-最新发布
	 * @param type
	 * @return
	 */
	List<SimpleBlogListVO> getBlogListForType(int type);
	
	/**
	 * 根据id获得详情页
	 * @param blogId
	 * @return
	 */
	BlogDetailVO getBlogDetailById(long blogId);
	
	/**
	 * 根据标签id查找博客
	 * @param tagId
	 * @return
	 */
	List<Blog> getBlogsByTagId(Integer tagId);
	
	/**
	 * 搜素关键字查找博客
	 * @param keyword
	 * @return
	 */
	List<Blog> searchBlogByKeyword(String keyword);
}

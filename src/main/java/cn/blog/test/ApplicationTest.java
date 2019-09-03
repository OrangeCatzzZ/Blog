package cn.blog.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.blog.Application;
import cn.blog.entity.Blog;
import cn.blog.mapper.AdminUserMapper;
import cn.blog.mapper.BlogCommentMapper;
import cn.blog.mapper.BlogConfigMapper;
import cn.blog.mapper.BlogMapper;
import cn.blog.mapper.BlogTagMapper;
import cn.blog.service.BlogService;
import cn.blog.service.ConfigService;
import cn.blog.service.TagService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {
	
	@Autowired
	private BlogMapper blogMapper;
	@Autowired
	private BlogConfigMapper blogConfigMapper;
	@Autowired
	private ConfigService configService;
	@Autowired
	private BlogCommentMapper blogCommentMapper;
	@Autowired
	private BlogTagMapper blogTagMapper;
	@Autowired
	private TagService tagService;
	@Autowired
	private BlogService blogService;
	@Autowired
	private AdminUserMapper adminUserMapper;
	
	@Test
	public void fun1() {
		Blog blog = new Blog();
		blog.setBlogTitle("测试1");
        blog.setBlogSubUrl("");
        blog.setBlogCategoryId(24);
        blog.setBlogCategoryName("日常随笔");
        blog.setBlogTags("目录");
        blog.setBlogContent("第一章");
        blog.setBlogCoverImage("/admin...");
        blog.setBlogStatus((byte) 1);
        blog.setEnableComment((byte) 0);
		blogMapper.insert(blog);
	}
	
}

package cn.blog.controller.blog;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cn.blog.entity.Blog;
import cn.blog.entity.BlogDetailVO;
import cn.blog.entity.BlogLink;
import cn.blog.service.BlogService;
import cn.blog.service.ConfigService;
import cn.blog.service.LinkService;
import cn.blog.service.TagService;

@Controller
public class MyBlogController {

	// public static String theme = "default";
	// public static String theme = "yummy-jekyll";
	public static String theme = "amaze";

	@Autowired
	private BlogService blogService;
	@Autowired
	private ConfigService configService;
	@Autowired
	private TagService tagService;
	@Autowired
	private LinkService linkService;

	/**
	 * 首页
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping({ "/", "/index" })
	public String index(HttpServletRequest request) {
		request.setAttribute("blogList", blogService.findAllBlog());
		request.setAttribute("newBlogs", blogService.getBlogListForType(1));
		request.setAttribute("hotBlogs", blogService.getBlogListForType(0));
		request.setAttribute("hotTags", tagService.getBlogTagCount());
		request.setAttribute("pageName", "首页");
		request.setAttribute("configurations", configService.getAllConfigs());
		return "blog/" + theme + "/index";
	}

	/**
	 * 详情页
	 * 
	 * @param request
	 * @param blogId
	 * @return
	 */
	@GetMapping("/blog/{blogId}")
	public String detail(HttpServletRequest request, @PathVariable("blogId") Long blogId) {
		BlogDetailVO blogDetailVO = blogService.getBlogDetailById(blogId);
		if (blogDetailVO != null) {
			request.setAttribute("blogDetailVO", blogDetailVO);
		}
		request.setAttribute("pageName", "详情");
		request.setAttribute("configurations", configService.getAllConfigs());
		return "blog/" + theme + "/detail";
	}
	
	/**
	 * 根据标签查找博客
	 * @param request
	 * @param tagId
	 * @return
	 */
	@GetMapping("tag/{tagId}")
	public String tag(HttpServletRequest request, @PathVariable("tagId") Integer tagId) {
		List<Blog> blogs = blogService.getBlogsByTagId(tagId);
		request.setAttribute("blogs", blogs);
		request.setAttribute("pageName", "标签");
        request.setAttribute("pageUrl", "tag");
        request.setAttribute("newBlogs", blogService.getBlogListForType(1));
		request.setAttribute("hotBlogs", blogService.getBlogListForType(0));
		request.setAttribute("hotTags", tagService.getBlogTagCount());
		request.setAttribute("configurations", configService.getAllConfigs());
		return "blog/" + theme + "/list";
	}
	
	/**
	 * 友链页
	 * @param request
	 * @return
	 */
	@GetMapping("/link")
	public String link(HttpServletRequest request) {
		request.setAttribute("pageName", "友情链接");
        Map<Byte, List<BlogLink>> linkMap = linkService.getLinksForType();
        if (linkMap != null) {
            //判断友链类别并封装数据 0-友链 1-推荐 2-个人网站
            if (linkMap.containsKey((byte) 0)) {
                request.setAttribute("favoriteLinks", linkMap.get((byte) 0));
            }
            if (linkMap.containsKey((byte) 1)) {
                request.setAttribute("recommendLinks", linkMap.get((byte) 1));
            }
            if (linkMap.containsKey((byte) 2)) {
                request.setAttribute("personalLinks", linkMap.get((byte) 2));
            }
        }
        request.setAttribute("configurations", configService.getAllConfigs());
		return "blog/" + theme + "/link";
	}
	
	/**
	 * 关于博主页面
	 * @return
	 */
	@GetMapping("/about")
	public String about(HttpServletRequest request) {
		BlogDetailVO blogDetailVO = blogService.getBlogDetailById(1);
		if (blogDetailVO != null) {
			request.setAttribute("blogDetailVO", blogDetailVO);
		}
		request.setAttribute("pageName", "about");
		request.setAttribute("configurations", configService.getAllConfigs());
		return "blog/" + theme + "/detail";
	}
	
	@GetMapping("/search/{keyword}")
	public String serach(HttpServletRequest request, @PathVariable("keyword") String keyword) {
		List<Blog> blogs = blogService.searchBlogByKeyword(keyword);
		request.setAttribute("blogs", blogs);
		request.setAttribute("pageName", "搜索");
        request.setAttribute("pageUrl", "search");
        request.setAttribute("keyword", keyword);
		request.setAttribute("newBlogs", blogService.getBlogListForType(1));
		request.setAttribute("hotBlogs", blogService.getBlogListForType(0));
		request.setAttribute("hotTags", tagService.getBlogTagCount());
		request.setAttribute("configurations", configService.getAllConfigs());
		return "blog/" + theme + "/list";
	}

}

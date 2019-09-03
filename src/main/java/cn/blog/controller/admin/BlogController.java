package cn.blog.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.blog.entity.Blog;
import cn.blog.service.BlogService;
import cn.blog.service.CategoryService;
import cn.blog.util.Result;
import cn.blog.util.ResultGenerator;

@Controller
@RequestMapping("/admin")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	@Autowired
	private CategoryService categoryService;	
	
//	@GetMapping("/blogs/list")
//    @ResponseBody
//    public Result list(@RequestParam Map<String, Object> params) {
//		List<Blog> blogList = blogService.findAllBlog();
//        System.out.println("---------");
//        return ResultGenerator.genSuccessResult(blogList);
//    }
	
	@GetMapping("/blogs")
    public String list(HttpServletRequest request) {
        request.setAttribute("path", "blogs");
        return "admin/blog";
    }
	
	@GetMapping("/blogs/edit")
	public String edit(HttpServletRequest request) {
		request.setAttribute("path", "edit");
		request.setAttribute("categories", categoryService.getAllCategories());
		return "admin/edit";
	}
	
	@PostMapping("/blogs/save")
	@ResponseBody
	public Result save(@RequestParam("blogTitle") String blogTitle,
            @RequestParam(name = "blogSubUrl", required = false) String blogSubUrl,
            @RequestParam("blogCategoryId") Integer blogCategoryId,
            @RequestParam("blogTags") String blogTags,
            @RequestParam("blogContent") String blogContent,
            @RequestParam("blogCoverImage") String blogCoverImage,
            @RequestParam("blogStatus") Byte blogStatus,
            @RequestParam("enableComment") Byte enableComment) {
		if (StringUtils.isEmpty(blogTitle)) {
            return ResultGenerator.genFailResult("请输入文章标题");
        }
        if (blogTitle.trim().length() > 150) {
            return ResultGenerator.genFailResult("标题过长");
        }
        if (StringUtils.isEmpty(blogTags)) {
            return ResultGenerator.genFailResult("请输入文章标签");
        }
        if (blogTags.trim().length() > 150) {
            return ResultGenerator.genFailResult("标签过长");
        }
        if (blogSubUrl.trim().length() > 150) {
            return ResultGenerator.genFailResult("路径过长");
        }
        if (StringUtils.isEmpty(blogContent)) {
            return ResultGenerator.genFailResult("请输入文章内容");
        }
        if (blogTags.trim().length() > 100000) {
            return ResultGenerator.genFailResult("文章内容过长");
        }
        if (StringUtils.isEmpty(blogCoverImage)) {
            return ResultGenerator.genFailResult("封面图不能为空");
        }
        Blog blog = new Blog();
        blog.setBlogTitle(blogTitle);
        blog.setBlogSubUrl(blogSubUrl);
        blog.setBlogCategoryId(blogCategoryId);
        blog.setBlogTags(blogTags);
        blog.setBlogContent(blogContent);
        blog.setBlogCoverImage(blogCoverImage);
        blog.setBlogStatus(blogStatus);
        blog.setEnableComment(enableComment);
        blog.setBlogCategoryName(categoryService.getCategoryById(blogCategoryId).getCategoryName());
        blogService.save(blog);
		return ResultGenerator.genSuccessResult("添加成功");
	}
	
}
